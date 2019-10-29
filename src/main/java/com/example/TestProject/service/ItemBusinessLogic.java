package com.example.TestProject.service;

import com.example.TestProject.model.Item;
import com.example.TestProject.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemBusinessLogic implements IItemBusinessLogic {

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public void addItem(String itemName, String itemDescription) {
        Item item = new Item();

        item.setItemName(itemName);
        item.setItemDescription(itemDescription);
        itemRepository.save(item);

    }

    @Override
    public void updateItem(Integer id, String itemName, String itemDescription) {

        Optional<Item> updated = findItemById(id);
        if(updated.isPresent()) {
            Item present = updated.get();
            if(itemName != null) {
                present.setItemName(itemName);
            }
            if(itemDescription != null) {
                present.setItemDescription(itemDescription);
            }

        }

    }

    @Override
    public Optional<Item> findItemById(Integer id) {
        return itemRepository.findById(id);
    }


    @Override
    public Optional<Item> deleteItemByItemId(Integer id) {
        Optional<Item> deleted = findItemById(id);
        deleted.ifPresent(item -> itemRepository.delete(item));
        return deleted;
    }


    @Override
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    @Override
    public void deleteAllItems() {
        itemRepository.deleteAll();
    }
}
