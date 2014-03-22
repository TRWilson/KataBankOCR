package com.trwilson.katabankocr.fileReader;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * Date: Mar 9, 2014
 * Time: 12:30:18 PM
 */
public class ReadOCRFileTest
{
    private String ocrData;

    @Before
    public void setUp() throws Exception
    {
        ReadOCRFile readOCRFile = new ReadOCRFile();
        ocrData = readOCRFile.readFile("OCRFile.txt");
    }

    @Test
    public void TestOpenFile() throws IOException
    {
        Assert.assertNotNull(ocrData);
    }

    @Test
    public void TestReadOCRData() throws IOException
    {
        String expectedOcrData = "    _  _     _  _  _  _  _  _ \r\n" +
                                 "  | _| _||_||_ |_   ||_||_|| |\r\n" +
                                 "  ||_  _|  | _||_|  ||_| _||_|\r\n";
        Assert.assertEquals(ocrData, expectedOcrData);
    }
}
