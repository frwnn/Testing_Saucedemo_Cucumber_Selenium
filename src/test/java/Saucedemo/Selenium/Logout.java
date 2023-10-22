package Saucedemo.Selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Logout {
    @Test
    public void success_logout_case(){
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

        //klik tombol menu
        driver.findElement(By.id("react-burger-menu-btn")).click();

        //konfirmasi menu
        String BurMen = driver.findElement(By.id("logout_sidebar_link")).getText();
        Assert.assertEquals(BurMen, "Logout");

        //klik tombol logout
        driver.findElement(By.id("logout_sidebar_link")).click();

        //user diarahkan ke login page
        String backtologin = driver.findElement(By.xpath("//div[@class='login_logo']")).getText();
        Assert.assertEquals(backtologin, "Swag Labs");


        driver.close();
    }
}
