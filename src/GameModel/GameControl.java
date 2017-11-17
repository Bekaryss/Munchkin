package GameModel;

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
        Session session = game.GetSession(id);
        session.AddPlayer(CreatePlayer(1));
    }
    public void CreateSession(PlayerController player, int id){
        game.AddSession(player, id);
    }

    public void Game(){

    }

}
