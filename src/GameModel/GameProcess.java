package GameModel;

import java.util.List;

public class GameProcess {
    public List<Session> sessions;

    public Session AddSession(PlayerController player){
        Session session = new Session(player);
        sessions.add(session);
        return session;
    }
}
