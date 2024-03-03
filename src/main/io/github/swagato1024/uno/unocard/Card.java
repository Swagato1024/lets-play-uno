package io.github.swagato1024.uno.unocard;

public class Card {
    private CardColor color;
    private CardType cardType;
    private int number;

  public Card(CardColor color, CardType cardType, int number) {
    this.color = color;
    this.cardType = cardType;
    this.number = number;
  }

  public Card(CardColor color, CardType cardType) {
    this.color = color;
    this.cardType = cardType;
    this.number = -1;
  }

  public Card(CardColor color, int number) {
    this.color = color;
    this.number = number;
    this.cardType = CardType.NUMBER;
  }

  public boolean isWild() {
    return this.cardType == CardType.WILD || this.cardType == CardType.WILD_D4;
  }
  private boolean isMatchingColor(Card otherCard) {
    return this.color == otherCard.color;
  }
  private boolean isMatchingNumber(Card otherCard) {
    return this.cardType == CardType.NUMBER && this.number == otherCard.number;
  }

  private boolean isMatchingType(Card otherCard) {
    return this.cardType == otherCard.cardType;
  }

  public boolean canPlayOn(Card otherCard, CardColor calledColor) {
    if (this.isWild()) {
      return true;
    }

    if(calledColor != CardColor.NONE) return this.color == calledColor;

    return this.isMatchingColor(otherCard) || this.isMatchingNumber(otherCard);
  }

  public CardType getType() {
    return this.cardType;
  }

  public Integer getNumber() {
    return this.number;
  }

  public CardColor getColor() {
    return this.color;
  }
}
