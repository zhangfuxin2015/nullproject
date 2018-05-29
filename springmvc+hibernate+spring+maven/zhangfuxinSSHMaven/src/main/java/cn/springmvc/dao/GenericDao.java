package cn.springmvc.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import cn.springmvc.util.PageUtil;

public interface GenericDao {
	 public <T> T findById(Class<T> type, Serializable id);    
     
	    public <T> List<T> findAll(Class<T> type);    
	    /**
	     * 保存的方法
	     * @param entities
	     */
	    public void save(Object... entities);    
	    /**
	     * 修改
	     * @param entities
	     */
	    public void update(Object... entities);    
	    /**
	     * 修改或者保存
	     * @param entity
	     */
	    public void saveOrUpdate(Object entity);    
	    /**
	     * 传入对象方式删除
	     * @param entities
	     */
	    public void delete(Object... entities);    
	    /**
	     * 通过id的方式删除
	     * @param type
	     * @param id
	     */
	    public void deleteById(Class<?> type, Serializable id);    
	    
	    public void refresh(Object... entities);    
	    
	    public void flush();  
	    /**
	     * 原生sql分页查询
	     * @param p				传入的类，里面包含分页的详细信息
	     * @param firstResult   从第几条记录开始取
	     * @param maxResult  	查几条数据，
	     * @param  Object[] obj 传入的数组。防止注入sql 
	     * @return
	     */
	    public PageUtil findBysqlPage(final PageUtil p,final int firstResult,final int maxResults,final Object[] obj);
	    
	    public void executeSql(String sql, Object[] obj);
	    
	    public Map findBysqlPage(final PageUtil p,final Object[] obj);
	    
	    
	    
	    
}
