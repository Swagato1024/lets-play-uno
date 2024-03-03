package io.github.swagato1024.uno;

import io.github.swagato1024.uno.cardManagment.Deck;
import io.github.swagato1024.uno.unocard.Card;
import io.github.swagato1024.uno.unocard.CardColor;

import static io.github.swagato1024.uno.unocard.CardColor.NONE;

public class Uno {
  private final Players players;
  private boolean isGameOver;
  private Player winner;
  private CardColor calledColor;
  private Card cardOnTop;
  private final Deck deck;

  public Uno(Players players, Deck deck, Card cardOnTop) {
    this.players = players;
    this.deck = deck;
    this.isGameOver = false;
    this.winner = null;
    this.cardOnTop = cardOnTop;
    this.calledColor = NONE;
  }

  public void chooseColor() {
    this.calledColor = CardColor.YELLOW;
  }

  private void drawTwo() {
    this.players.moveToNextPlayer();
    Player currentPlayer = this.players.getCurrentPlayer();
    currentPlayer.addCard(this.deck.draw());
    currentPlayer.addCard(this.deck.draw());
    this.players.moveToNextPlayer();
  }

  public void consolidateCard (Card card) {
    switch (card.getType()) {
      case SKIP:
        players.moveToNextPlayer();
        players.moveToNextPlayer();
        break;

      case REVERSE:
        players.reverseDirection();
        players.moveToNextPlayer();
        break;

      case DRAW_TWO:
        drawTwo();
        break;

      case WILD:
        this.chooseColor();
        players.moveToNextPlayer();
        break;

//      case WILD_D4:
//        nextPlayerDraw(game);
//        nextPlayerDraw(game);
//        nextPlayerDraw(game);
//        nextPlayerDraw(game);
//        game.advanceToNextPlayer();
//        game.advanceToNextPlayer();
//        break;
      default:
        players.moveToNextPlayer();
        System.out.println("turn goes to next player");
        break;
    }
  }
  public void play(int cardIndex) throws UnplayableCardSelection, CardNotInHand {
    Player currentPlayer = players.getCurrentPlayer();

    if(cardIndex == -1) {
      Card drawnCard = deck.draw();
      currentPlayer.addCard(drawnCard);
      players.moveToNextPlayer();
      return;
    }

      Card selectedCard = currentPlayer.placeCard(cardIndex);

      if(!selectedCard.canPlayOn(this.cardOnTop, this.calledColor)) {
        throw new UnplayableCardSelection();
      }

    this.cardOnTop = selectedCard;
    this.consolidateCard(this.cardOnTop);
  }

  public GameState gameState() {
    return new GameState(this.cardOnTop, players.getCurrentPlayer(), this.isGameOver);
  }
}
