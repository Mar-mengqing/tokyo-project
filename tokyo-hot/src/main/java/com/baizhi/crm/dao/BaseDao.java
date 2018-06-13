package com.baizhi.crm.dao;

import com.baizhi.crm.util.Where;

import java.util.List;
import java.util.Map;

/**
 * Created with mengqing.
 * Date: 2018/6/6 0006
 * Time: 上午 9:39
 * 数据底层操作接口
 */
public interface BaseDao {
    /**
     * 根据之间id查询实体
     * clazz 实体类
     * id 主键id
     */
    <T> T findById(Class<T> clazz,Object id);
    /**
     * 自定义sql语句查询
     * map形势的参数
     */
    List<Object[]> list(String sql,Map<String,Object> params);
    /**
     * 根据条件获取实体集合 某几条,1到多条
     * @param<T>
     * @param clazz
     * @param where
     * @param index 索引 null:全部集合；index1:获取指定索引的值；index1，index2:获取的是两个索引之间的集合
     * @return
     */
    <T> List<T> list(Class<T> clazz, Where where, int...index );
}
