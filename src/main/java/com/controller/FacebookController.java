package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.FacebookProfile;
import org.springframework.social.facebook.api.Page;
import org.springframework.social.facebook.api.impl.FacebookTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.social.facebook.api.PageOperations.*;
//import org.springframework.social.facebook.connect.FacebookConnectionFactory;
import org.springframework.social.facebook.api.Reference;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;

import java.util.List;
import java.util.logging.Logger;

/**
 * Created by akhilg on 6/4/2014.
 */

@Controller
@RequestMapping(value = "/social/facebook")
public class FacebookController {


    //private final Facebook facebook;



  //  @Autowired
  ConnectionRepository connectionRepository;

    private static Logger logger = Logger.getLogger("FacebookController.class");

//  /  Facebook facebook = new FacebookTemplate();

/*   @Inject
    public FacebookController(FacebookTemplate facebook){
       this.facebook = facebook;
   }*/

    @Inject
    Facebook facebook;

/*    public FacebookController(Facebook facebook){

        this.facebook = facebook;
    }*/



    @Bean
        public Facebook facebook() {
        logger.info("Instantiating FaceBook Instance>>>>>>>>>>>>....................");
        Connection<Facebook> connection = connectionRepository.findPrimaryConnection(Facebook.class);
        //Connection<Facebook> connection = connectionRepository.getConnectionFactory("facebook").createConnection(facebook.friendOperations().getFriendList(""))
        Facebook facebook = connection != null ? connection.getApi() : new FacebookTemplate();
        return facebook;
    }


    @RequestMapping(value = "/getFreindsList", method = RequestMethod.GET)
    public ModelAndView getFreindsList(Model model) {

        logger.info("Entered getFreindsList method....................");

        facebook();

   /*     if (!facebook.isAuthorized()) {
            return "redirect:/connect/facebook";
        }


        model.addAttribute(facebook.userOperations().getUserProfile());

        FacebookProfile userProfile = facebook.userOperations().getUserProfile();


        model.addAttribute("profile_user", userProfile);

        return "userProfile";*/




    List<Reference> friends = listOfFriends();

        logger.info("After fetchiing the freinds list.............");
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("freindsList",friends);

        modelAndView.setViewName("friendsList");




        return  modelAndView;

}


    List<Reference> listOfFriends(){

        logger.info("Inside get Freinds list method.................................");

        return facebook.friendOperations().getFriendLists();
    }


}