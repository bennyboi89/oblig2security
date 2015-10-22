package com.example.repository;

import com.example.model.Item;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by benny on 21.10.15.
 */
public interface ItemRepository extends MongoRepository<Item, String> {
}
