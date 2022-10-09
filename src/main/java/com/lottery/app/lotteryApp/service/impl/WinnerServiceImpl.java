package com.lottery.app.lotteryApp.service.impl;

import com.lottery.app.lotteryApp.dto.LotteryWinnerResponse;
import com.lottery.app.lotteryApp.dto.Response;
import com.lottery.app.lotteryApp.model.LotteryDetail;
import com.lottery.app.lotteryApp.service.SmsService;
import com.lottery.app.lotteryApp.service.WinnerService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WinnerServiceImpl implements WinnerService {

    Logger logger = LogManager.getLogger(WinnerServiceImpl.class);

    @Autowired
    LotteryWinnerResponse response;

    @Autowired
    SmsService smsService;

    @Override
    public LotteryWinnerResponse drawLottery(LotteryDetail lotteryDetail) {

        //verify otp
        if (lotteryDetail.getOtp().equals("123456")) {
            if (lotteryDetail.getTrackingNo().equals("LK-DM-DEX-000461842")) {

                //send sms
                smsService.sendSMS(lotteryDetail.getMobileNo(), "You have won Rs: 1000 gift voucher. " +
                        "Please download the reference QR here http://localhost:3000/qr-loader/000461842123234");

                response.setResultCode(1000);
                response.setResultDescription("Winner..");
                response.setWinReferenceNo("000461842123234");
            } else {
                response.setResultCode(1001);
                response.setResultDescription("Sorry no winner");
            }
        } else {
            response.setResultCode(1002);
            response.setResultDescription("Otp verification Failed");
        }
        return response;
    }
}
