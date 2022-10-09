package com.lottery.app.lotteryApp.model;

public class LotteryDetail {

    private String mobileNo;
    private String trackingNo;
    private Double amount;
    private String otp;

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

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }

    @Override
    public String toString() {
        return "LotteryDetail{" +
                "mobileNo='" + mobileNo + '\'' +
                ", trackingNo='" + trackingNo + '\'' +
                ", amount=" + amount +
                ", otp=" + otp +
                '}';
    }
}
