package edu.pingpong.stockx.domain.criteria;

import java.util.ArrayList;
import java.util.List;

import edu.pingpong.stockx.domain.item.*;
import edu.pingpong.stockx.domain.offer.*;

public class MinAsk implements Criteria{
    
    List<Offer> minAsk = new ArrayList<Offer>();

    public MinAsk() {}

    @Override
    public List<Offer> checkCriteria(Item sneaker) {

        Offer ask = sneaker.offers().get(0);

        for(Offer sneak : sneaker.offers()) {
            if(sneak instanceof Ask && sneak.value() < ask.value()){
                    ask = sneak;
                }
            }
    minAsk.add(ask);
    return minAsk;
    }
}
