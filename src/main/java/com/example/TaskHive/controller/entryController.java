package com.example.TaskHive.controller;

import com.example.TaskHive.entity.entry;
import com.example.TaskHive.service.EntryService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.*;

@RestController
@RequestMapping("/entryCon")
public class entryController
{

    @Autowired
    private EntryService entryService;

    @GetMapping
    public ResponseEntity<?> getAll(){
        List<entry> all = entryService.getAll();
        if(all !=null && !all.isEmpty())
        {
            return new ResponseEntity<>(all,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @PostMapping
    public ResponseEntity<entry> createEntry(@RequestBody entry myEntry){
        try{

            myEntry.setDate(LocalDateTime.now());
            entryService.saveEntry(myEntry);
            return new ResponseEntity<>(myEntry, HttpStatus.CREATED);
        }
        catch(Exception e){
            return new ResponseEntity<>(myEntry, HttpStatus.BAD_REQUEST);
        }
    }


    @GetMapping("id/{myId}")
    public ResponseEntity<entry> getEntryById(@PathVariable ObjectId myId){
        Optional<entry> jEntry= entryService.findById(myId);
        if(jEntry.isPresent()){
            return new ResponseEntity<>(jEntry.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @DeleteMapping("id/{myId}")
    public ResponseEntity<?> deleteEntryById(@PathVariable ObjectId myId){
        entryService.deleteById(myId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @PutMapping("id/{myId}")
    public ResponseEntity<?> updateEntryById(@PathVariable ObjectId id, @RequestBody entry newEntry){
        entry old=entryService.findById(id).orElse(null);
        if(old != null)
        {
            old.setTitle(newEntry.getTitle() != null && !newEntry.getTitle().equals("") ? newEntry.getTitle() : old.getTitle()) ;
            old.setContent(newEntry.getContent()!=null && !newEntry.getContent().equals("") ? newEntry.getContent() : old.getContent()) ;
            entryService.saveEntry(old);
            return new ResponseEntity<>(old,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
