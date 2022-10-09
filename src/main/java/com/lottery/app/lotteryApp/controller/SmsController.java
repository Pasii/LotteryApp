package com.lottery.app.lotteryApp.controller;

import com.lottery.app.lotteryApp.dto.Response;
import com.lottery.app.lotteryApp.dto.SmsRequest;
import com.lottery.app.lotteryApp.service.SmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SmsController {

    @Autowired
    SmsService smsService;

    @PostMapping("/smsApi2")
    public Response sendSms(@RequestBody SmsRequest request) {

        Response response = smsService.sendSMS(request.getMobileNo(),request.getSmsContent());
        return response;

    }


}
