package com.trwilson.katabankocr.parser;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by IntelliJ IDEA.
 * Date: Mar 3, 2014
 * Time: 5:38:10 PM
 */
public class AccountParserTest
{
    @Test
    public void TestParseSingleDigit()
    {
        AccountParser parser = new AccountParser();
        String ocrDigit5 = " _ " +
                           "|_ " +
                           " _|";
        Assert.assertEquals(5, parser.ParseDigit(ocrDigit5));
    }

    @Test
    public void TestParseAllDigits()
    {
        AccountParser parser = new AccountParser();
        String ocrDigits[] = {
                " _ " +
                "| |" +
                "|_|",
                "   " +
                "  |" +
                "  |",
                " _ " +
                " _|" +
                "|_ ",
                " _ " +
                " _|" +
                " _|",
                "   " +
                "|_|" +
                "  |",
                " _ " +
                "|_ " +
                " _|",
                " _ " +
                "|_ " +
                "|_|",
                " _ " +
                "  |" +
                "  |",
                " _ " +
                "|_|" +
                "|_|",
                " _ " +
                "|_|" +
                " _|"
        };

        for (int i = 0; i < ocrDigits.length; i++)
        {
            Assert.assertEquals(i, parser.ParseDigit(ocrDigits[i]));
        }
    }

    @Test
    public void TestParseAccountNumber()
    {
        AccountParser parser = new AccountParser();
        String ocrAccountString = parser.GetOcrDigit(1) +
                                  parser.GetOcrDigit(2) +
                                  parser.GetOcrDigit(3) +
                                  parser.GetOcrDigit(4) +
                                  parser.GetOcrDigit(5) +
                                  parser.GetOcrDigit(6) +
                                  parser.GetOcrDigit(7) +
                                  parser.GetOcrDigit(8) +
                                  parser.GetOcrDigit(9) +
                                  parser.GetOcrDigit(0);

        // This test currently fails.
        Assert.assertEquals(1234567890, parser.ParseAccountNumber(ocrAccountString));
    }
}
