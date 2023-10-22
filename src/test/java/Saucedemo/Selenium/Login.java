package Saucedemo.Selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Login {
    @Test
    public void success_login_case(){
        WebDriver driver;
        String baseUrl = "https://www.saucedemo.com/";

        WebDriverManager.chromedriver().setup();

        //membuka chrome
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        //akses ke saucedemo.com
        driver.get(baseUrl);

        //konfirmasi login page
        String loginPageAssert = driver.findElement(By.xpath("//div[@class='login_logo']")).getText();
        Assert.assertEquals(loginPageAssert, "Swag Labs");

        //input username
        driver.findElement(By.id("user-name")).sendKeys("standard_user");

        //input password
        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        //klik tombol login
        driver.findElement(By.id("login-button")).click();

        //konfirmasi dashboard page
        String dashboardPageAssert = driver.findElement(By.xpath("//div[@class='app_logo']")).getText();
        Assert.assertEquals(dashboardPageAssert, "Swag Labs");

        driver.close();
    }
    @Test
    public void failed_login_case(){
        WebDriver driver;
        String baseUrl = "https://www.saucedemo.com/";

        WebDriverManager.chromedriver().setup();

        //membuka chrome
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

        //akses saucedemo.com
        driver.get(baseUrl);

        //konfirmasi login page
        String loginPageAssert = driver.findElement(By.xpath("//div[@class='login_logo']")).getText();
        Assert.assertEquals(loginPageAssert, "Swag Labs");

        //input username
        driver.findElement(By.id("user-name")).sendKeys("standard_user");

        //input invalid password
        driver.findElement(By.id("password")).sendKeys("123123");

        //klik tombol login
        driver.findElement(By.id("login-button")).click();

        //konfirmasi error message
        String ErrorLogin = driver.findElement(By.xpath("//h3[contains(text(),'Epic sadface: Username and password do not match any user in this service')]")).getText();
        Assert.assertEquals(ErrorLogin, "Epic sadface: Username and password do not match any user in this service");

        driver.close();

    }
}
