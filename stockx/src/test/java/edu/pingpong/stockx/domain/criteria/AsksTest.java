package edu.pingpong.stockx.domain.criteria;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import edu.pingpong.stockx.domain.item.*;
import edu.pingpong.stockx.domain.offer.*;

public class AsksTest {

    private Item sneaker = null;
    private Criteria asks = null;

    @Test
    public void AsksCheck() {

        sneaker = new Sneaker("Nike", "Performance");
        asks = new Asks();

        Ask bid1 = new Ask("15", 2);
        Ask bid2 = new Ask("45", 6);
        Sale sale1 = new Sale("45", 3);

        sneaker.add(bid1);
        sneaker.add(bid2);
        sneaker.add(sale1);

        assertEquals(2, asks.checkCriteria(sneaker).size());
    } 

    @Test
    public void checkBidsNull() {

        sneaker = new Sneaker("Nike", "Performance");
        asks = new Asks();

        Bid bid1 = new Bid("15", 2);
        Bid bid2 = new Bid("45", 6);
        Sale sale1 = new Sale("45", 3);

        sneaker.add(bid1);
        sneaker.add(bid2);
        sneaker.add(sale1);

        assertEquals(0, asks.checkCriteria(sneaker).size());
    } 
    
}
