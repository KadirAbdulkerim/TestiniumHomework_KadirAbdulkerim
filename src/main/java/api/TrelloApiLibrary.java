package api;


import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Kadirdan Abdukerim
 * @create 2022-10-08-8:31 PM
 */
public class TrelloApiLibrary {
    String baseURI = "https://api.trello.com";
    String authKey = "cbd92e0f2a934d5836799e38afeb2f62";
    String authToken = "701ee43cc59229680aea931cc8dd22068ecbb8eda8b9abed13a2522470f9c96c";

    public String createBoardGetId(String boardName) {
        String newBoardId = null;
        Response response = RestAssured.given().headers("Content-Type", "application/json")
                .queryParam("key", authKey)
                .queryParam("token", authToken)
                .queryParam("name", boardName)
                .post(baseURI + "/1/boards/").then().extract().response();
        int responseCode = response.getStatusCode();
        if (responseCode == 200) {
            newBoardId = response.jsonPath().getString("id");
            ApiResponseDateHolder.setBoardId(newBoardId);
            ApiResponseDateHolder.setBoardResponseCode(200);
        }
        return newBoardId;
    }

    public String addListToBoard(String boardId, String listName) {
        String newListId = null;
        Response response = RestAssured.given().headers("Content-Type", "application/json")
                .queryParam("key", authKey)
                .queryParam("token", authToken)
                .queryParam("name", listName)
                .post(baseURI + "/1/boards/" + boardId + "/lists").then().extract().response();
        int responseCode = response.getStatusCode();
        if (responseCode == 200) {
            newListId = response.jsonPath().getString("id");
            ApiResponseDateHolder.setListId(newListId);
            ApiResponseDateHolder.setListIdResponseCode(200);
        }
        return newListId;
    }

    public List<String> addCardToList(String listId, List<String> cardNames) {
        List<String> cardIds = new ArrayList<>();
        for (String cardName : cardNames) {
            Response response = RestAssured.given().headers("Content-Type", "application/json")
                    .queryParam("key", authKey)
                    .queryParam("token", authToken)
                    .queryParam("idList", listId)
                    .queryParam("name", cardName)
                    .post(baseURI + "/1/cards/").then().extract().response();
            int responseCode = response.getStatusCode();
            if (responseCode == 200) {
                cardIds.add(response.jsonPath().getString("id"));
                ApiResponseDateHolder.setCardIds(cardIds);
                ApiResponseDateHolder.setCardResponseCode(200);
            }
        }
        return cardIds;
    }

    public String updateCardName(String cardId, String newCardName) {
        String newNameInResponse = null;
        Response response = RestAssured.given().headers("Content-Type", "application/json")
                .queryParam("key", authKey)
                .queryParam("token", authToken)
                .queryParam("name", newCardName)
                .put(baseURI + "/1/cards/" + cardId).then().extract().response();
        int responseCode = response.getStatusCode();
        if (responseCode == 200) {
            newNameInResponse = (response.jsonPath().getString("name"));
            ApiResponseDateHolder.setNewCardName(newNameInResponse);
            ApiResponseDateHolder.setNewCardResponseCode(200);
        }
        return newNameInResponse;
    }

    public int deleteCards(List<String> cardsId) {
        int responseCount = 0;
        for (String eachCardId : cardsId) {
            Response response = RestAssured.given().headers("Content-Type", "application/json")
                    .queryParam("key", authKey)
                    .queryParam("token", authToken)
                    .delete(baseURI + "/1/cards/" + eachCardId).then().extract().response();
            int responseCode = response.getStatusCode();
            if (responseCode == 200) {
                responseCount++;
                ApiResponseDateHolder.setCardDeleteResponseCode(200);
            }
        }
        return responseCount;
    }

    public int deleteBoard(String boardId) {
        Response response = RestAssured.given().headers("Content-Type", "application/json")
                .queryParam("key", authKey)
                .queryParam("token", authToken)
                .delete(baseURI + "/1/boards/" + boardId).then().extract().response();
        return response.getStatusCode();
    }
}
