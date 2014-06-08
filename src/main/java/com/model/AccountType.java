package com.model;

/**
 * Created with IntelliJ IDEA.
 * User: Dell
 * Date: 6/7/14
 * Time: 9:48 AM
 * To change this template use File | Settings | File Templates.
 */
public class AccountType {


    private String typeOfAccount;

    public String getTypeOfAccount() {
        return typeOfAccount;
    }

    public void setTypeOfAccount(String typeOfAccount) {
        this.typeOfAccount = typeOfAccount;
    }

    AccountType(){

    }



    AccountType(String typeOfAccount){

        this.typeOfAccount = typeOfAccount;
    }

}
