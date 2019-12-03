package com.codecool.zopcsak.adam.POM.tests;

import com.codecool.zopcsak.adam.POM.pages.InputForm;
import com.codecool.zopcsak.adam.POM.pages.SE_HomePage;
import com.codecool.zopcsak.adam.POM.pages.SE_SelectDropdownList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.Assert.*;

public class SelectListTest extends BaseTest {
    SE_SelectDropdownList selectDropdownListPage;


    @BeforeEach
    public void setupForDropdownListTest() {
        homePage = new SE_HomePage(driver);
        selectDropdownListPage = new SE_SelectDropdownList(driver);
        homePage.navigate(InputForm.SELECT_DROPDOWN_LIST);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/dropdown.csv")
    public void testIfDropdownSelectIsCorrect(String day, String expectedOutput) {
        selectDropdownListPage.writeToDropdown(day);
        assertEquals(expectedOutput, selectDropdownListPage.getSelectedValueText());
    }

    @Test
    public void testDayPickingWithMouse() {
        selectDropdownListPage.pickADayFromDropdown(selectDropdownListPage.getWednesdayFromDropdown());
        assertEquals("Day selected :- Wednesday", selectDropdownListPage.getSelectedValueText());
    }

    @Test
    public void testDayPickingWithArrowButtons() {
        selectDropdownListPage.hitDownArrowOnDropdown();
        assertEquals("Day selected :- Sunday", selectDropdownListPage.getSelectedValueText());

        selectDropdownListPage.hitRightArrowOnDropdown();
        assertEquals("Day selected :- Monday", selectDropdownListPage.getSelectedValueText());
    }

}
