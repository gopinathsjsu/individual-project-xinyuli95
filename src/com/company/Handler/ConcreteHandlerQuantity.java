package com.company.Handler;

import com.company.SaleClient.Order;
import com.company.DB.ItemsDB;

public class ConcreteHandlerQuantity implements Handler{
    private Handler successor = null;

    @Override
    public boolean handleRequest(Order request){
        if (checkQuantity(request))
        {
            System.out.println("valid quantity");
            if (successor != null)
            {
                return successor.handleRequest(request);
            }
            else
            {
                return true;
            }
        }

        System.out.println("invalid quantity");
        return false;
    }

    @Override
    public void setSuccessor(Handler next){
        this.successor = next;
    }

    private boolean checkQuantity(Order request){
        ItemsDB theItemsDB = ItemsDB.getInstance();
        return request.quantity <= theItemsDB.getQuantity(request.item);
    }

}
