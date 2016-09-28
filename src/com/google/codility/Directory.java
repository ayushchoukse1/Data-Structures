//package com.google.codility;
//
//import java.util.HashMap;
//import java.util.Scanner;
//
//public class Directory {
//
//	public static void main(String[] args) throws InterruptedException {
//
//		String s = "dir1\n" + " dir11\n" + " dir12\n" + "  picture.jpeg\n" + "  dir121\n" + "  file1.txt\n" + "dir2\n"
//				+ " file2.gif\n";
//		// String s = "/dir1/ root/dir1/dir11/ /dir1/dir12/
//		// /dir1/dir12/picture.jpeg
//		// /dir1/dir12/dir121/ /dir1/dir12/file1.txt /dir2/
//		// /dir2/file2.gif";
//		System.out.println(s);
//		HashMap<String, String> map = new HashMap<String, String>();
//		String defaultPath = "/";
//		Scanner sc = new Scanner(s);
//		while (sc.hasNextLine()) {
//			checkSpacesBeforeString(sc.nextLine());
//			
//		}
//	}
//	
//	public static void checkSpacesBeforeString(String string){
//		char[] chr= string.toCharArray();
//		int count=0;
//		int i = chr.length;
//		String str=" ";
////		char space = str.;
////		while(chr[i] != " "){
//			
//		}
//	}
//
//}
