package com.student.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="StudentInfo")
public class Student {
	@Id
	private int studId;
	private String studName;
	private String studEmail;
	private String studPhoneNo;
	
	public int getStudId() {
		return studId;
	}
	public void setStudId(int studId) {
		this.studId = studId;
	}
	public String getStudName() {
		return studName;
	}
	public void setStudName(String studName) {
		this.studName = studName;
	}
	public String getStudEmail() {
		return studEmail;
	}
	public void setStudEmail(String studEmail) {
		this.studEmail = studEmail;
	}
	public String getStudPhoneNo() {
		return studPhoneNo;
	}
	public void setStudPhoneNo(String newPhone) {
		this.studPhoneNo = newPhone;
	}
	
	@Override
	public String toString() {
		return "Student [studId=" + studId + ", studName=" + studName + ", studEmail=" + studEmail + ", studPhoneNo="
				+ studPhoneNo + "]";
	}
	
	
}
