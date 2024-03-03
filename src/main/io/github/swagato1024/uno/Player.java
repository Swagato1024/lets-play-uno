package io.github.swagato1024.uno;

import io.github.swagato1024.uno.CardNotInHand;
import io.github.swagato1024.uno.unocard.Card;

import java.util.ArrayList;

public class Player {
  private final String name;
  private ArrayList<Card> cardsInHand;

  public Player(String name) {
    this.name = name;
    this.cardsInHand = new ArrayList<>();
  }

  public void addCard(Card drawnCard) {
    cardsInHand.add(drawnCard);
  }

  public Card placeCard(int cardIndex) throws CardNotInHand {
    if(cardIndex >= this.cardsInHand.size()) {
      throw new CardNotInHand();
    }

    return cardsInHand.remove(cardIndex);
  }

  public ArrayList<Card> getCardsInHand() {
    return new ArrayList<Card>(cardsInHand);
  }
  public String getName() {
    return name;
  }
}
