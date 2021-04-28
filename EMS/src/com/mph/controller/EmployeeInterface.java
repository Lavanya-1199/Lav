package com.mph.controller;

import java.util.List;

public interface EmployeeInterface {
       
	public List addemployee();
    public void viewemployee(List elist);
    public void addManager();
    public void viewManager();
    public void sortemployee();
    public void StartswithA(List elist);
	public void Serial();
	public void Deserial();
	public void insertUsingProc();
	public void rsmd();
	public void type_forward_only_rs();
	public void type_scroll_insensitive_rs();
	public void type_scroll_sensitive_rs_insert();
	public void type_scroll_sensitive_rs_update();
	public void batchUpdate();
    
}
