package com.ait.qa28;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class findeElementTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://telranedu.web.app/login");
        driver.manage().window().maximize();
        //wait for all elements on the page to load
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void findElementByTagTest() {
        WebElement element = driver.findElement(By.tagName("h1"));
        System.out.println(element.getText());

        WebElement element1 = driver.findElement(By.tagName("a"));
        System.out.println(element1.getText());

        //finde list of elements bu tag
        List<WebElement> listElements = driver.findElements(By.tagName("a"));
        System.out.println(listElements.size());
    }

    @Test
    public void findElementest() {
        //id
        System.out.println("**************By.id(\"root\")****************");
        WebElement element = driver.findElement(By.id("root"));
        System.out.println(element.getText());

        //class name
        System.out.println("*************By.className(\"login_login__3EHKB\")*****************");
        WebElement element1 = driver.findElement(By.className("login_login__3EHKB"));
        System.out.println(element1.getText());

        //name
        System.out.println("**************By.name(\"email\")****************");
        WebElement element2 = driver.findElement(By.name("email"));
        System.out.println(element2.getAttribute("name"));

        //linkText
        System.out.println("***************By.linkText(\"LOGIN\")***************");
        WebElement element3 = driver.findElement(By.linkText("LOGIN"));
        System.out.println(element3.getText());

        System.out.println("***************By.partialLinkText(\"LOGIN\")***************");
        WebElement element4 = driver.findElement(By.partialLinkText("LOG"));
        System.out.println(element4.getText());
    }

    @Test
    public void findElementByCSSTest(){
       // WebElement element = driver.findElement(By.tagName("h1"));
        WebElement element = driver.findElement(By.cssSelector("h1"));

        //WebElement element1 = driver.findElement(By.id("root"));
        WebElement element1 = driver.findElement(By.cssSelector("#root"));

        //WebElement element2 = driver.findElement(By.className("login_login__3EHKB"));
        WebElement element2 = driver.findElement(By.cssSelector(".login_login__3EHKB"));

        //[attribute='value']
        //WebElement element2 = driver.findElement(By.name("email"));
        WebElement element3 = driver.findElement(By.cssSelector("[name='email']"));

        //placeholder="Password"
        //contains --> *
        WebElement element4 = driver.findElement(By.cssSelector("[placeholder*='ssw']"));
        System.out.println(element4.getText());

        //start --> ^
        //[placeholder^='Pas']
        WebElement element5 = driver.findElement(By.cssSelector("[placeholder^='Pas']"));
        System.out.println(element5.getText());

        //end to --> $
        //[placeholder$='word']
        WebElement element6 = driver.findElement(By.cssSelector("[placeholder$='word']"));
        System.out.println(element6.getText());
    }

    @Test
    public void findElementByXpath(){
        //xpath --> //*[@atribute='value']

        //tag --> //tag
        WebElement element = driver.findElement(By.xpath("//h1"));
        System.out.println(element.getText());

        //id --> //*[id='value']
        //WebElement element1 = driver.findElement(By.id("root"));
        WebElement element1 = driver.findElement(By.xpath("//div[@id='root']"));

        //className --> //*[@class='value']
        //WebElement element2 = driver.findElement(By.className("login_login__3EHKB"));
        WebElement element2 = driver.findElement(By.xpath("//div[@class='login_login__3EHKB']"));

        //contains --> //*[contains(., 'value')]
        // //button[contains(.,'Registration')]
        WebElement element3 = driver.findElement(By.xpath("//button[contains(.,'Registration')]"));

        //start --> //*[starts-with(@attribute, '...')]
        //button[starts-with(@name,'reg')]
    }

    @Test
    public void xpathParentTest() {
        //parent
        //WebElement parent = driver.findElement(By.xpath("//h1/parent::*"));
        //WebElement parent = driver.findElement(By.xpath("//h1/parent::div"));
        WebElement parent = driver.findElement(By.xpath("//h1/.."));
        System.out.println(parent.getText());
        System.out.println("****************************************************");

        //ancestor
        WebElement ancestor = driver.findElement(By.xpath("//h1/ancestor::*"));
        System.out.println(ancestor.getText());
        System.out.println("-----------------------------------------------------");

        //following-sibling
        WebElement following_sibling = driver.findElement(By.xpath("//h1/following-sibling::a"));
        System.out.println(following_sibling.getText());
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++");

        WebElement followingSibling = driver.findElement(By.xpath("//h1/following-sibling::a[3]"));
        System.out.println(followingSibling.getText());
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++");
    }
}
