package com.trwilson.katabankocr.fileReader;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Date: Mar 9, 2014
 * Time: 12:30:18 PM
 */
public class ReadOCRFileExceptionTest
{
	private static final String MISSING_FILE_NAME = "MissingFile.txt";
	private List<String> _OCRData;

	@Rule
	public final ExpectedException thrown = ExpectedException.none();

	@Before
	public void setUp() throws IOException
	{
		ReadOCRFile readOCRFile = new ReadOCRFile();

		thrown.expect(FileNotFoundException.class);
		thrown.expectMessage("Error encountered while reading file: " + MISSING_FILE_NAME);

		_OCRData = readOCRFile.ReadFile(MISSING_FILE_NAME);
	}

	@Test
	public void TestOpenFile()
	{
		Assert.assertNull(_OCRData);
	}
}
