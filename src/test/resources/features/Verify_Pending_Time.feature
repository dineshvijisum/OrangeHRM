@TimeSheet
Feature: This feature is to get pending timesheet
Scenario: This test is verify the pending timesheet
Given the user is on the homepage
When the user clicks on the time option from the menu
And the user enters the name as "Thomas Kutty Benny" using dropdown "text"
And clicks on the view button
Then the user should see the message as "<message>"

Scenario: 
