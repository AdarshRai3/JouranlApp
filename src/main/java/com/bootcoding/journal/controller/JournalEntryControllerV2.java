package com.bootcoding.journal.controller;

import com.bootcoding.journal.entity.JournalEntry;
import com.bootcoding.journal.services.JournalEntryServices;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/journal")
public class JournalEntryControllerV2 {

    @Autowired
    JournalEntryServices journalEntryServices;

    @GetMapping
    public List<JournalEntry> getAll(){
        return journalEntryServices.getAll();
    }

    @PostMapping
    public ResponseEntity<?> createEntries(@RequestBody JournalEntry myEntry){
        try{
            myEntry.setDate(LocalDateTime.now());
            journalEntryServices.saveEntry(myEntry);
            return new ResponseEntity<>(myEntry, HttpStatus.CREATED);
        }catch(Exception ex){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/id/{myId}")
    public ResponseEntity<?> getJournalEntryByID(@PathVariable String myId){
      Optional<JournalEntry> journalEntry = journalEntryServices.findById(myId);
      if(journalEntry.isPresent()){
          return new ResponseEntity<>(journalEntry,HttpStatus.OK);
      }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/id/{myId}")
    public ResponseEntity<?> deleteJournalEntryByID(@PathVariable String myId){
        journalEntryServices.deleteById(myId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/id/{id}")
    public ResponseEntity<?> updateJournalEntryByID(@PathVariable String id, @RequestBody JournalEntry newEntry){
        JournalEntry old = journalEntryServices.findById(id).orElse(null);
        if(old!=null){
            old.setTitle(newEntry.getTitle()!=null || !newEntry.getTitle().equals("")?newEntry.getTitle():old.getTitle());
            old.setContent(newEntry.getContent()!=null || !newEntry.getContent().equals("")?newEntry.getContent():old.getContent());
            journalEntryServices.saveEntry(old);
            return new ResponseEntity<>(old,HttpStatus.OK);
        }
         return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
