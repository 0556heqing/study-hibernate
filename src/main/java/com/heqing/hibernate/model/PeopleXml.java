package com.heqing.hibernate.model;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @author heqing
 * @since 2021-07-21
 */
@NoArgsConstructor
@Data
public class PeopleXml implements Serializable {

	private Long id;
	private String name;
	private Integer age;
	private String gender;
	@JSONField(name="create_time", format="yyyy-MM-dd HH:mm:ss")
	private Date createTime;
}
