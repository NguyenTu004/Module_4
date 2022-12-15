package com.example.thuchanh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.TimeZone;

@Controller
public class TimeController {
    @GetMapping("/world-clock")
    public String getTimeByTimezone(ModelMap modelMap, @RequestParam(name = "city", required = false, defaultValue = "Asia/Ha_Noi") String city){
        Date date = new Date();
        TimeZone timeZone = TimeZone.getDefault();
        TimeZone timeZoneCity = TimeZone.getTimeZone(city);
        long localTime = date.getTime() + (timeZone.getRawOffset() - timeZoneCity.getRawOffset());
        date.setTime(localTime);
        modelMap.addAttribute("city",city);
        modelMap.addAttribute("date",date);
        return "home-time";
    }

}
