package com.example.s3840234.model;

public class Item {

    public Item(){

    }

    public Item(Integer id, String name, String desc, double price){
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.price = price;

    }

    private Integer id;
    private String name;
    private String desc;
    private double price;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString(){
        return "item{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                ", price='" + price +
                '}';
    }

}
