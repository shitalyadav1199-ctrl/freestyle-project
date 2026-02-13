package StepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import io.cucumber.java.en.*;
import hooks.Hooks;

public class MouseHoverSteps {

    WebDriver driver = Hooks.driver;

    @Given("user is on hover page")
    public void user_is_on_hover_page() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/hovers");
        Thread.sleep(3000);
    }

    @When("user hovers on image")
    public void user_hovers_on_image() throws InterruptedException {
        Actions act = new Actions(driver);
        act.moveToElement(driver.findElements(By.className("figure")).get(0)).perform();
        Thread.sleep(3000);
    }

    @Then("user name should be displayed")
    public void user_name_should_be_displayed() {
        System.out.println("Hover successful");
    }
}
