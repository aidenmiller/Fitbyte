package ca.uwo.csd.cs2212.team07;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class FitbitInfo /*implements Serializable*/ {

    // private static final long serialVersionUID = 1L;
    public FitbitInfo() {

    }

    public void refreshInfo(int mode) {
        if(mode == 0) {
            System.out.println("REFRESH INFO - NORMAL MODE");
        }
        else {
            System.out.println("REFRESH INFO - TEST MODE");
        }
        
    }

    public void loadInfo(int mode) throws Exception {
        if(mode == 0) {
            System.out.println("LOAD INFO");
        }
        else {
            System.out.println("TEST MODE");
            throw new Exception("test mode");
        }
    }

    public void storeInfo(int mode) throws Exception {
        if(mode == 0) {
            System.out.println("STORE INFO");
        }
        else {
            System.out.println("TEST MODE");
            throw new Exception("test mode");
        }
    }

}
