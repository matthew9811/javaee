package util;


import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Author: matthew
 * @ClassName DBListTest
 * @Date: 2019-10-01 0:34
 * @Version: 1.0.0
 * @description:
 */
public class DBListTest {

    @Test
    public void check() {
        ResultSet check = DBList.check("lyh", "lyh");
        try {
            while (check.next()){
                System.out.println(check.getString("userName"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}