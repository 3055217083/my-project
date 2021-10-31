package com.song.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @author : zhixian.song
 * @description : TODO
 * @time : 2021.10.8 17:08
 */
@Service
public class MongoDbService {

    @Autowired
    MongoTemplate mongoTemplate;

    public Set<String> showCollectionNames() {
        Query query = new Query();
        return mongoTemplate.getCollectionNames();
    }
}
