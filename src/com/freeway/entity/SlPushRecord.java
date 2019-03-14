package com.freeway.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * sl_push_record:
 */
@Entity
@Table(name = "sl_push_record")
public class SlPushRecord implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * id:
	 */
	private int id;

	/**
	 * order_id:
	 */
	private int orderId;

	/**
	 * content:
	 */
	private String content;

	/**
	 * result:
	 */
	private String result;

	/**
	 * project:
	 */
	private String project;

	/**
	 * environment:
	 */
	private String environment;

	/**
	 * created_at:
	 */
	private Date createdAt;

	public SlPushRecord() {

		super();
	}

	public SlPushRecord(int id, int orderId, String content, String result, String project, String environment,
			Date createdAt) {

		super();
		this.id = id;
		this.orderId = orderId;
		this.content = content;
		this.result = result;
		this.project = project;
		this.environment = environment;
		this.createdAt = createdAt;
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

	public void setOrderId(int orderId) {

		this.orderId = orderId;
	}

	@Column(name = "order_id")
	public int getOrderId() {

		return orderId;
	}

	public void setContent(String content) {

		this.content = content;
	}

	@Column(name = "content", length = 200)
	public String getContent() {

		return content;
	}

	public void setResult(String result) {

		this.result = result;
	}

	@Column(name = "result", length = 200)
	public String getResult() {

		return result;
	}

	public void setProject(String project) {

		this.project = project;
	}

	@Column(name = "project", length = 50)
	public String getProject() {

		return project;
	}

	public void setEnvironment(String environment) {

		this.environment = environment;
	}

	@Column(name = "environment", length = 50)
	public String getEnvironment() {

		return environment;
	}

	public void setCreatedAt(Date createdAt) {

		this.createdAt = createdAt;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at", nullable = false)
	public Date getCreatedAt() {

		return createdAt;
	}

	public String toString() {

		return "SlPushRecord [id=" + id + ",orderId=" + orderId + ",content=" + content + ",result=" + result + ",project="
				+ project + ",environment=" + environment + ",createdAt=" + createdAt + "]";
	}

}
