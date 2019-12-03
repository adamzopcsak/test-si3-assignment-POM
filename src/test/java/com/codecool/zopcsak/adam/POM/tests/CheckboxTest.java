package com.codecool.zopcsak.adam.POM.tests;

import com.codecool.zopcsak.adam.POM.pages.InputForm;
import com.codecool.zopcsak.adam.POM.pages.SE_CheckboxDemo;
import com.codecool.zopcsak.adam.POM.pages.SE_HomePage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.Assert.*;

public class CheckboxTest extends BaseTest {
    SE_CheckboxDemo checkboxDemoPage;

    @BeforeEach
    public void setupForCheckboxTest() {
        this.checkboxDemoPage = new SE_CheckboxDemo(driver);
        homePage.navigate(InputForm.CHECKBOX_DEMO);
    }

    @Test
    public void testSingleCheckbox() {
        checkboxDemoPage.checkSingleCheckbox();
        assertEquals("Success - Check box is checked", checkboxDemoPage.getSingleCheckboxOutputText());
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/multipleCheckboxes.csv")
    public void testMultipleCheckboxes(String cb1, String cb2, String cb3, String cb4, String expectedOutput) {
        List<WebElement> allCheckboxes = checkboxDemoPage.getAllCheckboxes();
        clickSelectedCheckboxes(allCheckboxes, cb1, cb2, cb3, cb4);
        assertEquals(expectedOutput, checkboxDemoPage.getCheckBtnText());
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/singleCheckboxAndMultipleCheckboxes.csv")
    public void testSingleAndMultipleCheckboxes(String cb1, String cb2, String cb3, String cb4, String expectedOutput) {
        checkboxDemoPage.checkSingleCheckbox();
        List<WebElement> allCheckboxes = checkboxDemoPage.getAllCheckboxes();
        clickSelectedCheckboxes(allCheckboxes, cb1, cb2, cb3, cb4);
        assertEquals(expectedOutput, checkboxDemoPage.getCheckBtnText());
    }

    public void clickSelectedCheckboxes(List<WebElement> allCheckboxes, String cb1, String cb2, String cb3, String cb4) {
        for (int i = 0; i < allCheckboxes.size(); i++) {
            if (i == 0 && Integer.parseInt(cb1) > 0) {
                allCheckboxes.get(i).click();
            }
            if (i == 1 && Integer.parseInt(cb2) > 0) {
                allCheckboxes.get(i).click();
            }
            if (i == 2 && Integer.parseInt(cb3) > 0) {
                allCheckboxes.get(i).click();
            }
            if (i == 3 && Integer.parseInt(cb4) > 0) {
                allCheckboxes.get(i).click();
            }
        }
    }

}
