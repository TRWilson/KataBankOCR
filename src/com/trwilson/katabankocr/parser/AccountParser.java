package com.trwilson.katabankocr.parser;

/**
 * Created by IntelliJ IDEA.
 * Date: Feb 28, 2014
 * Time: 10:18:42 AM
 */

public class AccountParser
{
    private String[] OcrCharacters =
            {
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

    public String GetOcrDigit(int digit)
    {
        return OcrCharacters[digit];
    }

    public int ParseDigit(String ocrDigit)
    {
        for (int i = 0; i < OcrCharacters.length; i++)
        {
            if (OcrCharacters[i].equals(ocrDigit))
            {
                return i;
            }
        }
        return -1;
    }

    public int ParseAccountNumber(String[] ocrNumber)
    {
        int number = 0;

        for (String ocrChar : ocrNumber)
        {
            number *= 10; // Move the existing number to the left.
            number += ParseDigit(ocrChar);
        }
        return number;
    }
}
