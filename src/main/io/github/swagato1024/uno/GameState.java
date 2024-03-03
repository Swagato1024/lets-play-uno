package io.github.swagato1024.uno;

import io.github.swagato1024.uno.unocard.Card;

import java.util.ArrayList;

public class GameState {
  private final boolean isGameOver;
  private Card cardOnTop;
  private Player currentPlayer;

  public GameState(Card cardOnTop, Player currentPlayer, boolean isGameOver) {
    this.cardOnTop = cardOnTop;
    this.currentPlayer = currentPlayer;
    this.isGameOver = isGameOver;
  }

  public Card getCardOnTop() {
    return cardOnTop;
  };

  public Player getCurrentPlayer() {
    return currentPlayer;
  }

  public ArrayList<Card> getCurrentPlayerHand() {
    return this.currentPlayer.getCardsInHand();
  }

  public String getCurrentPlayerName() {
    return this.currentPlayer.getName();
  }

  public boolean isGameOver() {
    return this.isGameOver;
  }
}
