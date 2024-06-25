package com.example.TaskHive.controller;

import com.example.TaskHive.entity.entry;
import com.example.TaskHive.service.EntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Map;
import java.util.List;
import java.util.HashMap;

@RestController
@RequestMapping("/entryCon")
public class entryController
{

    @Autowired
    private EntryService entryService;

    @GetMapping
    public List<entry> getAll(){
    return entryService.getAll();
    }
    @PostMapping
    public boolean createEntry(@RequestBody entry myEntry){
        entryService.saveEntry(myEntry);
        return true;
    }
}
