package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by benny on 21.10.15.
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    @RequestMapping("/dashboard")
    public ModelAndView getDashboardPage(){
        return new ModelAndView("dashboard");
    }




}