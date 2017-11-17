package GameInfo;

import GameModel.PlayerController;
import GameModels.Door;
import GameModels.Player;
import GameModels.Treasure;

import java.util.ArrayList;
import java.util.Stack;

public class SessionInfo {
    public int id;
    public int Iteration;
    public boolean GameStatus = false;
    public ArrayList<PlayerInfo> Players = new ArrayList<>();
    public PlayerInfo currentPlayer;
    public Stack<CardInfo> doors = new Stack<>();
    public Stack<CardInfo> closeDoors = new Stack<>();
    public Stack<CardInfo> treasures = new Stack<>();
    public CardInfo openedDoor;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIteration() {
        return Iteration;
    }

    public void setIteration(int iteration) {
        Iteration = iteration;
    }

    public boolean isGameStatus() {
        return GameStatus;
    }

    public void setGameStatus(boolean gameStatus) {
        GameStatus = gameStatus;
    }

    public ArrayList<PlayerInfo> getPlayers() {
        return Players;
    }

    public void setPlayers(ArrayList<PlayerInfo> players) {
        Players = players;
    }

    public PlayerInfo getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(PlayerInfo currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public Stack<CardInfo> getDoors() {
        return doors;
    }

    public void setDoors(Stack<CardInfo> doors) {
        this.doors = doors;
    }

    public Stack<CardInfo> getCloseDoors() {
        return closeDoors;
    }

    public void setCloseDoors(Stack<CardInfo> closeDoors) {
        this.closeDoors = closeDoors;
    }

    public Stack<CardInfo> getTreasures() {
        return treasures;
    }

    public void setTreasures(Stack<CardInfo> treasures) {
        this.treasures = treasures;
    }

    public CardInfo getOpenedDoor() {
        return openedDoor;
    }

    public void setOpenedDoor(CardInfo openedDoor) {
        this.openedDoor = openedDoor;
    }

    public void GetInfo(){
        System.out.println("$$$$$$$$$$$$$$$$$ Session $$$$$$$$$$$$$$$$$$$$$$");
        System.out.println("Id: " + id + " " +"Iteration: " + Iteration + " " + "GameStatus: " + GameStatus);
        System.out.println("Doors: " );
//        for (int i=0; i<doors.size(); i++){
//            doors.get(i).GetInfo();
//        }
        System.out.println("Opened Door: ");
        if(openedDoor != null)
            openedDoor.GetInfo();
        if(currentPlayer!= null){
            System.out.println("Current Player: ");
            currentPlayer.GetInfo();
        }
        System.out.println("Players: " + Players.size());
        for (int i=0; i<Players.size(); i++){
            Players.get(i).GetInfo();
        }
    }
}
