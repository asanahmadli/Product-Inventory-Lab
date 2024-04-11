package models;


import services.SneakerService;

import java.awt.*;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.InputMismatchException;
import java.util.Scanner;

public class App  {
    private SneakerService sneakerService = new SneakerService(); // (1)
    Scanner scanner = new Scanner(System.in);
     private Sneaker sneaker = new Sneaker();

    public static void main(String[] args) {

            App application = new App(); // (2)
            application.init();  // (3)



    }//main


    public void init(){
        SneakerService.loadData();
        Console.printWelcome();

        // (4)
        // application logic here
        // call methods to take user input and interface with services
        boolean flag = true;
        while (flag) {
            System.out.println(ColorEnum.CYAN.formatString("📝Main Menu"));
            System.out.print(ColorEnum.BLUE.formatString("➕Create\t"));
            System.out.print(ColorEnum.BLUE.formatString("📖Read\t "));
            System.out.print(ColorEnum.BLUE.formatString("🖌Update\t"));
            System.out.print(ColorEnum.BLUE.formatString("⌦ Delete\t"));
            System.out.print(ColorEnum.BLUE.formatString("🔍Find\t"));
            System.out.println(ColorEnum.BLUE.formatString("❗️Exit\t"));
            String menu  = scanner.next();

            if(menu.equalsIgnoreCase("Create")){
                add();
                try {
                    SneakerService.savaDataToCsv();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            else if(menu.equalsIgnoreCase("Read")){
                System.out.println("Please enter product ID:");
                int id = scanner.nextInt();
                read(id);
            }
            else if(menu.equalsIgnoreCase("Update")){
                System.out.println("Please enter product id");
                int id = scanner.nextInt();
                update(id);

            }
            else if(menu.equalsIgnoreCase("Delete")){
                    System.out.println("Please enter product id");
                    int id = scanner.nextInt();
                    sneaker.delete(id);
            }
            else if(menu.equalsIgnoreCase("Find")){
                System.out.println("Please enter product id");
                int id = scanner.nextInt();
                Sneaker sneaker1 = sneaker.findSneaker(id);
                if(sneaker1!=null){
                    System.out.println(sneaker1.toString());
                }

            }

            else if(menu.equalsIgnoreCase("exit")){
                break;
            }
        }

    }

    /**Create different products to be added to inventory
    Read from existing products
    Update products
    Delete products
    Get different reports about products
    Exit the program*/

    public  void add(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter product name:");
        String name = scanner.nextLine();
        System.out.println("Please enter brand name:");
        String brand = scanner.nextLine();
        System.out.println("Please enter sport name:");
        String sport = scanner.nextLine();
        System.out.println("Please enter product size:");
        float size = scanner.nextFloat();
        System.out.println("Please enter product quantity:");
        int qty = scanner.nextInt();
        System.out.println("Please enter product price:");
        float price = scanner.nextFloat();
        sneaker = SneakerService.create(name,brand,sport,size,qty,price);
        System.out.println("Product created and product ID: " + sneaker.getId());
    }

    public void update(int id){
        for (Sneaker s:SneakerService.getInventory()){
            if(s.getId() == id){
                System.out.println("Please choice valid option");
                System.out.println(ColorEnum.CYAN.formatString("📝Options"));
                System.out.print(ColorEnum.BLUE.formatString("Name\t"));
                System.out.print(ColorEnum.BLUE.formatString("Brand\t "));
                System.out.print(ColorEnum.BLUE.formatString("Sport\t"));
                System.out.print(ColorEnum.BLUE.formatString("Size\t"));
                System.out.println(ColorEnum.BLUE.formatString("Quantity\t"));
                System.out.println(ColorEnum.BLUE.formatString("Price\t"));
                String menu1  = scanner.next();
                if(menu1.equalsIgnoreCase("name")){
                    System.out.println("Please enter new Product name:");
                    String input = scanner.next();
                    s.setName(input);
                    System.out.println("Name updated to: "+s.getName());
                }
                else if(menu1.equalsIgnoreCase("brand")){
                    System.out.println("Please enter new Brand name:");
                    String input = scanner.next();
                    s.setBrand(input);
                    System.out.println("Brand updated to: "+s.getBrand());
                }
                else if(menu1.equalsIgnoreCase("sport")){
                    System.out.println("Please enter new Sport name:");
                    String input = scanner.next();
                    s.setSport(input);
                    System.out.println("Sport name updated to "+s.getSport());
                }
                else if(menu1.equalsIgnoreCase("size")){
                    System.out.println("Please enter new size:");
                    float input = scanner.nextFloat();
                    s.setSize(input);
                    System.out.println("Size updated to "+s.getSize());
                }
                else if(menu1.equalsIgnoreCase("quantity")){
                    System.out.println("Please enter new size:");
                    int input = scanner.nextInt();
                    s.setSize(input);
                    System.out.println("Quantity updated to "+s.getId());

                }
                else if(menu1.equalsIgnoreCase("price")){
                    System.out.println("Please enter new size:");
                    int input = scanner.nextInt();
                    s.setSize(input);
                    System.out.println("Price updated to "+ s.getPrice());
                }

            }
        }

    }

    public void read(int id){
        boolean flag = true;
        for (Sneaker s:SneakerService.getInventory()){
            if(s.getId() == id){
                System.out.println(s.toString());
                flag = false;
                break;
            }
        }
        if(flag) {
            System.out.println(ColorEnum.RED.formatString("Product not found in the inventory!"));
        }
    }




}//class
