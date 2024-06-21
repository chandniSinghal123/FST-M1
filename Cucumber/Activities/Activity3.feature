@activity3
Feature: Testing with Tags


  @SimpleAlert @SmokeTest
  Scenario: Testing with Simple Alert
  GIVEN: User is on the page
  WHEN: User clicks the Simple Alert button
  THEN: Alert opens
  AND: Read the text from it and print it
  AND: Close the alert
  AND: Read the result text
  AND: Close Browser
  @ConfirmAlert
  Scenario: Testing with Confirm Alert
  GIVEN: User is on the page
  WHEN: User clicks the Confirm Alert button
  THEN: Alert opens
  AND: Read the text from it and print it
  AND: Close the alert with Cancel
  AND: Read the result text
  AND: Close Browser
  @PromptAlert
  Scenario: Testing with Prompt Alert
  GIVEN: User is on the page
  WHEN: User clicks the Prompt Alert button
  THEN: Alert opens
  AND: Read the text from it and print it
  AND: Write a custom message in it
  AND: Close the alert
  AND: Read the result text
  AND: Close Browser