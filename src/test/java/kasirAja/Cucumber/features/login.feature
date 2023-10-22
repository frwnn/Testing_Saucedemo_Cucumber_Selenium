Feature: Login page Aplikasi kasirAja

  Scenario: Success Login
    Given Halaman login kasirAja
    When Input username
    And Input password
    And Click login button
    Then User on dashboard page

    Scenario: Failed Login
      Given Halaman login kasirAja
      When Input username
      And Input invalid password
      And Click login button
      Then User get error message