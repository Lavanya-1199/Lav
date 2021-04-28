package com.mph.model;

public class Manager extends employee{
       private  String dept;
       
public String getDept() {
	return dept;
}

public void setDept(String dept) {
	this.dept = dept;
}

@Override
public String toString() {
	return "Manager [dept=" + dept + "]";
}

}


        