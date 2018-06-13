package com.baizhi.crm.dao.impl;

import com.baizhi.crm.dao.BaseDao;
import com.baizhi.crm.dao.DaoHelper;
import com.baizhi.crm.util.Where;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;
import java.util.Map;

/**
 * Created with mengqing.
 * Date: 2018/6/6 0006
 * Time: 上午 9:40
 * 职位增删改查. 该类作用
 */
@Repository
public class BaseDaoImpl extends DaoHelper implements BaseDao {

    @Override
    public <T> T findById(Class<T> clazz, Object id) {
        return em.find(clazz,id);
    }

    @Override
    public List<Object[]> list(String sql, Map<String, Object> params) {
        Query query = em.createNativeQuery(sql);
        //传入参数到查询语句
        if(params != null){
            String[] ps = this.getParams(params);
            Object[] vs = this.getValues(params);
            for(int i = 0 ; i<ps.length;i++){
                query.setParameter(ps[i],vs[i]);
            }
        }
        List<Object[]> list = query.getResultList();
        return list;
    }

    @Override
    public <T> List<T> list(Class<T> clazz, Where where, int... index) {
        //封装查询语句
        StringBuffer querySql = new StringBuffer("from "+ shortClassName(clazz));
        if (null != where && !"".equalsIgnoreCase(where.getQuery())){
            querySql.append(" where ").append(where.getQuery());
            querySql.append(" ").append(null != where.getOrderKeys() ? where.getOrderKeys() : "");
        }
        Query query = em.createQuery(querySql.toString());
        //
        // 2、传入参数到查询语句
        //
        if (null != where && !"".equalsIgnoreCase(where.getQuery())) {
            String[] ps = this.getParams(where.getParams());
            Object[] vs = this.getValues(where.getParams());
            for (int i = 0; i < ps.length; i++) {
                query.setParameter(ps[i], vs[i]);
            }
        }

        //
        // 3、设置获取result集合范围
        //
        setResult(query, index);
        List<T> result = query.getResultList();
        return result;
    }

    private void setResult(Query query, int... index) {
        if (null != index) {
            if (index.length == 1) {
                //
                // 获取一个实体
                //
                query.setFirstResult(index[0]);
                query.setMaxResults(1 + index[0]);
            } else {
                //
                // 获取两个索引之间的实体集合
                //
                query.setFirstResult(index[0]);
                query.setMaxResults(index[1]);
            }
        }
    }

}
