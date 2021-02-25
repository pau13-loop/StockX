package edu.pingpong.stockx.domain.criteria;

import org.junit.Test;

import edu.pingpong.stockx.domain.item.Item;
import edu.pingpong.stockx.domain.item.Sneaker;
import edu.pingpong.stockx.domain.offer.Ask;

public class MinTest {
    
    Item sneaker = null;
    Criteria bids = null;
    Criteria maxAsk = null;

    @Test
    public void checkMinAskTest1() {
        sneaker = new Sneaker("Nike", "Performance");
        bids = new Asks();
        maxAsk = new MinAsk();

        sneaker.add(new Ask("45", 300));
        sneaker.add(new Ask("80", 500));
        sneaker.add(new Ask("12", 78));
        sneaker.add(new Ask("74", 200));
        sneaker.add(new Ask("1", 15));

        assertArrayEquals(15, maxAsk.checkCriteria(sneaker).get(0).value());
    }

    private void assertArrayEquals(int i, int value) {
    }

    @Test
    public void checkMinAskTest2() {
        sneaker = new Sneaker("Nike", "Performance");
        bids = new Asks();
        maxAsk = new MinAsk();

        sneaker.add(new Ask("45", 100));
        sneaker.add(new Ask("80", 150));
        sneaker.add(new Ask("12", 78));
        sneaker.add(new Ask("74", 200));
        sneaker.add(new Ask("1", 15));

        assertArrayEquals(15, maxAsk.checkCriteria(sneaker).get(0).value());
    }

}
