package com.mph.Exception;

public class EmployeeNotFoundException extends Exception {
             public EmployeeNotFoundException() {
            	System.out.println("From Employee Not Found Exception Constructor"); 
             }

			@Override
			public String toString() {
				return "EmployeeNotFoundException.Plz check the Credential []";
			}
}
