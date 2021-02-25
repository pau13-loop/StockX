package edu.pingpong.stockx.domain.criteria;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Comparator;

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

        final Criteria andCriteria = new AndCriteria(this.criteria, this.otheCriteria);

        Comparator<Offer> comparator = Comparator.comparing( Offer::value);

        return andCriteria.checkCriteria(sneaker).stream().max(comparator).stream().collect(Collectors.toList());
    }

    
}
