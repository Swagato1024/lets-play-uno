package io.github.swagato1024.uno;

import io.github.swagato1024.uno.unocard.Card;
import io.github.swagato1024.uno.unocard.CardColor;
import io.github.swagato1024.uno.unocard.CardType;

import java.util.ArrayList;

public class View {
  private GameState gameState;

  public String formatCard(Card card) {
    CardType cardType = card.getType();
    Integer cardNumber = card.getNumber();
    CardColor cardColor = card.getColor();

    return "Type: " + cardType +
            " Color: " + cardColor +
            " Number: " + cardNumber ;
  }

  public String formatCardOnTop() {
    Card cardOnTop = gameState.getCardOnTop();
    return "Card On Top: " + formatCard(cardOnTop);
  }
  public String formatCardsInHand() {
    ArrayList<Card> cardsInHand = new ArrayList<>(this.gameState.getCurrentPlayerHand());

    String strigifiedCardsInHand = "\n-1 -> draw Card \n";
    int cardCount = 0;

    for(Card card: cardsInHand) {
      strigifiedCardsInHand += cardCount;
      strigifiedCardsInHand += " -> ";
      strigifiedCardsInHand += formatCard(card);
      strigifiedCardsInHand += "\n";

      cardCount++;
    }

    return strigifiedCardsInHand;
  }

  public String formatCurrentPlayerName() {
    return this.gameState.getCurrentPlayerName() +
            "'s Turn \n";
  }

  public void render(GameState gameState) {
    this.gameState = gameState;
    String currentPlayerName = formatCurrentPlayerName();
    String cardOnTop = formatCardOnTop();
    String cardsInHand = formatCardsInHand();

    System.out.println(currentPlayerName + cardOnTop + cardsInHand);
  }
}
