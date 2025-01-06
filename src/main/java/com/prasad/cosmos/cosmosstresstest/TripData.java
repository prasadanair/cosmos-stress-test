package com.prasad.cosmos.cosmosstresstest;

import java.util.Date;

import org.bson.Document;

import com.azure.cosmos.CosmosClient;
import com.azure.cosmos.CosmosClientBuilder;
import com.azure.cosmos.CosmosContainer;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class TripData {
	private String vinNbr;
	private String tripId;
	private String tripStartUtcDt;
	private String tripStartLocalTimstm;
	private double tripStartOdometerMiles;
	private double tripEndOdometerMiles;
	private double distanceMiles;
	private double durationMinutes;
	private double engineRuntimeMinutes;
	private double engineIdletimeMinutes;
	private boolean hasIdleAndRuntimeFlag;
	private int hardAcceleration7Count;
	private int hardAcceleration8Count;
	private int hardAcceleration9Count;
	private int hardBrake7Count;
	private int hardBrake8Count;
	private int hardBrake9Count;
	private double speeding80mphMiles;
	private double weekendDaytimeMiles;
	private double lateNightMiles;
	private boolean seatbeltLatchedFlag;
	private boolean canCaptureSeatbeltFlag;
	private String processedTime;
	private String pDate;
	private String id;
	private int ttl;

	// Getters and Setters
	public String getVinNbr() {
		return vinNbr;
	}

	public void setVinNbr(String vinNbr) {
		this.vinNbr = vinNbr;
	}

	public String getTripId() {
		return tripId;
	}

	public void setTripId(String tripId) {
		this.tripId = tripId;
	}

	public String getTripStartUtcDt() {
		return tripStartUtcDt;
	}

	public void setTripStartUtcDt(String tripStartUtcDt) {
		this.tripStartUtcDt = tripStartUtcDt;
	}

	public String getTripStartLocalTimstm() {
		return tripStartLocalTimstm;
	}

	public void setTripStartLocalTimstm(String tripStartLocalTimstm) {
		this.tripStartLocalTimstm = tripStartLocalTimstm;
	}

	public double getTripStartOdometerMiles() {
		return tripStartOdometerMiles;
	}

	public void setTripStartOdometerMiles(double tripStartOdometerMiles) {
		this.tripStartOdometerMiles = tripStartOdometerMiles;
	}

	public double getTripEndOdometerMiles() {
		return tripEndOdometerMiles;
	}

	public void setTripEndOdometerMiles(double tripEndOdometerMiles) {
		this.tripEndOdometerMiles = tripEndOdometerMiles;
	}

	public double getDistanceMiles() {
		return distanceMiles;
	}

	public void setDistanceMiles(double distanceMiles) {
		this.distanceMiles = distanceMiles;
	}

	public double getDurationMinutes() {
		return durationMinutes;
	}

	public void setDurationMinutes(double durationMinutes) {
		this.durationMinutes = durationMinutes;
	}

	public double getEngineRuntimeMinutes() {
		return engineRuntimeMinutes;
	}

	public void setEngineRuntimeMinutes(double engineRuntimeMinutes) {
		this.engineRuntimeMinutes = engineRuntimeMinutes;
	}

	public double getEngineIdletimeMinutes() {
		return engineIdletimeMinutes;
	}

	public void setEngineIdletimeMinutes(double engineIdletimeMinutes) {
		this.engineIdletimeMinutes = engineIdletimeMinutes;
	}

	public boolean isHasIdleAndRuntimeFlag() {
		return hasIdleAndRuntimeFlag;
	}

	public void setHasIdleAndRuntimeFlag(boolean hasIdleAndRuntimeFlag) {
		this.hasIdleAndRuntimeFlag = hasIdleAndRuntimeFlag;
	}

	public int getHardAcceleration7Count() {
		return hardAcceleration7Count;
	}

	public void setHardAcceleration7Count(int hardAcceleration7Count) {
		this.hardAcceleration7Count = hardAcceleration7Count;
	}

	public int getHardAcceleration8Count() {
		return hardAcceleration8Count;
	}

	public void setHardAcceleration8Count(int hardAcceleration8Count) {
		this.hardAcceleration8Count = hardAcceleration8Count;
	}

	public int getHardAcceleration9Count() {
		return hardAcceleration9Count;
	}

	public void setHardAcceleration9Count(int hardAcceleration9Count) {
		this.hardAcceleration9Count = hardAcceleration9Count;
	}

	public int getHardBrake7Count() {
		return hardBrake7Count;
	}

	public void setHardBrake7Count(int hardBrake7Count) {
		this.hardBrake7Count = hardBrake7Count;
	}

	public int getHardBrake8Count() {
		return hardBrake8Count;
	}

	public void setHardBrake8Count(int hardBrake8Count) {
		this.hardBrake8Count = hardBrake8Count;
	}

	public int getHardBrake9Count() {
		return hardBrake9Count;
	}

	public void setHardBrake9Count(int hardBrake9Count) {
		this.hardBrake9Count = hardBrake9Count;
	}

	public double getSpeeding80mphMiles() {
		return speeding80mphMiles;
	}

	public void setSpeeding80mphMiles(double speeding80mphMiles) {
		this.speeding80mphMiles = speeding80mphMiles;
	}

	public double getWeekendDaytimeMiles() {
		return weekendDaytimeMiles;
	}

	public void setWeekendDaytimeMiles(double weekendDaytimeMiles) {
		this.weekendDaytimeMiles = weekendDaytimeMiles;
	}

	public double getLateNightMiles() {
		return lateNightMiles;
	}

	public void setLateNightMiles(double lateNightMiles) {
		this.lateNightMiles = lateNightMiles;
	}

	public boolean isSeatbeltLatchedFlag() {
		return seatbeltLatchedFlag;
	}

	public void setSeatbeltLatchedFlag(boolean seatbeltLatchedFlag) {
		this.seatbeltLatchedFlag = seatbeltLatchedFlag;
	}

	public boolean isCanCaptureSeatbeltFlag() {
		return canCaptureSeatbeltFlag;
	}

	public void setCanCaptureSeatbeltFlag(boolean canCaptureSeatbeltFlag) {
		this.canCaptureSeatbeltFlag = canCaptureSeatbeltFlag;
	}

	public String getProcessedTime() {
		return processedTime;
	}

	public void setProcessedTime(String processedTime) {
		this.processedTime = processedTime;
	}

	public String getPDate() {
		return pDate;
	}

	public void setPDate(String pDate) {
		this.pDate = pDate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getTtl() {
		return ttl;
	}

	public void setTtl(int ttl) {
		this.ttl = ttl;
	}

	public TripData(String vinNbr) {
		super();
		this.vinNbr = vinNbr;
	}

	static TripData createMockTrip(String vinNbr) {
		TripData trip = new TripData(vinNbr);
		Date tripStart = new Date();
		trip.setTripId(Utils.getISO8601StrFromDate(tripStart));
		trip.setTripStartUtcDt(trip.getTripId());
		trip.setTripStartLocalTimstm(trip.getTripStartUtcDt());
		trip.setTripStartOdometerMiles(Utils.getFakeOdometer());
		trip.setDistanceMiles(Utils.getFakeDistanceMiles());
		trip.setDurationMinutes(Utils.getDurationMinutes(trip.getDistanceMiles()));
		trip.setTripEndOdometerMiles(trip.getTripStartOdometerMiles() + trip.getDistanceMiles());
		trip.setEngineRuntimeMinutes(Utils.getEngineRuntime(trip.getDistanceMiles()));
		trip.setEngineIdletimeMinutes(Utils.getEngineIdletime(trip.getEngineRuntimeMinutes()));
		trip.setHasIdleAndRuntimeFlag((Utils.getFaker().number().numberBetween(0, 1)) == 1);
		trip.setHardAcceleration7Count(0);
		trip.setHardAcceleration8Count(0);
		trip.setHardAcceleration9Count(0);
		trip.setHardBrake7Count(0);
		trip.setHardBrake8Count(0);
		trip.setHardBrake9Count(0);
		trip.setSpeeding80mphMiles(Utils.getFaker().number().numberBetween(0, 10));
		trip.setWeekendDaytimeMiles(0);
		trip.setLateNightMiles(0);
		trip.setSeatbeltLatchedFlag(Utils.getFaker().number().numberBetween(0, 1) == 1);
		trip.setCanCaptureSeatbeltFlag(Utils.getFaker().number().numberBetween(0, 1) == 1);
		trip.setProcessedTime(trip.getTripStartUtcDt());
		trip.setPDate(trip.getProcessedTime());
		trip.setId(trip.getTripId());
		trip.setTtl(30 * 24 * 60 * 60);
		return trip;
	}

	@Override
	public String toString() {
		return "TripData [vinNbr=" + vinNbr + ", tripId=" + tripId + ", tripStartUtcDt=" + tripStartUtcDt
				+ ", tripStartLocalTimstm=" + tripStartLocalTimstm + ", tripStartOdometerMiles="
				+ tripStartOdometerMiles + ", tripEndOdometerMiles=" + tripEndOdometerMiles + ", distanceMiles="
				+ distanceMiles + ", durationMinutes=" + durationMinutes + ", engineRuntimeMinutes="
				+ engineRuntimeMinutes + ", engineIdletimeMinutes=" + engineIdletimeMinutes + ", hasIdleAndRuntimeFlag="
				+ hasIdleAndRuntimeFlag + ", hardAcceleration7Count=" + hardAcceleration7Count
				+ ", hardAcceleration8Count=" + hardAcceleration8Count + ", hardAcceleration9Count="
				+ hardAcceleration9Count + ", hardBrake7Count=" + hardBrake7Count + ", hardBrake8Count="
				+ hardBrake8Count + ", hardBrake9Count=" + hardBrake9Count + ", speeding80mphMiles="
				+ speeding80mphMiles + ", weekendDaytimeMiles=" + weekendDaytimeMiles + ", lateNightMiles="
				+ lateNightMiles + ", seatbeltLatchedFlag=" + seatbeltLatchedFlag + ", canCaptureSeatbeltFlag="
				+ canCaptureSeatbeltFlag + ", processedTime=" + processedTime + ", pDate=" + pDate + ", id=" + id
				+ ", ttl=" + ttl + "]";
	}

	public Document toDocument() {
		return new Document("vinNbr", this.vinNbr).append("id", id).append("tripId", tripId)
				.append("tripStartUtcDt", tripStartUtcDt).append("tripStartLocalTimstm", id)
				.append("tripStartOdometerMiles", tripStartOdometerMiles)
				.append("tripEndOdometerMiles", tripEndOdometerMiles).append("distanceMiles", distanceMiles)
				.append("durationMinutes", durationMinutes).append("engineRuntimeMinutes", engineRuntimeMinutes)
				.append("engineIdletimeMinutes", engineIdletimeMinutes)
				.append("hasIdleAndRuntimeFlag", hasIdleAndRuntimeFlag)
				.append("hardAcceleration7Count", hardAcceleration7Count)
				.append("hardAcceleration8Count", hardAcceleration8Count)
				.append("hardAcceleration9Count", hardAcceleration9Count).append("hardBrake7Count", hardBrake7Count)
				.append("hardBrake8Count", hardBrake8Count).append("hardBrake9Count", hardBrake9Count)
				.append("speeding80mphMiles", speeding80mphMiles).append("weekendDaytimeMiles", weekendDaytimeMiles)
				.append("lateNightMiles", lateNightMiles).append("seatbeltLatchedFlag", seatbeltLatchedFlag)
				.append("canCaptureSeatbeltFlag", canCaptureSeatbeltFlag).append("processedTime", processedTime)
				.append("pDate", pDate).append("ttl", ttl);
	}

	public static void main(String[] args) {
		TripData t = TripData.createMockTrip("vin-" + Utils.getFaker().number().numberBetween(8888, 9999));
		AppConfig appConfig = null;
		try {
			appConfig = AppConfig.loadConfig("C:\\ENV\\gm\\config.json");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (appConfig != null && appConfig.getTarget().equals("COSMOS")) {
			CosmosClient cosmosClient = new CosmosClientBuilder()
					.endpoint(appConfig.getCosmosConfig().get("url").toString())
					.key(appConfig.getCosmosConfig().get("key").toString()).buildClient();
			CosmosContainer cosmosContainer = cosmosClient
					.getDatabase(appConfig.getCosmosConfig().get("database").toString())
					.getContainer(appConfig.getCosmosConfig().get("container").toString());
			cosmosContainer.createItem(t);
			System.out.println(t);
		} else if (appConfig != null && appConfig.getTarget().equals("MONGO")) {
			try {
				MongoClient mongoClient = MongoClients
						.create(appConfig.getMongoConfig().get("connectionString").toString());
				MongoDatabase database = mongoClient.getDatabase(appConfig.getMongoConfig().get("database").toString());
				MongoCollection<Document> mongoCollection = database
						.getCollection(appConfig.getMongoConfig().get("collection").toString());
				mongoCollection.insertOne(t.toDocument());
				System.out.println(t);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("App Config Load Failed");
		}
	}
}