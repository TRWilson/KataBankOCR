package com.trwilson.katabankocr.parser;

import org.junit.Test;
import org.junit.Assert;
import org.junit.Before;

/**
 * Created by IntelliJ IDEA.
 * Date: Mar 3, 2014
 * Time: 5:38:10 PM
 */
public class AccountParserTest
{
    @Test
    public void TestParseDigit()
    {
        AccountParser parser = new AccountParser();
        String ocrDigit5 = " _ " +
                           "|_ " +
                           " _|";
        Assert.assertEquals(5, parser.ParseDigit(ocrDigit5));
    }
}
