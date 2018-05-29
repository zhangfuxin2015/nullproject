package cn.springmvc.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.JsonNull;

import cn.springmvc.model.User;
import cn.springmvc.service.userservice;
import cn.springmvc.util.PageUtil;
@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private userservice user;
	@RequestMapping("/getu.do")
	 public ModelAndView getu(User u) {
		 ModelAndView modelAndView = new ModelAndView();
//		// User u=new User();
//		 u.setName("heheh");
//		 u.setDateee(new Date());
//		 u.setId(2);
//		 u.setName("fasdfafdsa");
//		 user.update(u);
		 PageUtil p=new PageUtil();
		 p.setCountSql("select count(1) from user u where u.name =?");
		 p.setSql("select * from user u where u.name =?");
		 String conditons[]= new String[]{"415415"};
		p=user.findBysqlPage(p, 0,2,conditons);
		try {
		     modelAndView.setViewName( "hehe" );  
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		 return modelAndView;
	 }
	@RequestMapping("/test.do")
    @ResponseBody 
    public String get(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException{
		String str = URLDecoder.decode(request.getParameter("Login"),"UTF-8");  
        JSONObject jb=new JSONObject(str);   
        String s=jb.getString("UserName");
        //将json格式的字符串转换为json对象，并取得该对象的“userName”属性值  
        System.out.println(s);  
		return "zfx";
	}
	
	@RequestMapping("/test1.do")
    public void getbigjson(HttpServletRequest request, HttpServletResponse response) throws IOException{
		//String str=request.getParameter("Personal");
		//String str = URLDecoder.decode(request.getParameter("Personal"),"UTF-8");  //GBK
		//String str = URLDecoder.decode(request.getParameter("Personal"),"GBK");
		String str=new String(request.getParameter("Personal").getBytes("ISO-8859-1"), "UTF-8");
		//System.out.println(new String(request.getParameter("Personal").getBytes("ISO-8859-1"), "UTF-8"));
        JSONObject jb=new JSONObject(str);   
        String Individual_ID=jb.getString("Individual_ID");
        String Individual_Name=jb.getString("Individual_Name");
        String Age=jb.getString("Age");  
        String JobOrientation=jb.getString("JobOrientation");
        String PlaceOfOrigin=jb.getString("PlaceOfOrigin");
        String DateOfBirth=jb.getString("DateOfBirth");
        String Education=jb.getString("Education");
        String WorkingYears=jb.getString("WorkingYears");
        String SelfIntroduction=jb.getString("SelfIntroduction");
        String WorkExperience=jb.getString("WorkExperience");
        String Remarks=jb.getString("Remarks");
        System.out.println("Individual_ID:"+Individual_ID);
        System.out.println("Individual_Name:"+Individual_Name);
        System.out.println("Age:"+Age);
        System.out.println("JobOrientation:"+JobOrientation);
        System.out.println("DateOfBirth:"+DateOfBirth);
        System.out.println("Education:"+Education);
        System.out.println("WorkingYears:"+WorkingYears);
        System.out.println("SelfIntroduction:"+SelfIntroduction);
        System.out.println("WorkExperience:"+WorkExperience);
        System.out.println("Remarks:"+Remarks);
        System.out.println("_______________________________________");
        response.setContentType("type=text;charset=UTF-8");  
		response.setCharacterEncoding("UTF-8");  
	    response.getWriter().write("{ \"id\":0, \"lists\":[\"1\",\"2\",\"呵呵\"],\"name\":\"张福新测试\"}"); 
	}
	/**
	 * 返回json数据
	 */
	@RequestMapping("/getjson.do")
	 public @ResponseBody String getjson(User u) {
//		// User u=new User();
//		 u.setName("heheh");
//		 u.setDateee(new Date());
//		 u.setId(2);
//		 u.setName("fasdfafdsa");
//		 user.update(u);
		 PageUtil p=new PageUtil();
		try {
			
			 p.setCountSql("select count(1) from material u ");
			 p.setSql("select * from material u2 ");
			 //String conditons[]= new String[]{"415415"};
			p=user.findBysqlPage(p, 0,5,null);
		
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		Gson gson=new Gson();  
		//p.getInfo()
		System.out.println(gson.toJson(p.getInfo()));
		 return  gson.toJson(p.getInfo());
	 }

	@RequestMapping(value="getjsonssss.do") 
	public void tes(HttpServletRequest request, HttpServletResponse response) throws IOException{
		  response.setContentType("type=text;charset=UTF-8");  
			response.setCharacterEncoding("UTF-8");  
		    response.getWriter().write("{ \"id\":0, \"lists\":[\"1\",\"2\",\"呵呵\"],\"name\":\"张福新测试\"}"); 
		    
		    
	}
}
