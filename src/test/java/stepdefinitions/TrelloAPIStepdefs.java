package stepdefinitions;

import api.ApiResponseDateHolder;
import api.TrelloApiLibrary;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @author Kadirdan Abdukerim
 * @create 2022-10-08-10:52 PM
 */
public class TrelloAPIStepdefs {

    TrelloApiLibrary trelloApiLibrary = new TrelloApiLibrary();
    String boardId;
    String listId;
    List<String> cardIds;
    String updatedCardName;
    int totalDeleteCounts;
    int boardDeleteResponseCode;

    @When("user sends a post request to create a new board")
    public void theUserSendsAPostRequestToCreateANewBoard() {

        boardId = trelloApiLibrary.createBoardGetId("TestBoard" + System.currentTimeMillis());
        System.out.println("boardId = " + boardId);
        Assert.assertNotNull(boardId);
    }

    @Then("the api should return {int} response code")
    public void theApiShouldReturnResponseCode(int expectedCode) {
        Assert.assertEquals(ApiResponseDateHolder.getBoardResponseCode(), expectedCode);
    }

    @And("the api should create a new board")
    public void theApiShouldCreateANewBoard() {
        Assert.assertNotNull(ApiResponseDateHolder.getBoardId());
    }

    @When("user sends a post request to create add a list to the board")
    public void theUserSendsAPostRequestToCreateAddAListToTheBoard() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        listId = trelloApiLibrary.addListToBoard(boardId,"TestList");
        System.out.println("listId = " + listId);
        Assert.assertNotNull(listId);
    }

    @Then("the api should return {int} response code to the add list method")
    public void theApiShouldReturnResponseCodeToTheAddListMethod(int expectedCode) {
        Assert.assertEquals(ApiResponseDateHolder.getListIdResponseCode(), expectedCode);
    }

    @And("the api should create a new list on the board")
    public void theApiShouldCreateANewListOnTheBoard() {
        Assert.assertNotNull(ApiResponseDateHolder.getListId());
    }

    @When("user sends a post request to add cards to the list")
    public void theUserSendsAPostRequestToAddCardsToTheList() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        cardIds = trelloApiLibrary.addCardToList(listId, Arrays.asList("TestCard1", "TestCard2"));
        for (String cardId : cardIds) {
            System.out.println("card id: " + cardId);
            Assert.assertNotNull(cardId);
        }
    }

    @Then("the api should return {int} response code to the add card method")
    public void theApiShouldReturnResponseCodeToTheAddCardMethod(int expectedCode) {
        Assert.assertEquals(ApiResponseDateHolder.getCardResponseCode(), expectedCode);
    }

    @And("the api should create cards on the list")
    public void theApiShouldCreateCardsOnTheList() {
        Assert.assertNotNull(ApiResponseDateHolder.getCardIds().get(0));
    }

    @When("user sends a put request to update a card with a new name")
    public void theUserSendsAPutRequestToUpdateACardWithANewName() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //trelloApiLibrary = new TrelloApiLibrary();
        Random random = new Random();
        updatedCardName = trelloApiLibrary.updateCardName(cardIds.get(random.nextInt(1)), "NweCard");
        System.out.println("updatedCardName = " + updatedCardName);
    }

    @Then("the api should return {int} response code for the update card method")
    public void theApiShouldReturnResponseCodeForTheUpdateCardMethod(int expectedCode) {
        Assert.assertEquals(ApiResponseDateHolder.getNewCardResponseCode(), expectedCode);
    }

    @And("the api should update the card name")
    public void theApiShouldUpdateTheCardName() {
        Assert.assertEquals(ApiResponseDateHolder.getNewCardName(),"NweCard");
    }

    @When("user sends a delete request to delete the cards")
    public void theUserSendsADeleteRequestToDeleteTheCards() {
        //trelloApiLibrary = new TrelloApiLibrary();
        totalDeleteCounts = trelloApiLibrary.deleteCards(cardIds);
        System.out.println("Total cards deleted: " + totalDeleteCounts);
    }

    @Then("the api should return {int} response code for the card delete method")
    public void theApiShouldReturnResponseCodeForTheCardDeleteMethod(int expectedCode) {
        Assert.assertEquals(ApiResponseDateHolder.getCardDeleteResponseCode(), expectedCode);
    }

    @When("user sends a delete request to delete a board")
    public void theUserSendsADeleteRequestToDeleteABoard() {
        //trelloApiLibrary = new TrelloApiLibrary();
        boardDeleteResponseCode = trelloApiLibrary.deleteBoard(boardId);
        System.out.println("Board Delete response code " + boardDeleteResponseCode);
    }

    @Then("the api should return {int} response code for the delete board method")
    public void theApiShouldReturnResponseCodeForTheDeleteBoardMethod(int expectedCode) {
        Assert.assertEquals(boardDeleteResponseCode,expectedCode);
    }
}
