package com.company.SaleClient;

import java.util.ArrayList;

import com.company.Handler.ConcreteHandlerQuantity;
import com.company.Handler.ConcreteHandlerLimit;
import com.company.Handler.ConcreteHandlerSale;
import com.company.Handler.Handler;
import com.company.Iterator.ConcreteAggregate;
import com.company.Iterator.ConcreteIterator;
import com.company.Iterator.Iterator;
import com.company.Iterator.Aggregate;
import com.company.DB.CardsDB;

import com.company.SaleClient.Order;

public class SaleProcessor {

    public double total = 0.00;
    public ArrayList<Order> orderFailures = new ArrayList<>();

    public void processSale(ArrayList<Order> orders){

        Handler quantityHandler = new ConcreteHandlerQuantity();
        Handler limitHandler = new ConcreteHandlerLimit();
        Handler saleHandler = new ConcreteHandlerSale();

        quantityHandler.setSuccessor(limitHandler);
        limitHandler.setSuccessor(saleHandler);

        Aggregate resultSet = new ConcreteAggregate();
        resultSet.fetchData(orders);

        Iterator iter = resultSet.createIterator();

        CardsDB theCardsDB = CardsDB.getInstance();

        while (!iter.isDone())
        {
            Order curr = iter.currentItem();

            System.out.println(curr.item);

            theCardsDB.addCard(curr.card);

            if (quantityHandler.handleRequest(curr))
            {
                total += curr.price;
            }
            else
            {
                orderFailures.add(curr);
            }

            iter.next();
        }

    }
}
