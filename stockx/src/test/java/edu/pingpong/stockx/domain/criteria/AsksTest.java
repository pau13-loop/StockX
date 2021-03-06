package edu.pingpong.stockx.domain.criteria;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import edu.pingpong.stockx.domain.item.*;
import edu.pingpong.stockx.domain.offer.*;

public class AsksTest {

    private Item sneaker;
    private Criteria asks = new Asks();

    @Before
    public void setupAsks() {

        sneaker = new Sneaker("Nike", "Performance");

        sneaker.add(new Ask("9.5", 100));
        sneaker.add(new Ask("9.5", 200));
        sneaker.add(new Ask("4", 300));
        sneaker.add(new Sale("3", 400));
        sneaker.add(new Sale("9.5", 500));
        sneaker.add(new Bid("13", 600));
        sneaker.add(new Bid("9.5", 700));
    }

    @Test
    public void asksLengthTest() {
        assertEquals(3, asks.checkCriteria(sneaker).size());
    } 

    @Test
    public void allMatchAsksTest() {
        assertTrue(asks.checkCriteria(sneaker)
                        .stream()
                        .allMatch(a -> a instanceof Ask));
    }

    @Test
    public void getBiggerAsk() {
        sneaker.setAsk(asks.checkCriteria(sneaker).get(0).value());
        assertEquals(300, sneaker.getAsk());
    }

    @Test
    public void nullAsksTest() {
        Item sneaker2 = new Sneaker("Nike", "Spider-Man");
        List<Offer> minimumAsk = asks.checkCriteria(sneaker2);
        sneaker2.setAsk(minimumAsk.isEmpty()? 0 : minimumAsk.get(0).value());
        assertEquals(0, sneaker.getAsk());
    }
}
