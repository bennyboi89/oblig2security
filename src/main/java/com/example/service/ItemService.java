package com.example.service;

import com.example.model.Item;

import java.util.List;

/**
 * Created by benny on 21.10.15.
 */
public interface ItemService {

    /**
     * Returns all guests registered at the hotel
     * @return guests list
     */
    List<Item> itemList();



    /**
     * Registers a new guest
     * @param newItem
     */
    void insertNewItem(Item newItem);

    void updateItem(Item updateItem);

    void deleteItem(Item deleteItem);
}
