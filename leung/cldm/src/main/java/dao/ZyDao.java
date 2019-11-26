package dao;

import java.util.List;
import model.Zyb;

public interface ZyDao {
    Zyb getOneZy(Integer zyId);

    List getAll();
}

