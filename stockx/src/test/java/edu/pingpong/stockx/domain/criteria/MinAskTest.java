package edu.pingpong.stockx.domain.criteria;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import edu.pingpong.stockx.domain.item.Item;
import edu.pingpong.stockx.domain.item.Sneaker;
import edu.pingpong.stockx.domain.offer.Ask;
import edu.pingpong.stockx.domain.offer.Offer;
import edu.pingpong.stockx.domain.offer.Sale;

public class MinAskTest {
    
    Item sneaker = null;
    Criteria asks = null;
    Criteria minAsk = null;

    @Test
    public void checkMinAskTest1() {
        sneaker = new Sneaker("Nike", "Performance");
        asks = new Asks();
        minAsk = new MinAsk();

        sneaker.add(new Ask("12", 300));
        sneaker.add(new Ask("8", 500));
        sneaker.add(new Ask("12", 78));
        sneaker.add(new Ask("9", 200));
        sneaker.add(new Ask("7", 15));
        sneaker.add(new Sale("10", 100));
        sneaker.add(new Sale("9", 500));
        sneaker.add(new Sale("8", 200));

        assertEquals(15, minAsk.checkCriteria(sneaker).get(0).value());
    }

    @Test
    public void noMinAskTest() {
        sneaker = new Sneaker("Nike", "Performance");
        asks = new Asks();
        minAsk = new MinAsk();
        List<Offer> minA = minAsk.checkCriteria(sneaker);
        sneaker.setAsk(minA.isEmpty()? 0 : minA.get(0).value());

        assertEquals(0, sneaker.getAsk());
    }
}
