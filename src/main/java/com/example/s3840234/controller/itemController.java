package com.example.s3840234.controller;

import com.example.s3840234.dao.ItemDAO;
import com.example.s3840234.model.Item;
import com.example.s3840234.model.Items;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path = "/item")
public class itemController {
    @Autowired
    private ItemDAO itemsDAO;
    private Item item;
//    Get Item List API
    @GetMapping(path="/", produces = "application/json")
    public Items get()
    {
        return itemsDAO.getAllItems();
    }


//    getItemAPI
    @GetMapping("/item{id}")
    public String getItem(@PathVariable String id){
        int number = 0;
        try{
            number = Integer.parseInt(id);
        }
        catch (NumberFormatException ex){
            ex.printStackTrace();
        }

        return itemsDAO.getItem(number+1).toString();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Item> update(@RequestBody Item item, @PathVariable int id) {
        Item updatedItem = itemsDAO.update(id, item);
        if (updatedItem == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(updatedItem);
        }
    }

    @PostMapping(path= "/", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> addItem(
            @RequestHeader(name = "X-COM-PERSIST", required = false) String headerPersist,
            @RequestHeader(name = "X-COM-LOCATION", required = false, defaultValue = "ASIA") String headerLocation,
            @RequestBody Item item)
            throws Exception
    {

        //add resource
        itemsDAO.addItems(item);

        //Create resource location
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(item.getId())
                .toUri();

        //Send location in response
        return ResponseEntity.created(location).build();
    }


//    Delete Item API
    @DeleteMapping("item/item{id}")
    public String deleteItem(@PathVariable String id)
    {
        int number = 0;
        try{
            number = Integer.parseInt(id);
        }
        catch (NumberFormatException ex){
            ex.printStackTrace();
            return "Fail Item does not exist";
        }
        itemsDAO.deleteItem(number);
        return "Success";
    }
}
