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
}
