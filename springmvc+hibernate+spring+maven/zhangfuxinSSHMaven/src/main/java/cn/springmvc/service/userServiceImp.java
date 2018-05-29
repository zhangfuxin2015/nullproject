package cn.springmvc.service;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.springmvc.dao.GenericDao;
import cn.springmvc.model.User;
import cn.springmvc.util.PageUtil;
@Service
public class userServiceImp implements userservice {
	@Autowired
	public GenericDao dao;
	@Override
    @Transactional(readOnly=false) 
	public void save(User u) {
		// TODO Auto-generated method stub
		dao.save(u);
	}
	
	@Transactional(readOnly=false) 
	public void delete(int i) {
		// TODO Auto-generated method stub
		dao.deleteById(User.class, i);
	}

	@Override
	@Transactional(readOnly=false) 
	public void update(User u) {
		// TODO Auto-generated method stub
		dao.update(u);
	}

	@Override
	public PageUtil findBysqlPage(PageUtil p, int firstResult, int maxResults, Object[] obj) {
		// TODO Auto-generated method stub
		return dao.findBysqlPage(p, firstResult, maxResults, obj);
	}


}
