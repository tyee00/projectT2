package com.korea.k2.cart;

import java.util.Date;

import lombok.Data;

@Data
public class OrderMoneyVO {
 private int idx;
 private int custNo;
 private int baesongbi;
 private int totalPrice;
 private Date getDate;
}
