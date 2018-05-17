package com.vertek;
import java.util.ArrayList;
import java.util.List;

public class HelpDaoImpl implements HelpDao{
        List<HelpDeskTicket> TicketList= new ArrayList<HelpDeskTicket>();
        List<Bug> BugList= new ArrayList<Bug>();
        public HelpDaoImpl(){ 
        }
        public void addTicket(HelpDeskTicket t) {
        	TicketList.add(t);
        }
        public void addBug(Bug b) {
        	BugList.add(b);
        }
        public void deleteTicket(HelpDeskTicket ticket){
            TicketList.remove(ticket);
        }
        public void deleteBug(Bug bug){
            BugList.remove(bug);
        }
        public int getIndex(HelpDeskTicket Ticket) {
        	return TicketList.indexOf(Ticket);
        }
        public int getBugIndex(Bug bug) {
        	return BugList.indexOf(bug);
        }
        public List<HelpDeskTicket> getAllTickets() {
            return TicketList;
        }
        public List<Bug> getAllBugs() {
            return BugList;
        }
        public HelpDeskTicket getTicket(HelpDeskTicket ticket){
        	int indexTrack= TicketList.indexOf(ticket);
            return TicketList.get(indexTrack);
        }
        public Bug getBug(Bug bug){
        	int i=BugList.indexOf(bug);
            return BugList.get(i);
        }
    }