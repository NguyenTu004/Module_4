package com.example.baitap.service;

import javax.servlet.http.HttpServletRequest;

public class MoneyChangeService {
    public MoneyChangeService() {
    }

    public long moneyChange(HttpServletRequest request){
        String text =  request.getParameter("usd");
        if (text != null){
            long usd = Long.parseLong(text);
            if (usd > 0){
                return usd*23000;
            }
        }
        return 0;
    }
}
