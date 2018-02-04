package com.practice.algorithms;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class CompareFilesNew {

	/*
	 *Given a directory containing folder and files, find all duplicated files. 
	 *A duplicate file is a file with same content. The name and location of the 
	 *file can be different. Assume there is only 1 duplicate max.
	 *
	 *For example,
	 * /etc/apache/httpd.conf could be copied into 
	 * 	/tmp/foo/httpd.conf.bak.
	 * 
	 * 
	 * Return a list of FilePaths.
	 */

	public static void main(String[] args) {
		if (args.length < 1) {
			System.out.println("Please provide a directory.");
			return;
		}
		File directory = new File(args[0]);
		if (!directory.isDirectory()) {
			System.out.println("Given Directory does not exist.");
			return;
		}
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		searchDirectoryForFiles(map, directory);
		for (List<String> list : map.values()) {
			if (list.size() > 1) {
				System.out.println("size: "+list.size());
				//return list;	 // return the list.
				//else print the list of the files.
				for (String filePath : list) {
					System.out.println(filePath);
				}
			}
		}
	}

	public static void searchDirectoryForFiles(Map<String, List<String>> map, File directory) {
		File[] files = directory.listFiles();
		for (File file : files) {
			// check whether the encountered file type is File or directory.
			if (file.isDirectory()) {
				CompareFilesNew.searchDirectoryForFiles(map, file);
			} else {
				// read the contents of the file,perform Hashing on its contents
				// and store generated hash in the map.
				try {
					FileInputStream fio = new FileInputStream(file);
					byte[] byteArray = new byte[(int) file.length()];
					fio.read(byteArray);
					fio.close();
					String hash = new BigInteger(1, MessageDigest.getInstance("SHA-512").digest(byteArray))
							.toString(16);
					System.out.println(hash);
					List<String> list = map.get(hash);
					if (list == null) {
						list = new LinkedList<String>();
						map.put(hash, list);
					}
					list.add(file.getAbsolutePath());
				} catch (IOException | NoSuchAlgorithmException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		}
	}

}
