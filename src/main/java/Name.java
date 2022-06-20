public class Name {
    String name;
    double rank;
    String gender;

    public Name() {
        name = "";
        rank = 0;
        gender = "";
    }

    public Name(String name, double rank, String gender) {
        this.name = name;
        this.rank = rank;
        this.gender = gender;
    }

    public Name (Name n) {
        this.name = n.getName();
        this.rank = n.getRank();
        this.gender = n.getGender();
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRank() {
        return rank;
    }

    public void setRank(double rank) {
        this.rank = rank;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String toString() {
        return  this.name;
    }
}
