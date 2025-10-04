package com.sqa.stepdefinitions;

import static org.junit.Assert.assertTrue;

import com.sqa.pages.DatepickerPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DatepickerSteps {

    DatepickerPage datepickerPage;

    @Given("the user is on the JQuery Datepicker page")
    public void theUserIsOnTheJQueryDatepickerPage() {
        datepickerPage.open();
    }

    @When("the user selects day {string} of the current month")
    public void theUserSelectsDayOfTheCurrentMonth(String day) {
        datepickerPage.switchToIframe();
        datepickerPage.openCalendar();
        datepickerPage.selectDay(day);
    }

    @When("the user selects day {string} of the next month")
    public void theUserSelectsDayOfTheNextMonth(String day) {
        datepickerPage.switchToIframe();
        datepickerPage.openCalendar();
        datepickerPage.navigateToNextMonth();
        datepickerPage.selectDay(day);
    }

    @Then("the user should see the day {string} in the selected date")
    public void theUserShouldSeeTheDayInTheSelectedDate(String expectedDay) {
        String selectedDate = datepickerPage.getSelectedDate();
        String expectedDateFragment = "/" + expectedDay + "/";
        assertTrue(
            "The selected date should contain '" + expectedDateFragment + "', but was: " + selectedDate,
            selectedDate.contains(expectedDateFragment)
        );
    }

@Then("the date field should be blocked for manual editing")
    public void theDateFieldShouldBeBlockedForManualEditing() {
        datepickerPage.switchToIframe();
        datepickerPage.verifyDateFieldIsBlocked();
    }

}