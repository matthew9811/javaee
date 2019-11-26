package action;
import java.util.Map;
import dao.DlDao;
import dao.imp.DlDaoImp;
import model.Dlb;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
public class LoginAction extends ActionSupport{

	private Dlb dlb;

	public Dlb getDlb() {
		return dlb;
	}
	public void setDlb(Dlb dlb) {
		this.dlb = dlb;
	}
	@Override
	public String execute() throws Exception {
		DlDao dlDao=new DlDaoImp();
		Dlb user=dlDao.validate(dlb.getXh(), dlb.getKl());
		if(user!=null){

			Map session=(Map)ActionContext.getContext().getSession();
			session.put("user", user);
			return SUCCESS;
		}else{
			return ERROR;
		}
	}
}

