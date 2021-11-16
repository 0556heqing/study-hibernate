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
@Table
public class Teacher implements Serializable {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column
	private long id;

	@Column
	private String name;

	/**
	 * 管理班级/班主任(一对一)
	 */
	@OneToOne(mappedBy="headTeacher")
	private SchoolClass superviseSchoolClass;

	/**
	 * 管理年级/年级主任（一对多）
	 */
	@OneToMany(targetEntity = SchoolClass.class, mappedBy = "classDirector",cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	private Set<SchoolClass> schoolClassDirectorList;

	/**
	 * 授课班级（多对多）
	 */
	@ManyToMany(cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinTable(
			name="teacher_class",
			joinColumns=@JoinColumn(name="teacher_id"),
			inverseJoinColumns=@JoinColumn(name="class_id")
	)
	private Set<SchoolClass> teachSchoolClassesList;

	@Override
	public String toString() {
		return "id=" + this.id;
	}
}
