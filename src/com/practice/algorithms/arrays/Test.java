package com.practice.algorithms.arrays;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.zone.ZoneRulesProvider;

public class Test {

	public static void main(String[] args) {
		long unix = 1554664319000L;
	    System.out.println(unix);
	    System.out.println(ZonedDateTime.ofInstant(Instant.ofEpochMilli(unix), ZoneId.of("America/Santiago")));
	    System.out.println(ZoneRulesProvider.getVersions("America/Santiago").lastEntry().getKey());
		String version = System.getProperty("java.version");
		System.out.println(version);
	}

}