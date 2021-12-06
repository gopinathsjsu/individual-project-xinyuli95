package com.company.DB;

import java.util.Map;
import java.util.HashMap;

public class ItemsDB {
    private static ItemsDB instance;

    private Map<String, String> categories;
    private Map<String, Double> prices;
    private Map<String, Integer> quantities;

    private int luxuryCap;
    private int essentialCap;
    private int miscCap;

    private ItemsDB(){
        luxuryCap = 3;
        essentialCap = 5;
        miscCap = 6;

        categories = new HashMap<>();
        prices = new HashMap<>();
        quantities = new HashMap<>();
    }

    public static ItemsDB getInstance() {
        if (instance == null)
        {
            instance = new ItemsDB();
        }
        return instance;
    }

    public String getCategory(String item){
        return categories.get(item);
    }

    public double getPrice(String item){
        return prices.get(item);
    }

    public int getQuantity(String item){
        return quantities.get(item);
    }

    public void setCategory(String item, String category){
        categories.put(item, category);
    }

    public void setPrice(String item, double price){
        prices.put(item, price);
    }

    public void setQuantity(String item, int quantity){
        quantities.put(item, quantity);
    }

    public int getCap(String category){
        int cap = 0;

        if (category.equals("Luxury"))
        {
            cap = luxuryCap;
        }
        else if (category.equals("Essential"))
        {
            cap = essentialCap;
        }
        else if (category.equals("Misc"))
        {
            cap = miscCap;
        }

        return cap;
    }

    public int setCap(String category, int cap){

        if (category.equals("Luxury"))
        {
            luxuryCap = cap;
        }
        else if (category.equals("Essential"))
        {
            essentialCap = cap;
        }
        else if (category.equals("Misc"))
        {
            miscCap = cap;
        }

        return cap;
    }
}
