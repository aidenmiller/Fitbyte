/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.uwo.csd.cs2212.team07;

import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.imageio.ImageIO;

/**
 * Constructs a new FileReader to store and load info and create BufferedImages
 * from Resource files
 *
 * @author team07
 */
public class FileReader {

    /**
     * Loads the user info from a stored file. Throws an exception if no user
     * data is available
     *
     * @param mode whether or not the user is on normal mode (0), or test mode
     * (1)
     * @return FitbitInfo class with user data
     * @throws Exception Thrown if user data is not available
     */
    public static FitbitInfo loadInfo(int mode) throws Exception {

        ObjectInputStream in;
        if (mode == 0) {
            in = new ObjectInputStream(new FileInputStream("user.data"));
            System.out.println("LOAD INFO SUCCESS");
        } else {
            in = new ObjectInputStream(new FileInputStream("test.data"));
            System.out.println("TEST MODE LOAD SUCCESS");
        }

        FitbitInfo userInfo = (FitbitInfo) in.readObject();

        return userInfo;
    }

    /**
     * Stores the user info into a stored file. Throws and exception if an error
     * occurs while storing
     *
     * @param fitbitInfo the fitbitInfo to store
     * @param mode whether or not the user is on normal mode (0) or test mode
     * (1)
     * @throws Exception Thrown is error occurs while storing
     */
    public static void storeInfo(FitbitInfo fitbitInfo, int mode) throws Exception {

        ObjectOutputStream out;

        if (mode == 0) {
            out = new ObjectOutputStream(new FileOutputStream("user.data"));
            out.writeObject(fitbitInfo);
            System.out.println("STORE INFO SUCCESS");
        } else {
            out = new ObjectOutputStream(new FileOutputStream("test.data"));
            out.writeObject(fitbitInfo);
            System.out.println("TEST MODE STORE SUCCESS");
        }

    }

    /**
     * Creates a buffered image using a filename in order to find it in the
     * resources folder
     *
     * @param fileName the name of the file in the resources folder
     * @return a BufferedImage of the file
     */
    public static BufferedImage getImage(String fileName) {

        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream is = classloader.getResourceAsStream(fileName);

        BufferedImage image = null;

        try {
            image = ImageIO.read(is);
            is.close();
        } catch (IOException e) {
        }

        return image;

    }

}
