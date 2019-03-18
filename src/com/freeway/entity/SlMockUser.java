package com.freeway.entity;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * sl_mock_user:
 */
@Entity
@Table(name = "sl_mock_user")
public class SlMockUser implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * id:
	 */
	private int id;

	/**
	 * user_id:
	 */
	private int userId;

	/**
	 * ����:����
	 */
	private String realname;

	/**
	 * phone:
	 */
	private String phone;

	/**
	 * ���п�:���п�
	 */
	private String bankcard;

	/**
	 * ���֤��:���֤��
	 */
	private String idcard;

	/**
	 * ״̬:״̬
	 */
	private byte status;

	/**
	 * ����ʱ��:����ʱ��
	 */
	private Date createdAt;
	

	/**
	 * ����ʱ��:����ʱ��
	 */
	private Date updatedAt;
	private SlMockUser slMockUser;

	public SlMockUser() {
		super();
	}

	public SlMockUser(int id, int userId, String realname, String phone,
			String bankcard, String idcard, byte status, Date createdAt,
			Date updatedAt) {
		super();
		this.id = id;
		this.userId = userId;
		this.realname = realname;
		this.phone = phone;
		this.bankcard = bankcard;
		this.idcard = idcard;
		this.status = status;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	public int getId() {
		return id;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Column(name = "user_id")
	public int getUserId() {
		return userId;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	@Column(name = "realname", length = 20)
	public String getRealname() {
		return realname;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "phone", length = 45)
	public String getPhone() {
		return phone;
	}

	public void setBankcard(String bankcard) {
		this.bankcard = bankcard;
	}

	@Column(name = "bankCard", length = 30, nullable = false)
	public String getBankcard() {
		return bankcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	@Column(name = "idCard", length = 255, nullable = false)
	public String getIdcard() {
		return idcard;
	}

	public void setStatus(byte status) {
		this.status = status;
	}

	@Column(name = "status", nullable = false)
	public byte getStatus() {
		return status;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at", nullable = false)
	public Date getCreatedAt() {
		return createdAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_at", nullable = false)
	public Date getUpdatedAt() {
		return updatedAt;
	}
	
//	public void setMockUser(SlMockUser slMockUser) {
//		this.slMockUser = slMockUser;
//	}
//
//	private Set<SlMockUser> slMockUserSet = new HashSet<SlMockUser>(0);
//    
//    public void setSlMockUserSet(Set<SlMockUser> slMockUserSet) {
//        this.slMockUserSet = slMockUserSet;
//    }
//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "slMockUser")
//    public Set<SlMockUser> getSlMockUserSet() {
//        return slMockUserSet;
//    }

	public String toString() {
		return "SlMockUser [id=" + id + ",userId=" + userId + ",realname="
				+ realname + ",phone=" + phone + ",bankcard=" + bankcard
				+ ",idcard=" + idcard + ",status=" + status + ",createdAt="
				+ createdAt + ",updatedAt=" + updatedAt + "]";
	}

}
