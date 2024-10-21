//package com.bootcoding.journal.controller;
//
//import com.bootcoding.journal.entity.JournalEntry;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.*;
//
//@RestController
//@RequestMapping("/journal")
//public class JournalEntryController {
//     private Map<Long, JournalEntry> journalEntries = new HashMap<>();
//
//     @GetMapping
//      public List<JournalEntry> getAll(){
//         return new ArrayList<>(journalEntries.values());
//     }
//
//     @PostMapping
//      public boolean createEntries(@RequestBody JournalEntry myEntry){
//         journalEntries.put(myEntry.getId(), myEntry);
//         return true;
//     }
//
//     @GetMapping("/id/{myId}")
//     public JournalEntry getJournalEntryByID(@PathVariable long myId){
//         return journalEntries.get(myId);
//     }
//
//     @DeleteMapping("/id/{myId}")
//     public boolean deleteJournalEntryByID(@PathVariable long myId){
//         journalEntries.remove(myId);
//         return true;
//     }
//
//     @PutMapping("/id/{id}")
//     public JournalEntry updateJournalEntryByID(@PathVariable long id, @RequestBody JournalEntry myEntry){
//         return journalEntries.put(id,myEntry);
//     }
//
//}
