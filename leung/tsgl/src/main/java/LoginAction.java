import com.opensymphony.xwork2.ActionSupport;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.struts2.ServletActionContext;
import pojo.User;
import util.DBList;

import javax.servlet.http.HttpServletRequest;
import java.sql.ResultSet;

/**
 * @Author: matthew
 * @ClassName LoginAction
 * @Date: 2019-09-28 19:49
 * @Version: 1.0.0
 * @description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginAction extends ActionSupport {

    private User user;

    @Override
    public String execute() throws Exception {
        Boolean check = DBList.check(this.getUser().getUn(), this.getUser().getPwd());
        HttpServletRequest request = ServletActionContext.getRequest();
        if (!check) {
            request.setAttribute("check", "密码错误");
            return ERROR;
        }
        request.setAttribute("user", this.user.getUn());
        return SUCCESS;
    }
}
