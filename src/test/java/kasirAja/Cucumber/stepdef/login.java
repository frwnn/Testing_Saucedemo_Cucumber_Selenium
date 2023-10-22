package kasirAja.Cucumber.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.junit.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.concurrent.TimeUnit;

public class login {
    WebDriver driver;
    String baseUrl = "https://kasirdemo.belajarqa.com/";

    @Given("Halaman login kasirAja")
    public void halaman_login_kasir_aja() {
        WebDriverManager.chromedriver().setup();


        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get(baseUrl);

        String loginPageAssert = driver.findElement(By.xpath("//h2[contains(text(),'hai, kasirAja')]")).getText();
        Assert.assertEquals(loginPageAssert, "hai, kasirAja");
    }

    @When("Input username")
    public void inputUsername() {
        driver.findElement(By.id("email")).sendKeys("tdd-selenium@gmail.com");
    }

    @And("Input password")
    public void inputPassword() {
        driver.findElement(By.id("password")).sendKeys("tdd-selenium");
    }

    @And("Click login button")
    public void clickLoginButton() {
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    @Then("User on dashboard page")
    public void userOnDashboardPage() {
        driver.findElement(By.xpath("//div[contains(text(), 'dashboard'"));
        String username = driver.findElement(By.xpath("//dd[contains(text(),'hai')]/preceding-sibling::at")).getText();
        Assert.assertEquals(username, "tdd-selenium");
    }

    @And("Input invalid password")
    public void inputInvalidPassword() {
        driver.findElement(By.id("password")).sendKeys("12345");
    }

    @Then("User get error message")
    public void userGetErrorMessage() {
        String errorLogin = driver.findElement(By.xpath("//div[@role='alert']")).getText();
        Assert.assertEquals(errorLogin, "Kredential yang anda berikan salah");
    }
}
