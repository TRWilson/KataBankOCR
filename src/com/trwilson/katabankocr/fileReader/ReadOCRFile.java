package com.trwilson.katabankocr.fileReader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Date: Mar 9, 2014
 * Time: 11:32:22 AM
 */
public class ReadOCRFile
{
    public List<String> ReadFile(String fileName) throws IOException
    {
        FileReader fileRead = null;
        BufferedReader bufferRead = null;
        StringBuilder sb = new StringBuilder();
        List<String> accountNumbers = new ArrayList<String>();

        try
        {
            String line;
            String ls = System.getProperty("line.separator");
            fileRead = new FileReader(fileName);
            bufferRead = new BufferedReader(fileRead);

            while ((line = bufferRead.readLine()) != null)
            {
                if (!line.isEmpty())
                {
                    sb.append(line);
                    sb.append(ls);
                }
                else
                {
                    accountNumbers.add(sb.toString());
                    sb.delete(0, sb.length());
                }
            }
        }

        catch (FileNotFoundException e)
        {
            System.err.println("File " + fileName + " not found");
            return null;
        }

        catch (IOException e)
        {
            System.err.println("Error encountered while reading file: " + e.getLocalizedMessage());
        }

        finally
        {
            if( sb.length() > 0 ) {
                accountNumbers.add(sb.toString());
            }

            if (bufferRead != null)
            {
                bufferRead.close();
                fileRead.close();
            }
        }

        return accountNumbers;
    }
}
