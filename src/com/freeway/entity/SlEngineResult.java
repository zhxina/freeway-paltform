package com.freeway.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * sl_engine_result:
 */
@Entity
@Table(name = "sl_engine_result")
public class SlEngineResult implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * id:
	 */
	private int id;

	/**
	 * product_code:
	 */
	private String productCode;

	/**
	 * phase:
	 */
	private String phase;

	/**
	 * trace_uid:
	 */
	private String traceUid;

	/**
	 * project_code:
	 */
	private String projectCode;

	/**
	 * user_id:
	 */
	private String userId;

	/**
	 * order_id:
	 */
	private String orderId;

	/**
	 * result:
	 */
	private String result;

	/**
	 * head_code:
	 */
	private String headCode;

	/**
	 * back_code:
	 */
	private String backCode;

	/**
	 * intervals_in_day:
	 */
	private String intervalsInDay;

	/**
	 * credit_line:
	 */
	private String creditLine;

	/**
	 * credit_level:
	 */
	private String creditLevel;

	public SlEngineResult() {
		super();
	}

	public SlEngineResult(int id, String productCode, String phase,
			String traceUid, String projectCode, String userId, String orderId,
			String result, String headCode, String backCode,
			String intervalsInDay, String creditLine, String creditLevel) {
		super();
		this.id = id;
		this.productCode = productCode;
		this.phase = phase;
		this.traceUid = traceUid;
		this.projectCode = projectCode;
		this.userId = userId;
		this.orderId = orderId;
		this.result = result;
		this.headCode = headCode;
		this.backCode = backCode;
		this.intervalsInDay = intervalsInDay;
		this.creditLine = creditLine;
		this.creditLevel = creditLevel;
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

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	@Column(name = "product_code", length = 30, nullable = false)
	public String getProductCode() {
		return productCode;
	}

	public void setPhase(String phase) {
		this.phase = phase;
	}

	@Column(name = "phase", length = 30, nullable = false)
	public String getPhase() {
		return phase;
	}

	public void setTraceUid(String traceUid) {
		this.traceUid = traceUid;
	}

	@Column(name = "trace_uid", length = 50, nullable = false)
	public String getTraceUid() {
		return traceUid;
	}

	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}

	@Column(name = "project_code", length = 30, nullable = false)
	public String getProjectCode() {
		return projectCode;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Column(name = "user_id", length = 20, nullable = false)
	public String getUserId() {
		return userId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	@Column(name = "order_id", length = 20)
	public String getOrderId() {
		return orderId;
	}

	public void setResult(String result) {
		this.result = result;
	}

	@Column(name = "result", length = 255, nullable = false)
	public String getResult() {
		return result;
	}

	public void setHeadCode(String headCode) {
		this.headCode = headCode;
	}

	@Column(name = "head_code", length = 10)
	public String getHeadCode() {
		return headCode;
	}

	public void setBackCode(String backCode) {
		this.backCode = backCode;
	}

	@Column(name = "back_code", length = 10)
	public String getBackCode() {
		return backCode;
	}

	public void setIntervalsInDay(String intervalsInDay) {
		this.intervalsInDay = intervalsInDay;
	}

	@Column(name = "intervals_in_day", length = 10)
	public String getIntervalsInDay() {
		return intervalsInDay;
	}

	public void setCreditLine(String creditLine) {
		this.creditLine = creditLine;
	}

	@Column(name = "credit_line", length = 10)
	public String getCreditLine() {
		return creditLine;
	}

	public void setCreditLevel(String creditLevel) {
		this.creditLevel = creditLevel;
	}

	@Column(name = "credit_level", length = 10)
	public String getCreditLevel() {
		return creditLevel;
	}

	public String toString() {
		return "SlEngineResultDao [id=" + id + ",productCode=" + productCode
				+ ",phase=" + phase + ",traceUid=" + traceUid + ",projectCode="
				+ projectCode + ",userId=" + userId + ",orderId=" + orderId
				+ ",result=" + result + ",headCode=" + headCode + ",backCode="
				+ backCode + ",intervalsInDay=" + intervalsInDay
				+ ",creditLine=" + creditLine + ",creditLevel=" + creditLevel
				+ "]";
	}

}
