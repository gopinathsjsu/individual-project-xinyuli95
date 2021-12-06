package com.company.Iterator;

import com.company.SaleClient.Order;
import java.util.ArrayList;

public class ConcreteAggregate implements Aggregate{
    private ArrayList<Order> results = new ArrayList<>();

    @Override
    public void fetchData(ArrayList<Order> r){
        results = r;
    }

    @Override
    public ConcreteIterator createIterator(){
        return new ConcreteIterator(results);
    }
}
