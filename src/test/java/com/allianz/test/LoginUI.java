package com.allianz.test;

import org.testng.annotations.Test;

public class LoginUI {
    @Test(priority = 1)
    public void titleTest(){
        System.out.println("title test");

    }
    @Test(priority=2)
    public void applicationDiscriptionTest(){
        System.out.println("app");

    }
}
