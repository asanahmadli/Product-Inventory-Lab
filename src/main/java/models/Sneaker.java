package models;

import services.SneakerService;

import java.util.Arrays;

public class Sneaker {
    private int id;
    private String name;
    private String brand;
    private String sport;
    private float size;
    private int qty;
    private float price;
    SneakerService sneakerService = new SneakerService();

    public Sneaker(){

    }


    public Sneaker(int id, String name, String brand, String sport, float size, int qty, float price) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.sport = sport;
        this.size = size;
        this.qty = qty;
        this.price = price;
    }

    public Sneaker(int id, String name, String brand, String sport, int qty, float price) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.sport = sport;
        this.qty = qty;
        this.price = price;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    public float getSize() {
        return size;
    }

    public void setSize(float size) {
        this.size = size;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    //read
    public Sneaker findSneaker(int id) {
        // should take an int and return an object with that id, if exists
        return sneakerService.getInventory().get(id);
    }

    //read all
    public Sneaker[] findAll() {
        // should return a basic array copy of the ArrayList
        return sneakerService.getInventory().toArray(new Sneaker[0]);
    }

    //delete
    public boolean delete(int id) {
        // should remove the object with this id from the ArrayList if exits and return true.
        // Otherwise return false
        sneakerService.getInventory().remove(id);
        return sneakerService.getInventory().contains(id)?true:false;
    }


}
