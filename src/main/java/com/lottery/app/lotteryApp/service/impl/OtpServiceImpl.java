package com.lottery.app.lotteryApp.service.impl;

import com.lottery.app.lotteryApp.dto.OtpRequest;
import com.lottery.app.lotteryApp.dto.Response;
import com.lottery.app.lotteryApp.service.OtpService;
import com.lottery.app.lotteryApp.service.SmsService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OtpServiceImpl implements OtpService {

    Logger logger = LogManager.getLogger(OtpServiceImpl.class);

    @Autowired
    Response response;

    @Autowired
    SmsService smsService;

    @Override
    public Response createAndSendOtp(OtpRequest otpRequest) {

        try {

            logger.info("__________sending otp....."+otpRequest.toString());
            int otp = 123456;
            String smsContent = "One Time Password is : "+otp;
            smsService.sendSMS(otpRequest.getMobileNo(),smsContent );

            //TODO - enter otp details to db

            response.setResultCode(1000);
            response.setResultDescription("Success");



        } catch (Exception e) {
            logger.error(e.getMessage());
            response.setResultCode(1999);
            response.setResultDescription("Error");
        }
        return response;
    }
}
