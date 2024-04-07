package models;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import services.SneakerService;

import java.util.ArrayList;
import java.util.List;

public class SneakerTest {
    @Test
    public void setNameTest() {
        Sneaker testSneaker1 = new Sneaker();
        // given (1)
        String expected = "OZWEEGO";

        // when (2)
        testSneaker1 = new Sneaker();
        testSneaker1.setName(expected);

        // then (3)
        Assertions.assertEquals(expected, testSneaker1.getName());
    }


    @Test // (1)
    public void constructorTest() {

        // (2)
        int expectedId = 6;
        String expectedName = "Stan Smith";
        String expectedBrand = "Adidas";
        String expectedSport = "Tennnis";
        int expectedQty = 10;
        float expectedPrice = 80.00f;

        // (3)
        Sneaker testSneaker = new Sneaker(expectedId, expectedName, expectedBrand, expectedSport, expectedQty, expectedPrice);

        // (4)
        Assertions.assertEquals(expectedId, testSneaker.getId());
        Assertions.assertEquals(expectedName, testSneaker.getName());
        Assertions.assertEquals(expectedBrand, testSneaker.getBrand());
        Assertions.assertEquals(expectedSport, testSneaker.getSport());
        Assertions.assertEquals(expectedQty, testSneaker.getQty());
        Assertions.assertEquals(expectedPrice, testSneaker.getPrice());
    }


    @Test
    public void findSneaker() {
       Sneaker sneaker =  SneakerService.create("Jogger", "Adidas", "Run", 10.5f, 1, 115);
        int id = sneaker.getId();
        int expected = 1;
        Assert.assertEquals(expected, id);
    }

    @Test
    public void findAll() {
        Sneaker sneaker = SneakerService.create("Jogger", "Adidas", "Run", 10.5f, 1, 115f);
        String expectedName = "Jogger";
        String expectedBrand = "Adidas";
        String expectedSportName = "Run";
        float expectedSize = 10.5f;
        int expectedQty = 1;
        float expectedPrice = 115f;
        //copy of the inventory list
        Sneaker[] sneakers = SneakerService.getInventory().toArray(new Sneaker[0]);
        Assert.assertEquals(expectedName,sneakers[0].getName());
        Assert.assertEquals(expectedBrand,sneakers[0].getBrand());
        Assert.assertEquals(expectedSportName,sneakers[0].getSport());
        Assert.assertEquals(expectedSize,sneakers[0].getSize(),0.01);
        Assert.assertEquals(expectedQty,sneakers[0].getQty());
        Assert.assertEquals(expectedPrice,sneakers[0].getPrice(),0.01);
    }


}

