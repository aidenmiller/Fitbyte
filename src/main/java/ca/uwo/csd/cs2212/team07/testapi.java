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
                Response res = test.getBestDays();
            } catch (JSONException ex) {
                Logger.getLogger(testapi.class.getName()).log(Level.SEVERE, null, ex);
            }
                
               
		
	}
	
}
