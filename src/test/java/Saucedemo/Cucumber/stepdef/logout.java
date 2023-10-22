package Saucedemo.Cucumber.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class logout {
    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";

    @Given("the user has successfully logged into the SauceDemo account")
    public void halaman_login_saucedemo() {
        WebDriverManager.chromedriver().setup();


        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get(baseUrl);

        String loginPageAssert = driver.findElement(By.xpath("//div[@class='login_logo']")).getText();
        Assert.assertEquals(loginPageAssert, "Swag Labs");

        driver.findElement(By.id("user-name")).sendKeys("standard_user");

        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        driver.findElement(By.id("login-button")).click();

        String dashboardPageAssert = driver.findElement(By.xpath("//div[@class='title']")).getText();
        Assert.assertEquals(dashboardPageAssert, "Products");
    }

    @And("the user is on the account's main page")
    public void theUserIsOnTheAccountSMainPage() {
        String dashboardPageAssert = driver.findElement(By.xpath("//div[@class='title']")).getText();
        Assert.assertEquals(dashboardPageAssert, "Products");
    }

    @When("the user clicks the Logout button")
    public void theUserClicksTheLogoutButton() {
        driver.findElement(By.id("react-burger-menu-btn")).click();

        String BurMen = driver.findElement(By.id("logout_sidebar_link")).getText();
        Assert.assertEquals(BurMen, "Logout");

        driver.findElement(By.id("logout_sidebar_link")).click();
    }

    @Then("the user successfully logs out and returns to the login page")
    public void theUserSuccessfullyLogsOutAndReturnsToTheLoginPage() {
        String loginPageAssert = driver.findElement(By.xpath("//div[@class='login_logo']")).getText();
        Assert.assertEquals(loginPageAssert, "Swag Labs");
    }
}
