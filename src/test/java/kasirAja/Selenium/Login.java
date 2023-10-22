package kasirAja.Selenium;

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
        String baseUrl = "https://kasirdemo.belajarqa.com/";

        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);

        String loginPageAssert = driver.findElement(By.xpath("//h2[contains(text(),'hai, kasirAja')]")).getText();
        Assert.assertEquals(loginPageAssert, "hai, kasirAja");
        driver.findElement(By.id("email")).sendKeys("tdd-selenium@gmail.com");

        driver.findElement(By.id("password")).sendKeys("tdd-selenium");

        driver.findElement(By.xpath("//button[@type='submit']")).click();


        driver.close();
    }
    @Test
    public void failed_login_case(){
        WebDriver driver;
        String baseUrl = "https://kasirdemo.belajarqa.com/";

        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get(baseUrl);

        String loginPageAssert = driver.findElement(By.xpath("//h2[contains(text(),'hai, kasirAja')]")).getText();
        Assert.assertEquals(loginPageAssert, "hai, kasirAja");
        driver.findElement(By.id("email")).sendKeys("tdd-selenium@gmail.com");

        driver.findElement(By.id("password")).sendKeys("121212");

        driver.findElement(By.xpath("//button[@type='submit']")).click();

        String ErrorLogin = driver.findElement(By.xpath("//div[@role='alert']")).getText();
        Assert.assertEquals(ErrorLogin, "Kredensial yang Anda berikan salah");

        driver.close();

    }
}
