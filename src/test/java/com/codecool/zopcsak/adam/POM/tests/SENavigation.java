package com.codecool.zopcsak.adam.POM.tests;

import com.codecool.zopcsak.adam.POM.enums.InputForm;
import com.codecool.zopcsak.adam.POM.pages.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.Assert.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class SENavigation extends BaseTest {
    private SE_HomePage homePage;

    @BeforeEach
    void initObjects() {
        this.homePage = new SE_HomePage(driver);
    }

    @ParameterizedTest
    @MethodSource("getInputFormsForTest")
    void testNavigation(InputForm inputForm, String expectedPageHeader) {
        homePage.navigate(inputForm);
        String actualHeader;

        switch(inputForm) {
            case SIMPLE_FORM_DEMO:
                SE_SimpleFormDemo simpleFormDemoPage = new SE_SimpleFormDemo(driver);
                actualHeader = simpleFormDemoPage.getPageHeaderText();
                break;
            case CHECKBOX_DEMO:
                SE_CheckboxDemo checkboxDemoPage = new SE_CheckboxDemo(driver);
                actualHeader = checkboxDemoPage.getPageHeaderText();
                break;
            case RADIO_BUTTONS_DEMO:
                SE_RadioButtonsDemo radioButtonsDemoPage = new SE_RadioButtonsDemo(driver);
                actualHeader = radioButtonsDemoPage.getPageHeaderText();
                break;
            case SELECT_DROPDOWN_LIST:
                SE_SelectDropdownList selectDropdownListPage = new SE_SelectDropdownList(driver);
                actualHeader = selectDropdownListPage.getPageHeaderText();
                break;
            case INPUT_FORM_SUBMIT:
                SE_InputFormSubmit inputFormSubmitPage = new SE_InputFormSubmit(driver);
                actualHeader = inputFormSubmitPage.getPageHeaderText();
                break;
            case AJAX_FORM_SUBMIT:
                SE_AjaxFormSubmit ajaxFormSubmitPage = new SE_AjaxFormSubmit(driver);
                actualHeader = ajaxFormSubmitPage.getPageHeaderText();
                break;
            case JQUERY_SELECT:
                SE_JQuerySelectDropdown jQuerySelectDropdownPage = new SE_JQuerySelectDropdown(driver);
                actualHeader = jQuerySelectDropdownPage.getPageHeaderText();
                break;
            default:
                actualHeader = "Couldn't find the header on this page...";
        }

        assertEquals(expectedPageHeader, actualHeader);
    }

    private Stream<Arguments> getInputFormsForTest() {
        return Stream.of(
                Arguments.of(InputForm.SIMPLE_FORM_DEMO, "This would be your first example to start with Selenium."),
                Arguments.of(InputForm.CHECKBOX_DEMO, "This would be a basic example to start with checkboxes using selenium."),
                Arguments.of(InputForm.RADIO_BUTTONS_DEMO, "This is again simple example to start working with radio buttons using Selenium."),
                Arguments.of(InputForm.SELECT_DROPDOWN_LIST, "This would be your first example on select dropd down list to with Selenium."),
                Arguments.of(InputForm.INPUT_FORM_SUBMIT, "Input form with validations"),
                Arguments.of(InputForm.AJAX_FORM_SUBMIT, "Ajax Form Submit with Loading icon"),
                Arguments.of(InputForm.JQUERY_SELECT, "Single Select - Search and Select country")
        );
    }

}
