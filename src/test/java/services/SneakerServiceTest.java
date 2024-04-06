package services;

import models.Sneaker;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class SneakerServiceTest {
        @Test
        public void createTest(){

            // (1)
            String expectedName = "Stan Smith";
            String expectedBrand = "Adidas";
            String expectedSport = "Tennis";
            float expectedSize =  10.5f;
            int expectedQty = 10;
            float expectedPrice = 80.00f;

            // (2)
            SneakerService sneakerService = new SneakerService();
            Sneaker testSneaker = SneakerService.create(expectedName, expectedBrand,
                    expectedSport, expectedSize, expectedQty, expectedPrice);

            // (3)
            int actualId = testSneaker.getId();
            String actualName = testSneaker.getName();
            String actualBrand = testSneaker.getBrand();
            String actualSport = testSneaker.getSport();
            float actualSize = testSneaker.getSize();
            int actualQty = testSneaker.getQty();
            float actualPrice = testSneaker.getPrice();

            // (4)
            Assertions.assertEquals(Integer.class.getName(), new Integer(actualId).getClass().getName());
            Assertions.assertEquals(expectedName, actualName);
            Assertions.assertEquals(expectedBrand, actualBrand);
            Assertions.assertEquals(expectedSport, actualSport);
            Assertions.assertEquals(expectedSize, actualSize);
            Assertions.assertEquals(expectedQty, actualQty);
            Assertions.assertEquals(expectedPrice, actualPrice);

        }
    }

