package hooks;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.*;

import java.io.File;
import java.nio.file.Files;

public class Hooks {

    public static WebDriver driver;

    @Before
    public void launchBrowser() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

  
    @AfterStep
    public void waitAfterEachStep() throws InterruptedException {
        Thread.sleep(4000);
    }

  
    @After
    public void closeBrowser(Scenario scenario) {

        if (scenario.isFailed()) {
            try {
                TakesScreenshot ts = (TakesScreenshot) driver;
                File source = ts.getScreenshotAs(OutputType.FILE);

                File destination = new File(
                        "target/screenshots/" +
                        scenario.getName().replace(" ", "_") + ".png"
                );

                destination.getParentFile().mkdirs();
                Files.copy(source.toPath(), destination.toPath());

                
                scenario.attach(
                        Files.readAllBytes(destination.toPath()),
                        "image/png",
                        "Failed Screenshot"
                );

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        driver.quit();
    }
}

