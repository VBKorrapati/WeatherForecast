@all @fiveday
Feature: As a User if i enter city name , i should able see 5 day weather forecast

  As a weather forecast Customer, if i enter the city  , i should get 5 days weather forecast

  Scenario Outline: generate 5 day weather forecast by entering valid city name

    Given launch weather forecast application
    When i enter city name:"<city>"
    Then i see 5 days weather forecast
    Then i close the weather forecast application


    Examples:

      |city  |
      |Edinburgh |


