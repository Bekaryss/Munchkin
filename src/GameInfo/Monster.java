package GameInfo;

public class Monster extends Door{
    private int Level;

    public int getLevel() {
        return Level;
    }

    public void setLevel(int level) {
        Level = level;
    }

    public Monster(String title, String description, int _level){
        setTitle(title);
        setDescription(description);
        Level = _level;
    }
}
