package dao;

import java.util.List;
import model.Kcb;

public interface KcDao {
    Kcb getOneKc(String kch);

    List getAll();
}
