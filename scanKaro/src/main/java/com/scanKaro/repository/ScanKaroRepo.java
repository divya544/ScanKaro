package com.scanKaro.repository;

import com.scanKaro.dto.ItemDescription;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ScanKaroRepo extends MongoRepository<ItemDescription,String> {
}
