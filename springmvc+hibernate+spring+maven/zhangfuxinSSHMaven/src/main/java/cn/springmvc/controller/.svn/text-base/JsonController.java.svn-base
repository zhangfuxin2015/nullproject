package cn.springmvc.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import cn.springmvc.service.JsonService;
import cn.springmvc.service.userservice;
import cn.springmvc.util.ObjectMappingCustomer;
import cn.springmvc.util.PageUtil;

@Controller
@RequestMapping("/json")
public class JsonController {
	@Autowired
	private JsonService jsonservice;
	 //登录（返回用户信息+场景id）
	 @RequestMapping("/login.do")
	public @ResponseBody void login(HttpServletRequest request, HttpServletResponse response) throws IOException{

			String str=new String(request.getParameter("WebWB").getBytes("ISO-8859-1"), "UTF-8");
		     JSONObject jb=new JSONObject(str);   
			 PageUtil p=new PageUtil();
			 String[] array =new String[3];
//			 Gson gson=new Gson();  
//			 Gson g = new GsonBuilder().serializeNulls().create();
			// p.setCountSql("select count(1) from member_info s where s.account_number=? and s.password=?");
			 StringBuffer sb=new StringBuffer();
			 //1 为 个人 2、企业3、平台场景
			 sb.append("select mem.*,h.zhanguanid as 'zhanguanid' ,DATE_FORMAT(mem.createTime,'%Y-%m-%d') as 'createtime2' from member_info mem LEFT JOIN (");
			 sb.append(" select info.id as 'zhanguanid',name,'2' as type ,associateZhangWei as infoid,exh.cust_id as userid from enterprise_liecai_info info,exhibition exh where info.associateZhangWei=exh.id");
			 sb.append(" union");
			 sb.append(" select info.id as 'zhanguanid',name,'1' as type, associatezhangwei as infoid,exh.cust_id as userid from personal_liecai_info info,exhibition exh where info.associatezhangwei=exh.id");
			 sb.append(" union");
			 sb.append(" select info.id as 'zhanguanid',name,'3' as type, exhibitionHallId as infoid,exh.cust_id as userid from scener_info info,exhibition exh where info.exhibitionHallId=exh.id");
			 sb.append(" ) h  on mem.id =h.userid  and h.type=?");
			 sb.append(" where mem.account_number=? and mem.password=?");
			 p.setSql(sb.toString());
			 System.out.println("sb:"+sb.toString());
			 if(str!=null){
				 array[0]=jb.getString("Type");
				 array[1]=jb.getString("UserName");	
				 array[2]=jb.getString("Password");
			 }
			 p=jsonservice.getUser(p, 0,5,array);
			 response.setContentType("type=text;charset=UTF-8");  
			 response.setCharacterEncoding("UTF-8");
			 Map map=null;
			 Map<String, Object> jsonMap = new HashMap<String, Object>();//定义map  
			 ObjectMappingCustomer mapper = new ObjectMappingCustomer();
			 
			 if(p.getInfo().size()>0){
				 map= p.getInfo().get(0);	 
				 jsonMap.put("zfx", map);
				 jsonMap.put("error","200" );
				 response.getWriter().write(mapper.writeValueAsString(jsonMap));//   g.toJson(map)
			 }else{
				 map=new HashMap();
				 map.put("error", "250");
				 response.getWriter().write(mapper.writeValueAsString(map));//   g.toJson(map)
			 }

			 
			 
			 
			
			 
	 }
	/**
	 * 企业/个人能保存招聘信息或者修改
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/insertEnterpriseResume.do")
	public @ResponseBody void insertEnterpriseRecurit(HttpServletRequest request, HttpServletResponse response) throws IOException{
		try {
			System.out.println("调用insertEnterpriseResume.do");
			String str=new String(request.getParameter("WebWB").getBytes("ISO-8859-1"), "UTF-8");
		     JSONObject jb=new JSONObject(str);   
			 PageUtil p=new PageUtil();
			 String[] array =new String[17];
			 ObjectMappingCustomer mapper = new ObjectMappingCustomer();
			 StringBuffer sb=new StringBuffer();
			 SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
			 String time=df.format(new Date());
			 String uuid = UUID.randomUUID().toString().replace("-", "");
			 //保存或者修改个人简历
			 System.out.println(str+"++发送的json");
			 if(!jb.getString("type").equals("2")){
				 String id=jb.getString("company_id");
				 if(id.equals("")){  // 
					 array[0]=uuid;array[1]=jb.getString("individual_Name");array[2]=jb.getString("placeOfOrigin");array[3]=jb.getString("education");
					 array[4]=jb.getString("age");array[5]=jb.getString("dateOfBirth");array[6]=jb.getString("photoURL");array[7]=jb.getString("jobOrientation");
					 array[8]=jb.getString("expectedSalary");array[9]=jb.getString("workingYears");array[10]=jb.getString("selfIntroduction");array[11]=jb.getString("workExperience");
					 array[12]=jb.getString("industryCategory");array[13]=jb.getString("remarks");array[14]=df.format(new Date());
					 array[15]=jb.getString("zhanguanid");
					 sb.append("insert into person_resumemanager (id,name,placeOfOrigin,education,age,dateOfBirth,photoURL,jobOrientation,expectedSalary,workingYears,indrouceMyself,workExperience,industryCategory,remarks,releaseDate,personal_liecai_infoId)");
					 sb.append(" values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
				 }else{
					 array[0]=jb.getString("individual_Name");array[1]=jb.getString("placeOfOrigin");array[2]=jb.getString("education");
					 array[3]=jb.getString("age");array[4]=jb.getString("dateOfBirth");array[5]=jb.getString("photoURL");array[6]=jb.getString("jobOrientation");
					 array[7]=jb.getString("expectedSalary");array[8]=jb.getString("workingYears");array[9]=jb.getString("selfIntroduction");
					 array[10]=jb.getString("workExperience");array[11]=jb.getString("industryCategory");
					 array[12]=jb.getString("remarks");array[13]=id;
					 sb.append("update person_resumemanager");
					 sb.append(" set name=?,placeOfOrigin=?,education=?,age=?,dateOfBirth=?,photoURL=?,jobOrientation=?,expectedSalary=?,workingYears=?,indrouceMyself=?,workExperience=?,");
					 sb.append(" industryCategory=?,remarks=?");
					 sb.append("  where id=?");
				 }
			 }else{
				 if(str!=null){
					 String id=jb.getString("company_id");
					 if(id.equals("")){
						 array[0]=uuid;
						 array[1]=jb.getString("zhanguanid");//enterprise_liecai_infoid
						 array[2]=jb.getString("company_name");  
						 array[3]=jb.getString("recruitment");
						 array[4]=jb.getString("number");
						 array[5]=jb.getString("salaryRange");
						 array[6]=jb.getString("recruitmentNode");
						 array[7]=jb.getString("industryCategory");
						 array[8]=jb.getString("workingDirection");
						 array[9]=jb.getString("enterprise");
						 array[10]=time;
						 array[11]=jb.getString("enterprise");
						 sb.append("insert into enterprise_recurit (id,enterprise_liecai_infoid,company_name,jobName,number,monthlySalaryRange,jobRequirement,industryCategory");
						 sb.append(" ,workingDirection,companyIntrouduce,releaseDate,remarks)");
						 sb.append(" values(?,?,?,?,?,?,?,?,?,?,?,?)");
					 }else{
						 array[0]=jb.getString("company_name");
						 System.out.println(jb.getString("recruitment"));
						 array[1]=jb.getString("recruitment");
						 array[2]=jb.getString("number");
						 array[3]=jb.getString("salaryRange");
						 array[4]=jb.getString("recruitmentNode");
						 array[5]=jb.getString("industryCategory");
						 array[6]=jb.getString("workingDirection");
						 array[7]=jb.getString("enterprise");
						 array[8]=jb.getString("remarks");
						 array[9]=jb.getString("company_id");
						 sb.append("update enterprise_recurit set company_name=?,jobName=?,number=?,monthlySalaryRange=?,jobRequirement=?");
						 sb.append(" ,industryCategory=?,workingDirection=?,companyIntrouduce=?,remarks =? where id=?");
					 }
				 }
			 }
			 
			 String sql=sb.toString();
			 jsonservice.insertOrupdate(array, sql);
			 response.setContentType("type=text;charset=UTF-8");  
			 response.setCharacterEncoding("UTF-8"); 
			 if(jb.getString("type").equals("1")){
				 response.getWriter().write("{\"error\":\"200\"}"); 
				 return;
			 }
			 response.getWriter().write(getlistrecurit(jb.getString("zhanguanid"),jb.getString("type")));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			 response.setContentType("type=text;charset=UTF-8");  
			 response.setCharacterEncoding("UTF-8"); 
			 response.getWriter().write("{\"error\":\"250\"}");
		}
		
	}
	/**
	 * 企业保存信息时进行list遍历
	 * @param id
	 * @param type
	 * @return
	 * @throws JsonGenerationException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public String getlistrecurit(String id,String type) throws JsonGenerationException, JsonMappingException, IOException{
		 StringBuffer sb=new StringBuffer();
		 PageUtil p=new PageUtil();
		 String[] array =new String[]{id};
		 ObjectMappingCustomer mapper = new ObjectMappingCustomer();
		 Map<String, Object> jsonMap = new HashMap<String, Object>();//定义map  
		if(type.equals("1")){
//			 sb.append("select id as 'individual_ID',name as 'individual_Name',placeOfOrigin  as 'placeOfOrigin'");
//			 sb.append(" ,education as 'education',age as 'age',DATE_FORMAT(dateOfBirth ,'%Y-%m-%d'),");
//			 sb.append(" photoURL as 'photoURL',jobOrientation as 'jobOrientation',expectedSalary as 'expectedSalary'");
//			 sb.append(" ,workingYears  as 'workingYears', indrouceMyself as 'selfIntroduction',workExperience as 'workExperience'");
//			 sb.append("  ,industryCategory as 'industryCategory' ,remarks  as 'remarks'");
//			 sb.append(" from person_resumemanager where personal_liecai_infoId=?");
//			 p.setSql(sb.toString());
//			 List<Map> list=jsonservice.getUser(p, 0, 10, array).getInfo();
//			 if(list==null){
//				 Map map=new HashMap<String,String>();  
//				 map.put("individual_ID", null); map.put("individual_Name", null); map.put("placeOfOrigin", null); map.put("education", null);
//				 map.put("age", null); map.put("dateOfBirth", null); map.put("photoURL", null); map.put("jobOrientation", null);
//				 map.put("expectedSalary", null); map.put("workingYears", null); map.put("selfIntroduction", null); map.put("workExperience", null);
//				 map.put("industryCategory", null); map.put("remarks", null); map.put("releaseDate", null);
//				 list.add(map);
//				 jsonMap.put("zfx", list);
//				 jsonMap.put("error", "200");
//			 }else{
//				 jsonMap.put("zfx", list);
//				 jsonMap.put("error", "200");
//			 }
		 }else if(type.equals("2")){
			 sb.append("select   e.id as 'company_id',e.company_name as 'company_name' ,e.jobName as 'recruitment',e.number as 'number',e.monthlySalaryRange as 'salaryRange' ,e.jobRequirement as 'recruitmentNode',e.industryCategory as 'industryCategory',e.workingDirection as 'workingDirection',e.companyIntrouduce  as 'enterprise',e.remarks  as 'remarks' from enterprise_recurit e where e.enterprise_liecai_infoid=?");
			 p.setSql(sb.toString());
			 List<Map> list=jsonservice.getUser(p, 0, 10, array).getInfo();

			 if(list==null){
				 Map map=new HashMap<String,String>();  
				 map.put("company_id", null);
				 map.put("company_name", null);
				 map.put("recruitment", null);
				 map.put("number", null);
				 map.put("salaryRange", null);
				 map.put("recruitmentNode", null);
				 map.put("industryCategory", null);
				 map.put("workingDirection", null);
				 map.put("enterprise", null);
				 map.put("releaseDate", null);
				 map.put("remarks", null);
				 list.add(map);
				 jsonMap.put("zfx", list);
				 jsonMap.put("error", "200");
				  
			 }else{
				 jsonMap.put("zfx", list); 
				 jsonMap.put("error", "200");
			 }
		 }else if(type.equals("3")){
			 return null;
		 }else{
			 return null;
		 }
		 System.out.println(mapper.writeValueAsString(jsonMap));
		return mapper.writeValueAsString(jsonMap);
	}
	
	/**
	 * 通过场景id，和type查找招聘的信息
	 */
	 @RequestMapping("/getRecurit.do")
		public @ResponseBody void getScener(HttpServletRequest request, HttpServletResponse response) throws IOException{
		 String str=new String(request.getParameter("WebWB").getBytes("ISO-8859-1"), "UTF-8");
	     JSONObject jb=new JSONObject(str);   
		 PageUtil p=new PageUtil();
		 String[] array =new String[1];
		 ObjectMappingCustomer mapper = new ObjectMappingCustomer();
		 StringBuffer sb=new StringBuffer();
		 String type=jb.getString("type");
		 array[0]=jb.getString("zhanguanid");
		 List<Map> list=null;
		 Map<String, Object> jsonMap = new HashMap<String, Object>();//定义map  
		 response.setContentType("type=text;charset=UTF-8");  
		 response.setCharacterEncoding("UTF-8"); 
		 if(type.equals("1")){
			 //sb.append("select * from person_resumemanager   s where s.personal_liecai_infoId=?");
			 sb.append("select id as 'individual_ID',name as 'individual_Name',placeOfOrigin  as 'placeOfOrigin'");
			 sb.append(" ,education as 'education',age as 'age',DATE_FORMAT(dateOfBirth ,'%Y-%m-%d') as 'dateOfBirth',");
			 sb.append(" photoURL as 'photoURL',jobOrientation as 'jobOrientation',expectedSalary as 'expectedSalary'");
			 sb.append(" ,workingYears  as 'workingYears', indrouceMyself as 'selfIntroduction',workExperience as 'workExperience'");
			 sb.append("  ,industryCategory as 'industryCategory' ,remarks  as 'remarks'");
			 sb.append(" from person_resumemanager where personal_liecai_infoId=?");
			 p.setSql(sb.toString());
			 list=jsonservice.getUser(p, 0, 10, array).getInfo();
			 if(list==null){
				 Map map=new HashMap<String,String>();  
				 map.put("individual_ID", null); map.put("individual_Name", null); map.put("placeOfOrigin", null); map.put("education", null);
				 map.put("age", null); map.put("dateOfBirth", null); map.put("photoURL", null); map.put("jobOrientation", null);
				 map.put("expectedSalary", null); map.put("workingYears", null); map.put("selfIntroduction", null); map.put("workExperience", null);
				 map.put("VIP", null); map.put("industryCategory", null); map.put("remarks", null); map.put("releaseDate", null);
				 list.add(map);
				 jsonMap.put("zfx", list);
			 }else{
				 jsonMap.put("zfx", list);
			 }
		 }else if(type.equals("2")){
			 sb.append("select   e.id as 'company_id',e.company_name as 'company_name' ,e.jobName as 'recruitment',e.number as 'number',e.monthlySalaryRange as 'salaryRange' ,e.jobRequirement as 'recruitmentNode',e.industryCategory as 'industryCategory',e.workingDirection as 'workingDirection',e.companyIntrouduce  as 'enterprise',e.remarks  as 'remarks' from enterprise_recurit e where e.enterprise_liecai_infoid=?");
			 p.setSql(sb.toString());
			 list=jsonservice.getUser(p, 0, 10, array).getInfo();
			 if(list==null){
				 Map map=new HashMap<String,String>();  
				 map.put("company_id", null);
				 map.put("company_name", null);
				 map.put("recruitment", null);
				 map.put("number", null);
				 map.put("salaryRange", null);
				 map.put("recruitmentNode", null);
				 map.put("industryCategory", null);
				 map.put("workingDirection", null);
				 map.put("enterprise", null);
				 map.put("releaseDate", null);
				 map.put("remarks", null);
				 list.add(map);
				 jsonMap.put("zfx", list);
			
			 }else{
				 jsonMap.put("zfx", list);
				 //response.getWriter().write(mapper.writeValueAsString(jsonMap)); 
			 }
		 }else if(type.equals("3")){
			 return ;
		 }else{
			 return ;
		 }
		 response.getWriter().write(mapper.writeValueAsString(jsonMap)); 
		
		 // map=jsonservice.getById(p, array);
		 
		
		
		 
		 
		 
	 }
	 /**
	  * 企业招聘信息分页
	  */
	 public @ResponseBody void page(HttpServletRequest request, HttpServletResponse response) throws IOException{
		 ObjectMappingCustomer mapper = new ObjectMappingCustomer();
		 PageUtil p=new PageUtil();
		 p.setCountSql("");
		 p.setSql("");
		 List<Map> list=jsonservice.getUser(p, 0, 10, null).getInfo();
	 }
	 /**
	  * 测试
	  * @param request
	  * @param response
	  * @throws IOException
	  */
	 @RequestMapping("/test.do")
	 public @ResponseBody void test(HttpServletRequest request, HttpServletResponse response) throws IOException{
		 Map a=new HashMap();
			a.put("name", null);
			a.put("age", "123");
			ObjectMappingCustomer mapper = new ObjectMappingCustomer();
		 System.out.println(mapper.writeValueAsString(a));  
	 }
}
