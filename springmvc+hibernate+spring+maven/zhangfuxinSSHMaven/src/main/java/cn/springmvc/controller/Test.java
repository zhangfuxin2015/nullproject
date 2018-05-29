package cn.springmvc.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONObject;

import cn.springmvc.util.ObjectMappingCustomer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Test {
	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {
//		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
//		String time=df.format(new Date());
//		System.out.println(time+"time");
//		 String uuid = UUID.randomUUID().toString().replace("-", "");  
//	        System.out.println(uuid);  
		List list=new ArrayList();
		Map a=new HashMap();
		a.put("name", null);
		a.put("age", "123");
		Map a1=new HashMap();
		a1.put("name", null);
		a1.put("age", "123");
		list.add(a);
		list.add(a1);
		Map<String, Object> jsonMap = new HashMap<String, Object>();//定义map  
		jsonMap.put("hehe", list);
		ObjectMappingCustomer mapper = new ObjectMappingCustomer();
		 //System.out.println(g.toJson(a));
		 System.out.println(mapper.writeValueAsString(jsonMap));  
		 
		
	}
}
