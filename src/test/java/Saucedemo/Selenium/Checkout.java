package Saucedemo.Selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Checkout {
    @Test
    public void checkout(){
        WebDriver driver;
        String baseUrl = "https://www.saucedemo.com/";

        WebDriverManager.chromedriver().setup();
        //membuka chrome
        driver = new ChromeDriver();
        driver.manage().window().maximize();
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

        //klik nama item
        driver.findElement(By.xpath("//div[@class='inventory_item_name ']")).click();

        //klik add cart
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();

        //klik cart
        driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();

        //konfirmasi item yang telah ditambahkan
        String itemInCart = driver.findElement(By.xpath("//div[@class='inventory_item_name']")).getText();
        Assert.assertEquals(itemInCart, "Sauce Labs Backpack");

        //klik tombol checkout
        driver.findElement(By.id("checkout")).click();

        //input first name
        driver.findElement(By.id("first-name")).sendKeys("Fajar");

        //input last name
        driver.findElement(By.id("last-name")).sendKeys("Irawan");

        //input zip/postalcode
        driver.findElement(By.id("postal-code")).sendKeys("15151");

        //klik tombol continue
        driver.findElement(By.id("continue")).click();

        //konfirmasi item yang akan dicheckout
        String diCheckout = driver.findElement(By.xpath("//div[@class='summary_info_label']")).getText();
        Assert.assertEquals(diCheckout, "Payment Information");

        //klik tombol finish
        driver.findElement(By.id("finish")).click();

        //konfirmasi item yang akan dicheckout
        String checkout = driver.findElement(By.xpath("//span[@class='title']")).getText();
        Assert.assertEquals(checkout, "Checkout: Complete!");

        driver.close();
    }
    @Test
    public void checkout_without_filling_firstname(){
        WebDriver driver;
        String baseUrl = "https://www.saucedemo.com/";

        WebDriverManager.chromedriver().setup();
        //membuka chrome
        driver = new ChromeDriver();
        driver.manage().window().maximize();
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

        //klik nama item
        driver.findElement(By.xpath("//div[@class='inventory_item_name ']")).click();

        //klik add cart
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();

        //klik cart
        driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();

        //konfirmasi item yang telah ditambahkan
        String itemInCart = driver.findElement(By.xpath("//div[@class='inventory_item_name']")).getText();
        Assert.assertEquals(itemInCart, "Sauce Labs Backpack");

        //klik tombol checkout
        driver.findElement(By.id("checkout")).click();

        //input last name
        driver.findElement(By.id("last-name")).sendKeys("Irawan");

        //input zip/postalcode
        driver.findElement(By.id("postal-code")).sendKeys("15151");

        //klik tombol continue
        driver.findElement(By.id("continue")).click();

        //konfirmasi error message
        String ErrorContinue = driver.findElement(By.xpath("//h3[contains(text(),'Error: First Name is required')]")).getText();
        Assert.assertEquals(ErrorContinue, "Error: First Name is required");

        driver.close();
    }
}
