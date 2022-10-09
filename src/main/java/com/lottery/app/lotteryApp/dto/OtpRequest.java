package com.lottery.app.lotteryApp.dto;

public class OtpRequest {

    private String mobileNo;
    private String trackingNo;
    private Double amount;

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getTrackingNo() {
        return trackingNo;
    }

    public void setTrackingNo(String trackingNo) {
        this.trackingNo = trackingNo;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "OtpRequest{" +
                "mobileNo='" + mobileNo + '\'' +
                ", trackingNo='" + trackingNo + '\'' +
                ", amount=" + amount +
                '}';
    }
}
