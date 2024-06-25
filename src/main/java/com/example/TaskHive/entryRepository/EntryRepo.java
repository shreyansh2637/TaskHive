package com.example.TaskHive.entryRepository;

import com.example.TaskHive.entity.entry;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EntryRepo extends MongoRepository<entry, ObjectId> {


}
