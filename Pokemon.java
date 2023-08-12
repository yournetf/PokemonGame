import java.util.Comparator;

public class Pokemon {
    public String name;
    public int type1;
    public int type2;
    public int pictureID;
    public int baseHP;
    public int baseATK;
    public int baseDEF;
    public int baseSPATK;
    public int baseSPDEF;
    public int baseSpeed;

    public boolean isLegendary;

    public Pokemon(String name, int type1, int type2, int pictureID, int baseHP, int baseATK, int baseDEF, int baseSPATK, int baseSPDEF, int baseSpeed) {
        this.name = name;
        this.type1 = type1;
        this.type2 = type2;
        this.pictureID = pictureID;
        this.baseHP = baseHP;
        this.baseATK = baseATK;
        this.baseDEF = baseDEF;
        this.baseSPATK = baseSPATK;
        this.baseSPDEF = baseSPDEF;
        this.baseSpeed = baseSpeed;
        this.isLegendary = determineLegendary();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getType1() {
        return type1;
    }

    public void setType1(int type1) {
        this.type1 = type1;
    }

    public int getType2() {
        return type2;
    }

    public void setType2(int type2) {
        this.type2 = type2;
    }

    public int getPictureID() {
        return pictureID;
    }

    public void setPictureID(int pictureID) {
        this.pictureID = pictureID;
    }

    public int getBaseHP() {
        return baseHP;
    }

    public void setBaseHP(int baseHP) {
        this.baseHP = baseHP;
    }

    public int getBaseATK() {
        return baseATK;
    }

    public void setBaseATK(int baseATK) {
        this.baseATK = baseATK;
    }

    public int getBaseDEF() {
        return baseDEF;
    }

    public void setBaseDEF(int baseDEF) {
        this.baseDEF = baseDEF;
    }

    public int getBaseSPATK() {
        return baseSPATK;
    }

    public void setBaseSPATK(int baseSPATK) {
        this.baseSPATK = baseSPATK;
    }

    public int getBaseSPDEF() {
        return baseSPDEF;
    }

    public void setBaseSPDEF(int baseSPDEF) {
        this.baseSPDEF = baseSPDEF;
    }

    public int getBaseSpeed() {
        return baseSpeed;
    }

    public void setBaseSpeed(int baseSpeed) {
        this.baseSpeed = baseSpeed;
    }

    public boolean isLegendary() {
        return isLegendary;
    }

    public void setLegendary(boolean legendary) {
        isLegendary = legendary;
    }

    public boolean determineLegendary(){
        int statProduct;
        statProduct = baseATK + baseDEF + baseHP + baseSPATK + baseSPDEF + baseSpeed;
        if (statProduct >= 580) return true;
        else return false;
    }




}
