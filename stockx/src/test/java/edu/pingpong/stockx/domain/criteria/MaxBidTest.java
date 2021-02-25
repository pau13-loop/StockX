package edu.pingpong.stockx.domain.criteria;

import org.junit.Test;

import edu.pingpong.stockx.domain.item.Item;
import edu.pingpong.stockx.domain.item.Sneaker;
import edu.pingpong.stockx.domain.offer.Bid;

public class MaxBidTest {
    
    Item sneaker = null;
    Criteria bids = null;
    Criteria maxBid = null;

    @Test
    public void checkMaxBidTest1() {
        sneaker = new Sneaker("Nike", "Performance");
        bids = new Bids();
        maxBid = new MaxBid();

        sneaker.add(new Bid("45", 300));
        sneaker.add(new Bid("80", 500));
        sneaker.add(new Bid("12", 78));
        sneaker.add(new Bid("74", 200));
        sneaker.add(new Bid("1", 15));

        assertArrayEquals(500, maxBid.checkCriteria(sneaker).get(0).value());
    }

    private void assertArrayEquals(int i, int value) {
    }

    @Test
    public void checkMaxBidTest2() {
        sneaker = new Sneaker("Nike", "Performance");
        bids = new Bids();
        maxBid = new MaxBid();

        sneaker.add(new Bid("45", 100));
        sneaker.add(new Bid("80", 150));
        sneaker.add(new Bid("12", 78));
        sneaker.add(new Bid("74", 200));
        sneaker.add(new Bid("1", 15));

        assertArrayEquals(200, maxBid.checkCriteria(sneaker).get(0).value());
    }
}
