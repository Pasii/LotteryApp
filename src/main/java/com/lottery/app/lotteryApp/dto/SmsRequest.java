package com.lottery.app.lotteryApp.dto;

public class SmsRequest {

    private String mobileNo;
    private String smsContent;
    private String refNo;

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getSmsContent() {
        return smsContent;
    }

    public void setSmsContent(String smsContent) {
        this.smsContent = smsContent;
    }

    public String getRefNo() {
        return refNo;
    }

    public void setRefNo(String refNo) {
        this.refNo = refNo;
    }

    @Override
    public String toString() {
        return "SmsRequest{" +
                "mobileNo='" + mobileNo + '\'' +
                ", smsContent='" + smsContent + '\'' +
                ", refNo='" + refNo + '\'' +
                '}';
    }
}
