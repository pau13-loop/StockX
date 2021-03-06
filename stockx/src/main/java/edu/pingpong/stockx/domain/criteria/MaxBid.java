package edu.pingpong.stockx.domain.criteria;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import edu.pingpong.stockx.domain.item.*;
import edu.pingpong.stockx.domain.offer.*;

public class MaxBid implements Criteria{

    @Override
    public List<Offer> checkCriteria(Item sneaker) {
    
    Comparator<Offer> comparator = Comparator.comparing(Offer::value);

    return sneaker.offers().stream().filter(b -> b instanceof Bid).max(comparator).stream().collect(Collectors.toList());
    }
}
