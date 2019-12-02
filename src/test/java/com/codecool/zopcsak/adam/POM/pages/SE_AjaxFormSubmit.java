package com.codecool.zopcsak.adam.POM.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SE_AjaxFormSubmit extends BasePage {

    @FindBy(tagName = "h1")
    private WebElement pageHeader;

    public SE_AjaxFormSubmit(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getPageHeaderText() {
        return pageHeader.getText();
    }

}
