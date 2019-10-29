package com.example.TestProject.controller;

import com.example.TestProject.model.Item;
import com.example.TestProject.service.ItemBusinessLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(path = "/items")
public class ItemController {


    @Autowired
    private ItemBusinessLogic itemBusinessLogic;

    @RequestMapping(value = "/addItem",method = RequestMethod.POST)
    public ResponseEntity<String> addNewUser(@RequestParam String itemName, @RequestParam String itemDescription) {
        itemBusinessLogic.addItem(itemName, itemDescription);
        return new ResponseEntity<String>("New item " + itemName +" successfully added", HttpStatus.OK);
    }

    @RequestMapping(value = "/allItems", method = RequestMethod.GET)
    public  ResponseEntity<List<Item>> getAllUsers() {
        return new ResponseEntity<List<Item>>(itemBusinessLogic.getAllItems(),HttpStatus.OK);
    }

    @RequestMapping(value = "/udpateItem", method = RequestMethod.PUT)
    public ResponseEntity<String> updateUser(@RequestParam Integer id,@RequestParam String itemName, @RequestParam String itemDescription) {
        itemBusinessLogic.updateItem(id, itemName, itemDescription);
        return new ResponseEntity<String>("Item with id "+ id + " updated successfully", HttpStatus.OK);
    }
}
