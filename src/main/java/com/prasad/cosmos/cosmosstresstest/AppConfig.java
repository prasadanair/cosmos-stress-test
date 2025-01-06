package com.prasad.cosmos.cosmosstresstest;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

public class AppConfig {
	private String target;
	private Map<String, Object> cosmosConfig;
	private Map<String, Object> mongoConfig;
	private CreateOp createOp;
	private UpdateOp updateOp;

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public Map<String, Object> getCosmosConfig() {
		return cosmosConfig;
	}

	public void setCosmosConfig(Map<String, Object> cosmosConfig) {
		this.cosmosConfig = cosmosConfig;
	}

	public Map<String, Object> getMongoConfig() {
		return mongoConfig;
	}

	public void setMongoConfig(Map<String, Object> mongoConfig) {
		this.mongoConfig = mongoConfig;
	}

	public CreateOp getCreateOp() {
		return createOp;
	}

	public void setCreateOp(CreateOp createOp) {
		this.createOp = createOp;
	}

	public UpdateOp getUpdateOp() {
		return updateOp;
	}

	public void setUpdateOp(UpdateOp updateOp) {
		this.updateOp = updateOp;
	}

	public static class CreateOp {
		private boolean enabled;
		private int numOfThreads;
		private int numOfVINsPerThread;
		private int vinRangeStart;
		private int vinRangeEnd;
		private int numOfTripsPerVinMin;
		private int numOfTripsPerVinMax;

		public boolean isEnabled() {
			return enabled;
		}

		public void setEnabled(boolean enabled) {
			this.enabled = enabled;
		}

		public int getNumOfThreads() {
			return numOfThreads;
		}

		public void setNumOfThreads(int numOfThreads) {
			this.numOfThreads = numOfThreads;
		}

		public int getNumOfVINsPerThread() {
			return numOfVINsPerThread;
		}

		public void setNumOfVINsPerThread(int numOfVINsPerThread) {
			this.numOfVINsPerThread = numOfVINsPerThread;
		}

		public int getVinRangeStart() {
			return vinRangeStart;
		}

		public void setVinRangeStart(int vinRangeStart) {
			this.vinRangeStart = vinRangeStart;
		}

		public int getVinRangeEnd() {
			return vinRangeEnd;
		}

		public void setVinRangeEnd(int vinRangeEnd) {
			this.vinRangeEnd = vinRangeEnd;
		}

		public int getNumOfTripsPerVinMin() {
			return numOfTripsPerVinMin;
		}

		public void setNumOfTripsPerVinMin(int numOfTripsPerVinMin) {
			this.numOfTripsPerVinMin = numOfTripsPerVinMin;
		}

		public int getNumOfTripsPerVinMax() {
			return numOfTripsPerVinMax;
		}

		public void setNumOfTripsPerVinMax(int numOfTripsPerVinMax) {
			this.numOfTripsPerVinMax = numOfTripsPerVinMax;
		}

	}

	public static class UpdateOp {
		private boolean enabled;
		private int numOfThreads;
		private int vinRangeStart;
		private int vinRangeEnd;
		private int tripIdRangeStart;
		private int tripIdRangeEnd;

		public boolean isEnabled() {
			return enabled;
		}

		public void setEnabled(boolean enabled) {
			this.enabled = enabled;
		}

		public int getNumOfThreads() {
			return numOfThreads;
		}

		public void setNumOfThreads(int numOfThreads) {
			this.numOfThreads = numOfThreads;
		}

		public int getVinRangeStart() {
			return vinRangeStart;
		}

		public void setVinRangeStart(int vinRangeStart) {
			this.vinRangeStart = vinRangeStart;
		}

		public int getVinRangeEnd() {
			return vinRangeEnd;
		}

		public void setVinRangeEnd(int vinRangeEnd) {
			this.vinRangeEnd = vinRangeEnd;
		}

		public int getTripIdRangeStart() {
			return tripIdRangeStart;
		}

		public void setTripIdRangeStart(int tripIdRangeStart) {
			this.tripIdRangeStart = tripIdRangeStart;
		}

		public int getTripIdRangeEnd() {
			return tripIdRangeEnd;
		}

		public void setTripIdRangeEnd(int tripIdRangeEnd) {
			this.tripIdRangeEnd = tripIdRangeEnd;
		}

	}

	public static AppConfig loadConfig(String fileName) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		// InputStream inputStream =
		// AppConfig.class.getClassLoader().getResourceAsStream(fileName);
		InputStream inputStream = new FileInputStream(fileName);
		return mapper.readValue(inputStream, AppConfig.class);
	}

	public static void main(String[] args) {
		try {
			AppConfig config = AppConfig.loadConfig("config.json");
			System.out.println("Target: " + config.getTarget());
			// Print other config parameters as needed
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}