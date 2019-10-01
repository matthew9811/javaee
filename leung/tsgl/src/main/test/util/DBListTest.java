package util;

import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.Assert.*;

/**
 * @Author: matthew
 * @ClassName DBListTest
 * @Date: 2019-10-01 18:02
 * @Version: 1.0.0
 * @description: 获取数据库测试
 */
public class DBListTest {

    @Test
    public void check() {

        try {
            Boolean check = DBList.check("lyh", "lyh");
            if (check) {

                System.out.println("good select");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}