package com.example.TaskHive.service;


import com.example.TaskHive.entity.entry;
import com.example.TaskHive.entryRepository.EntryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

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
}
