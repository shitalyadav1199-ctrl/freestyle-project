package StepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import hooks.Hooks;
import io.cucumber.java.en.*;

import java.time.Duration;

public class DynamicControlsSteps {

    @Given("user is on dynamic controls page")
    public void user_is_on_dynamic_controls_page() {
        Hooks.driver.get("https://the-internet.herokuapp.com/dynamic_controls");
    }

    @When("user clicks remove")
    public void user_clicks_remove() {
        Hooks.driver.findElement(By.xpath("//button[text()='Remove']")).click();
    }

    @Then("message should appear")
    public void message_should_appear() {
        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(10));
        String message = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("message"))
        ).getText();
        Assert.assertTrue(message.contains("It's gone!"));
    }
}
