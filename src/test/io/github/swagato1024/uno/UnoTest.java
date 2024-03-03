package io.github.swagato1024.uno;

import io.github.swagato1024.uno.*;
import io.github.swagato1024.uno.cardManagment.Deck;
import io.github.swagato1024.uno.unocard.Card;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static io.github.swagato1024.uno.unocard.CardColor.YELLOW;
import static org.junit.jupiter.api.Assertions.*;
class UnoTest {
 private Player bittu;
 private Player raj;
 private Players players;

  @BeforeEach
  public void setUpGame() {
    this.bittu = new Player("bittu");
    this.raj = new Player("raj");
    ArrayList <Player> participants = new ArrayList<>();
    participants.add(bittu);
    participants.add(raj);

    this.players = new Players(participants);
  }

  @Test
  void testPlayShouldThrowCardNotInHandException() {
    Card yellow_2 = new Card(YELLOW, 2);
    Deck deck = new Deck();
    Uno game = new Uno(players, deck, deck.draw());
    bittu.addCard(yellow_2);

    CardNotInHand thrown = assertThrows(CardNotInHand.class, () -> {
      game.play(2);
    }, "should be CardNotFound Exception");

    assertEquals("card not in hand", thrown.getMessage());
  }

  @Test
  void testPlayShouldChangeTurnAfterCardIsDrawn() throws UnplayableCardSelection, CardNotInHand {
    Card yellow_2 = new Card(YELLOW, 2);
    Card yellow_3 = new Card(YELLOW, 3);

    Deck deck = new Deck();
    Uno game = new Uno(players, deck, yellow_3);
    game.play(-1);
    assertEquals("raj", game.gameState().getCurrentPlayerName());
  }

  @Test
  void testPlayShouldPlaceTheSelectedCard() throws UnplayableCardSelection, CardNotInHand {
    Card yellow_2 = new Card(YELLOW, 2);
    Card yellow_3 = new Card(YELLOW, 3);

    Deck deck = new Deck();
    Uno game = new Uno(players, deck, yellow_3);
    bittu.addCard(yellow_2);
    game.play(0);
    game.play(-1);
    assertEquals(0, game.gameState().getCurrentPlayerHand().size());
  }
}