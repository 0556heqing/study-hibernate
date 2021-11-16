package com.heqing.hibernate.dao.impl;

import com.heqing.hibernate.dao.SchoolClassDao;
import com.heqing.hibernate.dao.base.AnnotationBaseDaoImpl;
import com.heqing.hibernate.model.SchoolClass;
import org.springframework.stereotype.Repository;

/**
 * @author heqing
 * @since 2021-07-21
 */
@Repository
public class SchoolClassDaoImpl extends AnnotationBaseDaoImpl<SchoolClass, Long> implements SchoolClassDao {
}
