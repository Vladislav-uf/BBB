package ru.sfedu.utils;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bson.Document;
import ru.sfedu.beans.HistoryContent;
import ru.sfedu.beans.Storekeeper;

import java.io.IOException;

import static ru.sfedu.Constants.*;
import static ru.sfedu.utils.ConfigurationUtil.getConfigurationEntry;

public class HistoryMongo {

    private static final Logger log = LogManager.getLogger(HistoryMongo.class.getName());

    public static void record (HistoryContent history) {
        try {
            MongoClient client = new MongoClient(new MongoClientURI(getConfigurationEntry(MONGO_URI)));
            MongoDatabase database = client.getDatabase(getConfigurationEntry(MONGO_DATABASE));
            MongoCollection<Document> collection = database.getCollection(getConfigurationEntry(MONGO_COLLECTION));
            Document document = new Document();
            document.put("id", history.getId());
            document.put("className", history.getClassName());
            document.put("createdDate", history.getCreatedDate());
            document.put("actor", history.getActor());
            document.put("methodName", history.getMethodName());
            document.put("object", history.getObject());
            document.put("status", history.getStatus().toString());
            log.info("Connection succesful");
            log.info("Connection succesful" + document);
            collection.insertOne(document);
            log.info("Connection succesful eee");
        } catch (IOException e) {
            log.info(e);
        }
    }
}