package dao;
import java.util.List;
import model.Kcb;
public interface KcDao {
	public Kcb getOneKc(String kch);
	public List getAll();
}
