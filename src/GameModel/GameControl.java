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
        while(game.GetSession(id).GameStatus == true){
            System.out.println("******** 1 st Player Game ********");
            Session curSession = game.GetSession(id);
            SessionInfo info = curSession.UpdateData();
            info.currentPlayer.GetInfo();
            System.out.println("Enter control: ");

            if(info.openedDoor != null){
                System.out.println("2 - Fight with Monster");
                System.out.println("3 - Run");
            }else{
                System.out.println("1 - Open Door");
            }
            System.out.println("4 - TurnEnds");
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    curSession.OpenDoor();
                    info = curSession.UpdateData();
                    System.out.println("!!!!!! -> MONSTER <- !!!!!!!! ");
                    info.openedDoor.GetInfo();
                    break;
                case 2:
                    curSession.fightWithMonster();
                    info = curSession.UpdateData();
                    info.currentPlayer.GetInfo();
                    break;
                case 3:
                    if(curSession.RunFromMonster() == true){
                        System.out.println("Congratulations!!! You can run");
                    }else{
                        System.out.println("You were eaten by a monster");
                    }
                    info = curSession.UpdateData();
                    info.currentPlayer.GetInfo();
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
                    break;
                default:

            }
        }
    }

}
