package com.example.TestProject.service;

import com.example.TestProject.model.Item;

import java.util.List;
import java.util.Optional;

public interface IItemBusinessLogic {

    void addItem(String itemName, String itemDescription);

    void updateItem(Integer id, String itemName, String itemDescription);

    Optional<Item> findItemById(Integer id);

    Optional<Item> deleteItemByItemId(Integer id);

    List<Item> getAllItems();

    void deleteAllItems();
}
