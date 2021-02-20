package edu.pingpong.stockx.domain.offer;

public interface Offer {

    String size();

    int value();

    int compareTo(Offer bid);
    
}
