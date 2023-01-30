package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class DataBaseTest {
    DataBase dataBase = new DataBase();
    Card card1 = new Card();
    Card card2 = new Card();
    Card card3 = new Card();

    @BeforeEach
    void setUp() {
        dataBase.add(card1);
        dataBase.add(card2);
        dataBase.add(card3);
    }

    @AfterEach
    void tearDown() {
        dataBase.clear();
    }

    @Test
    void size() {
        Assertions.assertEquals(3, dataBase.size(), "Check size");
    }

    @Test
    void isEmpty() {
        Assertions.assertFalse(false);
    }

    @Test
    void add() {
        dataBase.add(new Card());
        Assertions.assertEquals(4,dataBase.size(),"Check Add");
    }

    @Test
    void remove() {
        dataBase.remove(card3);
        Assertions.assertEquals(2, dataBase.size(), "Check remove");
    }

    @Test
    void removeExeption() {
        assertThrows(NoSuchElementException.class, () -> dataBase.remove(new Card()), "Remove with Exception");
    }

    @Test
    void clear() {
        dataBase.clear();
        Assertions.assertEquals(0, dataBase.size(), "Check clear");
    }

    @Test
    void getDataBaseCard() {
    }
}