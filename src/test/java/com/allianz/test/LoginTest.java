package com.allianz.test;

import com.allianz.base.AutomationWrapper;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest extends AutomationWrapper {
    @Test
    public void validLoginTest(){
        driver.findElement(By.name("username")).sendKeys("Admin");
        driver.findElement(By.name("password")).sendKeys("admin123");
        String header= driver.findElement(By.xpath("//h6[contains(normalize-space(),Dashboard)]")).getText();
        Assert.assertEquals(header,"Dashboard");

    }
    @DataProvider
    public Object[][] invalidLoginData(){
        Object[][] data= new Object[2][3];
        data[0][0]="john";
        data[0][1]="john123";
        data[0][2]="Invalid credentials";
        data[1][0]="saul";
        data[1][1]="saul123";
        data[1][2]="Invalid credentials";

        return data;

    }
@Test(dataProvider = "invalidLoginData")
    public void invalidLogintest(String username,String password, String expectedError){
    driver.findElement(By.name("username")).sendKeys("john");
    driver.findElement(By.name("password")).sendKeys("john123");
    driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
    String actualError= driver.findElement(By.xpath("//p[contains(normalize-space(),'Invalid')]")).getText();
    Assert.assertEquals(actualError,expectedError);
}
}
