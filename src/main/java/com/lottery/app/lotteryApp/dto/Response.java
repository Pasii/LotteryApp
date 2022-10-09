package com.lottery.app.lotteryApp.dto;

import org.springframework.stereotype.Component;

@Component
public class Response {

    private int resultCode;
    private String resultDescription;

    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultDescription() {
        return resultDescription;
    }

    public void setResultDescription(String resultDescription) {
        this.resultDescription = resultDescription;
    }

    @Override
    public String toString() {
        return "Response{" +
                "resultCode=" + resultCode +
                ", resultDescription='" + resultDescription + '\'' +
                '}';
    }
}
