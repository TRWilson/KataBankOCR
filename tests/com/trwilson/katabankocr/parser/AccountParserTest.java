package com.trwilson.katabankocr.parser;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by IntelliJ IDEA.
 * Date: Mar 3, 2014
 * Time: 5:38:10 PM
 */
public class AccountParserTest
{
    private AccountParser _AccountParser;

    @Before
    public void setUp() throws Exception
    {
        _AccountParser = new AccountParser();
    }

    @Test
    public void TestParseSingleDigit()
    {
        String ocrDigit5 = " _ " +
                           "|_ " +
                           " _|";
        Assert.assertEquals(5, _AccountParser.ParseDigit(ocrDigit5));
    }

    @Test
    public void TestParseAllDigits()
    {
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
            Assert.assertEquals(i, _AccountParser.ParseDigit(ocrDigits[i]));
        }
    }

    @Test
    public void TestParseAccountNumber()
    {
        String[] ocrAccountString = {
                _AccountParser.GetOCRDigit(1),
                _AccountParser.GetOCRDigit(2),
                _AccountParser.GetOCRDigit(3),
                _AccountParser.GetOCRDigit(4),
                _AccountParser.GetOCRDigit(5),
                _AccountParser.GetOCRDigit(6),
                _AccountParser.GetOCRDigit(7),
                _AccountParser.GetOCRDigit(8),
                _AccountParser.GetOCRDigit(9),
                _AccountParser.GetOCRDigit(0)
        };

        Assert.assertEquals(1234567890, _AccountParser.ParseAccountNumber(ocrAccountString));
    }

	@Test
	public void TestParseOCRAccount()
	{
		String accountOCR = "    _  _     _  _  _  _  _ \r\n" +
							"  | _| _||_||_ |_   ||_||_|\r\n" +
							"  ||_  _|  | _||_|  ||_| _|\r\n";
		int accountNumber = _AccountParser.ParseString(accountOCR);
		Assert.assertEquals(123456789, accountNumber);
	}

    @Test
    public void TestIsValidAccountNumber()
    {
        Assert.assertTrue(_AccountParser.IsValidAccountNumber(457508000));
    }

    @Test
    public void TestIsValidAccountNumber2()
    {
        Assert.assertTrue(_AccountParser.IsValidAccountNumber(345882865));
    }

    @Test
    public void TestIsNotValidAccountNumber()
    {
        Assert.assertFalse(_AccountParser.IsValidAccountNumber(664371495));
    }
}
