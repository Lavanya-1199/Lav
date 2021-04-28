package com.mph.controller;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Collections;
import java.util.Scanner;

import com.mph.Dao.EmployeeDao;
import com.mph.model.Manager;
import com.mph.model.Salary;
import com.mph.model.employee;
public class EmployeeController implements EmployeeInterface{
             employee emp;
             Salary sal;
             Manager man;
             List<employee> emplist = new ArrayList();
             EmployeeDao empdao = new EmployeeDao();
             public List addemployee()
             {
            	emp = new employee();
            	           Scanner sc = new Scanner(System.in);
            	           System.out.println("Enter the Eid");
            	           int eno = sc.nextInt();
            	           emp.setEid(eno);
            	           System.out.println("Enter the Ename");
            	           String enam = sc.next();
            	           emp.setEname(enam);
            	           sal=new Salary();
            	           System.out.println("Enter basic Salary");
        		           int basic = sc.nextInt();
        		           sal.setBasic(basic);
        		           sal.setDa(basic);
        		           sal.setHra(basic);
        		           sal.setPf(basic);
                           sal.setGross(basic, sal.getDa(), sal.getHra());
        		           sal.setNet(sal.getGross(),sal.getPf());
        		           emp.setSalary(sal);
        		           
        		          // emplist.add(emp);
        		           empdao.insertemp(emp);
        		          //System.out.println(emp.getEid() + " " + emp.getEname());
                          System.out.println("Employee " + eno + "Successfully added");
            	          return emplist;
             }
             public void addManager()
             {
            	 man = new Manager();
            	 Scanner sc = new Scanner(System.in);
            	              System.out.println("Enter the dept");            	 
            	              String dept = sc.next();
            	              man.setDept(dept);
            	 
            	              System.out.println("Manager" + dept + "Successfully added");
             }
             public void viewemployee(List elist)
             {
           /*     Iterator i = elist.iterator();
            	
            	while(i.hasNext())
            	{
            		System.out.println(i.next());
            	}
           */
             // elist.forEach(List -> System.out.println(List));     
              empdao.viewEmp();
             
             }
             public void viewManager()
             {
            	System.out.println(man.getDept()); 
             }
             @SuppressWarnings("unchecked")
             public void sortemployee()
             {
            	 Collections.sort(emplist,employee.nameComparator);
                 
             }
            
			
			@Override
			public void StartswithA(List elist) {
				
				elist.stream().filter((emp)->((employee)emp).getEname().startsWith("A") || ((employee)emp).getEname().startsWith("a"))
				.sorted(Comparator.comparing(employee::getEname))
				.forEach(System.out::println);
			}
			
			
		
			@Override
			public void Serial() {
				{ 
					FileOutputStream fos =null ;
					ObjectOutputStream oos =null;
					try
					{
						fos= new FileOutputStream("serialdata.txt");
						oos = new ObjectOutputStream(fos);
						oos.writeObject(emp);
						System.out.println(" Serialization done...");
						}
					catch (FileNotFoundException e)
					{	
						e.printStackTrace();
					} 
					catch (IOException e) 
					{	
						e.printStackTrace();
					}finally 
					{
					try
					{
						fos.close();
						oos.close();
					} 
					catch (IOException e)
					{
						e.printStackTrace();
					}
					
				}
				
				
			}
			
		}


		public void Deserial()
			// TODO Auto-generated method stub
			{
				employee eg=emp;
				try (FileInputStream fis = new FileInputStream("serialdata.txt");
						ObjectInputStream ois = new ObjectInputStream(fis))
				{
					eg=(employee)ois.readObject();
					fis.close();
					ois.close();
			}
			catch (ClassNotFoundException | IOException e)
			{
					
					e.printStackTrace();
				}
			
				System.out.println(eg.getEid());
				System.out.println(eg.getEname());
				System.out.println(eg.getSalary());
			
			
		}
		public void insertUsingProc()
		{
			employee e = new employee();
			Scanner  sc = new Scanner(System.in);
			System.out.println("Enter the Eid");
			int eno = sc.nextInt();
			e.setEid(eno);
			System.out.println("Enter the Ename ");
			String enam = sc.next();
			e.setEname(enam);
			
			empdao.insertUsingProcedure(e);
		}
		
		public void rsmd()
		{
			empdao.rsmd();
		}

		@Override
		public void type_forward_only_rs() {
			empdao.type_forward_only_rs();
			
		}

		@Override
		public void type_scroll_insensitive_rs() {
			empdao.type_scroll_insensitive_rs();
			
		}

		@Override
		public void type_scroll_sensitive_rs_insert() {
			empdao.type_scroll_sensitive_rs_insert();
			
		}

		@Override
		public void type_scroll_sensitive_rs_update() {
			empdao.type_scroll_sensitive_rs_update();
			
		}

		@Override
		public void batchUpdate() {
			empdao.batchUpdate();
			
		}
		
		
	}





