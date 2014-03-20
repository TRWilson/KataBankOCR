package com.trwilson.katabankocr.fileReader;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * Date: Mar 9, 2014
 * Time: 12:30:18 PM
 */
public class ReadOCRFileTest
{
    @Test
    public void TestOpenFile() throws IOException
    {
        ReadOCRFile readOCRFile = new ReadOCRFile();
        String accountNumber = readOCRFile.readFile("OCRFile.txt");
        Assert.assertNotNull(accountNumber);
    }
}
