package com.ait.qa28.hw4;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase{
    @BeforeMethod
    public void ensurePrecondition() {
        if(!isElementPresent(By.cssSelector("[href='/register']"))) {
            driver.findElement(By.cssSelector("[href='/logout']")).click();
        }
    }

    @Test
    public void createNewAccountPositiveTest() {
        driver.findElement(By.cssSelector("[href='/register']")).click();

        driver.findElement(By.cssSelector("#gender-female")).click();

        driver.findElement(By.cssSelector("#FirstName")).click();
        driver.findElement(By.cssSelector("#FirstName")).clear();
        driver.findElement(By.cssSelector("#FirstName")).sendKeys("newFirstName");

        driver.findElement(By.cssSelector("#LastName")).click();
        driver.findElement(By.cssSelector("#LastName")).clear();
        driver.findElement(By.cssSelector("#LastName")).sendKeys("newLastName");

        driver.findElement(By.cssSelector("#Email")).click();
        driver.findElement(By.cssSelector("#Email")).clear();
        driver.findElement(By.cssSelector("#Email")).sendKeys("newEMail@mail.com");

        driver.findElement(By.cssSelector("#Password")).click();
        driver.findElement(By.cssSelector("#Password")).clear();
        driver.findElement(By.cssSelector("#Password")).sendKeys("123456");

        driver.findElement(By.cssSelector("#ConfirmPassword")).click();
        driver.findElement(By.cssSelector("#ConfirmPassword")).clear();
        driver.findElement(By.cssSelector("#ConfirmPassword")).sendKeys("123456");

        driver.findElement(By.cssSelector("#register-button")).click();

        Assert.assertTrue(isElementPresent(By.cssSelector("[href='/logout']")));
    }
}
