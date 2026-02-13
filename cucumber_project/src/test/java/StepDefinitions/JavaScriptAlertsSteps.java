package StepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.*;
import hooks.Hooks;

public class JavaScriptAlertsSteps {

    WebDriver driver = Hooks.driver;

    @Given("user is on javascript alerts page")
    public void user_is_on_javascript_alerts_page() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        Thread.sleep(3000);
    }

    @When("user handles JS Alert")
    public void user_handles_js_alert() throws InterruptedException {
        driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
        Thread.sleep(2000);
        driver.switchTo().alert().accept();
        Thread.sleep(3000);
    }

    @And("user handles JS Confirm")
    public void user_handles_js_confirm() throws InterruptedException {
        driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
        Thread.sleep(2000);
        driver.switchTo().alert().dismiss(); // cancel
        Thread.sleep(3000);
    }

    @And("user handles JS Prompt")
    public void user_handles_js_prompt() throws InterruptedException {
        driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
        Thread.sleep(2000);
        driver.switchTo().alert().sendKeys("Shital");
        driver.switchTo().alert().accept();
        Thread.sleep(3000);
    }

    @Then("result message should be displayed")
    public void result_message_should_be_displayed() {
        String result = driver.findElement(By.id("result")).getText();
        System.out.println("Result message: " + result);
    }
}
