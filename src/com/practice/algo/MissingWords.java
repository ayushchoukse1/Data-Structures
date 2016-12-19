package com.practice.algo;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.naming.SizeLimitExceededException;

public class MissingWords {
	public static void main(String[] args) {
		String S = "I am using hackerrank to improve programming";
		String T = "am hackerrank to improve ";
		String[] array = missingWords(null, null);
		for (String string : array) {
			System.out.println(string);
		}

	}

	public static String[] missingWords(String S, String T) {
		try {
			if (S.isEmpty() || T.isEmpty()) {
				throw new NullPointerException("Please pass appropriate string.");
			}

			if (T.length() > S.length() || S.length() > Math.pow(10, 6) || T.length() > Math.pow(10, 6)) {
				throw new SizeLimitExceededException(
						"SubSequence provided is greater than the parent string or Strings provided exceeds the limit.");

			}

			StringTokenizer Stokens = new StringTokenizer(S);
			StringTokenizer Ttokens = new StringTokenizer(T);

			List<String> SList = new ArrayList<String>();
			List<String> TList = new ArrayList<String>();

			while (Stokens.hasMoreTokens()) {
				SList.add(Stokens.nextToken());
			}
			while (Ttokens.hasMoreTokens()) {
				TList.add(Ttokens.nextToken());
			}

			for (String string : SList) {
				if (string.length() >= 15) {
					throw new SizeLimitExceededException("String length more than 15 Characters: " + string);
				}
			}
			SList.removeAll(TList);

			return SList.toArray(new String[0]);

		} catch (SizeLimitExceededException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (NullPointerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
