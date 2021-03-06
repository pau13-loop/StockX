package edu.pingpong.stockx.domain.criteria;

import java.util.List;
import java.util.Optional;

import edu.pingpong.stockx.domain.item.*;
import edu.pingpong.stockx.domain.offer.*;

public class MinAsk implements Criteria{

    @Override
    public List<Offer> checkCriteria(Item sneaker) {

        Optional<Offer> minimum = sneaker.offers()
                                        .stream()
                                        .filter(a -> a instanceof Ask)
                                        .min(Offer::compareTo);
                                    
        return minimum.isPresent()? List.of(minimum.get()) : List.of();
    }
}
