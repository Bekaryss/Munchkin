package GameInfo;

import java.util.List;

public class Player {
    public int id;
    public String nickName;
    public int level;
    public int bonus;
    public int power;

    public List<Card> visibleCards;
    public List<Card> hiddenCards;

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
        this.level = level;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public List<Card> getVisibleCards() {
        return visibleCards;
    }

    public void setVisibleCards(List<Card> visibleCards) {
        this.visibleCards = visibleCards;
    }

    public List<Card> getHiddenCards() {
        return hiddenCards;
    }

    public void setHiddenCards(List<Card> hiddenCards) {
        this.hiddenCards = hiddenCards;
    }
}
