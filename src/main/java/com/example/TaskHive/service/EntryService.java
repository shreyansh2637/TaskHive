package com.example.TaskHive.service;


import com.example.TaskHive.entity.entry;
import com.example.TaskHive.entryRepository.EntryRepo;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class EntryService {

    @Autowired
    private EntryRepo entryRepo;
    public void saveEntry(entry entry) {
        entryRepo.save(entry);
    }
    public List<entry> getAll()
    {
        return entryRepo.findAll();
    }
    public Optional<entry> findById(ObjectId id) {
        return entryRepo.findById(id);
    }
    public void deleteById(ObjectId id) {
        entryRepo.deleteById(id);
    }
}
