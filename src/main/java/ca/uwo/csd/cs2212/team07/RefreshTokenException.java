package ca.uwo.csd.cs2212.team07;

/**
 * RefreshTokenException class, thrown when there is an error in the RefreshTokens.java
 * @author Team07
 * @extends Exception
 */
public class RefreshTokenException extends Exception {

    /**
     * Constructor method: creates refreshtokenexception object
     * @param message 
     */
    public RefreshTokenException(String message) {
        super(message);
    }
    
    /**
     * Constructor method: creates RefreshTokenException object
     */
    public RefreshTokenException(){
        super();
    }
}
