package cn.springmvc.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestDate {
	public static void main(String[] args) throws ParseException {
		Date date = new Date();   
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
		//DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

		String dateStr = "2015-01-05";   
		 date = df.parse(dateStr);   
		 System.out.println(date.toString());   
		 
		 String dd="1960-1-1";
		 Date ss=df.parse(dd);
		 System.out.println(ss.toString());
		 String s=df.format(ss);
		 System.out.println(s);

	}
}
