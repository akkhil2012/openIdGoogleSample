package com.model;

/**
 * Created with IntelliJ IDEA.
 * User: Dell
 * Date: 6/7/14
 * Time: 9:48 AM
 * To change this template use File | Settings | File Templates.
 */
public class AccountHolder {

    private String name;
    private int id;


    public AccountHolder(){

    }


    public AccountHolder(String name, int id) {
        super();
        this.name = name;
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

}