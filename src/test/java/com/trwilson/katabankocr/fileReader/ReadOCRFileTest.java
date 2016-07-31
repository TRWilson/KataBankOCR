package com.trwilson.katabankocr.fileReader;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Date: Mar 9, 2014
 * Time: 12:30:18 PM
 */
public class ReadOCRFileTest
{
	private List<String> _OCRData;

	@Before
	public void setUp() throws IOException
	{
		ReadOCRFile readOCRFile = new ReadOCRFile();
		_OCRData = readOCRFile.ReadFile("TestAccountNumbers.txt");
	}

	@Test
	public void TestOpenFile()
	{
		Assert.assertNotNull(_OCRData);
	}

	@Test
	public void TestReadOCRData()
	{
		String ls = System.getProperty("line.separator");

		String expectedOCRAccount1 =
				"    _  _     _  _  _  _  _ " + ls +
				"  | _| _||_||_ |_   ||_||_|" + ls +
				"  ||_  _|  | _||_|  ||_| _|" + ls;

		String expectedOCRAccount2 =
				" _  _  _  _  _     _  _    " + ls +
				"|_||_|  ||_ |_ |_| _| _|  |" + ls +
				" _||_|  ||_| _|  | _||_   |" + ls;

		String expectedOCRAccount3 =
				" _  _  _     _  _     _  _ " + ls +
				"| | _||_||_||_ |_|  ||_||_|" + ls +
				"|_||_ |_|  | _||_|  ||_| _|" + ls;

		String expectedOCRAccount4 =
				" _     _  _  _  _  _  _  _ " + ls +
				" _||_||_ |_||_| _||_||_ |_ " + ls +
				" _|  | _||_||_||_ |_||_| _|" + ls;

		List<String> expectedDataList = Arrays.asList(
				expectedOCRAccount1,
				expectedOCRAccount2,
				expectedOCRAccount3,
				expectedOCRAccount4
		);

		Assert.assertEquals(expectedDataList, _OCRData);
	}
}
