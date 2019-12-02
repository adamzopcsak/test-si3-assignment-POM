package com.codecool.zopcsak.adam.POM.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public abstract class BasePage {
    String url = "https://www.seleniumeasy.com/test/";
    WebDriver driver;

    public BasePage(){}

    BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);
    }

    public abstract String getPageHeaderText();

}
