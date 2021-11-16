package com.heqing.hibernate.model;

import com.alibaba.fastjson.JSONObject;
import lombok.*;

import java.io.Serializable;
import java.util.Set;

/**
 * @author heqing
 * @since 2021-07-21
 */
@NoArgsConstructor
@Setter
@Getter
public class TeacherXml implements Serializable {

	private long id;
	private String name;
	private SchoolClassXml superviseSchoolClass;
	private Set<SchoolClassXml> schoolClassDirectorList;
	private Set<SchoolClassXml> teachSchoolClassesList;

	@Override
	public String toString() {
		return "id=" + this.id;
	}
}
