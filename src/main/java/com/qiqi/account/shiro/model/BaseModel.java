package com.qiqi.account.shiro.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
@Data
public class BaseModel implements Serializable {
	private Integer id;
	private Boolean enable;
	private String remark;
	private Integer createBy;
	private Date createTime;
	private Integer updateBy;
	private Date updateTime;

}
