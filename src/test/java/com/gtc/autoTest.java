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

        // Navegar por los elementos del menú lateral si busco funcionabilidad
        WebElement element = driver.findElement(By.xpath("//*[@id=\"m-documentationoverview\"]"));
        element.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        takeScreenshot("Overview.png");

        WebElement element1 = driver.findElement(By.xpath("//*[@id='m-documentationwebdriver']"));
        element1.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        takeScreenshot("WebDrive.png");

        WebElement element2 = driver.findElement(By.xpath("//*[@id='m-documentationselenium_manager']"));
        element2.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        takeScreenshot("Selenium Manager.png");

        WebElement element3 = driver.findElement(By.xpath("//*[@id='m-documentationgrid']"));
        element3.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        takeScreenshot("Grid.png");


        WebElement element4 = driver.findElement(By.xpath("//*[@id='m-documentationie_driver_server']"));
        element4.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        takeScreenshot("IE Driver Server.png");


        WebElement element5 = driver.findElement(By.xpath("//*[@id='m-documentationide']"));
        element5.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        takeScreenshot("IDE.png");

        WebElement element6 = driver.findElement(By.xpath("//*[@id='m-documentationtest_practices']"));
        element6.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        takeScreenshot("Practices.png");

        WebElement element7 = driver.findElement(By.xpath("//*[@id='m-documentationlegacy']"));
        element7.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        takeScreenshot("Legacy.png");

        WebElement element8 = driver.findElement(By.xpath("//*[@id='m-documentationabout']"));
        element8.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        takeScreenshot("About.png");
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