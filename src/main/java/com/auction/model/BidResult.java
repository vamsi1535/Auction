package com.auction.model;

/**
 * Represents a bid.
 */
public class BidResult {
    private String bidderName;
    private Integer bidAmount;
    private String itemName;

    
    public BidResult(String bidderName, Integer bidAmount, String itemName) {
        super();
        this.bidderName = bidderName;
        this.bidAmount = bidAmount;
        this.itemName = itemName;
    }

    public String getBidderName() {
        return bidderName;
    }

    public void setBidderName(String bidderName) {
        this.bidderName = bidderName;
    }

    public Integer getBidAmount() {
        return bidAmount;
    }

    public void setBidAmount(Integer bidAmount) {
        this.bidAmount = bidAmount;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

}
