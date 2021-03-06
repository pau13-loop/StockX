package edu.pingpong.stockx.domain.criteria;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import edu.pingpong.stockx.domain.item.Item;
import edu.pingpong.stockx.domain.item.Sneaker;
import edu.pingpong.stockx.domain.offer.Ask;
import edu.pingpong.stockx.domain.offer.Bid;
import edu.pingpong.stockx.domain.offer.Sale;

public class AndCriteriaTest {

    private Item sneaker;
    private Criteria size;
    private Criteria sales;
    private Criteria bids;
    private Criteria asks;

    @Before
    public void setupAndCriteria() {

        sneaker = new Sneaker("Nike", "Performance");
        size = new Size("9.5");
        sales = new Sales();
        bids = new Bids();
        asks = new Asks();

        sneaker.add(new Sale("9.5", 750));
        sneaker.add(new Sale("10", 100));
        sneaker.add(new Sale("9.5", 200));
        sneaker.add(new Sale("8", 300));
        sneaker.add(new Sale("9.5", 400));
        sneaker.add(new Sale("9.5", 500));
        sneaker.add(new Bid("13", 300));
        sneaker.add(new Bid("7", 700));
        sneaker.add(new Bid("9.5", 900));
        sneaker.add(new Ask("9.5", 600));
        sneaker.add(new Ask("9.5", 150));
        sneaker.add(new Ask("5", 500));
    }

    @Test
    public void sizeLengthTest() {
        assertEquals(7, size.checkCriteria(sneaker).size());
    }

    @Test
    public void salesLengthTest() {
        assertEquals(6, sales.checkCriteria(sneaker).size());

        Criteria salesSize = new AndCriteria(size, sales);

        assertEquals(4, salesSize.checkCriteria(sneaker).size());
    }

    @Test
    public void bidsLengthTest() {
        assertEquals(3, bids.checkCriteria(sneaker).size());

        Criteria bidsSize = new AndCriteria(size, bids);

        assertEquals(1, bidsSize.checkCriteria(sneaker).size());
    }

    @Test
    public void asksLengthTest() {
        assertEquals(3, asks.checkCriteria(sneaker).size());

        Criteria asksSize = new AndCriteria(size, asks);

        assertEquals(2, asksSize.checkCriteria(sneaker).size());
    }

    @Test
    public void firstAndLastSaleElementTest() {
        Criteria andCriteria = new AndCriteria(size, sales);

        assertEquals(750, andCriteria.checkCriteria(sneaker).get(0).value());
        assertEquals(500,
                andCriteria.checkCriteria(sneaker).get(andCriteria.checkCriteria(sneaker).size() - 1).value());
    }

    @Test
    public void allElementsMatchTest() {
        Criteria andCriteriaSales = new AndCriteria(size, sales);

        assertTrue(andCriteriaSales.checkCriteria(sneaker)
                                    .stream()
                                    .allMatch(s -> s.size()
                                    .equals("9.5")));

        assertTrue(andCriteriaSales.checkCriteria(sneaker)
                                    .stream()
                                    .allMatch(s -> s instanceof Sale));
    }
}
