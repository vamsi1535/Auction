package com.auction.model;

public class BidRequest {
    public String bidderName;
    public Integer startingBid;
    public Integer maxBid;
    public Integer autoIncrementAmount;
    public String itemName;

    public BidRequest() {
        super();
        // TODO Auto-generated constructor stub
    }

    public BidRequest(String bidderName, Integer startingBid, Integer maxBid, Integer autoIncrementAmount,
            String itemName) {
        super();
        this.bidderName = bidderName;
        this.startingBid = startingBid;
        this.maxBid = maxBid;
        this.autoIncrementAmount = autoIncrementAmount;
        this.itemName = itemName;
    }

    public String getBidderName() {
        return bidderName;
    }

    public void setBidderName(String bidderName) {
        this.bidderName = bidderName;
    }

    public Integer getStartingBid() {
        return startingBid;
    }

    public void setStartingBid(Integer startingBid) {
        this.startingBid = startingBid;
    }

    public Integer getMaxBid() {
        return maxBid;
    }

    public void setMaxBid(Integer maxBid) {
        this.maxBid = maxBid;
    }

    public Integer getAutoIncrementAmount() {
        return autoIncrementAmount;
    }

    public void setAutoIncrementAmount(Integer autoIncrementAmount) {
        this.autoIncrementAmount = autoIncrementAmount;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

}
