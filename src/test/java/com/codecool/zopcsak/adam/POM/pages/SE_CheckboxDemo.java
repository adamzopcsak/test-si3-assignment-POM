package com.codecool.zopcsak.adam.POM.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SE_CheckboxDemo extends BasePage {

    @FindBy(tagName = "h3")
    private WebElement pageHeader;

    @FindBy(id = "isAgeSelected")
    private WebElement singleCheckbox;

    @FindBy(id = "txtAge")
    private WebElement singleCheckboxOutputText;

    @FindBy(className = "cb1-element")
    private List<WebElement> allCheckboxes;

    @FindBy(id = "check1")
    private WebElement checkBtn;

    public SE_CheckboxDemo(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getPageHeaderText() {
        return pageHeader.getText();
    }

    public void checkSingleCheckbox() {
        singleCheckbox.click();
    }

    public String getSingleCheckboxOutputText() {
        return singleCheckboxOutputText.getText();
    }

    public List<WebElement> getAllCheckboxes() {
        return allCheckboxes;
    }

    public String getCheckBtnText() {
        return checkBtn.getAttribute("value");
    }
}
