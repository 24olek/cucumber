Feature: Adding new adress on mystore
  Scenario Outline: After loggining on existing account, new adress is added
    Given opened browse
    When opened site
    Then User is logged. email <email> and password <password> are inserted
    And new adress alias <alias>
    And fuck cucumber firstname <firstname>, lastname <lastname>, company <company>
    And another adding , vat number <vat number>, adress <adress>, adress complemention <adress complement>
    And trolo city <city>, zip code <zip code>, country <country>, phone <phone> is added
    And address is checked <alias> <firstname> <lastname> <company> <vat number> <adress> <adress complement> <city> <zip code> <country> <phone>
    And address is deleted
    And address deletion is checked
    And browser is closed
    Examples:
    | email                              | password            | alias | firstname | lastname   | company | vat number | adress       | adress complement | city          | zip code | country         | phone     |
    | chomikdzungarski007@gmail.com      | takiesamojakemail   | NA    | Chomik    | Dzungarski | nw      | 99         | Pradotworcza | 66011             | Performancium | 660999   | United Kingdom  | 601601601 |
    | chomikdzungarski007@op.pl          | takiesamojakemail   | NA    | Chomik    | Dzungarski | nw      | 99         | Pradotworcza | 66011             | Performancium | 660999   | United Kingdom  | 601601601 |
    | chomikdzungarski007@buziaczek.pl   | takiesamojakemail   | NA    | Chomik    | Dzungarski | nw      | 99         | Pradotworcza | 66011             | Performancium | 660999   | United Kingdom  | 601601601 |
    | chomikdzungarski007@spoko.pl       | takiesamojakemail   | NA    | Chomik    | Dzungarski | nw      | 99         | Pradotworcza | 66011             | Performancium | 660999   | United Kingdom  | 601601601 |
    | chomikdzungarski007@vp.pl          | takiesamojakemail   | NA    | Chomik    | Dzungarski | nw      | 99         | Pradotworcza | 66011             | Performancium | 660999   | United Kingdom  | 601601601 |
    | chomikdzungarski007@autograf.pl    | takiesamojakemail   | NA    | Chomik    | Dzungarski | nw      | 99         | Pradotworcza | 66011             | Performancium | 660999   | United Kingdom  | 601601601 |
