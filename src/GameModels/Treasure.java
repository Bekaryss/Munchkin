package GameModels;

import GameInfo.CardInfo;

public class Treasure extends Card{
    public int Bonus;

    public int getBonus() {
        return Bonus;
    }

    public void setBonus(int bonus) {
        Bonus = bonus;
    }

    public Treasure(String _title, String _description, int _bonus){
        setTitle(_title);
        setDescription(_description);
        Bonus = _bonus;
    }

    public CardInfo UpdataData() {
        CardInfo c = new CardInfo();
        c.setId(getId());
        c.setTitle(getTitle());
        c.setDescription(getDescription());
        c.setLevel(0);
        c.setType("Treasure");
        c.setBonus(getBonus());
        return c;
    }
}
