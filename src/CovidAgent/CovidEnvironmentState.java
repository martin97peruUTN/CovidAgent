package CovidAgent;

import frsf.cidisi.faia.state.EnvironmentState;

import java.util.ArrayList;

public class CovidEnvironmentState extends EnvironmentState {

    private ArrayList<Node> map;
    private Node agentPosition;
    private ArrayList<Sick> sickArrayList;

    public CovidEnvironmentState() {
        this.map = new ArrayList<Node>();
        this.sickArrayList = new ArrayList<Sick>();
        this.initState();
    }

    public CovidEnvironmentState(ArrayList<Node> map, Node agentPosition, ArrayList<Sick> sickArrayList) {
        this.map = map;
        this.agentPosition = agentPosition;
        this.sickArrayList = sickArrayList;
    }

    public ArrayList<Node> getMap() {
        return map;
    }

    public void setMap(ArrayList<Node> map) {
        this.map = map;
    }

    public Node getAgentPosition() {
        return agentPosition;
    }

    public void setAgentPosition(Node position) {
        this.agentPosition = position;
    }

    public ArrayList<Sick> getSickArrayList() {
        return sickArrayList;
    }

    public void setSick(ArrayList<Sick> sickArrayList) {
        this.sickArrayList = sickArrayList;
    }

    public void addSick(Sick s){
        this.sickArrayList.add(s);
    }

    public void removeSick(Sick s){
        this.sickArrayList.remove(s);
    }

    @Override
    public void initState() {
        //Aca habria que cargar los csv
        //Ahora lo hago con un mapa mio nomas
        Node n101 = new Node(101);
        Node n102 = new Node(102);
        Node n103 = new Node(103);
        Node n104 = new Node(104);
        Node n201 = new Node(201);
        Node n202 = new Node(202);
        Node n203 = new Node(203);
        Node n204 = new Node(204);
        n101.addSuccessor(n201);
        n102.addSuccessor(n101);
        n103.addSuccessor(n102);
        n103.addSuccessor(n203);
        n104.addSuccessor(n103);
        n201.addSuccessor(n202);
        n202.addSuccessor(n203);
        n202.addSuccessor(n102);
        n203.addSuccessor(n204);
        n204.addSuccessor(n104);
        map.add(n101);
        map.add(n102);
        map.add(n103);
        map.add(n104);
        map.add(n201);
        map.add(n202);
        map.add(n203);
        map.add(n204);
        agentPosition = n101;
        Sick sick1 = new Sick(1,n204,n103);
        sickArrayList.add(sick1);
    }

    @Override
    public String toString() {
        return null;
    }
}
