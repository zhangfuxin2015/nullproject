package cn.springmvc.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.springmvc.model.Test22222;
import cn.springmvc.model.User;
import cn.springmvc.service.testservice;
import cn.springmvc.service.userservice;
import cn.springmvc.util.PageUtil;

@Controller
@RequestMapping("/zhangfuxin")
public class TestController {
	@Autowired
	private userservice user;
	@Autowired
	private testservice test;
	@RequestMapping("/getu.do")
	@Transactional
	 public ModelAndView saveuu() {
		String[] array = {"test", "231","35"};
		//test.savesql(array);
		test.updatesql(array);
		return null;
	 }
  
}
