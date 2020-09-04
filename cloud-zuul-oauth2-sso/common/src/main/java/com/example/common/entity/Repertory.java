package com.example.common.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author yinweiwei
 * @date 2019-02-11
 */
@Data
@Entity
@Table(name = "repertory")
public class Repertory implements Serializable {
	private static final long serialVersionUID = 5872438942257394882L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "username")
	private String username;

	@Column(name = "code")
	private String code;

	@Column(name = "status")
	private Integer status = 0;

	@Column(name = "create_user")
	private String createUser;

	@Column(name = "create_time")
	private Date createTime;

	@Column(name = "update_user")
	private String updateUser;

	@Column(name = "update_time")
	private Date updateTime;
}
