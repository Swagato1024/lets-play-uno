package io.github.swagato1024.uno.unocard;

import java.util.ArrayList;

public class CardGenerator {
  public static ArrayList<Card> generateCard() {
    ArrayList<Card> deck = new ArrayList<>();

    // Create cards for each color and number
    for (CardColor color : CardColor.values()) {
      for (int number = 0; number <= 9; number++) {
        deck.add(new Card(color, number));
        if (number != 0) {
          deck.add(new Card(color, number));
        }
      }

      // Create special action cards
      deck.add(new Card(color, CardType.SKIP));
      deck.add(new Card(color, CardType.SKIP));
      deck.add(new Card(color, CardType.REVERSE));
      deck.add(new Card(color, CardType.REVERSE));
      deck.add(new Card(color, CardType.DRAW_TWO));
      deck.add(new Card(color, CardType.DRAW_TWO));
    }

    // Create wild cards
    deck.add(new Card(CardColor.NONE, CardType.WILD));
    deck.add(new Card(CardColor.NONE, CardType.WILD));
    deck.add(new Card(CardColor.NONE, CardType.WILD_D4));
    deck.add(new Card(CardColor.NONE, CardType.WILD_D4));

    return deck;
  }
}

