package com.heqing.hibernate.model;

import com.alibaba.fastjson.JSONObject;
import lombok.*;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

/**
 * @author heqing
 * @since 2021-07-21
 */
@NoArgsConstructor
@Setter
@Getter
public class SchoolClassXml implements Serializable {

	private long id;
	private String name;
	private TeacherXml headTeacher;
	private TeacherXml classDirector;
	private String classDirectorName;
	private Set<TeacherXml> teacherList;

	@Override
	public String toString() {
		return "id=" + this.id;
	}
}
