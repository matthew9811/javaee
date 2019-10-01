package util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @Author: matthew
 * @ClassName DBList
 * @Date: 2019-09-30 13:26
 * @Version: 1.0.0
 * @description: 数据库操作
 */
public class DBList {
    private static Connection connection;
    private static Statement statement;
    private static ResultSet resultSet;

    /**
     * 查看是否有对应用户
     * @param userName un
     * @param pwd pwd
     * @return bool
     * @throws SQLException
     */
    public static Boolean check(String userName, String pwd) throws SQLException {
        DBUtil dbUtil = DBUtil.newInstance();
        Boolean flag = false;
        try {
            connection = dbUtil.getConn();
            String sql = "select * from usertable where userName = '" + userName + "' and password = '" + pwd + "' ";
            DBList.resultSet = connection.prepareStatement(sql).executeQuery();
            //书写完所有的数据库操作后提交事务，尽量避免多次提交事务。
            connection.commit();
            if (DBList.resultSet.next()) {
                flag = true;
            }
        } catch (SQLException e) {
            //出现异常时，进行事务回滚。
            connection.rollback();
            e.printStackTrace();
        } finally {
            DBUtil.close(connection, statement, resultSet);
        }
        return flag;
    }
}
