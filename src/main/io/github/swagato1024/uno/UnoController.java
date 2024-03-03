package io.github.swagato1024.uno;

import java.util.Scanner;
public class UnoController {
  private final Uno game;
  private final Scanner inputScanner;
  private final View view;

  public UnoController(Uno game, Scanner inputScanner, View view) {
    this.game = game;
    this.inputScanner = inputScanner;
    this.view = view;
  }
  public void start() {
    while(!this.game.gameState().isGameOver()) {
      view.render(this.game.gameState());

      try{
        this.game.play(this.inputScanner.nextInt());
      }
      catch (UnplayableCardSelection | CardNotInHand e) {
        System.out.println(e.getMessage());
      }
    }
  }
}
