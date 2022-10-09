package com.lottery.app.lotteryApp.service;

import com.lottery.app.lotteryApp.dto.LotteryWinnerResponse;
import com.lottery.app.lotteryApp.dto.Response;
import com.lottery.app.lotteryApp.model.LotteryDetail;

public interface WinnerService {

    LotteryWinnerResponse drawLottery(LotteryDetail lotteryDetail);
}
