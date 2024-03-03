package io.github.swagato1024.uno.cardManagment;

import io.github.swagato1024.uno.unocard.Card;
import io.github.swagato1024.uno.unocard.CardGenerator;

import java.util.ArrayList;
public class Deck implements drawable {
  private final ArrayList<Card> cardsInDeck;
  private final ArrayList<Card> discardPile;
  public Deck() {
    this.cardsInDeck = CardGenerator.generateCard();
    this.discardPile = new ArrayList<>();
  }
  public void addToDiscard(Card c) {
    this.discardPile.add(c);
  }
  public Card draw() {
    return  this.cardsInDeck.remove(0);
  }
}
