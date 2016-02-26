package ca.uwo.csd.cs2212.team07;

import com.github.scribejava.core.model.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONException;

public class testapi{
	
	
	public static void main(String[] args)
	{
		Api test = new Api();
		System.out.println("HERE WE GO: \n\n");
            try {
                BestDay[] bestdays = test.getBestDays();
                for(int i = 0; i< bestdays.length; i++)
                {
                    System.out.println(bestdays[i].toString());
                }
            } catch (JSONException ex) {
                Logger.getLogger(testapi.class.getName()).log(Level.SEVERE, null, ex);
            }
            
                
          
               
		
	}
	
}
