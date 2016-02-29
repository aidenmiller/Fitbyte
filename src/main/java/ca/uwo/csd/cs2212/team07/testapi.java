package ca.uwo.csd.cs2212.team07;

import com.github.scribejava.core.model.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONException;

public class testapi{
	
	
	public static void main(String[] args) 
	{
		
          
            try {
             Api.userProfile();
            } catch (JSONException ex) {
                Logger.getLogger(testapi.class.getName()).log(Level.SEVERE, null, ex);
            } catch (RefreshTokenException ex) {
               System.err.println("ERROR");
            }
                
          
               
		
	}
	
}
