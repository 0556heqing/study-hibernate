package com.heqing.hibernate.dao.base;

import com.heqing.hibernate.util.PageInfoUtil;

import java.io.Serializable;
import java.util.List;

/**
 * 注意: 继承这个接口中的实体必须是基于注解实现的, xml无法获取对应的字段名
 * @author heqing
 * @since 2021-07-21
 */
public interface AnnotationBaseDao<T, PK extends Serializable> extends BaseDao<T, PK>  {

    /**
     * 返回所有数据
     * @return List<T> 列信息
     */
    List<T> list();

    /**
     * 根据条件返回数据
     * @param t
     * @return
     */
    List<T> list(T t);

    /**
     * 根据条件返回数据
     * @param t
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfoUtil<T> listByPage(T t, int pageNum, int pageSize);
}
