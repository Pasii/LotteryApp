package com.lottery.app.lotteryApp.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.lottery.app.lotteryApp.client.SmsApiClient;
import com.lottery.app.lotteryApp.dto.Response;
import com.lottery.app.lotteryApp.dto.SmsApi2Request;
import com.lottery.app.lotteryApp.exception.InvalidFormatException;
import com.lottery.app.lotteryApp.exception.SendSmsException;
import com.lottery.app.lotteryApp.service.SmsService;
import com.lottery.app.lotteryApp.util.AppConstant;
import com.lottery.app.lotteryApp.util.CommonUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.URISyntaxException;
import java.security.NoSuchAlgorithmException;

@Service
public class SmsServiceImpl implements SmsService {

    Logger logger = LogManager.getLogger(SmsServiceImpl.class);

    @Autowired
    Response response;

    public Response sendSMS(String mobileNo, String smsContent)  {

        logger.info("__________Send SMS to : "+mobileNo);
        logger.info("_____message : "+smsContent);

        try {

            if (mobileNo.length() < 9) {
                throw new InvalidFormatException("Invalid mobile no");
            }

            String formattedMobileNo = "94"+mobileNo.substring(mobileNo.length() - 9);
            logger.info("______ 94 formatted mobile no :"+formattedMobileNo);

//        SmsSendRequest request = new SmsSendRequest();
//        MessageElement messageElement = new MessageElement();
//        List<MessageElement> messageElementList = new ArrayList<>();
//
//        messageElement.setClientRef(refNo);
//        messageElement.setNumber(formattedMobileNo);
//        messageElement.setMask("TEST");
//        messageElement.setText(smsContent);
//        messageElement.setCampaignName("Darazian campaign");
//
//        messageElementList.add(messageElement);
//
//        request.setMessages(messageElementList);

            //logger.info(request.toString());

            SmsApi2Request request = new SmsApi2Request();
            request.setMsisdn(formattedMobileNo); //set mobile no
            request.setChannel("9"); //Short sms (TRANSACTIONAL up to 160 characters
            request.setMsg(smsContent);
            request.setMt_port(AppConstant.SMS_MASK);

            //set current timestamp as start time
            request.setS_time(CommonUtil.getFormattedTimeString());

            //set current timestamp + 1 days as end time
            request.setE_time(CommonUtil.addDaysToCurrentTime(1));

            SmsApiClient smsApiClient = new SmsApiClient();
            //smsApiClient.sendSMSApi2(request);

            response.setResultCode(1000);
            response.setResultDescription("Successfully sent the sms");


        } catch (Exception e) {

            response.setResultCode(1999);
            response.setResultDescription("Error");
        }


         return response;
    }

}
