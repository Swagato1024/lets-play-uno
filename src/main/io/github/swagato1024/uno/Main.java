package io.github.swagato1024.uno;

import io.github.swagato1024.uno.cardManagment.Deck;
import io.github.swagato1024.uno.unocard.Card;

import java.util.ArrayList;
import java.util.Scanner;
public class Main {
  public static void main(String[] args) {
    Player bittu = new Player("bittu");
    Player raj = new Player("raj");

     ArrayList <Player> participants = new ArrayList<>();
     participants.add(bittu);
     participants.add(raj);

     Players players = new Players(participants);

     Deck deck = new Deck();
     Card firstCard = deck.draw();

     bittu.addCard(deck.draw());
    bittu.addCard(deck.draw());
    bittu.addCard(deck.draw());
    bittu.addCard(deck.draw());


    raj.addCard(deck.draw());
    raj.addCard(deck.draw());
    raj.addCard(deck.draw());
    raj.addCard(deck.draw());

    Uno unoGame = new Uno(players, deck, firstCard);
    UnoController unoController = new UnoController(unoGame, new Scanner(System.in), new View() );
    unoController.start();
  }
}
