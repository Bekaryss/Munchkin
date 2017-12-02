import GameInfo.SessionInfo;
import GameModel.GameControl;
import GameModel.GameProcess;
import GameModel.PlayerController;
import GameModel.Session;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GameControl game = new GameControl();
        game.CreateSession(game.CreatePlayer(1), 1);
        game.CreateSession(game.CreatePlayer(4), 2);
        game.CreateSession(game.CreatePlayer(7), 3);

        Session s = game.game.GetSession(1);
        s.AddPlayer(game.CreatePlayer(2));
        s.AddPlayer(game.CreatePlayer(3));

        Session s1 = game.game.GetSession(2);
        s1.AddPlayer(game.CreatePlayer(5));
        s1.AddPlayer(game.CreatePlayer(6));

        Session s3 = game.game.GetSession(3);
        s3.AddPlayer(game.CreatePlayer(8));
        s3.AddPlayer(game.CreatePlayer(9));

        SessionInfo sf = s.UpdateData();

        boolean gameSes = true;
        while (gameSes) {
            for (int i = 1; i <= game.game.sessions.size(); i++) {
                SessionInfo sf1 = game.game.GetSession(i).UpdateData();
                sf1.GetSmallInfo();
            }
            System.out.println("Enter number for connect to session: ");
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();

            for (int i = 1; i <= game.game.sessions.size(); i++) {
                if(choice == i){
                    Session ses = game.game.GetSession(i);
                    ses.StartGame();
                    ses.setCurrentPlayer(ses.Players.get(ses.curPlayerNumber));
                    SessionInfo sff = ses.UpdateData();
                    sff.GetInfo();
                    game.Game(i);
                }
            }
//        sf.GetInfo();
//        s.StartGame();
//        s.setCurrentPlayer(s.Players.get(s.curPlayerNumber));
//        game.Game(1);
//        s.StartGame();
//        sf = s.UpdateData();
//        sf.GetInfo();
//        s.setCurrentPlayer(s.Players.get(0));
//        sf = s.UpdateData();
//        sf.currentPlayer.GetInfo();
//        while (sf.GameStatus == true){
//
//        }
        }
    }
}
