package com.lottery.app.lotteryApp.dto;

import org.springframework.stereotype.Component;

@Component
public class LotteryWinnerResponse extends Response {

    private String winReferenceNo;

    public String getWinReferenceNo() {
        return winReferenceNo;
    }

    public void setWinReferenceNo(String winReferenceNo) {
        this.winReferenceNo = winReferenceNo;
    }

    @Override
    public String toString() {
        return "LoteryWinnerResponse{" +
                "winReferenceNo='" + winReferenceNo + '\'' +
                '}';
    }
}
