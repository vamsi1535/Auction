package com.auction.model;

public class Bidder {

    private int maximumBid;
    private int increment;
    private int startBid;
    private String bidderName;

    public Bidder(final String sName, final int iStartBid, final int iIncrement, final int iMaximumBid) {
        if ((iMaximumBid >> 31 != 0) || (iIncrement >> 31 != 0) || (iStartBid >> 31 != 0))
            throw new IllegalArgumentException("Negative bids not allowed");
        if ((iMaximumBid - iStartBid) < 0)
            throw new IllegalArgumentException("Maximum Bid should be greater than Start Bid");
        if ((iStartBid + iIncrement) > iMaximumBid || ((iMaximumBid - iStartBid) > 0 && (iIncrement == 0)))
            throw new IllegalArgumentException("Invalid increment Value");

        this.maximumBid = iMaximumBid;
        this.increment = iIncrement;
        this.startBid = iStartBid;
        this.bidderName = sName;
    }

    public Bid getBid(final Bid lastBid) {

        if (lastBid == null)
            throw new IllegalArgumentException("Invalid Bid parameter");

        Bid nextBid = null;
        int currentBid = this.startBid;

        if (this.equals(lastBid.getBidder())) {
            nextBid = lastBid;
        } else if (lastBid.getBidder() == null) {
            nextBid = new Bid(this, this.startBid);
        } else if (this.maximumBid >= lastBid.getAmount()) {
            while (currentBid <= lastBid.getAmount()) {
                currentBid = currentBid + this.increment;
                if (currentBid > this.maximumBid) {
                    currentBid = this.maximumBid;
                    break;
                }
            }
            nextBid = new Bid(this, currentBid);
        }

        return nextBid;
    }

    public String toString() {
        return "Bidder: " + bidderName;
    }

    public int getMaximumBid() {
        return maximumBid;
    }

    public void setMaximumBid(int maximumBid) {
        this.maximumBid = maximumBid;
    }

    public int getIncrement() {
        return increment;
    }

    public void setIncrement(int increment) {
        this.increment = increment;
    }

    public int getStartBid() {
        return startBid;
    }

    public void setStartBid(int startBid) {
        this.startBid = startBid;
    }

    public String getBidderName() {
        return bidderName;
    }

    public void setBidderName(String bidderName) {
        this.bidderName = bidderName;
    }
}




