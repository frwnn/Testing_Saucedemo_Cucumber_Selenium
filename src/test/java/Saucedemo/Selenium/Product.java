package Saucedemo.Selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Product {
    @Test
    public void delete_product_on_cart(){
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

        //klik remove
        driver.findElement(By.id("remove-sauce-labs-backpack")).click();

        //konfirmasi item yang telah dihapus
        String deleteitem = driver.findElement(By.xpath("//div[@class='removed_cart_item']")).getText();
        Assert.assertEquals(deleteitem, "");
        driver.close();
    }

    @Test
    public void delete_product_on_cart_at_dashboard(){
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

        //klik add cart
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();

        //konfirmasi item yang telah ditambahkan
        String itemInCart = driver.findElement(By.xpath("//span[@class='shopping_cart_badge']")).getText();
        Assert.assertEquals(itemInCart, "1");

        //klik remove
        driver.findElement(By.id("remove-sauce-labs-backpack")).click();

        //konfirmasi item yang telah dihapus
        String deleteitem = driver.findElement(By.xpath("//button[@class='btn btn_primary btn_small btn_inventory ']")).getText();
        Assert.assertEquals(deleteitem, "Add to cart");

        driver.close();
    }
}
