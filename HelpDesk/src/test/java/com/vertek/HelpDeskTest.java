package com.vertek;
import java.util.Scanner;
import org.junit.Test;
public class HelpDeskTest{
	public String getResponse() {
    	Scanner w = new Scanner(System.in);
    	String t = w.nextLine();
    	return t;
    }
//public static void main(String[]args) {
	@Test
	public void HelpDeskTest() {
       Scanner scanner;
	   int x=0;
	   int helpID=1;
	   int bugID=1;
	   int runCount=0;
	   String choice;
	   HelpDao helpDao = new HelpDaoImpl();
       System.out.println("Welcome to the Help Desk");
       System.out.println("_________________________________\n");
       System.out.println("H - Create Help Desk Request\nB - Create Bug Report\n"
                                + "VH - View Help Desk Request\nVB - View Bug Report\nDH - Delete Help Desk Request\n"
                            + "DB - Delete Bug Report\nLH - List All Help Desk Requests\n"
                            + "LB - List All Bug Reports\nLA - List All Tickets & Bugs\n"
                            + "C - Show Ticket & Bug Count\nE - Exit");
       System.out.println("_________________________________\n");
       
       while(x==0){
           if(runCount==0){
               System.out.println("How May I Assist You?: ");
           }
           else if(runCount>0){
               System.out.println("Anything else you need?: ");
           }
           else if(runCount==1000) {
           	System.out.println("Great. What's Next?");
           }
           runCount++;
           scanner = new Scanner(System.in);
           System.out.println("S");
		   choice = getResponse();
           System.out.println("SAs");
           switch (choice) {
               case "H":  
            	   			
            	   			HelpDeskTicket h = new HelpDeskTicket(helpID);
            	   			helpDao.addTicket(h);
                            System.out.println("Help Desk Ticket "+(h.getID())+" Created.\n");
                            helpID++;
                   break;
               case "B":    Bug b = new Bug(bugID);
               				helpDao.addBug(b);
               				System.out.println("Bug "+(b.getID())+" Created.\n");
                            bugID++;
                   break;
               case "VH":  
            	            System.out.println("Ticket ID You'd Like to View?: ");
               			    String viewID=scanner.next();
               			    int result = Integer.parseInt(viewID);
               			    HelpDeskTicket toView=null;
               			    try {
               			    	for (HelpDeskTicket Ticket : helpDao.getAllTickets()) {
               			    		if(Ticket.getID()==result) {
               			    			toView=helpDao.getTicket(Ticket);
               			    		}
               			    	}
               			    	if(toView!=null) {
               					System.out.println("[TicketID: " + (toView.getID()) //MAKE PRINT METHOD IN IMPL
                                      + ", Description: " + toView.getDescript() + ", Application: "+ toView.getApp()+
                                      ", Priority: "+toView.getPriority()+"]");
               			    	}
               			   }
               			   catch(IndexOutOfBoundsException e) {
	               	     		 System.out.println("Ticket With ID " +result+" Not Found in System.");
	               	       }
               			   catch(NumberFormatException e) {
        	     			 System.out.println("Entry Invalid.");
        	     		  }
                   break;
               case "VB":   
            	    System.out.println("Bug ID You'd Like to View?: ");
      			    String viewBugID=scanner.next();
      			    int r = Integer.parseInt(viewBugID);
      			 
      			    Bug toBug=null;
      			    try {
      			    	for (Bug bug : helpDao.getAllBugs()) {
      			    		if(bug.getID()==r) {
      			    			toBug=helpDao.getBug(bug);
      			    		}
      			    	}
      			    	if(toBug!=null) {
      			    		System.out.println("[BugID: " + (toBug.getID()) //MAKE PRINT METHOD IN IMPL
                             + ", Description: " + toBug.getDescript() + ", Application: "+ toBug.getApp()+
                             ", Priority: "+toBug.getPriority()+", Steps: "+toBug.getSteps()+"]");
      			    	}
      			   }
      			   catch(IndexOutOfBoundsException e) {
          	     		 System.out.println("Bug With ID " +r+" Not Found in System.");
          	       }
      			   catch(NumberFormatException e) {
	     			 System.out.println("Entry Invalid.");
	     		  }
            	   
                   break;
               case "DH": 
            	     	 if(helpDao.getAllTickets().isEmpty()) {
            	     		 System.out.println("No Help Desk Requests Available to Delete.");
            	     	 }
            	     	 else {
            	     		 //int oldIndex;
            	     		 HelpDeskTicket toDelete = null;
           	     		 	 System.out.println("ID of Ticket to Delete?: ");
	               	         String d=scanner.next();
	               	     	 int request = Integer.parseInt(d);
	               	     	 //HelpDeskTicket toDelete= new HelpDeskTicket;
            	     		 try {
            	     			for (HelpDeskTicket Ticket : helpDao.getAllTickets()) {
            	     			   if(Ticket.getID()==request) {
            	     				   toDelete=helpDao.getTicket(Ticket);
            	     			   }
            	     			}
            	     			if(toDelete!=null) {
            	     				System.out.println("Ticket "+toDelete.getID()+" deleted.");
            	     				helpDao.deleteTicket(toDelete);
            	     			}
            	     			else {
            	     				System.out.println("Ticket "+request+" not found.");
            	     			}
	            	     	 }
//	               	     	 catch(IndexOutOfBoundsException e) {
//	               	     		 System.out.println("Ticket with ID " +request+" Not Found in System.");
//	               	     	 }
            	     		 catch(NumberFormatException e) {
            	     			 System.out.println("Entry Invalid.");
            	     		 }
            	     	 }
                   break;
               case "DB":  
            		 if(helpDao.getAllBugs().isEmpty()) {
        	     		 System.out.println("No Bugs Available to Delete.");
        	     	 }
        	     	 else {
        	     		 //int oldIndex;
        	     		 Bug toBugDelete = null;
       	     		 	 System.out.println("ID of Bug to Delete?: ");
               	         String d=scanner.next();
               	     	 int request = Integer.parseInt(d);
               	     	 //HelpDeskTicket toDelete= new HelpDeskTicket;
        	     		 try {
        	     			for (Bug bug : helpDao.getAllBugs()) {
        	     			   if(bug.getID()==request) {
        	     				   toBugDelete=helpDao.getBug(bug);
        	     			   }
        	     			}
        	     			if(toBugDelete!=null) {
        	     				System.out.println("Bug "+toBugDelete.getID()+" deleted");
        	     				helpDao.deleteBug(toBugDelete);
        	     			}
            	     	 }
               	     	 catch(IndexOutOfBoundsException e) {
               	     		 System.out.println("Bug with ID " +request+" Not Found in System.");
               	     	 }
        	     		 catch(NumberFormatException e) {
        	     			 System.out.println("Entry Invalid.");
        	     		 }
        	     	 }
                   break;
               case "LH": 
            	   for (HelpDeskTicket Ticket : helpDao.getAllTickets()) {
            		   System.out.println("[TicketID: " + (Ticket.getID()) //MAKE PRINT METHOD IN IMPL
                               + ", Description: " + Ticket.getDescript() + ", Application: "+ Ticket.getApp()+
                               ", Priority: "+Ticket.getPriority()+"]");
                 }
                   break;
               case "LB": 
            	   for (Bug bug : helpDao.getAllBugs()) {
      					System.out.println("[BugID: " + (bug.getID()) //MAKE PRINT METHOD IN IMPL
               				    + ", Description: " + bug.getDescript() + ", Application: "+ bug.getApp()+
               				    ", Steps: "+bug.getSteps()+"]");
                   }
                   break;
               case "LA":
            	   System.out.println("Help Desk Requests:");
            	   for (HelpDeskTicket Ticket : helpDao.getAllTickets()) {
            		   System.out.println("[TicketID: " + (Ticket.getID()) //MAKE PRINT METHOD IN IMPL
                               + ", Description: " + Ticket.getDescript() + ", Application: "+ Ticket.getApp()+
                               ", Priority: "+Ticket.getPriority()+"]");
                   }
               			System.out.println("Bugs:");
               			for (Bug bug : helpDao.getAllBugs()) {
          					System.out.println("[BugID: " + (bug.getID()) //MAKE PRINT METHOD IN IMPL
                   				    + ", Description: " + bug.getDescript() + ", Application: "+ bug.getApp()+
                   				 ", Priority: "+bug.getPriority()+ ", Steps: "+bug.getSteps()+"]");
                       }		
                   break;
               case "C": 
            	      int helpCount=helpDao.getAllTickets().size();
               		  int bugCount=helpDao.getAllBugs().size();
               		  System.out.println("Help Count: "+helpCount);
               		  System.out.println("Bug Count: "+bugCount);
               		  System.out.println("Total: "+(helpCount+bugCount));
                   break;
               case "E": x=1;
                   break;
               default: System.out.println("Entry Invalid. Please Try Again.");
                   break;
           }
       }
       System.out.println("Thank you for using the help desk system!");

    }
}