package edu.pingpong.stockx.domain.offer;

public interface Offer extends Comparable<Offer> {

    String size();

    int value();

    int compareTo(Offer offer);
}
