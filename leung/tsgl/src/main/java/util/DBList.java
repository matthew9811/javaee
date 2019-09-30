package util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @Author: matthew
 * @ClassName DBList
 * @Date: 2019-09-30 13:26
 * @Version: 1.0.0
 * @description:
 */
public class DBList {
    private static Connection connection;
    private static Statement statement;
    private static ResultSet resultSet;

    public static ResultSet check(String userName, String pwd) {
        DBUtil dbUtil = DBUtil.newInstance();
        try {
            statement = dbUtil.getStatement();
            String sql = "select * from usertable where userName = '" + userName + "' and password = '" + pwd + "' ";
            resultSet = statement.executeQuery(sql);
//            resultSet = statement.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
//            try {
//                DBUtil.close(connection, statement);
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
        }
        return resultSet;
    }
}
