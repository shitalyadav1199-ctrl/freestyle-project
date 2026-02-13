package StepDefinitions;


import org.openqa.selenium.By;
import org.testng.Assert;

import hooks.Hooks;
import io.cucumber.java.en.*;

import java.io.File;

public class FileUploadSteps {

    @Given("user is on upload page")
    public void user_is_on_upload_page() {
        Hooks.driver.get("https://the-internet.herokuapp.com/upload");
    }

    @When("user uploads a file")
    public void user_uploads_a_file() {
        File file = new File("src/test/resources/testfile.txt");
        Hooks.driver.findElement(By.id("file-upload")).sendKeys(file.getAbsolutePath());
        Hooks.driver.findElement(By.id("file-submit")).click();
    }

    @Then("file should be uploaded")
    public void file_should_be_uploaded() {
        String text = Hooks.driver.findElement(By.id("uploaded-files")).getText();
        Assert.assertTrue(text.contains("testfile.txt"));
    }
}

