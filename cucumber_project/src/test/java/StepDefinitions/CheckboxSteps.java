package StepDefinitions;

import org.openqa.selenium.By;
import org.testng.Assert;

import hooks.Hooks;
import io.cucumber.java.en.*;

public class CheckboxSteps {

    @Given("user is on checkbox page")
    public void user_is_on_checkbox_page() {
        Hooks.driver.get("https://the-internet.herokuapp.com/checkboxes");
    }

    @When("user selects checkbox")
    public void user_selects_checkbox() {
        Hooks.driver.findElements(By.cssSelector("input[type='checkbox']")).get(0).click();
    }

    @Then("checkbox should be selected")
    public void checkbox_should_be_selected() {
        boolean status = Hooks.driver.findElements(By.cssSelector("input[type='checkbox']")).get(0).isSelected();
        Assert.assertTrue(status);
    }
}
