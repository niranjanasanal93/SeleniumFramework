package com.allianz.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginUI {
    @Test(priority = 1)
    public void titleTest(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php");
        String  actualtitle= driver.getTitle();
        Assert.assertEquals(actualtitle,"OrangeHRM");
        System.out.println(actualtitle);

    }
    @Test(priority=2)
    public void applicationDiscriptionTest(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php");
        String actualtext=driver.findElement(By.xpath("//p[contains(normalize-space(),'OS')]")).getText();
        Assert.assertEquals(actualtext,"OrangeHRM OS 5.6.1");
        System.out.println(actualtext);

    }
}
