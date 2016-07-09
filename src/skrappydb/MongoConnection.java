/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package skrappydb;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;
import org.bson.Document;



public class MongoConnection {

    private final static String DATABASE = "fin_news"; 
    private static final String HOST = "localhost"; 
    private static final int PORT = 27017; 
    private MongoClient mongoClient;
    private MongoDatabase db;
    
    
    public MongoConnection()
    {
        try   
        {
            mongoClient = new MongoClient(HOST, PORT);
            db = mongoClient.getDatabase(DATABASE);
            System.out.printf("Connection to DB successful");
        }
        catch(Exception e)
        {
            System.out.println("Error connecting to the database");
        }
    }
    
    public void closeResources()
    {
       mongoClient.close();
    }
    
    public void getCollections()
    {
        MongoIterable<String> results = db.listCollectionNames();
        MongoCursor<String> cursor = results.iterator();
        
        while(cursor.hasNext()){
            System.out.println(cursor.next());
        }
    }
    
    public void getListings(String database)
    {
        MongoCollection<Document> coll = db.getCollection(database);
        MongoCursor<Document> cursor = coll.find().iterator();
        try
        {
            while(cursor.hasNext()){
                Document doc = cursor.next();
                System.out.printf("%s %n%n", doc);
            }
        }
        finally
        {
            cursor.close();
        }
    }
    
    
    
    
}
