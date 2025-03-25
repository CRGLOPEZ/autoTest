package com.gtc;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;

public class autoTest {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void testSeleniumDocumentation() throws IOException {
        driver.get("https://www.selenium.dev/documentation/");


        // Captura de pantalla de la documentación
        takeScreenshot("selenium_documentation.png");

        // Navegar por los elementos del menú lateral
        List<WebElement> menus = driver.findElements(By.cssSelector("#m-documentation-li > ul"));
        for(WebElement menu : menus){
            menu.click();
            try {
            Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            takeScreenshot(menu.getText() + " .png");

        }
    }

    private void takeScreenshot(String fileName) throws IOException {
        File srcFile = ((ChromeDriver) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File("screenshots/" + fileName));
    }

    @AfterClass
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}