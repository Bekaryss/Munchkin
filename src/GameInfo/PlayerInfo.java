package GameInfo;

import GameModels.Card;

import java.util.ArrayList;
import java.util.List;

public class PlayerInfo {
    public int id;
    public String nickName;
    public int level;
    public int bonus;
    public int power;
    public boolean isActive;

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public ArrayList<CardInfo> visibleCards = new ArrayList<>();
    public ArrayList<CardInfo> hiddenCards = new ArrayList<>();

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

    public ArrayList<CardInfo> getVisibleCards() {
        return visibleCards;
    }

    public void setVisibleCards(ArrayList<CardInfo> visibleCards) {
        this.visibleCards = visibleCards;
    }

    public ArrayList<CardInfo> getHiddenCards() {
        return hiddenCards;
    }

    public void setHiddenCards(ArrayList<CardInfo> hiddenCards) {
        this.hiddenCards = hiddenCards;
    }

    public void GetInfo(){
        System.out.println("######## Player " + id + " ########");
        System.out.println("# Player: " + nickName + " " +"Level: " + level );
        System.out.println("# Bonus: " + bonus + " " + "Power: " + power);
        System.out.println("# Visible Cards: ");
        for(int i = 0; i < visibleCards.size(); i++){
            visibleCards.get(i).GetInfo();
        }
        System.out.println("# Hidden Cards: ");
        for(int i = 0; i < hiddenCards.size(); i++){
            hiddenCards.get(i).GetInfo();
        }
        System.out.println("######## Player Info End ########");
        System.out.println();
        System.out.println();
    }
}
