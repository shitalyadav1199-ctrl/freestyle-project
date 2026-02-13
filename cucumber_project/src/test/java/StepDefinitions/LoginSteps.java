package StepDefinitions;

import org.openqa.selenium.By;
import org.testng.Assert;

import hooks.Hooks;
import io.cucumber.java.en.*;

public class LoginSteps {

    @Given("user is on login page")
    public void user_is_on_login_page() {
        Hooks.driver.get("https://the-internet.herokuapp.com/login");
    }

    @When("user enters username and password")
    public void user_enters_username_and_password() {
        Hooks.driver.findElement(By.id("username")).sendKeys("tomsmith");
        Hooks.driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        Hooks.driver.findElement(By.cssSelector("button[type='submit']")).click();
    }

    @Then("user should login successfully")
    public void user_should_login_successfully() {
        String text = Hooks.driver.findElement(By.id("flash")).getText();
        Assert.assertTrue(text.contains("You logged into a secure area"));
    }
}
