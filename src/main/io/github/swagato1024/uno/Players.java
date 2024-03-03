package io.github.swagato1024.uno;

import io.github.swagato1024.uno.Player;

import java.util.ArrayList;

public class Players {
  private int currentPlayerIndex;
  private ArrayList<Player> players;
  private int direction;

  public Players(ArrayList<Player> players) {
    this.currentPlayerIndex = 0;
    this.players = players;
    this.direction = 1;
  }

  public Player getCurrentPlayer() {
    return players.get(currentPlayerIndex);
  }

  public void moveToNextPlayer() {
    int noOfPlayers = players.size();
    System.out.println(noOfPlayers);
    this.currentPlayerIndex = (this.currentPlayerIndex + direction) % noOfPlayers;
    if(this.currentPlayerIndex < 0) this.currentPlayerIndex = noOfPlayers - 1;
  }

  public void reverseDirection() {
    this.direction = this.direction == 1 ? -1 : 1;
  }
}
