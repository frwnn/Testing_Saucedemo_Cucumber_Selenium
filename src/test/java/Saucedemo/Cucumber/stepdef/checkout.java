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

public class checkout {
    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";

    @Given("User is on the Saucedemo home page")
    public void saucedemo_home_page() {
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

    @When("User clicks the cart button")
    public void userClicksTheCartButton() {
        driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
    }

    @And("User clicks the checkout button")
    public void userClicksTheCheckoutButton() {
        driver.findElement(By.id("checkout")).click();
    }

    @And("User inputs the first name in the first name field")
    public void userInputsTheFirstNameInTheFirstNameField() {
        driver.findElement(By.id("first-name")).sendKeys("Fajar");
    }

    @And("User inputs the second name in the second name field")
    public void userInputsTheSecondNameInTheSecondNameField() {
        driver.findElement(By.id("last-name")).sendKeys("Irawan");

    }

    @And("User inputs the zip code in the zip code field")
    public void userInputsTheZipCodeInTheZipCodeField() {
        driver.findElement(By.id("postal-code")).sendKeys("15151");
    }

    @And("User clicks the continue button")
    public void userClicksTheContinueButton() {
        driver.findElement(By.id("continue")).click();
    }

    @And("User clicks the finish button")
    public void userClicksTheFinishButton() {
        driver.findElement(By.id("finish")).click();
    }

    @Then("User completes the checkout process successfully")
    public void userCompletesTheCheckoutProcessSuccessfully() {
        String checkout = driver.findElement(By.xpath("//span[@class='title']")).getText();
        Assert.assertEquals(checkout, "Checkout: Complete!");
    }

    @When("the User clicks the cart button")
    public void theUserClicksTheCartButton() {
        driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
    }

    @And("the User clicks the checkout button")
    public void theUserClicksTheCheckoutButton() {
        driver.findElement(By.id("checkout")).click();
    }

    @And("the User inputs data into the second name field")
    public void theUserInputsDataIntoTheSecondNameField() {
        driver.findElement(By.id("last-name")).sendKeys("Irawan");
    }

    @And("the User inputs data into the zip code field")
    public void theUserInputsDataIntoTheZipCodeField() {
        driver.findElement(By.id("postal-code")).sendKeys("15151");
    }

    @And("the User clicks the continue button")
    public void theUserClicksTheContinueButton() {
        driver.findElement(By.id("continue")).click();
    }

    @Then("an error message should appear indicating that the first name must be filled")
    public void anErrorMessageShouldAppearIndicatingThatTheFirstNameMustBeFilled() {
        String ErrorContinue = driver.findElement(By.xpath("//h3[contains(text(),'Error: First Name is required')]")).getText();
        Assert.assertEquals(ErrorContinue, "Error: First Name is required");
    }
}
