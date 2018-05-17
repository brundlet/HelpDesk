package com.vertek;
import java.util.ArrayList;

import java.util.List;


public class Bug extends HelpDeskTicket{
            String steps;
            public Bug(int ID){
                    super(ID);
            	    //setDescript();
            	    //setApp();
                    setSteps();
            }
            public void setSteps() {
            	scan.nextLine();
                System.out.print("Steps to recreate?: ");
                steps = scan.nextLine();
            }
            public String getSteps() {
                return steps;
            }
            @Override
            public String toString() {
            	StringBuilder builder = new StringBuilder();
                builder.append("[ID: " + ID + ", ");
                builder.append("Description: " + descript + ", ");
                builder.append("Application: " + app + ", ");
                builder.append("Steps: "+ steps + "]");
                return builder.toString();
            }
    }