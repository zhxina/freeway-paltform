package com.freeway.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * sl_last_order:
 */
@Entity
@Table(name = "sl_last_order")
public class SlLastOrder implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * id:
	 */
	private int id;

	/**
	 * 业务类型:业务类型
	 */
	private int type;

	/**
	 * 当前订单号:当前订单号
	 */
	private int orderId;

	public SlLastOrder() {

		super();
	}

	public SlLastOrder(int id, int type, int orderId) {

		super();
		this.id = id;
		this.type = type;
		this.orderId = orderId;
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

	public void setType(int type) {

		this.type = type;
	}

	@Column(name = "type", nullable = false)
	public int getType() {

		return type;
	}

	public void setOrderId(int orderId) {

		this.orderId = orderId;
	}

	@Column(name = "order_id")
	public int getOrderId() {

		return orderId;
	}

	public String toString() {

		return "SlLastOrder [id=" + id + ",type=" + type + ",orderId=" + orderId + "]";
	}

}
