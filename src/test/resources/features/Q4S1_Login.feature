@Q4S1
Feature: Login

  @LoginOk
  Scenario Outline: iniciar sesion con dni, de manera exitosa
    Given usuario establece sus datos "<codigo>"
    When ingreso al app
    Then verifico estatus code
    Examples:
      | codigo    |
      | 1-1Hoja-1 |
      | 1-1Hoja-2 |
      | 1-1Hoja-4 |