package edu.pingpong.stockx.domain.item;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import edu.pingpong.stockx.domain.offer.Bid;

public class SneakerTest {
    

    private Sneaker sneaker = null;

    @Before
    public void setupSneaker() {

        sneaker = new Sneaker("555088-105", "Jordan 1 Retro High Dark Mocha");
    }

    @Test
    public void checkSneaker() {

        assertNotNull(sneaker);
    }

    @Test
    public void checkList() {

        Bid bid1 = new Bid("6", 200);
        Bid bid2 = new Bid("7", 300);
        Bid bid3 = new Bid("8", 400);

        sneaker.add(bid1);
        sneaker.add(bid2);
        sneaker.add(bid3);

        assertEquals(3, sneaker.offers().size());
    }

    @Test
    public void cehckToString() {
        assertEquals("Jordan 1 Retro High Dark Mocha\n\t\t555088-105", sneaker.toString());
    }
}
