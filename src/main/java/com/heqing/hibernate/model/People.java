package com.heqing.hibernate.model;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author heqing
 * @since 2021-07-21
 */
@NoArgsConstructor
@Data
@Entity
@Table
public class People implements Serializable {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column
	private Long id;

	@Column
	private String name;

	@Column
	private Integer age;

	@Column
	private String gender;

	@JSONField(name="create_time", format="yyyy-MM-dd HH:mm:ss")
	@Column(name="create_time",columnDefinition = "创建时间")
	private Date createTime;
}
