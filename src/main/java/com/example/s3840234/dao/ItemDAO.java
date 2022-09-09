package com.example.s3840234.dao;


import com.example.s3840234.model.Item;
import com.example.s3840234.model.Items;
import org.springframework.stereotype.Repository;

@Repository
public class ItemDAO {
    private static Items list = new Items();

    static
    {
        list.getItemList().add(new Item(1, "Pizza", "Food", 30.0));
        list.getItemList().add(new Item(2, "Can", "Metal", 12.0));
        list.getItemList().add(new Item(3, "Chocolate", "Food",90.50));
        list.getItemList().add(new Item(4, "Pie", "Food",8.50));
        list.getItemList().add(new Item(5, "Chocolate Frog", "Food",6.20));
    }

    public Item getItem(int id){

        return list.getItemList().get(id);
    }

    public boolean deleteItem(int id){
        try{
            list.getItemList().remove(id);

            return true;
        }catch(IndexOutOfBoundsException e){
            return false;
        }


    }

    public Item update(int id, Item item){
        return null;
    }

    public Items getAllItems()
    {
        return list;
    }

    public void addItems(Item item) {
        list.getItemList().add(item);
    }
}
