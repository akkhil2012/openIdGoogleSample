package com.controller;

import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.FacebookProfile;
import org.springframework.social.facebook.api.Page;
import org.springframework.social.facebook.api.impl.FacebookTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.social.facebook.api.PageOperations.*;

import javax.inject.Inject;
import java.util.logging.Logger;

/**
 * Created by akhilg on 6/4/2014.
 */

@Controller
@RequestMapping(value = "/social/facebook")
public class FacebookController {


    private static Logger logger = Logger.getLogger("FacebookController.class");

   private Facebook facebook;

   @Inject
    public FacebookController(FacebookTemplate facebook){
       this.facebook = facebook;
   }


    @RequestMapping(value = "/signin", method = RequestMethod.GET)
    public String LoginFacebook(Model model){



        if (!facebook.isAuthorized()) {
            return "redirect:/connect/facebook";
        }


        model.addAttribute(facebook.userOperations().getUserProfile());

        FacebookProfile userProfile = facebook.userOperations().getUserProfile();


        model.addAttribute("profile_user",userProfile);

        return "userProfile";

    }




}