package timetableProject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Scanner;

public class SimpleTimetableold {
	// variable section
	static Scanner keyboard = new Scanner(System.in);
	static boolean free[][]=new boolean[7][18];
	static boolean doubleLab[][]=new boolean[7][18];
	static boolean trebleLab[][]=new boolean[7][18];
	static String module[][]=new String[7][18];
	static String location[][]=new String[7][18];
	static int day,t;
	static String courseCode;
	public static void main(String[] args) throws IOException{
		   {
			    courseCode = getInformation("Enter the Course code");
			   
			   	String subject = "",room = "",time="",freeTime="",doubleTime="",trebleTime="";
		    	// url reader section *************************************************************************
			   	for (day=1;day<=5;day++)
			   	{// monday is 1 etc for loop through the days
			   		System.out.println(day);
			   	URL timetable = new URL("http://timetables.cit.ie:70/reporting/Individual;Student+Set;name;"+courseCode+"%0D%0A?weeks=3-15&days="+day+"&periods=1-40");
		        /* format
		         * 'http://timetables.cit.ie:70/reporting/Individual;Student+Set;name;' + items + '?weeks=3-15&days=' + days + '&periods=' + periods + '&height=100&width=100'
		         * 
		         */
			   	BufferedReader in = new BufferedReader(
		         new InputStreamReader(timetable.openStream()));
		         String pages[] = new String[999];
		         String inputLine;
		         int x=0;
		         while ((inputLine = in.readLine()) != null)
		        {// reads page and stops when page ends -  it stores the page in an array
		         pages[x]=inputLine;
		        x++; // increases line count
		        }
		         int max=x-1;// x would be null so one decreases it
		         in.close();// closes web
		         // this section finds the line needed
		        ///****************************** end url reading ******************************
		        
		        // the following line loops through the times from 9:00 to 17:00
		        for (int t =9; t<=17; t++)
		        {
		        time=t+":00";// adds the o'clock part
		         for (int f=0;f<=max;f++)
		        {// this searches to the time and stores the two variables in subject and time
		        	//System.out.print(f);
		        	//System.out.println(pages[f]);
		        	if (pages[f].contains("<font color='#000000'>"+time+"</font>"))
		        	{
		        		subject=pages[f+6]; //System.out.println("*1*"+subject);
		        		room=pages[f+12];	//System.out.println("*2*"+room);        	
		        	}
		        }// end of section that reads what's on
		         
		        
				// this part will get the information from the html line
		        location[day][t]=getRoomName(room);
		        module[day][t]=getSubjectName(subject);
		        freeTime=t+":45";
		        doubleTime=t+":30";
		        trebleTime=(t-1)+":30";
		        
		        free[day][t]=false;
		        doubleLab[day][t]=false;
		        trebleLab[day][t]=false;
		        // this checks to see if its free or a double
		        if (location[day][t].contains(freeTime) )
		        {
		        	free[day][t] = true;
		        }
		        else if (module[day][t].contains(doubleTime)||module[day][t].contains("<!-- END ROW OUTPUT -->"))
		        {
		        	System.out.println(doubleLab[day][t-1]);
		        	if (doubleLab[day][(t-1)])
		        	{
		        		trebleLab[day][t]=true;
		        		
		        		doubleLab[day][t]=false;
		        	}
		        	else;
		        	doubleLab[day][t] = true;
		        }
		       
		      
		        printSampleTimeTable(location[day][t],module[day][t], time, t);
		       
		        }// this is the end of the time loop
			   	}//end of day loop
		    }
		  
		        
		}

	public static String getInformation(String prompt) {
		// TODO Auto-generated method stub
		System.out.print(prompt);
		String courseCode=keyboard.nextLine();//spaces need to changed to %20
		   courseCode=courseCode.replace(" ", "%20");// this does the replacing
		   return courseCode;
		   
	}

	public static void printSampleTimeTable(String roomName, String subjectName,String time, int t) {
		// TODO Auto-generated method stub
		/**
		 * @author Dennis Sheehan
		 * This prints a sample time table
		 * 
		 */
		//System.out.println(trebleLab[day][t]);
		// System.out.println(day+" "+t);
		if (free[day][t])
		{
			System.out.println(time+" ; free period");
		}
		else if (doubleLab[day][t])
		{
			if (trebleLab[day][t])
			{
				System.out.println(time+" ; **************"+module[day][(t-2)]+" continues");
				
			}
			else;
			System.out.println(time+" ; "+module[day][(t-1)]+" continues");
			
		}
		
		
		else System.out.println(time+" ; "+subjectName+" in room "+roomName);
		
	}

	public static String getSubjectName(String subject) {
		// TODO Auto-generated method stub
		/**
		 * @author Dennis Sheehan
		 * @param
		 * sName is local for subject
		 * returns the subject name minus the html
		 */

        String sName="";
		for (int c=41; c<=(subject.length()-1);c++)// 41st character is first word of the subject
        {// 
  
    	   sName+=subject.charAt(c);
       }// end of for loop counting from 41 to end
        sName=sName.replace("</font></td>", "");
        return sName;
	}

	public static String getRoomName(String room) {
		// TODO Auto-generated method stub
		/**
		 * @author Dennis Sheehan
		 * @param
		 * rName is local for room
		 * returns the room name minus the html
		 */
		{
			String rName = "";
			for (int c=42; c<=(room.length()-1);c++)// 41st character is first word of the venue
	        {// 
	  
	    	   rName+=room.charAt(c);
	       }// end of for loop counting from 41 to end
	        // now replace </font></td>
	        rName=rName.replace("</font></td>", "");
	        return rName;
	       }// end method for getting room name
	}
	


    
    	

    

	
 
 
    
}
