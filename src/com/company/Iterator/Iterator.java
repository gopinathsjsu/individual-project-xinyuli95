package com.company.Iterator;

import com.company.SaleClient.Order;

public interface Iterator {
    Order first();
    Order next();
    boolean isDone();
    Order currentItem();
}
