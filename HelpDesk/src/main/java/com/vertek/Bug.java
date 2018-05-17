package com.vertek;

public class Bug extends HelpDeskTicket{
            String steps;
            public Bug(int ID){
                    super(ID);
                    setSteps();
            }
            @Override
            public void setDescript() {
                System.out.println("Describe your bug: ");
                descript = scan.nextLine();
                if (descript.length()>15) {
                    String cut = descript.substring(0, 15);
                    descript = cut;
                }
            }
            public void setSteps() {
            	scan.nextLine();
                System.out.println("Steps to recreate?: ");
                steps = scan.nextLine();
                if (steps.length()>15) {
                    String cut = steps.substring(0, 15);
                    steps = cut;
                }
            }
            public String getSteps() {
                return steps;
            }
            @Override
            public String toString() {
                return "[BugID: " + (getID()) 
                        + ", Description: " + getDescript() + ", Application: "+ getApp()+
                        ", Priority: "+getPriority()+", Steps: "+getSteps()+"]";
            }
    }