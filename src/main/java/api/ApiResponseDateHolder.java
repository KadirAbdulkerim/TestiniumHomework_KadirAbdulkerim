package api;

import java.util.List;

/**
 * @author Kadirdan Abdukerim
 * @create 2022-10-08-11:06 PM
 */
public class ApiResponseDateHolder {
    static String boardId;
    static int boardResponseCode;
    static String listId;
    static int listIdResponseCode;
    static List<String> cardIds;
    static int cardResponseCode;
    static String newCardName;
    static int newCardResponseCode;
    static int cardDeleteResponseCode;

    public static int getNewCardResponseCode() {
        return newCardResponseCode;
    }

    public static void setNewCardResponseCode(int newCardResponseCode) {
        ApiResponseDateHolder.newCardResponseCode = newCardResponseCode;
    }

    public static String getNewCardName() {
        return newCardName;
    }

    public static void setNewCardName(String newCardName) {
        ApiResponseDateHolder.newCardName = newCardName;
    }

    public static String getBoardId() {
        return boardId;
    }

    public static void setBoardId(String boardId) {
        ApiResponseDateHolder.boardId = boardId;
    }

    public static int getBoardResponseCode() {
        return boardResponseCode;
    }

    public static void setBoardResponseCode(int boardResponseCode) {
        ApiResponseDateHolder.boardResponseCode = boardResponseCode;
    }

    public static String getListId() {
        return listId;
    }

    public static void setListId(String listId) {
        ApiResponseDateHolder.listId = listId;
    }

    public static int getListIdResponseCode() {
        return listIdResponseCode;
    }

    public static void setListIdResponseCode(int listIdResponseCode) {
        ApiResponseDateHolder.listIdResponseCode = listIdResponseCode;
    }

    public static List<String> getCardIds() {
        return cardIds;
    }

    public static void setCardIds(List<String> cardIds) {
        ApiResponseDateHolder.cardIds = cardIds;
    }

    public static int getCardResponseCode() {
        return cardResponseCode;
    }

    public static void setCardResponseCode(int cardResponseCode) {
        ApiResponseDateHolder.cardResponseCode = cardResponseCode;
    }

    public static int getCardDeleteResponseCode() {
        return cardDeleteResponseCode;
    }

    public static void setCardDeleteResponseCode(int cardDeleteResponseCode) {
        ApiResponseDateHolder.cardDeleteResponseCode = cardDeleteResponseCode;
    }
}
