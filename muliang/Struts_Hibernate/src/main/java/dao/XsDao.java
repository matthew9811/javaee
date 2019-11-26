package dao;

import java.util.List;
import model.Xsb;

public interface XsDao {
    /**
     * 根据学号查询学生信息
     */
    Xsb getOneXs(String xh);

    /**
     * 修改学生信息
     */
    void update(Xsb xs);
}
