package cn.springmvc.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.print.attribute.standard.Finishings;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ObjectRetrievalFailureException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import cn.springmvc.util.PageUtil;
@Repository
public class GenericDAOHibernate implements GenericDao  {
	/** 
     * 这个bean里面需要注入sessionFactory，所以把这个bean写在了配置中。 
     */  
    @Autowired  
    private HibernateTemplate hibernateTemplate;  
  
    public <T> T findById(Class<T> type, Serializable id) {  
        return hibernateTemplate.get(type, id);  
    }  
  
    public <T> List<T> findAll(Class<T> type) {  
        return hibernateTemplate.loadAll(type);  
    }  
  
    public void save(Object... entities) {  
        for (Object entity : entities) {  
            hibernateTemplate.save(entity);  
            
           
        }  
    }  
  
    public void saveOrUpdate(Object entity) {  
        hibernateTemplate.saveOrUpdate(entity);  
    }  
  
    public void update(Object... entities) {  
        for (Object entity : entities) {  
            hibernateTemplate.update(entity);  
        }  
    }  
  
    public void delete(Object... entities) {  
        for (Object entity : entities) {  
            if (entity != null) {  
                hibernateTemplate.delete(entity);  
            }  
        }  
    }  
  
    public void deleteById(Class<?> type, Serializable id) {  
        if (id == null) {  
            return;  
        }  
        Object entity = findById(type, id);  
        if (entity == null) {  
            return;  
        }  
        delete(entity);  
    }  
  
    public void refresh(Object... entities) {  
        for (Object entity : entities) {  
            hibernateTemplate.refresh(entity);  
        }  
    }  
  
    public void flush() {  
        hibernateTemplate.flush();  
    
    }  
    //分页查询
    public PageUtil findBysqlPage(final PageUtil p,final int firstResult,final int maxResults,final Object[] obj){
    	PageUtil p1=hibernateTemplate.execute(new HibernateCallback() {
			@Override
			public Object doInHibernate(Session session)throws HibernateException {
						Query querycount=null;
						if(p.getCountSql()!=null){
							 querycount = session.createSQLQuery(p.getCountSql());  
						}
					
						Query query = session.createSQLQuery(p.getSql());  
						query.setFirstResult((firstResult - 1) * maxResults);
						query.setMaxResults(maxResults);
						if(obj!=null){
							 for (int i = 0; i< ((Object[]) obj).length; i++) {
							     query.setParameter(i, ((Object[]) obj)[i]);
							     if(querycount!=null){
							    	 querycount.setParameter(i, ((Object[]) obj)[i]);
							     }
							 }
						}
						
						List<Map> list = (List)query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
						if(querycount!=null){
							int totalRows = ( (Number) querycount.uniqueResult()).intValue();  
							p.setTotalRecord(totalRows);
						}
						p.setInfo(list);
						
				return p;
			}
    	});
    	return p1;
    }

	@Override
	public void executeSql(final String sql,final Object[] obj) {
		// TODO Auto-generated method stub
		hibernateTemplate.execute(new HibernateCallback() {
			@Override
			public Object doInHibernate(Session session)throws HibernateException {
				Query customerInsert = session.createSQLQuery(sql);
				if(obj!=null){
					 for (int i = 0; i< ((Object[]) obj).length; i++) {
						 if(((Object[]) obj)[i]!=null){
							 customerInsert.setParameter(i, ((Object[]) obj)[i]);
							 //customerInsert.setParameter(i, ((Object[]) obj)[i]);
						 }
						 
					 }
				}
				customerInsert.executeUpdate();
				return session;
					
			}
    	});
	}

	@Override
	public Map findBysqlPage(final PageUtil p, final Object[] obj) {
		Map m=hibernateTemplate.execute(new HibernateCallback() {
			@Override
			public Object doInHibernate(Session session)throws HibernateException {
						Query query = session.createSQLQuery(p.getSql());  
						if(obj!=null){
							 for (int i = 0; i< ((Object[]) obj).length; i++) {
								 if(((Object[]) obj)[i]!=null){
									 query.setParameter(i, ((Object[]) obj)[i]);
								 }
							     
							 }
						}
						
						Map list = (Map) query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).uniqueResult();
				return list;
			}
		});
		return m;
	}
    
    
  
}
