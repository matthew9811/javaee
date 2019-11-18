package com.shengxi.carblog.controller.main;

import com.shengxi.carblog.pojo.User;
import com.shengxi.carblog.service.admin.IUserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yan
 */
@RestController
public class TestController {

    @Autowired
    private IUserService userService;

    @GetMapping("/findAll")
    public void findAll(){
//        List<User> users = userService.listAll();
//        users.forEach(k-> System.out.println(k.toString()));
    }
}
