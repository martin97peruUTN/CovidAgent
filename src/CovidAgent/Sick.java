package CovidAgent;

import java.util.Objects;

public class Sick {
    private Integer id;
    private Node position;
    private Node home;
    private Integer mulctAmount;

    public Sick() {
    }

    public Sick(Integer id, Node position, Node home) {
        this.id = id;
        this.position = position;
        this.home = home;
        this.mulctAmount = 0;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Node getPosition() {
        return position;
    }

    public void setPosition(Node position) {
        this.position = position;
    }

    public Node getHome() {
        return home;
    }

    public void setHome(Node home) {
        this.home = home;
    }

    public Integer getMulctAmount() {
        return mulctAmount;
    }

    public void setMulctAmount(Integer mulctAmount) {
        this.mulctAmount = mulctAmount;
    }

    public void addMulct(){
        this.mulctAmount=this.mulctAmount+1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sick sick = (Sick) o;
        return id==sick.getId() &&
                position.equals(sick.getPosition()) &&
                home.equals(sick.getHome()) &&
                mulctAmount==sick.mulctAmount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, position, home, mulctAmount);
    }

    @Override
    public String toString() {
        return "Sick{" +
                "id=" + id +
                ", position=" + position +
                ", home=" + home +
                ", mulctAmount=" + mulctAmount +
                '}';
    }
}
