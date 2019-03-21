package com.freeway.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * sl_project:
 */
@Entity
@Table(name = "sl_project")
public class SlProject implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * project_id:
	 */
	private int projectId;

	/**
	 * project_name:
	 */
	private String projectName;

	/**
	 * project_code:
	 */
	private String projectCode;

	/**
	 * environment:
	 */
	private String environment;

	/**
	 * url:
	 */
	private String url;

	/**
	 * product_code:
	 */
	private String productCode;

	/**
	 * product_name:
	 */
	private String productName;

	/**
	 * status:
	 */
	private String status;

	public SlProject() {
		super();
	}

	public SlProject(int projectId, String projectName, String projectCode,
			String environment, String url, String productCode,
			String productName, String status) {
		super();
		this.projectId = projectId;
		this.projectName = projectName;
		this.projectCode = projectCode;
		this.environment = environment;
		this.url = url;
		this.productCode = productCode;
		this.productName = productName;
		this.status = status;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "project_id", nullable = false)
	public int getProjectId() {
		return projectId;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	@Column(name = "project_name", length = 50)
	public String getProjectName() {
		return projectName;
	}

	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}

	@Column(name = "project_code", length = 100)
	public String getProjectCode() {
		return projectCode;
	}

	public void setEnvironment(String environment) {
		this.environment = environment;
	}

	@Column(name = "environment", length = 45)
	public String getEnvironment() {
		return environment;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Column(name = "url", length = 500)
	public String getUrl() {
		return url;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	@Column(name = "product_code", length = 50)
	public String getProductCode() {
		return productCode;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	@Column(name = "product_name", length = 20)
	public String getProductName() {
		return productName;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "status", length = 20, nullable = false)
	public String getStatus() {
		return status;
	}

	public String toString() {
		return "SlProject [projectId=" + projectId + ",projectName="
				+ projectName + ",projectCode=" + projectCode + ",environment="
				+ environment + ",url=" + url + ",productCode=" + productCode
				+ ",productName=" + productName + ",status=" + status + "]";
	}

}
