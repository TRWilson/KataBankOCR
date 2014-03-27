package com.trwilson.katabankocr.fileReader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * Date: Mar 9, 2014
 * Time: 11:32:22 AM
 */
public class ReadOCRFile
{
    String ReadFile(String fileName) throws IOException
    {
        try
        {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fileReader);
            try
            {
                StringBuilder sb = new StringBuilder();
                String line;
                String ls = System.getProperty("line.separator");

                while ((line = br.readLine()) != null)
                {
                    sb.append(line);
                    sb.append(ls);
                }
                return sb.toString();
            } finally
            {
                br.close();
            }
        }
        catch (FileNotFoundException fnfe)
        {
            System.err.println("File " + fileName + " not found");
            return null;
        }
    }
}
