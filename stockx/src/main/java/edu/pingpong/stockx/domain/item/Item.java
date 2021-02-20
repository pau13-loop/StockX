package edu.pingpong.stockx.domain.item;

import java.util.List;

import edu.pingpong.stockx.domain.offer.*;

public interface Item {

    int getBid();

    int getAsk();

    int getSale();

    void add(Offer value);

    List<Offer> offers();

    void setBid(int bid);

    void setAsk(int ask);

    void setSale(int sale);
}
