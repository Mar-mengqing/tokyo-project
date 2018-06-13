
package com.baizhi.crm.dao;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Table;

import com.baizhi.crm.entity.User;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class DaoHelper {

	private static Logger logger = Logger.getLogger(DaoHelper.class);

	@PersistenceContext
	protected EntityManager em;
	
	protected <T> String className(Class<T> clazz) {
		return clazz.getSimpleName();
	}
	
	protected <T> String shortClassName(Class<T> clazz) {
		return clazz.getName();
	}

	protected <T> String getTableName(Class<T> clazz) {
		Table a = (Table) clazz.getAnnotation(Table.class);
		if (null != a)
			return a.name().toLowerCase();
		return null;
	}
	
	protected HibernateTemplate getHibernateTemplate() {
		HibernateTemplate hibernateTemplate = null;
		Session session = (Session) em.getDelegate();
		hibernateTemplate = new HibernateTemplate(session.getSessionFactory());
		return hibernateTemplate;
	}

	protected String[] getParams(Map<String, Object> queryParams) {
		String[] params = new String[0];
		if (null != queryParams) {
			params = new String[queryParams.size()];
			int index = 0;
			Set<String> ps = queryParams.keySet();
			for (String p : ps) {
				params[index++] = p;
			}
		}
		return params;
	}

	protected Object[] getValues(Map<String, Object> queryParams) {
		String[] params = getParams(queryParams);
		Object[] values = new Object[params.length];
		int index = 0;
		for (String p : params) {
			values[index++] = queryParams.get(p);
		}
		return values;
	}

	private Method findSetter(Method[] ms, String f) {
		Method method = null;
		for (Method m : ms) {
			if (("set" + f).equals(m.getName())) {
				method = m;
				break;
			}
		}
		return method;
	}

	private Method findGetter(Method[] ms, String f) {
		Method method = null;
		for (Method m : ms) {
			if (("get" + f).equals(m.getName()) || ("is" + f).equals(m.getName())) {
				method = m;
				break;
			}
		}
		return method;
	}

	protected <T> List<T> packageEntity(String columns, List<Object[]> values, Class<T> clazz) {
		List<T> result = new ArrayList<T>();
		String[] mm = columns.replaceAll(" ", "").split(",");
		Method[] ms = clazz.getMethods();
		try {
			if(mm.length == 1){
				for (Object value : values) {
					T t = (T) clazz.newInstance();
					Object objs = value;
						char firstChar = mm[0].charAt(0);
						String lastStr = (firstChar + "").toUpperCase() + mm[0].substring(1);
						Method gm = findGetter(ms, lastStr);
						Method sm = findSetter(ms, lastStr);
						DataTypeEnum[] dt = DataTypeEnum.values();
						Object o = null;
						for (DataTypeEnum dte : dt) {
							if (dte.findClass() == gm.getReturnType()) {
								o = dte.convertDataType(objs);
								break;
							}
						}
						sm.invoke(t, o);
					result.add(t);
				}
			}else{
				for (Object[] value : values) {
					T t = (T) clazz.newInstance();
					Object[] objs = value;
					for (int i = 0; i < mm.length; i++) {
						char firstChar = mm[i].charAt(0);
						String lastStr = (firstChar + "").toUpperCase() + mm[i].substring(1);
						Method gm = findGetter(ms, lastStr);
						Method sm = findSetter(ms, lastStr);
						DataTypeEnum[] dt = DataTypeEnum.values();
						Object o = null;
						for (DataTypeEnum dte : dt) {
							if (dte.findClass() == gm.getReturnType()) {
								o = dte.convertDataType(objs[i]);
								break;
							}
						}
						sm.invoke(t, o);
					}
					result.add(t);
				}
			}
			
		} catch (Exception ex) {
			logger.debug("方法packageEntity把指定列值封装到自定义bean中发生异常", ex);
		}
		return result;
	}

	
	public static void main(String[] args) {
		System.out.println(User.class.getSimpleName());
	}
}
