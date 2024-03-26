Feature: Load Testing API

  Background:
      url 'http://localhost:8000/'

  @local
  Scenario: Send HTTP GET local data
    Given path 'test'
    And param foo = 'bar'
    When method get
    Then status 200
