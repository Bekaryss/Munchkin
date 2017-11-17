package GameModel;

import java.util.ArrayList;
import java.util.List;

public class GameProcess {
    public List<Session> sessions = new ArrayList<>();

    public Session AddSession(PlayerController player, int id){
        Session session = new Session(player, id);
        sessions.add(session);
        return session;
    }

    public Session GetSession(int id){
        for (int i=0; i<sessions.size(); i++){
            if(sessions.get(i).id == id){
                return sessions.get(i);
            }
        }
        return null;
    }
}
