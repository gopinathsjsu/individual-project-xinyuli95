package com.company.FileHelpers;

import com.company.SaleClient.Order;

import java.io.*;
import java.text.DecimalFormat;
import java.math.RoundingMode;
import java.util.ArrayList;

public class OutputWriter {

    public void writeCSV(double amount) throws IOException{
        DecimalFormat df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.CEILING);
        String total = String.valueOf(df.format(amount));

        BufferedWriter writer = new BufferedWriter(new FileWriter("Output.csv"));
        writer.write("Amt Paid");
        writer.newLine();
        writer.write(total);

        writer.close();
    }

    public  void writeTXT(ArrayList<Order> failedOrders) throws IOException{
        BufferedWriter writer = new BufferedWriter(new FileWriter("Errors.txt"));
        writer.write("Please correct quantities.");
        writer.newLine();

        for (Order order: failedOrders)
        {
            writer.write("Item: ");
            writer.write(order.item);
            writer.write(" Quantity: ");
            writer.write(String.valueOf(order.quantity));
        }

        writer.close();

    }
}
