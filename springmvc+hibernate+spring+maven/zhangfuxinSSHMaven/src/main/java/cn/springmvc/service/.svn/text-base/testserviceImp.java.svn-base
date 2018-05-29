package cn.springmvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.springmvc.dao.GenericDao;
import cn.springmvc.model.Test22222;
@Service
public class testserviceImp implements testservice {
	@Autowired
	public GenericDao dao;
	 @Transactional(readOnly=false) 
	public void save(Test22222 u) {
		// TODO Auto-generated method stub
		dao.save(u);
	
	}
	@Override
	public void savesql(Object[] obj) {
		// TODO Auto-generated method stub
		String sql="INSERT into test22222 (name,sex)  values(?,?)";
		dao.executeSql(sql, obj);
	}
	@Override
	public void updatesql(Object[] obj) {
		// TODO Auto-generated method stub
		String sql="update test22222 set name=?,sex=? where id=? ";
		dao.executeSql(sql, obj);
	}
	

}
