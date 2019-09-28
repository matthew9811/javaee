package com.shengxi.leung.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.shengxi.leung.model.StuUsers;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

/**
 * @Author: matthew
 * @ClassName LoginAction
 * @Date: 2019-09-28 17:48
 * @Version: 1.0.0
 * @description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginAction extends ActionSupport {

    private StuUsers user;

    @Override
    public String execute() throws Exception {
        ActionContext context = ActionContext.getContext();
        Map request = (Map) context.get("request");
        request.put("user", user);
        return SUCCESS;
    }
}
