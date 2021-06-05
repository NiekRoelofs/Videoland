Feature: Movie test

  Scenario: Ophalen van movies geeft status 200
    When Ik alle movies ophaal
    Then Is de status van het request 200

  Scenario: Het ophalen van alle movies is een lijst
    When Ik alle movies ophaal
    Then Krijg ik een lijst terug van 3 movies

