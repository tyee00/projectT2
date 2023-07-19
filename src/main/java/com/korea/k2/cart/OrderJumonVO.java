package com.korea.k2.cart;

import java.util.Date;

import lombok.Data;

@Data
public class OrderJumonVO {
	private int idx;
	 private int custNo;
	 private int cartId;
	 private int productId;
	 private String productName;
	 private int amount;
	 private Date getDate;

	
}
