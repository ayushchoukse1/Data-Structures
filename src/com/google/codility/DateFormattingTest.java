package com.google.codility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormattingTest {

	public void date(String dateString) throws ParseException {

		// This Regular Expression will replace st to blank
		String dateString1 = dateString.replaceFirst("[a-zA-Z]{2}", "");
		// create Date Format and Parse it based on input

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("d MMMM yyyy");
		Date rightNow = simpleDateFormat.parse(dateString1);

		// Now create Date format for output type. and format the input
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String formattedDate = dateFormat.format(rightNow);
		System.out.println(formattedDate);
	}

	public static void main(String[] args) throws ParseException {
		String dateString = "4th April 1840";
		DateFormattingTest t = new DateFormattingTest();
		t.date(dateString);
	}
}