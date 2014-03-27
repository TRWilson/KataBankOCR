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
    private String _OCRData;
    private ReadOCRFile _ReadOCRFile;

    @Before
    public void setUp() throws IOException
    {
        _ReadOCRFile = new ReadOCRFile();
        _OCRData = _ReadOCRFile.ReadFile("OCRFile.txt");
    }

    @Test
    public void TestOpenFile()
    {
        Assert.assertNotNull(_OCRData);
    }

    @Test
    public void TestReadOCRData()
    {
        String expectedOCRData = "    _  _     _  _  _  _  _ \r\n" +
                                 "  | _| _||_||_ |_   ||_||_|\r\n" +
                                 "  ||_  _|  | _||_|  ||_| _|\r\n";
        Assert.assertEquals(expectedOCRData, _OCRData);
    }

    @Test
    public void TestParseFileData()
    {
        int accountNumber;

        accountNumber = _ReadOCRFile.ParseString(_OCRData);
        Assert.assertEquals(123456789, accountNumber);
    }

}
