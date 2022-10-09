package com.lottery.app.lotteryApp.controller;

import com.lottery.app.lotteryApp.dto.OtpRequest;
import com.lottery.app.lotteryApp.dto.Response;
import com.lottery.app.lotteryApp.service.OtpService;
import com.lottery.app.lotteryApp.util.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
public class OtpController {

    @Autowired
    OtpService otpService;

    @CrossOrigin(origins = AppConstant.CROSS_ORIGIN)
    @PostMapping("/otp")
    public Response createAndSendOtp(@RequestBody OtpRequest otpRequest) {
        Response response = otpService.createAndSendOtp(otpRequest);
        return response;
    }
}
