package com.korea.k2.cart;

import java.util.Date;

import lombok.Data;

@Data
public class OrderOneVO {
	private int idx;
	private int money_idx;
	private String custName;
	private String address;
	private String phone;
	private int custNo;
	private int cartId;
	private int productId;
	private String productName;
	private int amount;
	private Date getDate;
	private int baesongbi;
	private int totalPrice;
}
