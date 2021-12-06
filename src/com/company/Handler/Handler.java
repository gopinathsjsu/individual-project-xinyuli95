package com.company.Handler;

import com.company.SaleClient.Order;

public interface Handler {
    boolean handleRequest(Order request);
    void setSuccessor(Handler next);
}
