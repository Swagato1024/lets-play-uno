package io.github.swagato1024.uno;

public class CardNotInHand extends Throwable{
  public CardNotInHand() {
    super("card not in hand");
  }
}
