package com.vertek;
import java.util.Random;

import java.util.Scanner;
import org.junit.Test;
public class HelpDeskTest{
//public static void main(String[]args) {
	@Test
	public void HelpDeskTest() {
	   int sentinal=0;
	   int helpID=1;
	   int bugID=1;
	   int runCount=0;
	   String choice;
	   HelpDao helpDao = new HelpDaoImpl();
       System.out.println("Welcome to the Help Desk");
       System.out.println("_________________________________\n");
       System.out.println("h - Create Help Desk Request\nb - Create Bug Report\n"
                                + "vh - View Help Desk Request\nvb - View Bug Report\n"
                                + "dh - Delete Help Desk Request\n"
                            + "db - Delete Bug Report\nlh - List All Help Desk Requests\n"
                            + "lb - List All Bug Reports\nla - List All Tickets & Bugs\n"
                            + "c - Show Ticket & Bug Count\ne - Exit");
       System.out.println("_________________________________\n");
       while(sentinal==0){
    	   Random rand = new Random();
    	   int n = rand.nextInt(3)+1;
           if(runCount==0){
               System.out.println("How May I Assist You?: ");
           }
           else if(n==1){
               System.out.println("Anything Else You Need?: ");
           }
           else if(n==2) {
           	   System.out.println("What's Next?: ");
           }
           else if(n==3) {
        	   System.out.println("Further Actions?: ");
           }
           runCount=1;
		   choice = getResponse();
           switch (choice) {
               case "h":  
            	   		 HelpDeskTicket h = new HelpDeskTicket(helpID);
            	   		 helpDao.addTicket(h);
                         System.out.println("Help Desk Ticket "+(h.getID())+" Created.\n");
                         helpID++;
                   break;
               case "b": Bug b = new Bug(bugID);
               		     helpDao.addBug(b);
               		     System.out.println("Bug "+(b.getID())+" Created.\n");
                         bugID++;
                   break;
               case "vh":  
            	         System.out.println("Ticket ID You'd Like to View?: ");
               			 String viewID=getResponse();
               			 try {
               			    int result = Integer.parseInt(viewID);
               			    HelpDeskTicket toView=null;
               			    	for(HelpDeskTicket Ticket : helpDao.getAllTickets()) {
               			    		if(Ticket.getID()==result) {
               			    			toView=helpDao.getTicket(Ticket);
               			    		}
               			    	}
               			    	if(toView!=null) {
               			    		System.out.println(toView.toString());
               			    	}
               			    	else {
        	  			    		System.out.println("Help Desk Request "+result+ " Not Found.");
        	  			    	}
               			   }
               			   catch(NumberFormatException e) {
        	     			 System.out.println("Entry Invalid.");
        	     		  }
                   break;
               case "vb":   
            	    System.out.println("Bug ID You'd Like to View?: ");
      			    String viewBugID=getResponse();
      			    try {
	      			    int r = Integer.parseInt(viewBugID);
	      			    Bug toBug=null;
	  			    	for (Bug bug : helpDao.getAllBugs()) {
	  			    		if(bug.getID()==r) {
	  			    			toBug=helpDao.getBug(bug);
	  			    		}
	  			    	}
	  			    	if(toBug!=null) {
	  			    		System.out.println(toBug.toString());
	  			    	}
	  			    	else {
	  			    		System.out.println("Bug "+r+ " Not Found.");
	  			    	}
      			   }
      			   catch(NumberFormatException e) {
      				   System.out.println("Entry Invalid.");
  	     		   }
                   break;
               case "dh": 
            	     	 if(helpDao.getAllTickets().isEmpty()) {
            	     		 System.out.println("No Help Desk Requests Available to Delete.");
            	     	 }
            	     	 else {
            	     		 HelpDeskTicket toDelete = null;
           	     		 	 System.out.println("ID of Ticket to Delete?: ");
	               	         String d=getResponse();
	               	         try {
		               	     	 int request = Integer.parseInt(d);
	        	     			 for (HelpDeskTicket Ticket : helpDao.getAllTickets()) {
	        	     			   if(Ticket.getID()==request) {
	        	     				   toDelete=helpDao.getTicket(Ticket);
	        	     			   }
	        	     			 }
	        	     			 if(toDelete!=null) {
	        	     				System.out.println("Ticket "+toDelete.getID()+" Deleted.");
	        	     				helpDao.deleteTicket(toDelete);
	        	     			 }
	        	     			 else {
	        	     				System.out.println("Ticket "+request+" Not Found.");
	        	     			 }
	            	     	 }
            	     		 catch(NumberFormatException e) {
            	     			 System.out.println("Entry Invalid.");
            	     		 }
            	     	 }
                   break;
               case "db":  
            		 if(helpDao.getAllBugs().isEmpty()) {
        	     		 System.out.println("No Bugs Available to Delete.");
        	     	 }
        	     	 else {
        	     		 Bug toBugDelete = null;
       	     		 	 System.out.println("ID of Bug to Delete?: ");
               	         String d=getResponse();
               	         try {
               	     	    int request = Integer.parseInt(d);
        	     			for (Bug bug : helpDao.getAllBugs()) {
        	     			   if(bug.getID()==request) {
        	     				   toBugDelete=helpDao.getBug(bug);
        	     			   }
        	     			}
        	     			if(toBugDelete!=null) {
        	     				System.out.println("Bug "+toBugDelete.getID()+" Deleted");
        	     				helpDao.deleteBug(toBugDelete);
        	     			}
        	     			else {
        	     				System.out.println("Bug "+request+" Not Found.");
        	     			}
            	     	 }
        	     		 catch(NumberFormatException e) {
        	     			 System.out.println("Entry Invalid.");
        	     		 }
        	     	 }
                   break;
               case "lh": 
            	   for (HelpDeskTicket Ticket : helpDao.getAllTickets()) {
            		   System.out.println(Ticket.toString());
                 }
                   break;
               case "lb": 
            	   for (Bug bug : helpDao.getAllBugs()) {
      					System.out.println(bug.toString());
                   }
                   break;
               case "la":
            	   System.out.println("Help Desk Requests:");
            	   for (HelpDeskTicket Ticket : helpDao.getAllTickets()) {
            		   System.out.println(Ticket.toString());
                   }
               	   System.out.println("Bugs:");
               	   for (Bug bug : helpDao.getAllBugs()) {
          					System.out.println(bug.toString());
                       }		
                   break;
               case "c": 
            	      int helpCount=helpDao.getAllTickets().size();
               		  int bugCount=helpDao.getAllBugs().size();
               		  System.out.println("Help Count: "+helpCount);
               		  System.out.println("Bug Count: "+bugCount);
               		  System.out.println("Total: "+(helpCount+bugCount));
                   break;
               case "e": sentinal=1;
                   break;
               default: System.out.println("Entry Invalid. Please Try Again.");
                   break;
           }
       }
       System.out.println("Thank you for using the help desk system!");
    }
	public String getResponse() {
    	Scanner w = new Scanner(System.in);
    	String t = w.nextLine();
    	return t;
    }
}