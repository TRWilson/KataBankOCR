package com.trwilson.katabankocr.fileReader;

import com.trwilson.katabankocr.parser.AccountParser;

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

    int ParseString(String ocrString)
    {
        String[] ocrChars = {"", "", "", "", "", "", "", "", ""};
        AccountParser parser = new AccountParser();

        String noLineSeps = ocrString.replace(System.getProperty("line.separator"), "");

        for (int line = 0; line < 3; line++)
        {
            for (int index = 0; index < 9; index++)
            {
                int offset = line * 27 + index * 3;
                ocrChars[index] += noLineSeps.substring(offset, offset + 3);
            }
        }

        return parser.ParseAccountNumber(ocrChars);
    }
}
