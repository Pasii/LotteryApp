package com.lottery.app.lotteryApp.service;

import com.lottery.app.lotteryApp.dto.OtpRequest;
import com.lottery.app.lotteryApp.dto.Response;

public interface OtpService {

    public Response createAndSendOtp(OtpRequest otpRequest);
}
