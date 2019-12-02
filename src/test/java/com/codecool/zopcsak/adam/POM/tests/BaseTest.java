package com.codecool.zopcsak.adam.POM.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class BaseTest {
    public WebDriver driver;

    @BeforeEach
    public void setup(){
        System.setProperty("webdriver.chrome.driver", getBasePathForDriver() + "/src/main/resources/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterEach
    public void closeDriver() {
        driver.quit();
    }

    private String getBasePathForDriver() {
        String basePath;
        try {
            basePath = new File("./").getCanonicalPath();
        } catch (IOException e) {
            basePath = "Driver not found";
            System.err.println(basePath);
            e.printStackTrace();
        }
        return basePath;
    }

}
