package com.krs.controller;

import com.krs.service.MyService;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private MyService myService;

    @GetMapping("/get")
    public void readFromSlaveAndWriteToMaster() {
        myService.readFromSlaveAndWriteToMaster();
    }

}
