package com.auction;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import com.auction.model.Bid;
import com.auction.model.Bidder;
import com.auction.service.AuctionService;

public class AuctionServiceTest {
    @Test
    public void testProcess() {
        ArrayList<Bidder> bidders = new ArrayList<>();
        Bidder bidder1 = new Bidder("Linda", 170, 3, 240);
        Bidder bidder2 = new Bidder("Dave", 160, 7, 243);
        Bidder bidder3 = new Bidder("Eric", 190, 4, 240);
        bidders.add(bidder1);
        bidders.add(bidder2);
        bidders.add(bidder3);
        Bid winningBid = AuctionService.process(bidders, null);

        assertEquals("Dave", winningBid.getBidder().getBidderName());
        assertEquals(243, winningBid.getAmount());

    }

}
