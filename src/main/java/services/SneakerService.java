package services;

import models.Sneaker;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SneakerService {

        private static int nextId = 1;  // (1)

        private static List<Sneaker> inventory = new ArrayList<>();  // (2)


        public  static Sneaker create(String name, String brand,String sport,float size,int qty,float price){
            Sneaker createdSneaker =  new Sneaker(nextId,name,brand,sport,size,qty,price);
            inventory.add(createdSneaker);
            try{
                savaDataToCsv();
            }
            catch (IOException e){
                System.out.println(e.getMessage());
            }
            nextId++;
            return createdSneaker;
        }

        public Sneaker find(Sneaker sneaker){
            return inventory.get(nextId);
        }


    public static List<Sneaker> getInventory() {
        return inventory;
    }

    public static int getNextId() {
        return nextId;
    }


    public  static void  savaDataToCsv() throws IOException {
        String csvFile = "/Users/asan/Desktop/Projects/Product-Inventory-Lab/src/main/java/services/Sneaker.csv";
        FileWriter writer = new FileWriter(csvFile,true); //(1)

        CSVUtils.writeLine(writer, new ArrayList<>(Arrays.asList(String.valueOf(nextId))));  // (2)

        for (Sneaker s : inventory) {
            List<String> list = new ArrayList<>(); // (3)
            list.add(String.valueOf(s.getId()));
            list.add(s.getName());
            list.add(s.getBrand());
            list.add(s.getSport());
            list.add(String.valueOf(s.getQty()));
            list.add(String.valueOf(s.getPrice()));
            CSVUtils.writeLine(writer, list);  // (4)
        }

// (5)
        writer.flush();
        writer.close();
    }

    private static void loadData(){
        // (1)
        String csvFile = "/Users/asan/Desktop/Projects/Product-Inventory-Lab/src/main/java/services/Sneaker.csv";
        String line = "";
        String csvSplitBy = ",";

        // (2)
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            if(br.readLine() !=null){
                nextId = Integer.parseInt(br.readLine());  // (3)
                while ((line = br.readLine()) != null) {
                    // split line with comma
                    String[] beer = line.split(csvSplitBy);

                    // (4)
                    int id = Integer.parseInt(beer[0]);
                    String name = beer[1];
                    String brand = beer[2];
                    String sport = beer[3];
                    int qty = Integer.parseInt(beer[4]);
                    float price = Float.parseFloat(beer[5]);

                    // (5)
                    inventory.add(new Sneaker(id, name, brand, sport, qty, price));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
