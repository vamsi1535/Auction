package com.auction.model;

public class Bid implements Comparable<Bid> {

    private final Bidder bidder;

    private final int amount;

    public Bid(final Bidder defaultBidder, final int amount) {
        if (amount >> 31 != 0)
            throw new IllegalArgumentException("Negative bids not allowed");
        this.bidder = defaultBidder;
        this.amount = amount;
    }

    public Bidder getBidder() {
        return this.bidder;
    }

    public int getAmount() {
        return this.amount;
    }

    public int compareTo(final Bid bid) {
        final Integer bid1 = this.getAmount();
        final Integer bid2 = bid.getAmount();
        return bid1.compareTo(bid2);
    }

    public String toString() {
        return "$" + this.getAmount() + " by " + this.getBidder();
    }
}