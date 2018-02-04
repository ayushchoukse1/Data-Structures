package com.practice.algorithms;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class CompareFiles {
	public boolean contentEquals(File f1, File f2) throws IOException {
		       if (f1.exists() != f2.exists()) {
		           return false;
		       }
		
		        if (!f1.exists()) {
		            // two not existing files are equal
		            return true;
		        }
		
		       if (f1.isDirectory() || f2.isDirectory()) {
	           // don't want to compare directory contents for now
		            return false;
		        }
		
		        if (f1.equals(f2)) {
		          // same filename => true
		            return true;
		        }
		
	       if (f1.length() != f2.length()) {
	            // different size =>false
	           return false;
		        }
		
		        InputStream in1 = null;
		InputStream in2 = null;
		try {
		            in1 = new BufferedInputStream(new FileInputStream(f1));
		            in2 = new BufferedInputStream(new FileInputStream(f2));
		
		            int expectedByte = in1.read();
		           while (expectedByte != -1) {
		               if (expectedByte != in2.read()) {
		                    return false;
		                }
		                expectedByte = in1.read();
		            }
		           if (in2.read() != -1) {
		               return false;
		           }
		            return true;
		       } finally {
		            if (in1 != null) {
		                try {
		                    in1.close();
		                } catch (IOException e) {}
		           }
		            if (in2 != null) {
		                try {
		                    in2.close();
		               } catch (IOException e) {}
		            }
		     }
		    }
}
