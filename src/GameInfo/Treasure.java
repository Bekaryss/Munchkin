package GameInfo;

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

    public void GetInfo(){
        System.out.println("Title: " + getTitle());
        System.out.println("Description: " + getDescription());
        System.out.println("Bonus: " + Bonus);
    }
}
