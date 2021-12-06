package com.company.FileHelpers;

import com.company.SaleClient.Order;
import com.company.DB.ItemsDB;
import com.company.DB.CardsDB;

import java.util.ArrayList;
import java.util.Arrays;
import java.io.*;

public class CSVReader {

    private ArrayList<ArrayList<String>> read(String path) throws IOException {
        ArrayList<ArrayList<String>> records = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(path));
        String line;
        while ((line = br.readLine()) != null) {
            String[] values = line.split(",");
            records.add(new ArrayList<>(Arrays.asList(values)));
        }
        return records;
    }

    public ArrayList<Order> readInput(String path) throws IOException {
        ArrayList<Order> orders = new ArrayList<>();

        ArrayList<ArrayList<String>> records = read(path);

        for (ArrayList<String> record:records)
        {
            String item = record.get(0);
            String quantity = record.get(1);
            String card = record.get(2);

            if (item.equals("Item") && quantity.equals("Quantity") && card.equals("Card number") )
            {
                continue;
            }

            Order order = new Order();
            order.item = item;
            order.quantity = Integer.parseInt(quantity);
            order.card = card;

            orders.add(order);
        }

        return orders;
    }

    public void readDataset(String path) throws IOException {
        ItemsDB theItemsDB = ItemsDB.getInstance();

        ArrayList<ArrayList<String>> records = read(path);

        for (ArrayList<String> record: records)
        {
            String category = record.get(0);
            String item = record.get(1);
            String quantity = record.get(2);
            String price = record.get(3);

            if (category.equals("Category") && item.equals("Item") && quantity.equals("Quantity") && price.equals("Price/ Piece") )
            {
                continue;
            }

            theItemsDB.setCategory(item, category);
            theItemsDB.setPrice(item, Double.parseDouble(price));
            theItemsDB.setQuantity(item, Integer.parseInt(quantity));
        }

    }

    public void readCards(String path) throws IOException {
        CardsDB theCardsDB = CardsDB.getInstance();

        ArrayList<ArrayList<String>> records = read(path);

        for (ArrayList<String> record: records)
        {
            String card = record.get(0);

            if (card.equals("CardNumber"))
            {
                continue;
            }

            theCardsDB.addCard(card);
        }

    }
}
