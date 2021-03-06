package com.example.controller;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;

/**
 * Created by benny on 21.10.15.
 */
@Controller
public class LoginController {
    @RequestMapping("/login")
    public ModelAndView getLoginPage(){
        Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>)
                SecurityContextHolder.getContext().getAuthentication().getAuthorities();
        boolean hasRole = false;
        for (GrantedAuthority authority : authorities) {
            hasRole = authority.getAuthority().equals("ADMIN");
            if (hasRole)
                break;
        }
        if(hasRole)
            return new ModelAndView("redirect:admin/dashboard");
        else
            return new ModelAndView("login");
    }
}
