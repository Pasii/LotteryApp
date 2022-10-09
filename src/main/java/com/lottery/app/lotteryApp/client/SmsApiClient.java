package com.lottery.app.lotteryApp.client;

import com.lottery.app.lotteryApp.dto.SmsApi2AuthRequest;
import com.lottery.app.lotteryApp.dto.SmsApi2AuthResponse;
import com.lottery.app.lotteryApp.dto.SmsApi2Request;
import com.lottery.app.lotteryApp.dto.SmsApi2Response;
import com.lottery.app.lotteryApp.exception.SendSmsException;
import com.lottery.app.lotteryApp.util.AppConstant;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.net.URISyntaxException;
import java.security.NoSuchAlgorithmException;


public class SmsApiClient {

    @Autowired
    RestTemplate restTemplate;

    Logger logger = LogManager.getLogger(SmsApiClient.class);


    public void sendSMSApi2(SmsApi2Request request) throws SendSmsException {

        String url = AppConstant.SMS_API_2_URL;

        String authToken = smsApi2AuthToken();

        HttpHeaders headers = new HttpHeaders();

        headers.set("Authorization",authToken);
        headers.set("Content-Type", "application/json");
        headers.set("Accept", "application/json");

        HttpEntity<SmsApi2Request> requestEntity = new HttpEntity<>(request, headers);

        restTemplate = new RestTemplate();

        ResponseEntity<SmsApi2Response> response = restTemplate.exchange(url,HttpMethod.POST, requestEntity, SmsApi2Response.class);

        logger.info("_____sms api 2 response "+response.toString());
        if (!response.getBody().getError().equals("0")) {
            throw new SendSmsException("Sms exception failed");
        }

    }

    public String smsApi2AuthToken() throws SendSmsException {

        String api2UserName = AppConstant.SMS_API_2_USER;
        String api2Password = AppConstant.SMS_API_2_PWD;

        String api2AuthUrl = AppConstant.SMS_API_2_AUTH_URL;

        SmsApi2AuthRequest request = new SmsApi2AuthRequest();
        request.setU_name(api2UserName);
        request.setPasswd(api2Password);

        HttpHeaders headers = new HttpHeaders();

        headers.set("Content-Type", "application/json");

        HttpEntity<SmsApi2AuthRequest> requestEntity = new HttpEntity<>(request, headers);

        restTemplate = new RestTemplate();

        ResponseEntity<SmsApi2AuthResponse> response = restTemplate.exchange(api2AuthUrl,HttpMethod.POST, requestEntity, SmsApi2AuthResponse.class);

        logger.info("__________auth response "+response.toString());

        if (response.getBody().getError() != null) {
            throw new SendSmsException("Authentication failed");
        }

        return response.getBody().getAccess_token();


    }


}
