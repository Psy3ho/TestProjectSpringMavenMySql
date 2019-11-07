package com.example.TestProject.controller;

import com.example.TestProject.model.Item;
import com.example.TestProject.service.item.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "/items")
public class ItemController {


    @Autowired
    private ItemService itemBusinessLogic;

    @PostMapping(value = "/addItem")
    public ResponseEntity<String> addNewUser(@RequestParam String itemName, @RequestParam String itemDescription) {
        itemBusinessLogic.addItem(itemName, itemDescription);
        return new ResponseEntity<>("New item " + itemName +" successfully added", HttpStatus.OK);
    }

    @GetMapping(value = "/allItems")
    public  ResponseEntity<List<Item>> getAllUsers() {
        return new ResponseEntity<>(itemBusinessLogic.getAllItems(),HttpStatus.OK);
    }

    @PutMapping(value = "/udpateItem")
    public ResponseEntity<String> updateUser(@RequestParam Integer id,@RequestParam String itemName, @RequestParam String itemDescription) {
        itemBusinessLogic.updateItem(id, itemName, itemDescription);
        return new ResponseEntity<>("Item with id "+ id + " updated successfully", HttpStatus.OK);

    }

}
