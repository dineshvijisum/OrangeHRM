@Leave
Feature: Apply Leave
Scenario: Apply leavefor employee
When Click the Apply tab
Given the leave type "strindsds"
And enter the From and To date
And choose the duration
And enter the comments 
And click the save btn


Scenario: choose the To date before from date
    When Click the Apply tab
    Given the leave type "gyhbhj"
    And enter the From and To date
    And choose the duration
    And enter the comments
    And click the save btn
    Then user should see the error