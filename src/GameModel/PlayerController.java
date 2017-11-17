package GameModel;

import GameInfo.PlayerInfo;
import GameModels.Card;
import GameModels.Gear;
import GameModels.Treasure;

import java.util.ArrayList;
import java.util.List;

public class PlayerController {
    public PlayerController(int _id, String _nickName, int _level, int _bonus, boolean _isActive){
        id = _id;
        nickName = _nickName;
        level = _level;
        bonus = _bonus;
        isActive = _isActive;
    }

    private int id;
    private String nickName;
    private int level;
    private int bonus;
    private int power;
    public boolean isActive;
    public ArrayList<Treasure> VisibleCards = new ArrayList<Treasure>();
    public ArrayList<Treasure> HiddenCards = new ArrayList<Treasure>();

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = Math.max(level, 1);
        power = level + bonus;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
        power = level + bonus;
    }

    public int getPower() {
        return power;
    }

    public List<Treasure> getVisibleCards() {
        return VisibleCards;
    }

    public void setVisibleCards(ArrayList<Treasure> visibleCards) {
        VisibleCards = visibleCards;
    }

    public List<Treasure> getHiddenCards() {
        return HiddenCards;
    }

    public void setHiddenCards(ArrayList<Treasure> hiddenCards) {
        HiddenCards = hiddenCards;
    }



    public void AddVisibleCard(Gear card) {
        setBonus(bonus + card.getBonus());
        VisibleCards.add(card);
    }

    public void AddHiddenCard(Treasure card) {
        HiddenCards.add(card);
    }

    public Card RemoveVisibleCard(Treasure card) {
        VisibleCards.remove(card);
        return card;
    }

    public Card RemoveHiddenCard(Treasure card) {
        HiddenCards.remove(card);
        return card;
    }

    public void SwapCard(Treasure cardV, Treasure cardH){
        AddVisibleCard((Gear) cardH);
        AddHiddenCard(cardV);
        RemoveVisibleCard(cardV);
        RemoveHiddenCard(cardH);
    }

    public void ShowCard(Treasure card) {
        AddVisibleCard((Gear) card);
        RemoveHiddenCard(card);
    }

    public PlayerInfo UpdateData(){
        PlayerInfo pl = new PlayerInfo();
        pl.id = id;
        pl.nickName = nickName;
        pl.level = level;
        pl.power = power;
        pl.bonus = bonus;
        pl.isActive = isActive;
        for (int i=0; i<VisibleCards.size(); i++){
            pl.visibleCards.add(VisibleCards.get(i).UpdataData());
        }
        for (int i=0; i<HiddenCards.size(); i++){
            pl.hiddenCards.add(HiddenCards.get(i).UpdataData());
        }
        return pl;
    }
}
