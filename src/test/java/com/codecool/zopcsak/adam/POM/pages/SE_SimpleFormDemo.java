package com.codecool.zopcsak.adam.POM.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SE_SimpleFormDemo extends BasePage {

    @FindBy(tagName = "h3")
    public WebElement pageHeader;

    public SE_SimpleFormDemo(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getPageHeaderText() {
        return pageHeader.getText();
    }

}
