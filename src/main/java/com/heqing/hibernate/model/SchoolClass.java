package com.heqing.hibernate.model;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * @author heqing
 * @since 2021-07-21
 */
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name="school_class")
public class SchoolClass implements Serializable {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column
	private long id;

	@Column
	private String name;

	@OneToOne(cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name = "head_teacher_id")
	private Teacher headTeacher;

	@ManyToOne(targetEntity = Teacher.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "class_director_id", referencedColumnName="id")
	private Teacher classDirector;

	@Column(name="class_director_name")
	private String classDirectorName;

	@ManyToMany(mappedBy="teachSchoolClassesList",fetch=FetchType.EAGER)
	private Set<Teacher> teacherList;

	@Override
	public String toString() {
		return "id=" + this.id;
	}
}
