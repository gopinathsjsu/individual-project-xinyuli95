package com.company.Iterator;

import com.company.SaleClient.Order;

import java.util.ArrayList;

public interface Aggregate {
    Iterator createIterator();
    void fetchData(ArrayList<Order> r);
}
