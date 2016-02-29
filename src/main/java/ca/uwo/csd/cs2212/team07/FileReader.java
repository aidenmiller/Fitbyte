/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.uwo.csd.cs2212.team07;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;

/**
 *
 * @author team07
 */
public class FileReader {

    private FitbitInfo fitbitInfo;
    
    public FileReader() {

    }

    /**
     * Loads the user info from a stored file. Throws an exception if no user
     * data is available
     *
     * @param mode whether or not the user is on normal mode (0) or test mode
     * (1)
     * @return FitbitInfo class with user data
     * @throws Exception Thrown if user data is not available
     */
    public FitbitInfo loadInfo(int mode) throws Exception {
        fitbitInfo = new FitbitInfo();
        
        if (mode == 0) {
            System.out.println("LOAD INFO");
        } else {
            System.out.println("TEST MODE");
            throw new Exception("test mode");
        }
        
        return fitbitInfo;
    }

    /**
     * Stores the user info into a stored file. Throws and exception if an error
     * occurs while storing
     *
     * @param mode whether or not the user is on normal mode (0) or test mode
     * (1)
     * @throws Exception Thrown is error occurs while storing
     */
    public void storeInfo(int mode) throws Exception {
        if (mode == 0) {
            System.out.println("STORE INFO");
        } else {
            System.out.println("TEST MODE");
            throw new Exception("test mode");
        }
    }

    /**
     * Creates a buffered image using a filename in order to find it in the
     * resources folder
     *
     * @param fileName the name of the file in the resources folder
     * @return a BufferedImage of the file
     */
    public BufferedImage getFile(String fileName) {

        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream is = classloader.getResourceAsStream(fileName);

        BufferedImage image = null;

        try {
            image = ImageIO.read(is);
        } catch (IOException e) {
        }

        return image;

    }
    
    public FitbitInfo getFitbitInfo() {
        return fitbitInfo;
    }

}
