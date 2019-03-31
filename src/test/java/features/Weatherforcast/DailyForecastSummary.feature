@all @dailyforecaste
Feature: As a user i could able to see daily forecast should displays into 3 hour data

  As a weather forecast Customer, if i enter the city  , i should get 5 days weather forecast

  Scenario Outline: generate 5 day weather forecast by entering valid city name

    Given launch weather forecast application
    When i enter city name:"<city>"
    Then i see 5 days weather forecast
    Then i see each day forecast shows the most dominent details
    Then i close the weather forecast application


    Examples:

      |city  |
      |Edinburgh |


