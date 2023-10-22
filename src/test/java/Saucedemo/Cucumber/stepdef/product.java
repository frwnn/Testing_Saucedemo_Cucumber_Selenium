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
public class product {
    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";

    @Given("the user is logged in and is on the dashboard")
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

    @When("the user clicks on the product name")
    public void theUserClicksOnTheProductName() {
        driver.findElement(By.xpath("//div[@class='inventory_item_name ']")).click();
    }

    @And("the user click Add to Cart")
    public void theUserClickAddToCart() {
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
    }

    @And("the user goes to the shopping cart page")
    public void theUserGoesToTheShoppingCartPage() {
        driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
    }

    @And("the user click Remove")
    public void theUserClickRemove() {
        driver.findElement(By.id("remove-sauce-labs-backpack")).click();
    }

    @Then("the product should be removed from the cart")
    public void theProductShouldBeRemovedFromTheCart() {
        String deleteitem = driver.findElement(By.xpath("//div[@class='removed_cart_item']")).getText();
        Assert.assertEquals(deleteitem, "");
    }
    @Then("the product should be removed")
    public void theProductShouldBeRemoved() {
        String deleteitem = driver.findElement(By.xpath("//button[@class='btn btn_primary btn_small btn_inventory ']")).getText();
        Assert.assertEquals(deleteitem, "Add to cart");
    }
}
