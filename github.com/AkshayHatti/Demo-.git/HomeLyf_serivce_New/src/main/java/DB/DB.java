package DB;
import org.bson.Document;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
class DB {
	public static void main(String[] args) {
        // MongoDB Cloud Database connection string
        String connectionString = "mongodb+srv://amitpotdukhe20:cmPUrefrPzB0BIuW@homelyfcluster0.4fzxngg.mongodb.net/?retryWrites=true&w=majority";

        // Connect to MongoDB Cloud Database
        MongoClient mongoClient = MongoClients.create(
                MongoClientSettings.builder()
                        .applyConnectionString(new ConnectionString(connectionString))
                        .build()
        );

        // Select the database
        MongoDatabase database = mongoClient.getDatabase("test");

        // Select the collection
        MongoCollection<Document> collection = database.getCollection("users");
        
        // Find documents
        
        FindIterable<Document> documents = collection.find();
        for (Document document : documents) {
            System.out.println(document.toJson());
        }

        Document query = new Document("email", "kamal@gmail.com");
		//FindIterable<Document> documents = collection.find(query);
        
        MongoCollection<Document> collection1 = database.getCollection("users");
        
		  Document documentToInsert = new Document("name", "pranav")
            .append("email", "pranav@gmail.com")
            .append("password", "Pranav@123");
	    collection.insertOne(documentToInsert);
	    System.out.println("Document inserted successfully.");
        

    /*    // Insert document
        Document documentToInsert = new Document("key", "value");
        collection.insertOne(documentToInsert);
        System.out.println("Document inserted successfully.");

        // Update document
        Document filter = new Document("key", "value");
        Document update = new Document("$set", new Document("key", "updatedValue"));
        collection.updateOne(filter, update);
        System.out.println("Document updated successfully.");

        // Delete document
        Document documentToDelete = new Document("key", "updatedValue");
        collection.deleteOne(documentToDelete);
        System.out.println("Document deleted successfully.");
        */

        // Close the MongoDB client
        mongoClient.close();
	}

}