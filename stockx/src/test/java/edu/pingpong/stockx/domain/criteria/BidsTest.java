package edu.pingpong.stockx.domain.criteria;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;
import org.junit.Before;
import org.junit.Test;

import edu.pingpong.stockx.domain.item.Item;
import edu.pingpong.stockx.domain.item.Sneaker;
import edu.pingpong.stockx.domain.offer.Ask;
import edu.pingpong.stockx.domain.offer.Bid;
import edu.pingpong.stockx.domain.offer.Offer;
import edu.pingpong.stockx.domain.offer.Sale;

public class BidsTest {

    private Item sneaker;
    private Criteria bids = new Bids();

    @Before
    public void setupBids() {

        sneaker = new Sneaker("Nike", "Performance");

        sneaker.add(new Ask("9.5", 100));
        sneaker.add(new Ask("9.5", 200));
        sneaker.add(new Ask("4", 300));
        sneaker.add(new Sale("3", 400));
        sneaker.add(new Sale("9.5", 500));
        sneaker.add(new Bid("13", 600));
        sneaker.add(new Bid("9.5", 700));
        sneaker.add(new Bid("9.5", 100));
        sneaker.add(new Bid("12", 1100));

    }

    @Test
    public void bidsLengthTest() {
        assertEquals(4, bids.checkCriteria(sneaker).size());
    }

    @Test
    public void allMatchTest() {
        assertTrue(bids.checkCriteria(sneaker).stream().allMatch(b -> b instanceof Bid));
    }

    @Test
    public void getBiggerBid() {
        sneaker.setBid(bids.checkCriteria(sneaker).get(0).value());
        assertEquals(1100, sneaker.getBid());
    }

    @Test
    public void noBidsTest() {
        Item sneaker2 = new Sneaker("Nike", "Spider-Man");
        List<Offer> minimumBid = bids.checkCriteria(sneaker2);
        sneaker2.setBid(minimumBid.isEmpty() ? 0 : minimumBid.get(0).value());
        assertEquals(0, sneaker2.getBid());
    }
}
