package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @Author: matthew
 * @ClassName DBUtil
 * @Date: 2019-09-28 23:01
 * @Version: 1.0.0
 * @description: 数据连接池
 */
public class DBUtil {
    private static Connection conn;
    private Statement statement;
    private static DBUtil dbUtil = new DBUtil();

    private static final String url = "jdbc:postgresql://47.106.188.177:5432/s2sh";
    private static final String className = "org.postgresql.Driver";
    private static final String userName = "s2sh";
    private static final String pwd = "s2sh";

    static {
        try {
            Class.forName(className);
            conn = DriverManager.getConnection(url, userName, pwd);
            System.out.println("connection is " + conn.toString());
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static DBUtil newInstance() {
        if (null == dbUtil) {
            synchronized (dbUtil) {
                if (null == dbUtil) {
                    dbUtil = new DBUtil();
                }
            }
        }
        try {
            //默认数据不自动提交事务
            conn.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dbUtil;
    }

    public static Boolean close(Connection conn) throws SQLException {
        boolean flag = false;
        if (null != conn) {
            conn.close();
            flag = true;
        }
        return flag;
    }

    public static Boolean close(Connection conn, Statement statement) throws SQLException {
        boolean flag;
        if (null != statement) {
            statement.close();
        }
        flag = close(conn);
        return flag;
    }

    public static Boolean close(Connection conn, Statement statement, ResultSet resultSet) throws SQLException {
        boolean flag;
        if (null != resultSet) {
            resultSet.close();
        }
        flag = close(conn, statement);

        return flag;
    }

    public Connection getConn() {
        return conn;
    }

    public Statement getStatement() throws SQLException {
        return conn.createStatement();
    }

}
