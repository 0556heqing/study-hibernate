package com.heqing.hibernate.dao.impl;

import com.heqing.hibernate.dao.TeacherDao;
import com.heqing.hibernate.dao.base.AnnotationBaseDaoImpl;
import com.heqing.hibernate.model.Teacher;
import org.springframework.stereotype.Repository;

/**
 * @author heqing
 * @since 2021-07-21
 */
@Repository
public class TeacherDaoImpl extends AnnotationBaseDaoImpl<Teacher, Long> implements TeacherDao {

}
