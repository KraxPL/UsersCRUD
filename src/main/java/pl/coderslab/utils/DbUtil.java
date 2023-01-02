package pl.coderslab.utils;

import pl.coderslab.constant.Constant;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {

    public static Connection connect() throws SQLException{
        return DriverManager.getConnection(Constant.DbURL, Constant.DbUser, Constant.DbPass);
    }
}