package com.dkd.springboot.firstwebapp.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@SessionAttributes("username")
@Controller
public class WelcomeController {

    @RequestMapping(value="/",method= RequestMethod.GET)
    public String gotoWelcomePage(ModelMap model)
    {
        model.put("username", getLoggedinUsername());
        return "welcome";
    }
    private String getLoggedinUsername(){
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        return  authentication.getName();
    }
}
