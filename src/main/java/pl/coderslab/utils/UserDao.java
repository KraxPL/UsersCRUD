package pl.coderslab.utils;

import org.mindrot.jbcrypt.BCrypt;
import pl.coderslab.constant.Constant;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class UserDao {
    public void CreateDatabase(){
        try (Connection connection = DbUtil.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(Constant.CREATE_DATABASE);
            preparedStatement.execute();
        } catch (SQLException e6) {
            e6.printStackTrace();
        }
    }
    public void CreateUsersTable() {
        try (Connection conn = DbUtil.getConnection()) {
            PreparedStatement preparedStatement = conn.prepareStatement(Constant.CREATE_TABLE);
            preparedStatement.execute();
        } catch (SQLException e7){
            e7.printStackTrace();
        }
    }

    public String hashPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public User create(User user) {

        try (Connection conn = DbUtil.getConnection()) {

            PreparedStatement statement = conn.prepareStatement(Constant.ADD_USER, Statement.RETURN_GENERATED_KEYS);

            statement.setString(1, user.getEmail());
            statement.setString(2, user.getUsername());
            statement.setString(3, hashPassword(user.getPassword()));
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                user.setId(resultSet.getInt(1));
            }
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<String> read(int userId) {
        String email = null;
        String username = null;
        String password = null;
        try (Connection connection = DbUtil.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(Constant.SELECT_BY_ID);
            preparedStatement.setInt(1, userId);
            try (ResultSet rs = preparedStatement.executeQuery()) {
                if (rs.next()) {
                    email = rs.getString(1);
                    username = rs.getString(2);
                    password = rs.getString(3);
                    ArrayList<String> arrayList = new ArrayList<>();
                    arrayList.add(email);
                    arrayList.add(username);
                    arrayList.add(password);
                    arrayList.add(String.valueOf(userId));
                    return arrayList;
                } else System.out.println("null");
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        } catch (SQLException e2) {
            e2.printStackTrace();
        }
        return null;
    }

    public void update(User user) {
        String mail = user.getEmail();
        String userName = user.getUsername();
        String pass = user.getPassword();

        try (Connection connection = DbUtil.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(Constant.UPDATE_USER);
            preparedStatement.setInt(4, user.getId());
            preparedStatement.setString(1, mail);
            preparedStatement.setString(2, userName);
            preparedStatement.setString(3, hashPassword(pass));
            preparedStatement.executeUpdate();
        } catch (SQLException e3) {
            e3.printStackTrace();
        }
    }
    public void delete(int userId) {
        try (Connection connection = DbUtil.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(Constant.DELETE_USER);
            preparedStatement.setInt(1, userId);
            preparedStatement.execute();
            System.out.println("Użytkownik o id " + userId + " został usunięty z bazy użytkowników");
        } catch (SQLException e4) {
            e4.printStackTrace();
        }
    }

    public ArrayList<User> findAll() {
        ArrayList<User> list = new ArrayList<>(0);
        try (Connection connection = DbUtil.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(Constant.SELECT_ALL_USERS);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setEmail(rs.getString("email"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                list.add(user);
            }
                for (User user1 : list) {
                    System.out.println(user1);
                }
        } catch (SQLException e5) {
            e5.printStackTrace();
        }
        return list;
    }
}
