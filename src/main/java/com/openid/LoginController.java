package com.openid;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created with IntelliJ IDEA.
 * User: Dell
 * Date: 5/26/14
 * Time: 10:53 PM
 * To change this template use File | Settings | File Templates.
 */

@Controller
public class LoginController {

    @RequestMapping(value ="/welcome",method = RequestMethod.GET)
            public ModelAndView welcomePage() {

            ModelAndView model = new ModelAndView();
            model.addObject("title", "Spring Security Sample");
    model.addObject("message", "This is welcome page!");
    model.setViewName("user");
    return model;

}

   /* @RequestMapping(value = "/admin**", method = RequestMethod.GET)
    public ModelAndView adminPage() {

        ModelAndView model = new ModelAndView();
        model.addObject("title", "Spring Security Sample");
        model.addObject("message", "This is protected page!");
        model.setViewName("admin");

        return model;

    }*/


}
