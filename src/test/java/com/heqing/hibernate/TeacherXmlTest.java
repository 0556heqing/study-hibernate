package com.heqing.hibernate;

import com.alibaba.fastjson.JSONObject;
import com.heqing.hibernate.dao.SchoolClassXmlDao;
import com.heqing.hibernate.dao.TeacherXmlDao;
import com.heqing.hibernate.model.SchoolClassXml;
import com.heqing.hibernate.model.TeacherXml;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.StringUtils;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        locations = {"classpath*:spring-core.xml","classpath:spring-hibernate.xml"}
)
public class TeacherXmlTest {

    @Autowired
    TeacherXmlDao teacherXmlDao;

    @Autowired
    SchoolClassXmlDao schoolClassXmlDao;

    @Test
    public void testGetOneByKey() {
        TeacherXml teacher = teacherXmlDao.getOneByKey(1L);
        System.out.println("-->" + JSONObject.toJSONString(teacher));
        System.out.println("-----------管理班级----------");
        System.out.println("-->" + JSONObject.toJSONString(teacher.getSuperviseSchoolClass()));
        System.out.println("-----------授课年级中含有的班级----------");
        for(SchoolClassXml schoolClass : teacher.getSchoolClassDirectorList()) {
            System.out.println("-->" + JSONObject.toJSONString(schoolClass));
        }
        if(teacher.getTeachSchoolClassesList() != null) {
            System.out.println("-----------授课班级----------");
            for (SchoolClassXml schoolClass : teacher.getTeachSchoolClassesList()) {
                System.out.println("-->" + JSONObject.toJSONString(schoolClass));
            }
        }

        SchoolClassXml schoolClass = schoolClassXmlDao.getOneByKey(1L);
        System.out.println("-->" + JSONObject.toJSONString(schoolClass));
        System.out.println("-----------班主任----------");
        System.out.println("-->" + JSONObject.toJSONString(schoolClass.getHeadTeacher()));
        System.out.println("-----------年级主任----------");
        System.out.println("-->" + JSONObject.toJSONString(schoolClass.getClassDirector()));
        if(schoolClass.getTeacherList() != null) {
            System.out.println("-----------授课教师----------");
            for (TeacherXml t : schoolClass.getTeacherList()) {
                System.out.println("-->" + JSONObject.toJSONString(t));
            }
        }
    }

}
