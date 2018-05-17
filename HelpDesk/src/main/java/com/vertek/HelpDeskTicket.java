package com.vertek;

import java.util.InputMismatchException;

import java.util.Scanner;

public class HelpDeskTicket {
    Scanner scan = new Scanner(System.in);
	enum priority{
        LOW, MEDIUM, HIGH;
	}
	int ID;
    String descript;
    String app;
    priority p;
    public HelpDeskTicket(int ID){
        this.ID = ID;
        setDescript();
        setApp();
        setPriority();
    }
    public void setDescript() {
        System.out.println("Describe your problem: ");
        descript = scan.nextLine();
    }
    public void setApp() {
        System.out.println("Which application?: ");
        app = scan.nextLine();
    }
    public void setPriority(){
    	String result;
    	int sentinal=0;
    	System.out.println("What's the priority? LOW(L), MEDIUM(M), HIGH(H): ");
        while(sentinal==0){
    	    result= scan.next();
        	switch(result){
        	case "L": p=priority.LOW;
        	     sentinal++;
        	break;
        	case "M": p=priority.MEDIUM;
        	 sentinal++;
        	break;
        	case "H": p=priority.HIGH;
        	 sentinal++;
        	break;
        	default: System.out.println("Please Enter L, M, or H: ");
        	}
        }
      
    }
    public int getID() {
        return ID;
    }
    public String getDescript() {
        return descript;
    }
    public String getApp(){
        return app;
    }
    public priority getPriority(){
        return p;
    }
    public String toString() {
    	StringBuilder builder = new StringBuilder();
        builder.append("[ID: " + this.getID() + ", ");
        builder.append("Description: " + this.getDescript() + ", ");
        builder.append("Application: " + this.getApp() + "]");
        return builder.toString();
    }
    
}


