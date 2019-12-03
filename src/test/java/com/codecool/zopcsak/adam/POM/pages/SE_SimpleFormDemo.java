package com.codecool.zopcsak.adam.POM.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SE_SimpleFormDemo extends BasePage {

    @FindBy(tagName = "h3")
    private WebElement pageHeader;

    @FindBy(id = "user-message")
    private WebElement singleTextInput;

    @FindBy(css = "button[type='button'][onclick='showInput();']")
    private WebElement showMessageButton;

    @FindBy(id = "display")
    private WebElement displayText;

    @FindBy(id = "sum1")
    private WebElement inputFieldSum1;

    @FindBy(id = "sum2")
    private WebElement inputFieldSum2;

    @FindBy(id = "displayvalue")
    private WebElement displayValue;

    @FindBy(css = "button[type='button'][onclick='return total()']")
    private WebElement getTotalBtn;

    public SE_SimpleFormDemo(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getPageHeaderText() {
        return pageHeader.getText();
    }


    public void writeToSingeTextInputField(String text) {
        singleTextInput.sendKeys(text);
        showMessageButton.click();
    }

    public String getDisplayText() {
        return displayText.getText();
    }

    public String getDisplayValueText() {
        return displayValue.getText();
    }

    public void writeToMultipleInputFields(String number1, String number2) {
        inputFieldSum1.sendKeys(number1);
        inputFieldSum2.sendKeys(number2);
        getTotalBtn.click();
    }
}
