package cn.springmvc.service;

import java.util.List;
import java.util.Map;

import cn.springmvc.model.Test22222;
import cn.springmvc.util.PageUtil;

public interface JsonService {
	/**
	 * 用户登录
	 * @param p
	 * @param firstResult
	 * @param maxResults
	 * @param obj
	 * @return
	 */
	PageUtil getUser( PageUtil p, int firstResult, int maxResults, Object[] obj);
	
	void insertOrupdate(Object[] obj,String sql);
	
	Map getById(PageUtil p,Object[] obj );
}
