package GameModel;

import GameInfo.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;

public class Session {
    public ArrayList<PlayerController> Players;
    public int Iteration;
    private PlayerController currentPlayer;
    public Stack<Door> doors;
    public Stack<Door> closeDoors;
    public Stack<Treasure> treasures;
    public Door openedDoor;
    public boolean GameStatus = false;

    public Door getOpenedDoor() {
        return openedDoor;
    }

    public Session(PlayerController player){
        AddPlayer(player);
    }

    public void AddPlayer(PlayerController player)
    {
        player.AddVisibleCard(new Gear("Some title", "Somedescroption", 5));
        Players.add(player);
    }
    public void RemovePlayer(PlayerController player)
    {
        Players.remove(player);
    }

    public void StartGame(){
        if(Players.size() >=2){
            GameStatus = true;
        }
    }

    public void AddDoor(){
        doors.push(new Monster("Nurba", "Mda", 1));
        doors.push(new Monster("Alikhan", "Mda", 2));
        doors.push(new Monster("Beka", "Mda", 1));
        doors.push(new Monster("Aslan", "Mda", 3));
        doors.push(new Monster("Vasilisk", "Mda", 2));
        doors.push(new Monster("Dragon", "Mda", 5));
        doors.push(new Monster("Wiverna", "Mda", 6));

    }

    public void AddTreasure(){
        treasures.push(new Gear("Armor", "Give", 3));
        treasures.push(new Buff("Bonus Armor", "Give armor", 2));
        treasures.push(new Gear("Sword", "Give", 6));
        treasures.push(new Buff("Bow", "Give", 1));
        treasures.push(new Gear("Hammer", "Give", 5));
        treasures.push(new Buff("Knife", "Give", 4));
        treasures.push(new Gear("Katana", "Give", 10));

    }

    public void setCurrentPlayer(PlayerController currentPlayer) {
        currentPlayer.setActive(true);
        this.currentPlayer = currentPlayer;
    }

    public void OpenDoor(){
        openedDoor = doors.pop();
        closeDoors.push(openedDoor);
    }

    public void GetTreasure(){
        currentPlayer.AddHiddenCard(treasures.pop());
    }

    public void fightWithMonster(){
        Monster monster =(Monster)openedDoor;
        int level = monster.getLevel();
        if(level < currentPlayer.getPower()){
            int pLevel = currentPlayer.getLevel();
            pLevel++;
            currentPlayer.setLevel(pLevel);
        }
        else{
            int pLevel = currentPlayer.getLevel();
            pLevel--;
            currentPlayer.setLevel(pLevel);
        }
    }

    public boolean RunFromMonster(){
        Random random = new Random();
        if(random.nextInt(6 - 1 + 1) + 1 > 3){
            return true;
        }else{
            int pLevel = currentPlayer.getLevel();
            pLevel--;
            currentPlayer.setLevel(pLevel);
            return false;
        }
    }

    public void OpenTreasre(Buff buff){
        currentPlayer.setBonus(buff.Bonus);
        currentPlayer.RemoveHiddenCard(buff);
    }

    public void TurnEnds(){
        currentPlayer.setActive(false);
        Players.get(Iteration);
        Iteration++;
        if(Iteration >= Players.size()){
            Iteration = 0;
        }
    }

}
