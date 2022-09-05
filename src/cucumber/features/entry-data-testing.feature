Feature: Testing entry data
  Scenario Outline: Testing login with introducing potentially unaccepted data on several sites
    Given Opened and maximized browse
    When first site is opened
    Then user is redirected to creating account page
    And potentially unaccepted data is introduced <firstName> <lastName> <email> <password> <repeatPassword>
    And browser is  closed

    Examples:
    | firstName         | lastName       | email            | password                                    | repeatPassword          |
    | 012whoaccepts     | digitsinname   | np&zsz           | mni3J)                                      | mni3J)                  |
    | @@@shouldbenot    | possible       | 123abrakadabra   | zdecydowanie nie powinno byc w hasle spacji | i powinny sie match     |
    | Takiebedzieokej   | Hejka          | c@tsarecute      | Tutajbedzi3p@prawne                         | Tutajbedzi3p@prawne     |
    | SQLiniection      | DragonLordy    | sucharyzkieszeni | insert myname into user;                    | drop database;          |
