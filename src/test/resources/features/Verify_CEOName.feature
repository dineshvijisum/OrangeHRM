@GetCEOName
Feature: This feature is to get the CEO name from the application
Scenario Outline: Thistest is verify the CEO name
Given the user is logged in successfully and is on home page
When the user clicks on the directory option in the menu bar
And the user select the job title as "Cheif Executive Officer" from the dropdown using "text"
And clicks the search btn
Then the user should see  the CEO name as "<CEO_Name>"

Examples:
|CEO_Name|
|No Records Found|