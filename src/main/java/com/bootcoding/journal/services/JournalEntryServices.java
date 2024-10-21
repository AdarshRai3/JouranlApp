package com.bootcoding.journal.services;

import com.bootcoding.journal.entity.JournalEntry;
import com.bootcoding.journal.repository.JournalEntryRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.*;

@Component
public class JournalEntryServices {
  @Autowired
    private JournalEntryRepository journalEntryRepository;
    public void saveEntry(JournalEntry journalEntry){
        journalEntryRepository.save(journalEntry);
    }
    public List<JournalEntry> getAll(){
       return journalEntryRepository.findAll();
    }

   public Optional<JournalEntry> findById(String id){
        return journalEntryRepository.findById(id);
   }

   public void deleteById(String id){
        journalEntryRepository.deleteById(id);
   }
}
