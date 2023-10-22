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

public class order {
    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";

    @Given("the User is on the Saucedemo home page")
    public void saucedemo_home_page() {
        WebDriverManager.chromedriver().setup();


        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get(baseUrl);


        String loginPageAssert = driver.findElement(By.xpath("//div[@class='login_logo']")).getText();
        Assert.assertEquals(loginPageAssert, "Swag Labs");

        driver.findElement(By.id("user-name")).sendKeys("standard_user");

        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        driver.findElement(By.id("login-button")).click();



    }

    @When("clicks on the product name")
    public void ClicksOnTheProductName() {
        driver.findElement(By.id("item_4_title_link")).click();
    }

    @And("clicks on the Add to Cart button")
    public void ClicksOnTheButton() {
        driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
    }

    @Then("the product should be added to the cart")
    public void theProductShouldBeAddedToTheCart() {
        String itemInCart = driver.findElement(By.xpath("//div[@class='inventory_item_name']")).getText();
        Assert.assertEquals(itemInCart, "Sauce Labs Backpack");
    }

    @When("the User clicks on the cart button")
    public void theUserClicksOnTheCartButton() {
        driver.findElement(By.xpath("//div[@class='shopping_cart_link']")).click();
    }

    @And("the User changes the quantity of the item to zero")
    public void theUserChangesTheQuantityOfTheItemToZero() {
        driver.findElement(By.className("cart_quantity")).sendKeys("1");
    }

    @Then("the item quantity in the cart should be updated to zero")
    public void theItemQuantityInTheCartShouldBeUpdatedToZero() {
        String itemInCart = driver.findElement(By.xpath("//div[@class='cart_quantity']")).getText();
        Assert.assertEquals(itemInCart, "0");
    }

    @And("clicks on the Cart button")
    public void ClicksOnTheCartButton() {
        driver.findElement(By.id("shopping_cart_container")).click();
    }

    @And("already have item in cart")
    public void alreadyHaveItemInCart() {
        driver.findElement(By.xpath("//button[@class='btn btn_primary btn_small btn_inventory ']")).click();
    }
}
