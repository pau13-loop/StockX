package edu.pingpong.stockx.domain.criteria;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import edu.pingpong.stockx.domain.item.Item;
import edu.pingpong.stockx.domain.item.Sneaker;
import edu.pingpong.stockx.domain.offer.Ask;
import edu.pingpong.stockx.domain.offer.Bid;
import edu.pingpong.stockx.domain.offer.Sale;

public class BidsTest {


    private Item sneaker = null;
    private Criteria bids = null;

    @Test
    public void checkBids() {

        sneaker = new Sneaker("Nike", "Performance");
        bids = new Bids();

        Bid bid1 = new Bid("15", 2);
        Bid bid2 = new Bid("45", 6);
        Sale sale1 = new Sale("45", 3);

        sneaker.add(bid1);
        sneaker.add(bid2);
        sneaker.add(sale1);

        assertEquals(2, bids.checkCriteria(sneaker).size());
    } 

    @Test
    public void checkBidsNull() {

        sneaker = new Sneaker("Nike", "Performance");
        bids = new Bids();

        Ask ask1 = new Ask("15", 2);
        Ask ask2 = new Ask("45", 6);
        Sale sale1 = new Sale("45", 3);

        sneaker.add(ask1);
        sneaker.add(ask2);
        sneaker.add(sale1);

        assertEquals(0, bids.checkCriteria(sneaker).size());
    } 

    
}
