package edu.pingpong.stockx.domain.criteria;

import java.util.List;
import java.util.Optional;

import edu.pingpong.stockx.domain.item.Item;
import edu.pingpong.stockx.domain.offer.Offer;

public class Max implements Criteria{

    private Criteria criteria = null;
    private Criteria otheCriteria = null;


    public Max(Criteria criteria, Criteria otheCriteria) {
        this.criteria = criteria; 
        this.otheCriteria = otheCriteria; 
    }

    @Override
    public List<Offer> checkCriteria(Item sneaker){

        Criteria andCriteria = new AndCriteria(this.criteria, this.otheCriteria);

        Optional<Offer> max = andCriteria.checkCriteria(sneaker)
                                                .stream()
                                                .max(Offer::compareTo);

        return max.isPresent()? List.of(max.get()) : List.of();
    }
}
