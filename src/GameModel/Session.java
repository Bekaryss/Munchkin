package GameModel;

import GameInfo.SessionInfo;
import GameModels.*;

import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

public class Session {
    public int id;
    public int Iteration;
    public boolean GameStatus = false;
    public ArrayList<PlayerController> Players;
    public PlayerController currentPlayer;
    public Stack<Door> doors;
    public Stack<Door> closeDoors;
    public Stack<Treasure> treasures;
    public Door openedDoor;
    public int curPlayerNumber = 0;

    public Door getOpenedDoor() {
        return openedDoor;
    }

    public Session(PlayerController player, int id){
        this.id = id;
        doors = new Stack<Door>();
        closeDoors = new Stack<Door>();
        treasures = new Stack<Treasure>();
        Players = new ArrayList<PlayerController>();
        AddPlayer(player);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        if(GameStatus = true){
            AddDoor();
            AddTreasure();
        }
    }

    public void AddDoor(){
        doors.push(new Monster("Nurba Dragon", "Mda", 1));
        doors.push(new Monster("Alikhan Dragon", "Mda", 2));
        doors.push(new Monster("Beka Dragon", "Mda", 1));
        doors.push(new Monster("Aslan Pig", "Mda", 3));
        doors.push(new Monster("Vasilisk", "Mda", 2));
        doors.push(new Monster("Dragon", "Mda", 5));
        doors.push(new Monster("Wiverna", "Mda", 6));
    }

    public void AddTreasure(){
        treasures.push(new Gear("Armor Gear", "Give", 3));
        treasures.push(new Buff("Bonus Armor", "Give armor", 2));
        treasures.push(new Gear("Sword Gear", "Give", 6));
        treasures.push(new Buff("Bow", "Give", 1));
        treasures.push(new Gear("Hammer Gear", "Give", 5));
        treasures.push(new Buff("Knife", "Give", 4));
        treasures.push(new Gear("Katana Gear", "Give", 10));
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
            System.out.println("Player Win");
        }
        else{
            int pLevel = currentPlayer.getLevel();
            if(pLevel>1){
                pLevel--;
            }

            currentPlayer.setLevel(pLevel);
            System.out.println("Monster Win");
        }
    }

    public boolean RunFromMonster(){
        Random random = new Random();
        if(random.nextInt(6 - 1 + 1) + 1 > 3){
            return true;
        }else{
            int pLevel = currentPlayer.getLevel();
            if(pLevel > 1){
                pLevel--;
            }
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
        openedDoor = null;
    }

    public SessionInfo UpdateData(){
        SessionInfo sf = new SessionInfo();
        sf.id = id;
        sf.Iteration = Iteration;
        sf.GameStatus = GameStatus;
        for (int i=0; i<doors.size(); i++){
            sf.doors.push(((Monster)doors.get(i)).UpdataData());
        }
        for (int i=0; i<closeDoors.size(); i++){
            sf.closeDoors.push(((Monster)closeDoors.get(i)).UpdataData());
        }
        for (int i=0; i<treasures.size(); i++){
            sf.treasures.push(treasures.get(i).UpdataData());
        }
        if(openedDoor != null){
            sf.openedDoor = ((Monster)openedDoor).UpdataData();
        }
        for (int i=0; i<Players.size(); i++){
            sf.Players.add(Players.get(i).UpdateData());
        }
        if(currentPlayer != null){
            sf.currentPlayer = currentPlayer.UpdateData();
        }
        return sf;
    }

}
