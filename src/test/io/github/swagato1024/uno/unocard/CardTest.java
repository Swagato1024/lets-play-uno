package io.github.swagato1024.uno.unocard;

import io.github.swagato1024.uno.unocard.Card;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static io.github.swagato1024.uno.unocard.CardColor.*;
import static io.github.swagato1024.uno.unocard.CardType.*;
import static org.junit.jupiter.api.Assertions.*;

class CardTest {
  private Card wild;
  private Card wild_d4;
  private Card red4;
  private Card redSkip;
  private Card yellow2;
  @BeforeEach
  void createCard() {
    this.wild = new Card(NONE, WILD);
    this.wild_d4 = new Card(NONE, WILD_D4);
    this.red4 = new Card(RED, 4);
    this.yellow2 = new Card(YELLOW, 2);
    this.redSkip = new Card(RED, SKIP);
  }

  @Test
  void testIsWild() {
    assertTrue(this.wild.isWild(), "should be true when card is a wild one");
    assertTrue(this.wild_d4.isWild(),"should be true when card is wild draw 4");
    assertFalse(this.red4.isWild(), "should be false for red card");
  }

  @Test
  void testCanPlayOn() {
    assertTrue(this.wild.canPlayOn(red4, NONE), "wild card should be placed on number card");
    assertFalse(this.yellow2.canPlayOn(red4, NONE), "should be false when color or symbol doesnot match");
  }
}