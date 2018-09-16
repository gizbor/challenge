package com.necar.fingerprint.beans;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="finger_print_log")
public class FingerPrintLog {
	
	@Column
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@Column(name="date")
	private Date date;
	
	@Column(name="n_order")
	private Integer nOrder;
	
	@Column(name="result")
	private Character result;
	
	@Column (name="row_1")
	private String row1;
	@Column (name="row_2")
	private String row2;
	@Column (name="row_3")
	private String row3;
	@Column (name="row_4")
	private String row4;
	@Column (name="row_5")
	private String row5;
	@Column (name="row_6")
	private String row6;
	@Column (name="row_7")
	private String row7;
	@Column (name="row_8")
	private String row8;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Integer getnOrder() {
		return nOrder;
	}
	public void setnOrder(Integer nOrder) {
		this.nOrder = nOrder;
	}
	public Character getResult() {
		return result;
	}
	public void setResult(Character result) {
		this.result = result;
	}
	public String getRow1() {
		return row1;
	}
	public void setRow1(String row1) {
		this.row1 = row1;
	}
	public String getRow2() {
		return row2;
	}
	public void setRow2(String row2) {
		this.row2 = row2;
	}
	public String getRow3() {
		return row3;
	}
	public void setRow3(String row3) {
		this.row3 = row3;
	}
	public String getRow4() {
		return row4;
	}
	public void setRow4(String row4) {
		this.row4 = row4;
	}
	public String getRow5() {
		return row5;
	}
	public void setRow5(String row5) {
		this.row5 = row5;
	}
	public String getRow6() {
		return row6;
	}
	public void setRow6(String row6) {
		this.row6 = row6;
	}
	public String getRow7() {
		return row7;
	}
	public void setRow7(String row7) {
		this.row7 = row7;
	}
	public String getRow8() {
		return row8;
	}
	public void setRow8(String row8) {
		this.row8 = row8;
	}


}
