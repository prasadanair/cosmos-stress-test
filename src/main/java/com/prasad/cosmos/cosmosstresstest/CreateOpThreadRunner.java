package com.prasad.cosmos.cosmosstresstest;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.bson.Document;

import com.azure.cosmos.CosmosContainer;
import com.mongodb.client.MongoCollection;

public class CreateOpThreadRunner implements Runnable {

	private String threadId;
	private int numOfVINsPerThread;
	private int vinRangeStart;
	private int vinRangeEnd;
	private int numOfTripsPerVinMin;
	private int numOfTripsPerVinMax;
	private CosmosContainer cosmosContainer;
	private MongoCollection<Document> mongoCollection = null;
	private String target = null;

	public CreateOpThreadRunner(String threadId, int numOfVINsPerThread, int vinRangeStart, int vinRangeEnd,
			int numOfTripsPerVinMin, int numOfTripsPerVinMax, CosmosContainer cosmosContainer,
			MongoCollection<Document> mongoCollection, String target) {
		super();
		this.numOfVINsPerThread = numOfVINsPerThread;
		this.vinRangeStart = vinRangeStart;
		this.vinRangeEnd = vinRangeEnd;
		this.numOfTripsPerVinMin = numOfTripsPerVinMin;
		this.numOfTripsPerVinMax = numOfTripsPerVinMax;
		this.threadId = threadId;
		this.cosmosContainer = cosmosContainer;
		this.mongoCollection = mongoCollection;
		this.target = target;
	}

	@Override
	public String toString() {
		return "CreateOpThreadRunner [threadId=" + threadId + ", numOfVINsPerThread=" + numOfVINsPerThread
				+ ", vinRangeStart=" + vinRangeStart + ", vinRangeEnd=" + vinRangeEnd + ", numOfTripsPerVinMin="
				+ numOfTripsPerVinMin + ", numOfTripsPerVinMax=" + numOfTripsPerVinMax + "]";
	}

	@Override
	public void run() {
		Date startTime = new Date();
		System.out.println("Starting Task at " + startTime + ": " + this);
		int tripsForThisBatch = 0;
		for (int i = vinRangeStart; i <= vinRangeEnd; i++) {
			int tripsForThisVIN = Utils.getFaker().number().numberBetween(numOfTripsPerVinMin, numOfTripsPerVinMax);
			String vin = "vin-" + i;
			// System.out.println("Running Task for " + this.threadId + " VIN : " + vin);
			for (int x = 0; x < tripsForThisVIN; x++) {
				TripData t = TripData.createMockTrip(vin);
				try {
					if (target.equals("COSMOS")) {
						cosmosContainer.createItem(t);
					} else if (target.equals("MONGO")) {
						mongoCollection.insertOne(t.toDocument());
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
				tripsForThisBatch++;
			}
		}
		long diffInMillies = new Date().getTime() - startTime.getTime();
		long minutes = TimeUnit.MILLISECONDS.toMinutes(diffInMillies);
		System.out.println("Completed Task for " + this.threadId + " (# of Trips=" + tripsForThisBatch + ") in : "
				+ minutes + " minutes");
	}

}
