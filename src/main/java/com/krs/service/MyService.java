package com.krs.service;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyService {

    @Autowired
    @Qualifier("masterMongoTemplate")
    private MongoTemplate masterMongoTemplate;

    @Autowired
    @Qualifier("slaveMongoTemplate")
    private MongoTemplate slaveMongoTemplate;

    public void readFromSlaveAndWriteToMaster() {
        List<Document> documents = slaveMongoTemplate.findAll(Document.class, "movierulz");

        for (Document doc : documents) {
            masterMongoTemplate.insert(doc, "movierulz");
        }
    }

}