package com.trwilson.katabankocr.fileReader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Date: Mar 9, 2014
 * Time: 11:32:22 AM
 */
public class ReadOCRFile
{
	public List<String> ReadFile(String fileName) throws IOException
	{
		InputStream inputStream;
		InputStreamReader inputStreamReader = null;
		BufferedReader bufferRead = null;
		StringBuilder sb = new StringBuilder();
		List<String> accountNumbers = new ArrayList<>();

		String line;
		String ls = System.getProperty("line.separator");

		ClassLoader classloader = Thread.currentThread().getContextClassLoader();
		inputStream = classloader.getResourceAsStream(fileName);
		if (inputStream == null)
		{
			throw new FileNotFoundException("Error encountered while reading file: " + fileName);
		}
		try
		{
			inputStreamReader = new InputStreamReader(inputStream);

			bufferRead = new BufferedReader(inputStreamReader);

			while ((line = bufferRead.readLine()) != null)
			{
				if (!line.isEmpty())
				{
					sb.append(String.format("%-27s%s", line, ls));
				} else
				{
					accountNumbers.add(sb.toString());
					sb.delete(0, sb.length());
				}
			}
		} finally
		{
			if (sb.length() > 0)
			{
				accountNumbers.add(sb.toString());
			}

			if (bufferRead != null)
			{
				bufferRead.close();
				inputStreamReader.close();
				inputStream.close();
			}
		}

		return accountNumbers;
	}
}
