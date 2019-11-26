package dao;
import model.Dlb;
public interface DlDao {

	/**
	 *
	 根据学号和密码查询
	 */
	public Dlb validate(String xh, String kl);
}

