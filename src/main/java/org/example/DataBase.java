package org.example;

import java.util.ArrayList;
import java.util.List;

public class DataBase {
    private final List<Card> dataBaseCard;

    public DataBase() {
        this.dataBaseCard = new ArrayList<>();
    }
    public int size() {
        return dataBaseCard.size();
    }

    public boolean isEmpty() {
        return dataBaseCard.size() == 0;
    }

    public void add(Card card) {
        dataBaseCard.add(card);
    }

    public void remove(Card card) {
        dataBaseCard.remove(card);
    }

    public void clear() {
        dataBaseCard.clear();
    }

    public List<Card> getDataBaseCard() {
        return dataBaseCard;
    }
}

