package edu.pingpong.stockx.domain.criteria;

import java.util.ArrayList;
import java.util.List;

import edu.pingpong.stockx.domain.item.*;
import edu.pingpong.stockx.domain.offer.*;

public class Sales implements Criteria{

    List<Offer> sales = new ArrayList<Offer>();

    public Sales() {}

    @Override
    public List<Offer> checkCriteria(Item sneaker){
        for(Offer sneak : sneaker.offers()){
        if(sneak instanceof Sale){
            sales.add(sneak);
        }
    }
    return sales;
    }
}
