package com.korea.k2.guestbook;

import java.util.Date;

import lombok.Data;

@Data
public class GuestBookVO {
	private int rownum;
	private int rnum;
	private int idx;
	private String title;
	private String writer;
	private Date date_for;
	private String dateStr;
}
