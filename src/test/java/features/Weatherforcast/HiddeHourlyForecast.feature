  @all @hide
  Feature: As a User Select day twice, hides 3 hourly forecast

  As a weather forecast Customer,if i enter city name, and if i select day, get 3 hourly forecast.

  Scenario Outline: Select day, get 3 hourly forecast

    Given launch weather forecast application
    When i enter city name:"<city>"
    When i click on day:"<day>"
    When i click on day:"<day>"
    Then i should see 3 hourly forecast hidden:"<day>"
    Then i close the weather forecast application

    Examples:
      |city      |day|
      |Edinburgh |3   |



