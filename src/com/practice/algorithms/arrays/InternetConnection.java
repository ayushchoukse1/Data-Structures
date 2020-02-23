package com.practice.algorithms.arrays;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class InternetConnection {

	public static void main(String[] args) {
		try {
			final URL url = new URL("http://www.google.com");
			final URLConnection conn = url.openConnection();
			conn.connect();
			conn.getInputStream().close();
			System.out.println("true");
		} catch (MalformedURLException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			System.out.println("false");
		} catch (IOException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			System.out.println("false");
		}

	}

}
