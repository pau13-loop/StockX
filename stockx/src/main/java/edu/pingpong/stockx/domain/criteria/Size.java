package edu.pingpong.stockx.domain.criteria;

import java.util.List;
import java.util.stream.Collectors;

import edu.pingpong.stockx.domain.item.*;
import edu.pingpong.stockx.domain.offer.*;

public class Size implements Criteria{

    private String size = null;

    public Size(String size) {
        this.size = size;
    }

    @Override
    public List<Offer> checkCriteria(Item sneaker){
        return sneaker.offers().stream()
                                .filter(s -> s instanceof Sale)
                                .collect(Collectors.toList())
                                .stream()
                                .filter(s -> s.size().equals(this.size)).collect(Collectors.toList());
    }
}

