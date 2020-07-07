package com.longlvq.mybatis_h2db.entity;

import java.math.BigDecimal;
import java.util.List;

import javax.validation.constraints.NotNull;
public class PerSonEntity {
	private int id;
	@NotNull
	private String first_name;
	@NotNull
	private String last_name;
	private String email;
	private BigDecimal word_cnt;
	private List<String> wordCntTempList;
	private String data1;
	private String data2;
	private String data3;
	private String data4;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public List<String> getWordCntTempList() {
		return wordCntTempList;
	}
	public void setWordCntTempList(List<String> wordCntTempList) {
		this.wordCntTempList = wordCntTempList;
	}
	public String getData1() {
		return data1;
	}
	public void setData1(String data1) {
		this.data1 = data1;
	}
	public String getData2() {
		return data2;
	}
	public void setData2(String data2) {
		this.data2 = data2;
	}
	public String getData3() {
		return data3;
	}
	public void setData3(String data3) {
		this.data3 = data3;
	}
	public String getData4() {
		return data4;
	}
	public void setData4(String data4) {
		this.data4 = data4;
	}
	public BigDecimal getWord_cnt() {
		return word_cnt;
	}
	public void setWord_cnt(BigDecimal word_cnt) {
		this.word_cnt = word_cnt;
	}
	
}
