Feature: Get Booking
  Scenario: User should see valid response when user sends valid id
    Given User sets the "bookingId" path as 1
    When user sends a request to "/booking/{bookingId}"
    Then user should see expected record
  Scenario:User should see invalid response when user sends valid id as String
