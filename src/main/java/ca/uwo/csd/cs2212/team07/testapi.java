package ca.uwo.csd.cs2212.team07;

import com.github.scribejava.core.model.*;

public class testapi{
	
	
	public static void main(String[] args)
	{
		Api test = new Api();
		
		Response res = test.getDailySummary("2016-01-15");
                
                System.out.println("DailyActivitySummary for jan 15 2016: " +res.getBody());
		
	}
	
}
