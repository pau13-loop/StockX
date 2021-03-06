package edu.pingpong.stockx.domain.criteria;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import edu.pingpong.stockx.domain.item.Item;
import edu.pingpong.stockx.domain.item.Sneaker;
import edu.pingpong.stockx.domain.offer.Bid;
import edu.pingpong.stockx.domain.offer.Offer;
import edu.pingpong.stockx.domain.offer.Sale;

public class MaxTest {

    Item sneaker;
    Criteria bids;
    Criteria size;
    Criteria max;

    @Test
    public void checkMaxBidTest1() {
        sneaker = new Sneaker("Nike", "Performance");
        bids = new Bids();
        size = new Size("9");
        max = new Max(size, bids);

        sneaker.add(new Bid("9", 300));
        sneaker.add(new Bid("9", 500));
        sneaker.add(new Bid("12", 78));
        sneaker.add(new Bid("9", 200));
        sneaker.add(new Bid("7", 15));
        sneaker.add(new Sale("9", 3000));
        sneaker.add(new Sale("8", 200));
        sneaker.add(new Sale("12", 180));

        List<Offer> sameSize = max.checkCriteria(sneaker);

        // By the same type
        assertTrue(sameSize.stream().allMatch(b -> b instanceof Bid));
        // By the same size
        assertTrue(sameSize.stream().allMatch(b -> b.size().equals("9")));
        // The max between all of the same size
        assertEquals(500, sameSize.get(0).value());
    }

    @Test
    public void nullMaxBidTest() {
        sneaker = new Sneaker("Nike", "Performance");
        bids = new Bids();
        size = new Size("9");
        max = new Max(size, bids);

        List<Offer> sameSize = max.checkCriteria(sneaker);
        assertTrue(sameSize.isEmpty());
    }
}
