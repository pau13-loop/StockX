package edu.pingpong.stockx.domain.criteria;

import java.util.ArrayList;
import java.util.List;

import edu.pingpong.stockx.domain.item.*;
import edu.pingpong.stockx.domain.offer.*;

public class MaxBid implements Criteria{

    List<Offer> maxBid = new ArrayList<Offer>();

    public MaxBid() {}

    @Override
    public List<Offer> checkCriteria(Item sneaker) {

        Offer bid = new Bid("46", 0);

        for(Offer sneak : sneaker.offers()) {
            if(sneak instanceof Bid && sneak.value() > bid.value()) {
                    bid = sneak;
            }
        }
    maxBid.add(bid);
    return maxBid;
    }
    
}
