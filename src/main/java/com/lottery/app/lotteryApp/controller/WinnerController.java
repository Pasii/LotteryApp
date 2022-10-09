package com.lottery.app.lotteryApp.controller;

import com.lottery.app.lotteryApp.dto.LotteryWinnerResponse;
import com.lottery.app.lotteryApp.dto.Response;
import com.lottery.app.lotteryApp.model.LotteryDetail;
import com.lottery.app.lotteryApp.service.WinnerService;
import com.lottery.app.lotteryApp.service.impl.OtpServiceImpl;
import com.lottery.app.lotteryApp.util.AppConstant;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
public class WinnerController {

    @Autowired
    LotteryWinnerResponse response;

    @Autowired
    WinnerService winnerService;

    Logger logger = LogManager.getLogger(WinnerController.class);

    @CrossOrigin(origins = AppConstant.CROSS_ORIGIN)
    @PostMapping("/winner")
    public LotteryWinnerResponse drawLottery (@RequestBody LotteryDetail lotteryDetail) {
        logger.info("_____draw lottery : request "+ lotteryDetail.toString());
        response = winnerService.drawLottery(lotteryDetail);
        return response;
    }
}
