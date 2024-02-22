package com.auction;

import org.junit.Test;

import com.auction.model.Bid;
import com.auction.model.Bidder;

import static org.junit.Assert.*;

public class BidderTest {

    @Test
    public void testGetBid() {

        Bidder bidder1 = new Bidder("Linda", 170, 3, 240);
        Bidder bidder2 = new Bidder("Dave", 160, 7, 243);

        Bid bid = bidder2.getBid(new Bid(bidder1, 5));

        assertEquals(bid.getBidder(), bidder2);
        assertEquals(160, bid.getAmount());
    }
}