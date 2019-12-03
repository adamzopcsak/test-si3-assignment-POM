package com.codecool.zopcsak.adam.POM.tests;

import com.codecool.zopcsak.adam.POM.pages.SE_HomePage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class BaseTest {
    protected WebDriver driver;
    protected SE_HomePage homePage;

    @BeforeEach
    public void setup(){
        System.setProperty("webdriver.chrome.driver", getBasePath() + "/src/main/resources/chromedriver");
        driver = new ChromeDriver();
        homePage = new SE_HomePage(driver);
        driver.manage().window().maximize();
    }

    @AfterEach
    public void closeDriver() {
        driver.quit();
    }

    private String getBasePath() {
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
