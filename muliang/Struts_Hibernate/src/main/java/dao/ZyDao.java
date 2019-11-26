package dao;
import java.util.List;
import model.Zyb;
public interface ZyDao {
	public Zyb getOneZy(Integer zyId);
	public List getAll();
}

