package edu.pingpong.stockx.domain.criteria;

import java.util.List;
import java.util.Optional;

import edu.pingpong.stockx.domain.item.Item;
import edu.pingpong.stockx.domain.offer.Offer;

public class Min implements Criteria{
    
    private Criteria criteria = null;
    private Criteria otheCriteria = null;


    public Min(Criteria criteria, Criteria otheCriteria) {
        this.criteria = criteria; 
        this.otheCriteria = otheCriteria; 
    }

    @Override
    public List<Offer> checkCriteria(Item sneaker){

        Criteria andCriteria = new AndCriteria(this.criteria, this.otheCriteria);

        Optional<Offer> min = andCriteria.checkCriteria(sneaker).stream().min(Offer::compareTo);

        return min.isPresent()? List.of(min.get()) : List.of();
    }
}
