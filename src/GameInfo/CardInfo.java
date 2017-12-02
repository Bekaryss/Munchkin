package GameInfo;

public class CardInfo {
    private int Id;
    private String Title;
    private String Description;
    private int Level;
    private int Bonus;
    private String Type;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public int getLevel() {
        return Level;
    }

    public void setLevel(int level) {
        Level = level;
    }

    public int getBonus() {
        return Bonus;
    }

    public void setBonus(int bonus) {
        Bonus = bonus;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }
    public void GetInfo(){
        System.out.println("  ************** Card ****************");
        System.out.println("  * Id: " + Id + " " + "Title: " + Title );
        System.out.println("  * Description: " + Description);
        System.out.println("  * Type: " + Type + " *");
        if(Type == "Monster"){
            System.out.println("  * Level: " + Level);
        }else if (Type == "Treasure"){
            System.out.println("  * Bonus: " + Bonus);
        }
        System.out.println("  ************** End ****************");
    }
}
