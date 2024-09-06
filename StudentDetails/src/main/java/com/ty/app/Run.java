package com.ty.app;

import java.util.Scanner;
import com.ty.model.StudentModel;
public class Run {
	public static Scanner Sc = new Scanner(System.in);
	static {
		System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
		String disp = "Welcome to STudent Management System...";
		for(int i =0; i<disp.length(); i++) {
			System.out.print(disp.charAt(i));
			try {
				Thread.sleep(100);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
		System.out.println();
		System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
	}
public static void main(String[] args) {
	try {
		a:while(true) {
			System.out.println("Press 1: for Adding Student");
			Thread.sleep(1000);
			System.out.println("Press 2: for Updating Student data");
			Thread.sleep(1000);
			System.out.println("Press 3: for Deleting Student Data");
			Thread.sleep(1000);
			System.out.println("Press 4: for Exit");
			Thread.sleep(1000);
			System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
			Thread.sleep(1000);
		    System.out.println("Enter Your Choice:");
		    int choice = Sc.nextInt();
		    StudentModel sm = StudentModel.getInstance();
		    switch(choice){
		    	case 1:sm.add();
		    	       break;
		    	case 2:sm.update();
	    	       break;
		    	case 3:sm.delete();
	    	       break;
		    	case 4:System.out.println("You Had Entered Wrong Number......");;
	    	       break a;
	    	       default :
	    	    	   System.out.println("YOu Had Entered Wrong Input");
		    }
		}
	}catch(InterruptedException e) {
		e.printStackTrace();
	}
	
	
}
@Override
protected void finalize() throws Throwable{
	super.finalize();
	Sc.close();
}


}
