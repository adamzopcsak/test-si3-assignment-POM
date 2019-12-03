package com.codecool.zopcsak.adam.POM.tests;

import com.codecool.zopcsak.adam.POM.pages.InputForm;
import com.codecool.zopcsak.adam.POM.pages.SE_SimpleFormDemo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.Assert.*;

public class SingleFieldAndButtonTest extends BaseTest {
    SE_SimpleFormDemo simpleFormDemoPage;

    @BeforeEach
    public void setupForSingleFieldAndButtonTest() {
        this.simpleFormDemoPage = new SE_SimpleFormDemo(driver);
        homePage.navigate(InputForm.SIMPLE_FORM_DEMO);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/SingleFieldAndButton.csv")
    void testSingleFieldAndButton(String inputText, String expectedOutput) {
        simpleFormDemoPage.writeToSingeTextInputField(inputText);
        assertEquals(expectedOutput, simpleFormDemoPage.getDisplayText());
    }

}
