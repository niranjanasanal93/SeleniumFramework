package com.allianz.test;

import com.allianz.base.AutomationWrapper;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;

public class AddEmployee extends AutomationWrapper {


    @Test
    public void uploadInvalidDisplayPicture() {
        File file= new File ("src/test/resources/Files/training.txt");
        String path= file.getAbsolutePath();
        driver.findElement(By.name("username")).sendKeys("Admin");
        driver.findElement(By.name("password")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
        driver.findElement(By.xpath("//span[text()='PIM']")).click();
        driver.findElement(By.linkText("Add Employee")).click();
        driver.findElement(By.xpath("//input[@type='file']")).sendKeys(path);
        String UploadError= driver.findElement(By.xpath("//span[contains(normalize-space(),'File type not allowed')]")).getText();
        Assert.assertTrue(UploadError.contains("File type not allowed"));
    }
}