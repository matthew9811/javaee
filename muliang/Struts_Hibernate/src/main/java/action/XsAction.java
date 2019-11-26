package action;
import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;
import dao.XsDao;
import dao.ZyDao;
import dao.imp.KcDaoImp;
import dao.imp.XsDaoImp;
import dao.imp.ZyDaoImp;
import model.Dlb;
import model.Kcb;
import model.Xsb;
import model.Zyb;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
public class XsAction extends ActionSupport{
	XsDao xsDao;
	private Xsb xs;
	private Kcb kcb;
	private File zpFile;
	private Zyb zyb;
	public File getZpFile() {
		return zpFile;
	}
	public void setZpFile(File zpFile) {
		this.zpFile = zpFile;
	}
	public Kcb getKcb() {
		return kcb;
	}
	public void setKcb(Kcb kcb) {
		this.kcb = kcb;
	}
	public Zyb getZyb() {
		return zyb;
	}
	public void setZyb(Zyb zyb) {
		this.zyb = zyb;
	}
	public Xsb getXs() {
		return xs;
	}
	public void setXs(Xsb xs) {
		this.xs = xs;
	}
	public String execute() throws Exception {
		Map session=(Map)ActionContext.getContext().getSession();
		Dlb user=(Dlb) session.get("user");
		xsDao=new XsDaoImp();
		Xsb xs=xsDao.getOneXs(user.getXh());
		Map request=(Map)ActionContext.getContext().get("request");
		request.put("xs", xs);
		return SUCCESS;
	}

	public String getImage()throws Exception{
		xsDao=new XsDaoImp();
		byte[] zp=xsDao.getOneXs(xs.getXh()).getZp();
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("image/jpeg");
		ServletOutputStream os=response.getOutputStream();
		if(zp!=null&&zp.length>0){
			for(int i=0;i<zp.length;i++){
				os.write(zp[i]);
			}
		}
		return NONE;
	}

	public String updateXsInfo()throws Exception{
		Map session=(Map)ActionContext.getContext().getSession();
		Dlb user=(Dlb) session.get("user");
		xsDao=new XsDaoImp();
		ZyDao zyDao=new ZyDaoImp();
		List zys=zyDao.getAll();
		Xsb xs=xsDao.getOneXs(user.getXh());
		Map request=(Map)ActionContext.getContext().get("request");
		request.put("zys", zys);
		request.put("xs", xs);
		return SUCCESS;
	}

	public String updateXs()throws Exception{
		xsDao =new XsDaoImp();
		ZyDao zyDao=new ZyDaoImp();
		Xsb stu=new Xsb();
		stu.setXh(xs.getXh());
		Set list=xsDao.getOneXs(xs.getXh()).getKcs();
		stu.setKcs(list);
		stu.setXm(xs.getXm());
		stu.setXb(xs.getXb());
		stu.setCssj(xs.getCssj());
		stu.setZxf(xs.getZxf());
		stu.setBz(xs.getBz());
		Zyb zy=zyDao.getOneZy(zyb.getId());
		stu.setZyb(zy);
		if(this.getZpFile()!=null){
			FileInputStream fis=new FileInputStream(this.getZpFile());
			byte[] buffer=new byte[fis.available()];
			fis.read(buffer);
			stu.setZp(buffer);
		}
		xsDao.update(stu);
		return SUCCESS;
	}

	public String getXsKcs() throws Exception{
		Map session=(Map)ActionContext.getContext().getSession();
		Dlb user=(Dlb) session.get("user");
		String xh=user.getXh();
		Xsb xsb=new XsDaoImp().getOneXs(xh);
		Set list=xsb.getKcs();
		Map request=(Map) ActionContext.getContext().get("request");
		request.put("list",list);
		return SUCCESS;
	}


	public String deleteKc()throws Exception{
		Map session=(Map)ActionContext.getContext().getSession();
		String xh=((Dlb)session.get("user")).getXh();
		xsDao=new XsDaoImp();
		Xsb xs2=xsDao.getOneXs(xh);
		Set list=xs2.getKcs();
		Iterator iter=list.iterator();
		while(iter.hasNext()){
			Kcb kc2=(Kcb)iter.next();
			if(kc2.getKch().equals(kcb.getKch())){
				iter.remove();
			}
		}
		xs2.setKcs(list);
		xsDao.update(xs2);
		return SUCCESS;
	}

	public String selectKc()throws Exception{
		Map session=(Map)ActionContext.getContext().getSession();
		String xh=((Dlb)session.get("user")).getXh();
		xsDao=new XsDaoImp();
		Xsb xs3=xsDao.getOneXs(xh);
		Set list=xs3.getKcs();
		Iterator iter=list.iterator();
		while(iter.hasNext()){
			Kcb kc3=(Kcb)iter.next();
			if(kc3.getKch().equals(kcb.getKch())){
				return ERROR;
			}
		}
		list.add(new KcDaoImp().getOneKc(kcb.getKch()));
		xs3.setKcs(list);
		xsDao.update(xs3);
		return SUCCESS;
	}

}
