package com.auction.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.auction.model.Bid;
import com.auction.model.BidRequest;
import com.auction.model.BidResult;
import com.auction.service.AuctionService;

@RestController
@RequestMapping("/auction")
public class AuctionController {
    
    @ResponseBody
    @PostMapping("/bid")
    public String updateBid(@RequestBody BidRequest bidRequest, Model model) {

        AuctionService.populate(bidRequest);
        return "bid posted successfully";
    }

    @ResponseBody
    @GetMapping("/winningBid")
    public ResponseEntity<BidResult> getWinningBid(@RequestParam String itemName, Model model) {
        Bid result = AuctionService.process(AuctionService.getBidMap().get(itemName), null);
        if (result == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        BidResult bidResult = new BidResult(result.getBidder().getBidderName(), result.getAmount(), itemName);
        return new ResponseEntity<BidResult>(bidResult, HttpStatus.OK);
    }
}
