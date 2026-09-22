@RecruitmentSearch
Feature: This to verify the recruitment search working or not
Scenario: This scenario for searching the recruitment details
Given the user is on the homepage rec
When the user is on home page click the Recuruitment btn
And choose the Job title"DDD"
And choose the vacancy"sas"
And choose the hiring manager "sda"
And choose the status "asd"
And choose the Date
And choose the ToDate
And click the search
And user get No Records Found then click add btn
And I upload the resume "C:\\Users\\dines\\Downloads\\ChoiceOrder_405635.pdf"