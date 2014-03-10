package com.trwilson.katabankocr.fileReader;

import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * Created by IntelliJ IDEA.
 * Date: Mar 9, 2014
 * Time: 11:32:22 AM
 */
public class ReadOCRFile
{
    String readFile(String fileName)
    {
        try
        {
            FileReader fileReader = new FileReader(fileName);
            return "Success!";
        }
        catch (FileNotFoundException fnfe)
        {
            return "Failure!";
        }
    }
}
