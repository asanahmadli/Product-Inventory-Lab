package models;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

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
        public void constructorTest(){

            // (2)
            int expectedId = 6;
            String expectedName = "Stan Smith";
            String expectedBrand = "Adidas";
            String expectedSport = "Tennnis";
            int expectedQty = 10;
            float expectedPrice = 80.00f;

            // (3)
            Sneaker testSneaker = new Sneaker(expectedId,expectedName,expectedBrand,expectedSport,expectedQty,expectedPrice);

            // (4)
            Assertions.assertEquals(expectedId, testSneaker.getId());
            Assertions.assertEquals(expectedName, testSneaker.getName());
            Assertions.assertEquals(expectedBrand, testSneaker.getBrand());
            Assertions.assertEquals(expectedSport, testSneaker.getSport());
            Assertions.assertEquals(expectedQty, testSneaker.getQty());
            Assertions.assertEquals(expectedPrice, testSneaker.getPrice());
        }
    }

