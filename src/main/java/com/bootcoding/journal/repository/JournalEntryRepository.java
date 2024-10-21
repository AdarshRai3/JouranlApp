package com.bootcoding.journal.repository;
import com.bootcoding.journal.entity.JournalEntry;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface JournalEntryRepository extends MongoRepository<JournalEntry, String>{

}
