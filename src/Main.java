import GameInfo.SessionInfo;
import GameModel.GameControl;
import GameModel.GameProcess;
import GameModel.PlayerController;
import GameModel.Session;

public class Main {
    public static void main(String[] args) {
        GameControl game = new GameControl();
        game.CreateSession(game.CreatePlayer(1), 1);
        Session s = game.game.GetSession(1);
        s.AddPlayer(game.CreatePlayer(2));
        SessionInfo sf = s.UpdateData();
        sf.GetInfo();
        s.StartGame();
        sf = s.UpdateData();
        sf.GetInfo();
        s.setCurrentPlayer(s.Players.get(0));
        sf = s.UpdateData();
        sf.currentPlayer.GetInfo();
//        while (sf.GameStatus == true){
//
//        }
    }
}
