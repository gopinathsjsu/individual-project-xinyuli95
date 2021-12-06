package com.company;

import com.company.DB.ItemsDB;
import com.company.DB.CardsDB;
import com.company.FileHelpers.OutputWriter;
import com.company.SaleClient.Order;
import com.company.SaleClient.SaleProcessor;
import com.company.FileHelpers.CSVReader;
import java.io.*;

import java.sql.SQLClientInfoException;
import java.util.ArrayList;


public class Main {

    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
            System.out.println("Please specify input files");
            return;
        }

        String dataPath = args[0];
        String cardsPath = args[1];
        String inputPath = args[2];

        CSVReader reader = new CSVReader();
        ArrayList<Order> orders = reader.readInput(inputPath);
        reader.readDataset(dataPath);
        reader.readCards(cardsPath);

        SaleProcessor processor = new SaleProcessor();
        processor.processSale(orders);

        OutputWriter writer = new OutputWriter();

        if (processor.orderFailures.size() > 0)
        {
            System.out.println("Please correct quantities.");
            writer.writeTXT(processor.orderFailures);
        }
        else
        {
            writer.writeCSV(processor.total);
        }

        //System.out.println(order.item);
        //System.out.println(order.price);
    }
}
