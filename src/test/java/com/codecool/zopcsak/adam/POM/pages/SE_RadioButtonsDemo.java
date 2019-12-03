package com.codecool.zopcsak.adam.POM.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SE_RadioButtonsDemo extends BasePage {

    @FindBy(tagName = "h3")
    private WebElement pageHeader;

    @FindBy(css = "input[type='radio'][value='Male'][name='gender']")
    private WebElement maleRadioBtn;

    @FindBy(css = "input[type='radio'][value='Female'][name='gender']")
    private WebElement femaleRadioBtn;

    @FindBy(css = "input[type='radio'][value='0 - 5'][name='ageGroup']")
    private WebElement ageBtn0_5;

    @FindBy(css = "input[type='radio'][value='5 - 15'][name='ageGroup']")
    private WebElement ageBtn5_15;

    @FindBy(css = "input[type='radio'][value='15 - 50'][name='ageGroup']")
    private WebElement ageBtn15_50;

    @FindBy(css = "p[class='groupradiobutton']")
    private WebElement valueText;

    @FindBy(css = "button[type='button'][class='btn btn-default'][onclick='getValues();']")
    private WebElement getValuesBtn;


    public SE_RadioButtonsDemo(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getPageHeaderText() {
        return pageHeader.getText();
    }

    public String getValueText() {
       return valueText.getText().replace("\n", " ");
    }

    public void clickOnRadioButton(WebElement radioButton) {
        radioButton.click();
    }

    public void clickRadioButtons(String gender, String ageGroup) {
        switch (gender) {
            case "Male":
                maleRadioBtn.click();
                break;
            case "Female":
                femaleRadioBtn.click();
                break;
        }

        switch (ageGroup) {
            case "0 - 5":
                ageBtn0_5.click();
                break;
            case "5 - 15":
                ageBtn5_15.click();
                break;
            case "15 - 50":
                ageBtn15_50.click();
                break;
        }

        getValuesBtn.click();
    }

}
