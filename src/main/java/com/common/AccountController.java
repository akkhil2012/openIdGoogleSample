package com.common;

import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.model.AccountHolder;
import com.services.AccountService;
import com.services.AccountServiceImpl;

@Controller
public class AccountController extends MultiActionController{




    private AccountServiceImpl accountServiceImpl;
    //private AccountHolder accountHolder;

    @Autowired
    public AccountController(AccountServiceImpl accountServiceImpl){

        this.accountServiceImpl = accountServiceImpl;
        //this.accountHolder = accountHolder;
    }

    private AccountHolder accountHolder = new AccountHolder();

    private Account account = new Account();

    protected static final Logger logg = Logger.getLogger(AccountController.class.getName());

    @RequestMapping(value="/enterAccountDtls/", method=RequestMethod.POST)
    public ModelAndView enterAccountDtls(ModelAndView modelAndView,HttpServletRequest
            request,HttpServletResponse response){

        // String name = request.getParameter("name");


        logg.info("Inside AccountHolder Class---------------------------->>>>");

        String name ="akkhil";

        logg.info("name form form is::::::"+name);

     //   accountHolder.setName(name);

        logg.info("Acoount object is--------------------->>>>"+account);

       // logg.info("account holder anme is........."+accountHolder.getName());

        account.setAccount_name("akkhil");

        logg.info("account holder account name is..."+account.getAccount_name());

        //account.getAccountType().setTypeOfAccount("savings.....");

        logg.info("Account typpe is========================="+account.getAccountType());


        //account.setAccountType(account.getAccountType());


        accountServiceImpl.enterAccountDetails(account);

        // String name = accountHolder.getName();//???
        //String accountType = accountHolder.g

        modelAndView.addObject("newuser",name);

        modelAndView.setViewName("newuser");

        return modelAndView;

    }

}