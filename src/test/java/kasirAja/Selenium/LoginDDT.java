package kasirAja.Selenium;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.awt.*;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class LoginDDT {
    @Test
    public void login_ddt(){
        WebDriver driver;
        String baseUrl = "https://kasirdemo.belajarqa.com/";

        WebDriverManager.chromedriver().setup();
        ChromeOptions opt = new ChromeOptions();


        String csvDir = System.getProperty("user.dir")+"/src/test/data/test-data.csv";

        try (CSVReader reader = new CSVReader(new FileReader(csvDir))){
        String[] nextLine;
        while ((nextLine = reader.readNext()) != null){
            String email = nextLine[0];
            String password = nextLine[1];
            String status = nextLine[2];

            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
            driver.manage().window().maximize();
            driver.get(baseUrl);
            driver.findElement(By.id("email")).sendKeys("tdd-selenium@gmail.com");

            driver.findElement(By.id("password")).sendKeys("tdd-selenium");

            driver.findElement(By.xpath("//button[@type='submit']")).click();

            if (status.equals("success")){
                driver.findElement(By.xpath("//div[contains(text(),'dashboard')]"));
                String username = driver.findElement(By.xpath("//dd[contains(text(),'hai')]/preceding-sibling::dt")).getText();
                Assert.assertEquals(username, "tdd-selenium");

            } else {
                String ErrorLogin = driver.findElement(By.xpath("//div[@role='alert']")).getText();
                Assert.assertEquals(ErrorLogin, "Kredensial yang Anda berikan salah");
            }
            driver.close();

            }
        } catch (CsvValidationException | IOException e){
            throw new RuntimeException(e);
        }
    }
}
