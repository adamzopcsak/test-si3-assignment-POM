package com.codecool.zopcsak.adam.POM.tests;

import com.codecool.zopcsak.adam.POM.pages.InputForm;
import com.codecool.zopcsak.adam.POM.pages.SE_SimpleFormDemo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.Assert.*;

public class TwoFieldsAndOutputTest extends BaseTest {
    SE_SimpleFormDemo simpleFormDemoPage;

    @BeforeEach
    public void setupForTwoFieldsAndOutputTest() {
        this.simpleFormDemoPage = new SE_SimpleFormDemo(driver);
        homePage.navigate(InputForm.SIMPLE_FORM_DEMO);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/TwoFieldsAndOutput.csv")
    public void testTwoFieldsAndOutput(String input1, String input2, String expectedOutput) {
        simpleFormDemoPage.writeToMultipleInputFields(input1, input2);
        assertEquals(expectedOutput, simpleFormDemoPage.getDisplayValueText());
    }

}
