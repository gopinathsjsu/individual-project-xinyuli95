package com.company.Iterator;

import java.util.ArrayList;
import com.company.SaleClient.Order;

public class ConcreteIterator implements Iterator{
    private ArrayList<Order> orders;
    private int cursor;
    private int max;

    public ConcreteIterator(){
        orders = new ArrayList<>();
        cursor = 0;
        max = 0;
    }

    public ConcreteIterator(ArrayList<Order> o){
        orders = o;
        cursor = 0;
        max = o.size();
    }

    public Order first(){
        return orders.get(0);
    }

    public Order next(){
        cursor++;
        if (!isDone())
        {
            return orders.get(cursor);
        }
        else
        {
            return null;
        }
    }

    public Order currentItem(){
        return orders.get(cursor);
    }

    public boolean isDone(){
        return (cursor==max);
    }

}
