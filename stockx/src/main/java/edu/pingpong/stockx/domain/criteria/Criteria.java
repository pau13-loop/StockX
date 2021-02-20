package edu.pingpong.stockx.domain.criteria;

import java.util.List;

import edu.pingpong.stockx.domain.item.Item;
import edu.pingpong.stockx.domain.offer.Offer;

public interface Criteria {

    List<Offer> checkCriteria(Item sneaker); 
}
