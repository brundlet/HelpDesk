package com.vertek;
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
        if (descript.length()>15) {
            String cut = descript.substring(0, 15);
            descript = cut;
        }
    }
    public void setApp() {
        System.out.println("Which application?: ");
        app = scan.nextLine();
    }
    public void setPriority(){
    	String result;
    	int sentinal=0;
    	System.out.println("What's the priority? LOW(l), MEDIUM(m), HIGH(h): ");
        while(sentinal==0){
    	    result= scan.next();
        	switch(result){
        	case "l": p=priority.LOW;
        	     sentinal++;
        	break;
        	case "m": p=priority.MEDIUM;
        	     sentinal++;
        	break;
        	case "h": p=priority.HIGH;
        	     sentinal++;
        	break;
        	default: System.out.println("Please Enter l, m, or h: ");
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
        return "[TicketID: " + (getID())
                + ", Description: " + getDescript() + ", Application: "+ getApp()+
                ", Priority: "+getPriority()+"]";		    	
    }
}