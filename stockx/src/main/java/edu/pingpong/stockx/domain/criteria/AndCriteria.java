package edu.pingpong.stockx.domain.criteria;

import java.util.List;
import java.util.ArrayList;

import edu.pingpong.stockx.domain.item.Item;
import edu.pingpong.stockx.domain.offer.Offer;

public class AndCriteria implements Criteria {

    private Criteria criteria = null;
    private Criteria otheCriteria = null;

    public AndCriteria(Criteria criteria, Criteria otheCriteria) {
        this.criteria = criteria;
        this.otheCriteria = otheCriteria;
    }

    @Override
    public List<Offer> checkCriteria(Item sneaker){

        List<Offer> criteriaList = this.criteria.checkCriteria(sneaker);
        List<Offer> otherCriteriaList = this.otheCriteria.checkCriteria(sneaker);
        List<Offer> finalCriteriaList = new ArrayList<Offer>();

        for(Offer element : criteriaList) {
            if(otherCriteriaList.contains(element)) {
                finalCriteriaList.add(element);
            }
        }
        return finalCriteriaList;
    }
    
}
