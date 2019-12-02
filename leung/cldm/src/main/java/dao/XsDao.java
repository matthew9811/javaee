package dao;

import model.Xsb;

public interface XsDao {

    Xsb getOneXs(String xh);

    void update(Xsb xs);
}
