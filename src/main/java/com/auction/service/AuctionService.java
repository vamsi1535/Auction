package com.auction.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.auction.model.Bid;
import com.auction.model.BidRequest;
import com.auction.model.Bidder;

public class AuctionService {
    private static HashMap<String, ArrayList<Bidder>> bidMap = new HashMap<String, ArrayList<Bidder>>();

    public static ArrayList<Bidder> getBidders(String itemName) {
        ArrayList<Bidder> bidders = bidMap.get(itemName);
        if (bidders == null) {
            bidders = new ArrayList<Bidder>();
            bidMap.put(itemName, bidders);
        }
        return bidders;
    }

    public static void populate(BidRequest bidRequest) {

        Bidder bidder = new Bidder(bidRequest.getBidderName(), bidRequest.getStartingBid(),
                bidRequest.getAutoIncrementAmount(), bidRequest.getMaxBid());
        ArrayList<Bidder> bidders = getBidders(bidRequest.getItemName());
        bidders.add(bidder);
    }

    public static Bid process(ArrayList<Bidder> bidders, Bid baseBid) {
        try {
            if (bidders == null)
                throw new IllegalArgumentException("Invalid Bidders");
            if (baseBid == null)
                baseBid = new Bid(null, 0);

            boolean validBids = false;
            for (Bidder bidder : bidders) {
                Bid bid = bidder.getBid(baseBid);
                if (bid == null)
                    continue;
                if (bid.compareTo(baseBid) > 0) {
                    baseBid = bid;
                    validBids = true;
                }

                if (bid.compareTo(baseBid) == 0 && baseBid.getBidder() != null) {
                    if (bidders.indexOf(bid.getBidder()) < bidders.indexOf(baseBid.getBidder()))
                        baseBid = bid;
                }
            }

            if (validBids) {
                baseBid = process(bidders, baseBid);
            }
        } catch (Exception e) {
        }
        return baseBid;
    }

    public static HashMap<String, ArrayList<Bidder>> getBidMap() {
        return bidMap;
    }

    public static void setBidMap(HashMap<String, ArrayList<Bidder>> bidMap) {
        AuctionService.bidMap = bidMap;
    }
}
