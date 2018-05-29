package cn.springmvc.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.springmvc.dao.GenericDao;
import cn.springmvc.util.PageUtil;
@Service
public class JsonServiceImp implements JsonService {
	@Autowired
	public GenericDao dao;
	@Override
	public PageUtil getUser( PageUtil p, int firstResult, int maxResults, Object[] obj) {
		// TODO Auto-generated method stub
		return dao.findBysqlPage(p, firstResult, maxResults, obj);
	}
	@Override
	public void insertOrupdate(Object[] obj,String sql) {
		// TODO Auto-generated method stub
		dao.executeSql(sql, obj);
	}
	@Override
	public Map getById(PageUtil p,Object[] obj ) {
		// TODO Auto-generated method stub
		return dao.findBysqlPage(p, obj);
	}

}
