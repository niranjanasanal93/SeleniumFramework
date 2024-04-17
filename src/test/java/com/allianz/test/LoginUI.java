package com.allianz.test;

import com.allianz.base.AutomationWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginUI extends AutomationWrapper {

    @Test(priority = 1)
    public void titleTest(){
        String  actualtitle= driver.getTitle();
        Assert.assertEquals(actualtitle,"OrangeHRM");
        System.out.println(actualtitle);

    }
    @Test(priority=2)
    public void applicationDiscriptionTest(){

        String actualtext=driver.findElement(By.xpath("//p[contains(normalize-space(),'OS')]")).getText();
        Assert.assertEquals(actualtext,"OrangeHRM OS 5.6.1");
        System.out.println(actualtext);

    }
}
