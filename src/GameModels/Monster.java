package GameModels;

import GameInfo.CardInfo;

public class Monster extends Door {
    private int Level;

    public int getLevel() {
        return Level;
    }

    public void setLevel(int level) {
        Level = level;
    }

    public Monster(String title, String description, int _level) {
        setTitle(title);
        setDescription(description);
        Level = _level;
    }

    public CardInfo UpdataData() {
        CardInfo c = new CardInfo();
        c.setId(getId());
        c.setTitle(getTitle());
        c.setDescription(getDescription());
        c.setLevel(getLevel());
        c.setType("Monster");
        c.setBonus(0);
        return c;
    }
}
