/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ensorcell;

/**
 *
 * @author Udyan Sharma
 */
import java.io.File;  
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class OCRConv {
    public static void main(String[] args)
    {
        Tesseract tessobj = new Tesseract();
        try {
            //The path of the tesseract data folder
            tessobj.setDatapath("C:/Users/Udyan Sharma/Downloads/Tess4J/tessdata");
            //The Image for Text Extraction
            String text = tessobj.doOCR(new File("C:/Users/Udyan Sharma/Downloads/ocrtesting4.png"));
            //Path of Output image file
            System.out.print(text);
        }
        catch (TesseractException exp) {
            exp.printStackTrace();
        }
    }
}
