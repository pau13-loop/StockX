package edu.pingpong.stockx.domain.criteria;

import java.util.ArrayList;
import java.util.List;

import edu.pingpong.stockx.domain.item.*;
import edu.pingpong.stockx.domain.offer.*;

public class LastSale implements Criteria{
    
    List<Offer> lastSale = new ArrayList<Offer>();

    public LastSale() {}

    @Override
    public List<Offer> checkCriteria(Item sneaker) {

        int i = sneaker.offers().size();

            lastSale.add(sneaker.offers().get(i-1));
            return lastSale;
    }
}
