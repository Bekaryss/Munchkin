package GameModel;

import GameInfo.SessionInfo;
import GameModels.*;

import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

public class Session {
    public int id;
    public int Iteration;
    public int GameCycle = 0;
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
        player.AddVisibleCard(new Gear("Knife", "Small knife", 4));
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
        doors.push(new Monster("Chupacabra", "The chupacabra is thought to be a large", 12));
        doors.push(new Monster("Nessie", "The Loch Ness monster", 7));
        doors.push(new Monster("Jersey devil", "Regional monster", 8));
        doors.push(new Monster("Headless Horseman", "The Legend of Sleepy Hollow", 8));
        doors.push(new Monster("Vasilisk", "Sneck", 9));
        doors.push(new Monster("Dragon", "Large dragon with fire breath", 11));
        doors.push(new Monster("Wiverna", "Very dangerous", 15));
        doors.push(new Monster("Cerberus", "Three-headed dog", 6));
        doors.push(new Monster("Gorgons", "Perhaps the most well-known monsters of Greek mythology.", 8));
        doors.push(new Monster("Chimera", "Snake, with its head as the tip.", 5));
        doors.push(new Monster("Typhon", "The big daddy of mythological", 4));
    }

    public void AddTreasure(){
        treasures.push(new Gear("Armor Gear", "Gear", 3));
        treasures.push(new Gear("Sword Gear", "Gear", 4));
        treasures.push(new Gear("Hammer Gear", "Gear", 2));
        treasures.push(new Gear("Arming Swords", "Gear", 5));
        treasures.push(new Gear("Broad Swords", "Gear", 2));
        treasures.push(new Gear("Falchions", "Gear", 1));
        treasures.push(new Gear("Long Sword", "Gear", 3));
        treasures.push(new Gear("Rondels", "Gear", 6));
        treasures.push(new Gear("Viking sword", "Gear", 3));
        treasures.push(new Gear("Backsword ", "Gear", 4));
        treasures.push(new Gear("Billhook", "Gear", 2));
        treasures.push(new Gear("Cutlass", "Gear", 5));
        treasures.push(new Gear("Falcata", "Gear", 2));
        treasures.push(new Gear("Katzbalger", "Gear", 1));
        treasures.push(new Gear("Kilidsch", "Gear", 3));
        treasures.push(new Gear("Kopis", "Gear", 6));
    }

    public void setCurrentPlayer(PlayerController currentPlayer) {
        currentPlayer.setActive(true);
        this.currentPlayer = currentPlayer;
    }

    public void OpenDoor(){
        openedDoor = doors.pop();
        closeDoors.push(openedDoor);
    }

    public Gear GetTreasure(){
        Gear g = (Gear) treasures.pop();
        currentPlayer.AddVisibleCard(g);
        return g;
    }

    public void fightWithMonster(){
        Monster monster =(Monster)openedDoor;
        int level = monster.getLevel();
        if(level < currentPlayer.getPower()){
            int pLevel = currentPlayer.getLevel();
            pLevel++;
            currentPlayer.setLevel(pLevel);
            System.out.println("Player Win");
            if(pLevel == 10){
                GameStatus = false;
            }
            System.out.println("And you get Gear: ");
            Gear g = GetTreasure();
            System.out.println(g.getTitle());
        }
        else{
            int pLevel = currentPlayer.getLevel();
            if(pLevel>1){
                pLevel--;
            }
            currentPlayer.setLevel(pLevel);
            System.out.println("Monster Win");
        }
        closeDoors.push(openedDoor);
        openedDoor = null;
    }

    public boolean RunFromMonster(){
        Random random = new Random();
        if(random.nextInt(6 - 1 + 1) + 1 > 3){
            closeDoors.push(openedDoor);
            openedDoor = null;
            return true;
        }else{
            int pLevel = currentPlayer.getLevel();
            if(pLevel > 1){
                pLevel--;
            }
            closeDoors.push(openedDoor);
            openedDoor = null;
            currentPlayer.setLevel(pLevel);
            return false;
        }
    }

    public void OpenTreasure(Buff buff){
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
        GameCycle++;
    }

    public SessionInfo UpdateData(){
        SessionInfo sf = new SessionInfo();
        sf.id = id;
        sf.Iteration = Iteration;
        sf.GameStatus = GameStatus;
        sf.GameCycle = GameCycle;

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
