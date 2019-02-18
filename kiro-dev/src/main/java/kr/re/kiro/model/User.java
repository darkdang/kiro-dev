package kr.re.kiro.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import kr.re.kiro.type.UserType;

/**
 * <pre>
 * kr.re.kiro.model
 * User.java
 * </pre>
 *
 * @Author : Kim sungkeun
 * @Date   : 2019. 2. 18.
 * @Version: 
 */
@Entity
@Table(name = "kiro_user")
public class User {

	@Id
	@Column(name = "id", length = 11, unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "email", length = 50, unique = true)
	private String email;

	@Column(name = "password", length = 128)
	private String password;

	@Column(name = "name", length = 10, nullable = false)
	private String name;

	@Column(name = "created_on", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdOn;

	@Column(name = "modified_on")
	@Temporal(TemporalType.TIMESTAMP)
	private Date modifiedOn;

	@Column(name = "last_accessed_on")
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastAccessedOn;

	@Column(name = "user_type", length = 10, nullable = false)
	@Enumerated(EnumType.ORDINAL)
	private UserType userType;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Date getModifiedOn() {
		return modifiedOn;
	}

	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}

	public Date getLastAccessedOn() {
		return lastAccessedOn;
	}

	public void setLastAccessedOn(Date lastAccessedOn) {
		this.lastAccessedOn = lastAccessedOn;
	}

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ""
				+ ", email=" + email + ""
				+ ", password=" + password + ""
				+ ", name=" + name + ""
				+ ", createdOn=" + createdOn + ""
				+ ", modifiedOn=" + modifiedOn + ""
				+ ", lastAccessedOn=" + lastAccessedOn + ""
				+ ", userType=" + userType + "]";
	}
	
	
}
