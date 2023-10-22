package Saucedemo.Cucumber.stepdef;

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
    String baseUrl = "https://www.saucedemo.com/";

    @Given("Halaman login Saucedemo")
    public void halaman_login_saucedemo() {
        WebDriverManager.chromedriver().setup();


        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get(baseUrl);

        String loginPageAssert = driver.findElement(By.xpath("//div[@class='login_logo']")).getText();
        Assert.assertEquals(loginPageAssert, "Swag Labs");
    }

    @When("Input username")
    public void inputUsername() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
    }

    @And("Input password")
    public void inputPassword() {
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }

    @And("Click login button")
    public void clickLoginButton() {
        driver.findElement(By.id("login-button")).click();
    }

    @Then("User on dashboard page")
    public void userOnDashboardPage() {
        String dashboardPageAssert = driver.findElement(By.xpath("//div[@class='app_logo']")).getText();
        Assert.assertEquals(dashboardPageAssert, "Swag Labs");
    }

    @And("Input invalid password")
    public void inputInvalidPassword() {
        driver.findElement(By.id("password")).sendKeys("123123");
    }

    @Then("User get error message")
    public void userGetErrorMessage() {
        String ErrorLogin = driver.findElement(By.xpath("//h3[contains(text(),'Epic sadface: Username and password do not match any user in this service')]")).getText();
        Assert.assertEquals(ErrorLogin, "Epic sadface: Username and password do not match any user in this service");
    }
}
