package com.trwilson.katabankocr.parser;

/**
 * Created by IntelliJ IDEA.
 * Date: Feb 28, 2014
 * Time: 10:18:42 AM
 */

public class AccountParser
{
    private String[] OCRDigits =
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

    public String GetOCRDigit(int digit)
    {
        return OCRDigits[digit];
    }

    public int ParseDigit(String ocrDigit)
    {
        for (int i = 0; i < OCRDigits.length; i++)
        {
            if (OCRDigits[i].equals(ocrDigit))
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

    public int ParseString(String ocrString)
    {
        String[] ocrChars = {"", "", "", "", "", "", "", "", ""};

        String noLineSeparators = ocrString.replace(System.getProperty("line.separator"), "");

        for (int line = 0; line < 3; line++)
        {
            for (int index = 0; index < 9; index++)
            {
                int offset = line * 27 + index * 3;
                ocrChars[index] += noLineSeparators.substring(offset, offset + 3);
            }
        }

        return ParseAccountNumber(ocrChars);
    }
}
