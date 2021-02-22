package edu.pingpong.stockx.domain.criteria;

import java.util.List;
import java.util.stream.Collectors;

import edu.pingpong.stockx.domain.item.*;
import edu.pingpong.stockx.domain.offer.*;

public class Bids implements Criteria{
    public Bids() {}

    @Override
    public List<Offer> checkCriteria(Item sneaker){
        return sneaker.offers().stream()
                        .filter(s -> s instanceof Bid)
                        .collect(Collectors.toList());
    }
}
