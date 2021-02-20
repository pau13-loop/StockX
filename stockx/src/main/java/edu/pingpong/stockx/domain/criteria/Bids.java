package edu.pingpong.stockx.domain.criteria;

import java.util.ArrayList;
import java.util.List;

import edu.pingpong.stockx.domain.item.*;
import edu.pingpong.stockx.domain.offer.*;

public class Bids implements Criteria{
    
    List<Offer> bids = new ArrayList<Offer>();

    public Bids() {}

    @Override
    public List<Offer> checkCriteria(Item sneaker){
        for(Offer sneak : sneaker.offers()){
        if(sneak instanceof Bid){
            bids.add(sneak);
        }
    }
    return bids;
    }
}
