package com.codecool.zopcsak.adam.POM.tests;

import com.codecool.zopcsak.adam.POM.pages.InputForm;
import com.codecool.zopcsak.adam.POM.pages.SE_RadioButtonsDemo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.Assert.*;

public class RadioButtonsTest extends BaseTest {
    private SE_RadioButtonsDemo radioButtonsDemoPage;

    @BeforeEach
    public void setupRadioButtonsTest() {
        radioButtonsDemoPage = new SE_RadioButtonsDemo(driver);
        homePage.navigate(InputForm.RADIO_BUTTONS_DEMO);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/radioButtons.csv")
    public void testRadioButtons(String gender, String ageGroup, String expectedOutput) {
        radioButtonsDemoPage.clickRadioButtons(gender, ageGroup);
        assertEquals(expectedOutput, radioButtonsDemoPage.getValueText());
    }

}
