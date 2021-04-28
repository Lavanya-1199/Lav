package com.mph.model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Comparator;
public class employee implements Comparable<employee> , Serializable{
	private int eid;
	private String ename;
	private Salary salary;
	 
	public employee()
	{
		System.out.println("From Emp constr..");
	}
	
	public void setEid(int eid)
	{
		this.eid=eid;
	}
	
	public int getEid()
	{
		return eid;
	}
    
	public void setEname(String ename)
	{
		this.ename=ename;
	}
	public String getEname()
	{
		return ename;
	}
	
	public Salary getSalary() {
		return salary;
	}

	public void setSalary(Salary salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "employee [eid=" + eid + ", ename=" + ename + ", salary=" + salary + "]";
	}
	  //Anonyomous class
    public static Comparator<employee> nameComparator = new Comparator<employee>() {
   	 @Override
   	 public int compare(employee e1, employee e2) {
   		 return (e1.getEname().compareTo(e2.getEname()));
   	 }
    };
    
    public int compareTo(employee o) {
    	return 0;
    };
    
    /*public static void main(String[] args) throws FileNotFoundException, IOException
    {
    	String filename = "file.txt";
    	FileOutputStream fos = null;
    	ObjectOutputStream oos = null;
    	try
    	{
    	   fos = new FileOutputStream("file.txt");
    	   oos = new ObjectOutputStream(fos);
    	   
    	   System.out.println("Data successfully Serialized...");
    	   
    	 }
    	 catch(FileNotFoundException e) {
    		 e.printStackTrace();
    	 }catch(IOException e) {
    		 e.printStackTrace();
    	 }finally {
    		 try {
    			 fos.close();
    			 oos.close();
    		 } catch(IOException e) {
    			 e.printStackTrace();
    		 }
    	 }
         
    	
    }
*/    
}
