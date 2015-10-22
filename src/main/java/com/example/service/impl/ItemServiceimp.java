package com.example.service.impl;

import com.example.exception.ItemFoundException;
import com.example.model.Item;
import com.example.repository.ItemRepository;
import com.example.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.UUID;

/**
 * Created by benny on 21.10.15.
 */
@Service("itemserviceimp")
public class ItemServiceimp  {


    @Autowired
    private MongoTemplate repository;







    public void insertNewItem(Item newItem) {
        if (!repository.collectionExists(Item.class)) {
            repository.createCollection(Item.class);

        }
        newItem.setId(UUID.randomUUID().toString());
        repository.insert(newItem);
    }

    public Item getItem(String id){
        return repository.findOne(Query.query(Criteria.where("_id").is(id)),
                Item.class);
    }


    //Sletter en vare fra collection med id som kommer fra varekontrolleren
    public void deleteItem(Item item){
        repository.remove(item);
    }

    //Oppdaterer en vare fra collection
    public void updateItem(Item item) {repository.save(item);
    }

    public List<Item> itemList() {
        return repository.findAll(Item.class);
    }


}
