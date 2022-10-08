@Test
Feature: an authorized user should be able to add, updated and delete cards in the Trello board using API

  @ApiTest
  Scenario: an authorized user should be able to add, updated and delete cards
    When user sends a post request to create a new board
    Then the api should return 200 response code
    And the api should create a new board
    When user sends a post request to create add a list to the board
    Then the api should return 200 response code to the add list method
    And the api should create a new list on the board
    When user sends a post request to add cards to the list
    Then the api should return 200 response code to the add card method
    And the api should create cards on the list
    When user sends a put request to update a card with a new name
    Then the api should return 200 response code for the update card method
    And the api should update the card name
    When user sends a delete request to delete the cards
    Then the api should return 200 response code for the card delete method
    When user sends a delete request to delete a board
    Then the api should return 200 response code for the delete board method