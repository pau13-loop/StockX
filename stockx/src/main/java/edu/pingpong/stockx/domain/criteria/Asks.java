package edu.pingpong.stockx.domain.criteria;

import java.util.ArrayList;
import java.util.List;

import edu.pingpong.stockx.domain.item.*;
import edu.pingpong.stockx.domain.offer.*;

public class Asks implements Criteria{

    List<Offer> asks = new ArrayList<Offer>();

    public Asks() {}

    @Override
    public List<Offer> checkCriteria(Item sneaker){
        for(Offer sneak : sneaker.offers()){
        if(sneak instanceof Ask){
            asks.add(sneak);
        }
    }
    return asks;
    }
    
}
