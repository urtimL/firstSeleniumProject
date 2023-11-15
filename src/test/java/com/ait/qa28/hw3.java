package com.ait.qa28;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class hw3 {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void findeByCssSelector() {
        //tagName
        System.out.println("--1------------------------------------------------");
        WebElement element1 = driver.findElement(By.cssSelector("h2"));
        System.out.println(element1.getText());

        System.out.println("--2------------------------------------------------");
        List<WebElement> elements2 = driver.findElements(By.cssSelector("h2"));
        for (WebElement el: elements2) {
            System.out.println(el.getText());
        }

        //id
        System.out.println("--3------------------------------------------------");
        WebElement element3 = driver.findElement(By.cssSelector("#newsletter-subscribe-block"));
        System.out.println(element3.getText());

        //className
        System.out.println("--4------------------------------------------------");
        WebElement element4 = driver.findElement(By.cssSelector(".topic-html-content-header"));
        System.out.println(element4.getText());

        //[attribute='value']
        System.out.println("--5------------------------------------------------");
        WebElement element5 = driver.findElement(By.cssSelector("[for='pollanswers-1']"));
        System.out.println(element5.getText());

        //contains --> *
        System.out.println("--6------------------------------------------------");
        WebElement element6 = driver.findElement(By.cssSelector("[style*='150']"));
        System.out.println(element6.getText());

        System.out.println("--7------------------------------------------------");
        List<WebElement> elements7 = driver.findElements(By.cssSelector("[style*='85']"));
        for (WebElement el: elements7) {
            System.out.println(el.getText());
        }

        //start --> ^
        System.out.println("--8------------------------------------------------");
        WebElement element8 = driver.findElement(By.cssSelector("[href^='/producttag/8']"));
        System.out.println(element8.getText());

        System.out.println("--9------------------------------------------------");
        List<WebElement> elements9 = driver.findElements(By.cssSelector("[href^='/producttag']"));
        for (WebElement el: elements9) {
            System.out.println(el.getText());
        }

        //end to --> $
        System.out.println("--10------------------------------------------------");
        List<WebElement> elements10 = driver.findElements(By.cssSelector("[style$='85%;']"));
        for (WebElement el: elements10) {
            System.out.println(el.getText());
        }

    }

    @Test
    public void findeByxPath() {
        //tagName
        System.out.println("--1------------------------------------------------");
        WebElement element1 = driver.findElement(By.xpath("//h2"));
        System.out.println(element1.getText());

        System.out.println("--2------------------------------------------------");
        List<WebElement> elements2 = driver.findElements(By.xpath("//h2"));
        for (WebElement el: elements2) {
            System.out.println(el.getText());
        }

        //id
        System.out.println("--3------------------------------------------------");
        WebElement element3 = driver.findElement(By.xpath("//div[@id='newsletter-subscribe-block']"));
        System.out.println(element3.getText());

        //className
        System.out.println("--4------------------------------------------------");
        WebElement element4 = driver.findElement(By.xpath("//h2[@class='topic-html-content-header']"));
        System.out.println(element4.getText());

        //[attribute='value']
        System.out.println("--5------------------------------------------------");
        WebElement element5 = driver.findElement(By.xpath("//label[@for='pollanswers-1']"));
        System.out.println(element5.getText());

        //contains --> *
        System.out.println("--6------------------------------------------------");
        WebElement element6 = driver.findElement(By.xpath("//a[@style[contains(., '150')]]"));
        System.out.println(element6.getText());

        System.out.println("--7------------------------------------------------");
        List<WebElement> elements7 = driver.findElements(By.xpath("//a[@style[contains(., '85')]]"));
        for (WebElement el: elements7) {
            System.out.println(el.getText());
        }

        //start --> ^
        System.out.println("--8------------------------------------------------");
        WebElement element8 = driver.findElement(By.xpath("//a[starts-with(@href, '/producttag/8')]"));
        System.out.println(element8.getText());

        System.out.println("--9------------------------------------------------");
        List<WebElement> elements9 = driver.findElements(By.xpath("//a[starts-with(@href, '/producttag')]"));
        for (WebElement el: elements9) {
            System.out.println(el.getText());
        }
/*
        // Такого в лекции небыло ???
        //end to --> $
        System.out.println("--10------------------------------------------------");
        List<WebElement> elements10 = driver.findElements(By.xpath("[style$='85%;']"));
        for (WebElement el: elements10) {
            System.out.println(el.getText());
        }
*/
    }
}
