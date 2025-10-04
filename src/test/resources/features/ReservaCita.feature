Feature: Booking Appointments on JQuery Datepicker

  Scenario: Book an appointment by selecting a date in the calendar
    Given the user is on the JQuery Datepicker page
    When the user selects day "15" of the current month
    Then the user should see the day "15" in the selected date

  Scenario: Select a specific date in a different month
    Given the user is on the JQuery Datepicker page
    When the user selects day "10" of the next month
    Then the user should see the day "10" in the selected date

  Scenario: Validate the date field is blocked for manual input
    Given the user is on the JQuery Datepicker page
    Then the date field should be blocked for manual editing