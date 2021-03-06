package edu.pingpong.stockx.domain.criteria;

import java.util.ArrayList;
import java.util.List;

import edu.pingpong.stockx.domain.item.*;
import edu.pingpong.stockx.domain.offer.*;

public class LastSale implements Criteria{
    
    List<Offer> lastSale = new ArrayList<Offer>();

    @Override
    public List<Offer> checkCriteria(Item sneaker) {
            lastSale.add(sneaker.offers().get(sneaker.offers().size()-1));
            return lastSale;
    }
}
