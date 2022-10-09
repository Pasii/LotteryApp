package com.lottery.app.lotteryApp.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.lottery.app.lotteryApp.dto.Response;
import com.lottery.app.lotteryApp.exception.InvalidFormatException;
import com.lottery.app.lotteryApp.exception.SendSmsException;

import java.net.URISyntaxException;
import java.security.NoSuchAlgorithmException;

public interface SmsService {

    public Response sendSMS(String mobileNo, String smsContent) ;
}
