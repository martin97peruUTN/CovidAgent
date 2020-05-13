package CovidAgent;

import java.util.ArrayList;
import java.util.Objects;

public class Node {
    private Integer id;
    private double x;
    private double y;
    private String calles;
    private ArrayList<Node> successors;

    public Node() {
        this.successors = new ArrayList<Node>();
    }

    public Node(Integer id) {
        this.id = id;
        this.successors = new ArrayList<Node>();
    }

    public Node(Integer id, double x, double y) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.successors = new ArrayList<Node>();
    }

    public Node(Integer id, double x, double y, String calles) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.calles = calles;
        this.successors = new ArrayList<Node>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public String getCalles() {
        return calles;
    }

    public void setCalles(String calles) {
        this.calles = calles;
    }

    public ArrayList<Node> getSuccessors() {
        return successors;
    }

    public void setSuccessors(ArrayList<Node> successors) {
        this.successors = successors;
    }

    public void addSuccessor(Node n){
        this.successors.add(n);
    }

    public void removeSuccessor(Node n){
        successors.remove(n);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        Boolean b = Double.compare(node.x, x) == 0 &&
                Double.compare(node.y, y) == 0 &&
                Objects.equals(id, node.id);
        boolean lista=node.getSuccessors().size()==successors.size();
        if(lista){
            for(int i=0;i<successors.size();i++){
                if(node.getSuccessors().get(i).getId()!=successors.get(i).getId()){
                    lista=false;
                }
            }
        }
        return lista && b;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, x, y, successors);
    }

    @Override
    public String toString() {
        return "Node{" +
                "id=" + id +
                ", x=" + x +
                ", y=" + y +
                ", calles='" + calles + '\'' +
                ", successors=" + successors +
                '}';
    }
}
