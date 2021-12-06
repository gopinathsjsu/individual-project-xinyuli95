package com.company.DB;

import java.util.HashSet;
import java.util.Set;

public class CardsDB {
    private static CardsDB instance;

    private Set<String> cards;

    private CardsDB(){
        cards = new HashSet<>();
    }

    public static CardsDB getInstance() {
        if (instance == null)
        {
            instance = new CardsDB();
        }
        return instance;
    }

    public void addCard(String card){
        cards.add(card);
    }

    public Set<String> getCards(){
        return cards;
    }

}
