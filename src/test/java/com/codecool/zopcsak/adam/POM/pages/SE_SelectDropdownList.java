package com.codecool.zopcsak.adam.POM.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SE_SelectDropdownList extends BasePage {

    @FindBy(tagName = "h3")
    private WebElement pageHeader;

    @FindBy(id = "select-demo")
    private WebElement dropdown;

    @FindBy(css = "p[class='selected-value']")
    private WebElement selectedValue;

    @FindBy(css = "option[value='Wednesday']")
    private WebElement wednesdayFromDropdown;

    public SE_SelectDropdownList(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getPageHeaderText() {
        return pageHeader.getText();
    }

    public String getSelectedValueText() {
        return selectedValue.getText();
    }

    public void writeToDropdown(String text) {
        dropdown.sendKeys(text, Keys.ENTER);;
    }

    public void pickADayFromDropdown(WebElement day) {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        dropdown.click();
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        day.click();
    }

    public WebElement getWednesdayFromDropdown() {
        return wednesdayFromDropdown;
    }

    public void hitRightArrowOnDropdown() {
        dropdown.sendKeys(Keys.RIGHT);
    }

    public void hitDownArrowOnDropdown() {
        dropdown.sendKeys(Keys.DOWN);
    }

}
