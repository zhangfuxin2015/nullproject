package cn.springmvc.controller;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.springmvc.model.User;
import cn.springmvc.service.UserService;
import cn.springmvc.service.impl.UserServiceImpl;

 
@Controller
@RequestMapping("/")
public class UserComtroller {
	@Autowired
	private UserService u;
    @RequestMapping("index")
    public String index(){
    	System.out.println("走了index的方法");
    	User user = new User();
        user.setNickname("你好");
        user.setState(2);
    	u.insertUser(user);
        return "index";
    }
	public UserService getU() {
		return u;
	}
	public void setU(UserService u) {
		this.u = u;
	}
    
     
}