import GameModel.GameProcess;
import GameModel.PlayerController;
import GameModel.Session;

public class Main {
    public static void main(String[] args) {
        GameProcess game = new GameProcess();
        PlayerController player1 = new PlayerController(1, "Bekarys", 1, 0, false);
        PlayerController player2 = new PlayerController(2, "Nurbol", 1, 0, false);

        Session session = game.AddSession(player1);
        session.AddPlayer(player2);
        session.StartGame();
        session.AddDoor();
        session.AddTreasure();

    }
}
