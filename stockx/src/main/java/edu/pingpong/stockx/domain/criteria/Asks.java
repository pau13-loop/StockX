package edu.pingpong.stockx.domain.criteria;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import edu.pingpong.stockx.domain.item.*;
import edu.pingpong.stockx.domain.offer.*;

public class Asks implements Criteria{

    @Override
    public List<Offer> checkCriteria(Item sneaker){
        return sneaker.offers().stream()
                        .filter(s -> s instanceof Ask)
                        .sorted(Comparator.reverseOrder())
                        .collect(Collectors.toList());
    }
}
