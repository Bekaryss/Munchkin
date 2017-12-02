package GameModel;

import GameInfo.SessionInfo;

import java.util.Scanner;

public class GameControl {
    public GameProcess game = new GameProcess();

    public GameControl(){

    }
    public PlayerController CreatePlayer(int number) {
        int id = 0;
        String nickName = "defoult";
        int level = 1;
        int bonus = 0;
        boolean isActive = false;
        if (number == 1) {
            id = 1;
            nickName = "player " + id;
        } else if (number == 2) {
            id = 2;
            nickName = "player " + id;
        } else if (number == 3) {
            id = 3;
            nickName = "player " + id;
        } else if (number == 4) {
            id = 4;
            nickName = "player " + id;
        } else if (number == 5) {
            id = 5;
            nickName = "player " + id;
        } else if (number == 6) {
            id = 6;
            nickName = "player " + id;
        } else if (number == 7) {
            id = 7;
            nickName = "player " + id;
        } else if (number == 8) {
            id = 8;
            nickName = "player " + id;
        } else if (number == 9) {
            id = 9;
            nickName = "player " + id;
        } else if (number == 10) {
            id = 10;
            nickName = "player " + id;
        } else if (number == 11) {
            id = 11;
            nickName = "player " + id;
        } else if (number == 12) {
            id = 12;
            nickName = "player " + id;
        }
        return new PlayerController(id, nickName, level, bonus, isActive);
    }

    public void AddPlayer(int id){
        game.AddPlayer(CreatePlayer(1), id);
    }
    public void CreateSession(PlayerController player, int id){
        game.AddSession(player, id);
    }

    public void Game(int id){
        boolean opened = false;
        Session curSession = game.GetSession(id);
        while(game.GetSession(id).GameStatus == true){
            Space();
            System.out.println("$$$$$$ Player Game $$$$$$$");
            SessionInfo info = curSession.UpdateData();
            info.currentPlayer.GetInfo();
            System.out.println("Enter control: ");

            if(info.openedDoor != null){
                System.out.println("2 - Fight with Monster");
                System.out.println("3 - Run");
            }else if(opened == false){
                System.out.println("1 - Open Door");
            }
            System.out.println("4 - TurnEnds");
            System.out.println("5 - Exit");

            System.out.println("Enter number: ");
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            Space();
            switch (choice) {
                case 1:
                    if(opened == false){
                        curSession.OpenDoor();
                        info = curSession.UpdateData();
                        System.out.println("!!!!!!!! -> MONSTER <- !!!!!!!! ");
                        info.openedDoor.GetInfo();
                        opened = true;
                    }
                    break;
                case 2:
                    curSession.fightWithMonster();
                    curSession.UpdateData();
                    break;
                case 3:
                    if(curSession.RunFromMonster() == true){
                        System.out.println("!!!!! --- Congratulations!!! You can run --- !!!!!");
                    }else{
                        System.out.println("!!!!! --- You were eaten by a monster --- !!!!!");
                    }
                    curSession.UpdateData();
                    break;
                case 4:
                    if(curSession.curPlayerNumber+1 == curSession.Players.size()){
                        curSession.curPlayerNumber = 0;
                    }else{
                        curSession.curPlayerNumber++;
                    }
                    curSession.currentPlayer  = curSession.Players.get(curSession.curPlayerNumber);
                    curSession.TurnEnds();
                    info = curSession.UpdateData();
                    info.GetInfo();
                    opened = false;
                    break;
                case 5:
                    game.GetSession(id).GameStatus = false;
                    break;
                default:
                    break;
            }
        }
        if(curSession.currentPlayer.getLevel() == 10) {
            System.out.println("@@@@@@@ ---> This Player Win Game <--- @@@@@@@");
            SessionInfo info = curSession.UpdateData();
            info.currentPlayer.GetInfo();
        }
    }

    public void SeeCards(Session curSession){
        boolean cardProcess = true;
        while(cardProcess){
            SessionInfo info = curSession.UpdateData();
            info.currentPlayer.GetInfo();

        }
    }

    public void Space(){
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
    }
}
