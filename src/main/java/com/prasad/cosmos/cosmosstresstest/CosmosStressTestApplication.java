package com.prasad.cosmos.cosmosstresstest;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.bson.Document;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.azure.cosmos.CosmosClient;
import com.azure.cosmos.CosmosClientBuilder;
import com.azure.cosmos.CosmosContainer;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

@SpringBootApplication
public class CosmosStressTestApplication {

	static AppConfig APPCONFIG = null;
	static CosmosContainer cosmosContainer = null;
	static MongoCollection<Document> mongoCollection = null;

	public static void main(String[] args) {
		Date appStartTime = new Date();
		System.out.println("App started at " + appStartTime + " by " + Thread.currentThread().getName());
		// Load App Config from Args
		loadAppConfig(args);

		// Create Cosmos/Mongo Client and Container objects
		if (APPCONFIG.getTarget().equals("COSMOS")) {
			CosmosClient cosmosClient = new CosmosClientBuilder()
					.endpoint(APPCONFIG.getCosmosConfig().get("url").toString())
					.key(APPCONFIG.getCosmosConfig().get("key").toString()).buildClient();
			cosmosContainer = cosmosClient.getDatabase(APPCONFIG.getCosmosConfig().get("database").toString())
					.getContainer(APPCONFIG.getCosmosConfig().get("container").toString());
		} else if (APPCONFIG.getTarget().equals("MONGO")) {
			try {
				MongoClient mongoClient = MongoClients
						.create(APPCONFIG.getMongoConfig().get("connectionString").toString());
				MongoDatabase database = mongoClient.getDatabase(APPCONFIG.getMongoConfig().get("database").toString());
				mongoCollection = database.getCollection(APPCONFIG.getMongoConfig().get("collection").toString());
				System.out.println(mongoCollection.countDocuments());
			} catch (Exception ex) {
				System.out.println("Mongo client initiation failed.");
				ex.printStackTrace();
				return;
			}
		} else {
			System.out.println(
					"Configuration point 'target' must be set to either 'COSMOS' or 'MONGO'. Actual received target was '"
							+ APPCONFIG.getTarget() + "'");
			return;
		}

		// Create CreateOp Thread Pool Executor Service
		ExecutorService createOpExecutorService = Executors
				.newFixedThreadPool(APPCONFIG.getCreateOp().getNumOfThreads());

		// Submit Tasks to the executor service
		for (int i = APPCONFIG.getCreateOp().getVinRangeStart(); i < APPCONFIG.getCreateOp()
				.getVinRangeEnd(); i += APPCONFIG.getCreateOp().getNumOfVINsPerThread()) {
			CreateOpThreadRunner task = new CreateOpThreadRunner("CreateBatch" + i,
					APPCONFIG.getCreateOp().getNumOfVINsPerThread(), i + 1,
					i + APPCONFIG.getCreateOp().getNumOfVINsPerThread(),
					APPCONFIG.getCreateOp().getNumOfTripsPerVinMin(), APPCONFIG.getCreateOp().getNumOfTripsPerVinMax(),
					cosmosContainer, mongoCollection, APPCONFIG.getTarget());
			createOpExecutorService.submit(task);
		}

		// Shutdown the executor service
		createOpExecutorService.shutdown();
		try {
			if (createOpExecutorService.awaitTermination(5, TimeUnit.HOURS)) {
				long diffInMillies = new Date().getTime() - appStartTime.getTime();
				long minutes = TimeUnit.MILLISECONDS.toMinutes(diffInMillies);
				System.out.println(
						"App exited from " + Thread.currentThread().getName() + " in : " + minutes + " minutes");
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void loadAppConfig(String[] args) {
		// load config
		try {
			String configFile = "/home/azureuser/cosmos-stress-test-gm/config00.json";
			if (args != null && args.length > 0 && args[0] != null && args[0].length() > 0) {
				configFile = args[0];
			}
			APPCONFIG = AppConfig.loadConfig(configFile);
			System.out.println("Target: " + APPCONFIG.getTarget());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
