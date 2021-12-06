package com.company.Handler;

import com.company.SaleClient.Order;
import com.company.DB.ItemsDB;

public class ConcreteHandlerLimit implements Handler{
    private Handler successor = null;

    @Override
    public boolean handleRequest(Order request){
        if (checkCap(request))
        {
            System.out.println("valid cap");
            if (successor != null)
            {
                return successor.handleRequest(request);
            }
            else
            {
                return true;
            }
        }

        System.out.println("invalid cap");
        return false;
    }

    @Override
    public void setSuccessor(Handler next){
        this.successor = next;
    }

    private boolean checkCap(Order request){
        ItemsDB theItemsDB = ItemsDB.getInstance();
        String category = theItemsDB.getCategory(request.item);
        int currCap = theItemsDB.getCap(category);

        if (request.quantity <= currCap)
        {
            theItemsDB.setCap(category,currCap - request.quantity);

            return true;
        }

        return false;
    }

}
