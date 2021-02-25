package edu.pingpong.stockx.domain.criteria;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import edu.pingpong.stockx.domain.item.*;
import edu.pingpong.stockx.domain.offer.*;

public class MinAsk implements Criteria{
    
    List<Offer> minAsk = new ArrayList<Offer>();

    @Override
    public List<Offer> checkCriteria(Item sneaker) {

        Comparator<Offer> comparator = Comparator.comparing( Offer::value);

        return sneaker.offers().stream().filter(a -> a instanceof Ask).min(comparator).stream().collect(Collectors.toList());
    }
}
