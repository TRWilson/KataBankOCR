package com.trwilson.katabankocr;

import com.trwilson.katabankocr.fileReader.ReadOCRFile;
import com.trwilson.katabankocr.parser.AccountParser;

import java.io.IOException;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Date: Mar 28, 2014
 * Time: 9:15:03 PM
 */
public class OCRConvert
{
    public static void main(String[] args) throws IOException
    {
        ReadOCRFile readOCRFile = new ReadOCRFile();
        AccountParser accountParser = new AccountParser();
        String ocrFile = (args.length > 0) ? args[0] : "OCRFile.txt";
        List<String> ocrData = readOCRFile.ReadFile(ocrFile);

        for (String ocrAccount : ocrData)
        {
            int accountNumber = accountParser.ParseString(ocrAccount);
            System.out.println("Account: " + String.format("%09d", accountNumber));
        }
    }
}
