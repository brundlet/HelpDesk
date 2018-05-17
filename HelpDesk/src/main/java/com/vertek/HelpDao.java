package com.vertek;
import java.util.List;
public interface HelpDao{
        public List<HelpDeskTicket> getAllTickets() ;
        public HelpDeskTicket getTicket(HelpDeskTicket ticket) ;
        public void deleteTicket(HelpDeskTicket Ticket);
        public void addTicket(HelpDeskTicket Ticket);
        public int getIndex(HelpDeskTicket Ticket);
        public void addBug(Bug bug);
        public List<Bug> getAllBugs() ;
        public Bug getBug(Bug bug) ;
        public void deleteBug(Bug Bug);
        public int getBugIndex(Bug bug);
}