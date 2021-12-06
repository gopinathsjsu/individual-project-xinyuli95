package com.company.Handler;

import com.company.SaleClient.Order;
import com.company.DB.ItemsDB;
import com.company.DB.CardsDB;

public class ConcreteHandlerSale implements Handler{
    private Handler successor = null;

    @Override
    public boolean handleRequest(Order request){
        if (sale(request))
        {
            System.out.println("sale success");
            if (successor != null)
            {
                return successor.handleRequest(request);
            }
            else
            {
                return true;
            }
        }

        System.out.println("sale failure");
        return false;
    }

    @Override
    public void setSuccessor(Handler next){
        this.successor = next;
    }

    private boolean sale(Order request){
        ItemsDB theItemsDB = ItemsDB.getInstance();
        double total = request.quantity * theItemsDB.getPrice(request.item);
        request.price = total;

        //CardsDB theCardsDB =  CardsDB.getInstance();
        //theCardsDB.addCard(request.card);

        return true;
    }

}
