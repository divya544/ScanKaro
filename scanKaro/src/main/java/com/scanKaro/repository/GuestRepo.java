package com.scanKaro.repository;

import com.scanKaro.dto.Guest;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuestRepo extends MongoRepository<Guest, String> {
}
