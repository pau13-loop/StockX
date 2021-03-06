package edu.pingpong.stockx.domain.criteria;

import java.util.List;

import edu.pingpong.stockx.domain.item.*;
import edu.pingpong.stockx.domain.offer.*;

public class LastSale implements Criteria{

    @Override
    public List<Offer> checkCriteria(Item sneaker) {
        Criteria sales = new Sales();
        List<Offer> salesList = sales.checkCriteria(sneaker);

        return salesList.isEmpty()? List.of() : List.of(salesList.get(salesList.size()-1));
    }
}
