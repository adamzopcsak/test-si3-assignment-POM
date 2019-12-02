package com.codecool.zopcsak.adam.POM.pages;

import com.codecool.zopcsak.adam.POM.enums.InputForm;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class SE_HomePage extends BasePage {

    @FindBy(linkText = "Input Forms")
    private WebElement inputFormsMenu;

    @FindBy(linkText = "Simple Form Demo")
    private WebElement simpleFormDemoMenu;

    @FindBy(linkText = "Checkbox Demo")
    private WebElement checkboxDemoMenu;

    @FindBy(linkText = "Radio Buttons Demo")
    private WebElement radioButtonsDemoMenu;

    @FindBy(linkText = "Select Dropdown List")
    private WebElement selectDropdownListMenu;

    @FindBy(linkText = "Input Form Submit")
    private WebElement inputFormSubmitMenu;

    @FindBy(linkText = "Ajax Form Submit")
    private WebElement ajaxFormSubmitMenu;

    @FindBy(linkText = "JQuery Select dropdown")
    private WebElement jQuerySelectDropdownMenu;

    @FindBy(tagName = "h3")
    private WebElement pageHeader;

    public SE_HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getPageHeaderText() {
        return this.pageHeader.getText();
    }

    public void navigate(InputForm pageToNavigate) {
        driver.get(url);
        inputFormsMenu.click();
        switch(pageToNavigate) {
            case SIMPLE_FORM_DEMO:
                simpleFormDemoMenu.click();
                break;
            case CHECKBOX_DEMO:
                checkboxDemoMenu.click();
                break;
            case RADIO_BUTTONS_DEMO:
                radioButtonsDemoMenu.click();
                break;
            case SELECT_DROPDOWN_LIST:
                selectDropdownListMenu.click();
                break;
            case INPUT_FORM_SUBMIT:
                inputFormSubmitMenu.click();
                break;
            case AJAX_FORM_SUBMIT:
                ajaxFormSubmitMenu.click();
                break;
            case JQUERY_SELECT:
                jQuerySelectDropdownMenu.click();
                break;
        }
    }
}
