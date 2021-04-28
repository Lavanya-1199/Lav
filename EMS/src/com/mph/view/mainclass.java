package com.mph.view;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiPredicate;

import com.mph.controller.EmployeeController;
import com.mph.controller.EmployeeInterface;
import com.mph.model.employee;


import com.mph.Exception.EmployeeNotFoundException;
public class mainclass {
	
	public static void main(String[] args) throws IOException, EmployeeNotFoundException {
		  EmployeeInterface ec = new EmployeeController();
		  List<employee> elist=null;
		  Scanner sc = new Scanner(System.in);
		  String input = null;
		  
		  try {
			  InputStreamReader isr = new InputStreamReader(System.in);
              BufferedReader br = new BufferedReader(isr);
              String un,pw;
              System.out.println("Enter Username");
              un=br.readLine();
              System.out.println("Enter Password");
              pw=br.readLine();
              BiPredicate<String,String>pred = (user,pass)->un.equals("laav") && pw.equals("laav");
		      if(pred.test(un,pw))
		      {
		    	  try {
		    		  System.out.println("Loading");
		    		  Thread.sleep(3000);
		    		  
		    	  }
		    	  catch(InterruptedException ie)
		    	  {
		    		  ie.printStackTrace();
		    	  }
		    	  
			  do {
			       System.out.println("Enter your choice");
			       System.out.println("1.Add employee");
			       System.out.println("2.View employee");
			       System.out.println("3.Add Manager");
			       System.out.println("4.View Manager");
			       System.out.println("5.Sort employee");
			       System.out.println("6.view sorted list");
			       System.out.println("7.Starts with A");
			       System.out.println("8.view Starts with A");
			       System.out.println("9.Serializable");
			       System.out.println("10.Deserializable");
			       System.out.println("11. Procedure Insert");
				   System.out.println("12. Get ResultSet MetaData Info ");
				   System.out.println("13. RS Forward Only");
				   System.out.println("14. RS scroll insensitive");
				   System.out.println("15. RS scroll sensitive - insert");
				   System.out.println("16. RS scroll sensitive - update");
			       int choice = sc.nextInt();
			       switch(choice) {
			       case 1: {
				            elist =ec.addemployee();
			                break;
			        }
			        case 2: {
				            ec.viewemployee(elist);
				            break;
			        }
			        case 3:{
                              ec.addManager();
                              break;
		            }
			        case 4:{
				               ec.viewManager();
				               break;
			        }
			        case 5:{
				               ec.sortemployee();
				               break;
			        }
			        case 6:{
				               ec.viewemployee(elist);
				               break;
			        }
			        case 7:{
			        	       ec.StartswithA(elist);
			        	       break;
			        }
			        case 8:{
			        	       ec.viewemployee(elist);
			        	       break;
			        }
			        case 9:{
			        	       ec.Serial();
			        	       break;
			        }
			        case 10:{
			        	       ec.Deserial();
			        	       break;
			        }
			        case 11:{
			        	       ec.insertUsingProc();
			        	       break;
			        }
			        case 12: {
						ec.rsmd();
						break;
					}
					case 13: {
						ec.type_forward_only_rs();
						break;
					}
					case 14: {
						ec.type_scroll_insensitive_rs();
						break;
					}
					case 15: {
						ec.type_scroll_sensitive_rs_insert();
						break;
					}
					case 16: {
						ec.type_scroll_sensitive_rs_update();
						break;
					}
					case 17: {
						ec.batchUpdate();
					}
			        default:{
			         }
			         }
			   System.out.println("Do you want to continue ?Y or y for yes ");
			  input = sc.next();
		      }
		     while(input.equals("Y") || input.equals("y"));
			 System.out.println("System Exited..Thanks for using our system!!!");
			 System.exit(0);
		      }
		      else
		      {
		    	  System.out.println("Employee not found Exception");
		      }
		  }
		      finally
		      {
		    	  System.exit(0);
		      }
	   }     
}
