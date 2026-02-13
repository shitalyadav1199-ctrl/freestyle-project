package StepDefinitions;


import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import hooks.Hooks;
import io.cucumber.java.en.*;

public class DropdownSteps {

    @Given("user is on dropdown page")
    public void user_is_on_dropdown_page() {
        Hooks.driver.get("https://the-internet.herokuapp.com/dropdown");
    }

    @When("user selects {string}")
    public void user_selects(String option) {
        Select select = new Select(Hooks.driver.findElement(By.id("dropdown")));
        select.selectByVisibleText(option);
    }

    @Then("option should be selected")
    public void option_should_be_selected() {
        Select select = new Select(Hooks.driver.findElement(By.id("dropdown")));
        Assert.assertEquals(select.getFirstSelectedOption().getText(), "Option 2");
       
    }
}
