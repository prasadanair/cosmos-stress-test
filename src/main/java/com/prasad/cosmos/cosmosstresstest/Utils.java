package com.prasad.cosmos.cosmosstresstest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.TimeZone;

import com.github.javafaker.Faker;

public class Utils {
	static Faker faker = new Faker();
	static Random random = new Random();
	
	static String getISO8601StrFromDate(Date date) {
		SimpleDateFormat isoFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
        isoFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        String formattedDate = isoFormat.format(date);
        return formattedDate;
	}
	
	
	static Date getDateFromISO8601Str(String isoDateString){
		SimpleDateFormat isoFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
        isoFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        try {
            Date date = isoFormat.parse(isoDateString);
            return date;
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
	}

	static Faker getFaker() {
		return faker;
	}
	
	static int getFakeOdometer() {
		return faker.number().numberBetween(10000, 300000);
	}


	public static double getFakeDistanceMiles() {
		return faker.number().numberBetween(7, 131);
	}


	public static double getEngineRuntime(double distanceMiles) {
		return distanceMiles*3*(random.nextDouble());
	}


	public static double getEngineIdletime(double engineRuntimeMinutes) {
		return engineRuntimeMinutes*(random.nextDouble(0.01, 0.18));
	}


	public static double getDurationMinutes(double distanceMiles) {
		return distanceMiles*3.5*(random.nextDouble());
	}
}
