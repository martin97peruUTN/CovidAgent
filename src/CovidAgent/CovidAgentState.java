package CovidAgent;

import frsf.cidisi.faia.agent.Action;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;

import java.util.ArrayList;
import java.util.Objects;

public class CovidAgentState extends SearchBasedAgentState {

    private ArrayList<Node> knownMap;
    private Node position;
    private ArrayList<Sick> sickArrayList;

    public CovidAgentState() {
        this.knownMap = new ArrayList<Node>();
        this.sickArrayList = new ArrayList<Sick>();
        this.initState();
    }

    public CovidAgentState(ArrayList<Node> map, Node position, ArrayList<Sick> sickArrayList) {
        this.knownMap = map;
        this.position = position;
        this.sickArrayList = sickArrayList;
    }

    public ArrayList<Node> getKnownMap() {
        return knownMap;
    }

    public void setKnownMap(ArrayList<Node> map) {
        this.knownMap = knownMap;
    }
    public Node getPosition() {
        return position;
    }

    public void setPosition(Node position) {
        this.position = position;
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
    public SearchBasedAgentState clone() {
        //No estoy seguro que este clone ande 100%
        CovidAgentState newState = new CovidAgentState();
        newState.setPosition(position);
        ArrayList<Sick> newSickArrayList = (ArrayList<Sick>) sickArrayList.clone();
        newState.setSick(newSickArrayList);
        return newState;
    }

    @Override
    public void updateState(Perception p) {
        CovidPerception covidPerception = (CovidPerception) p;
        this.setKnownMap(covidPerception.getMap());
        //Los de la posicion no se si va
        this.setPosition(covidPerception.getAgentPosition());
        this.setSick(covidPerception.getSickArrayList());
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
        knownMap.add(n101);
        knownMap.add(n102);
        knownMap.add(n103);
        knownMap.add(n104);
        knownMap.add(n201);
        knownMap.add(n202);
        knownMap.add(n203);
        knownMap.add(n204);
        position = n101;
        Sick sick1 = new Sick(1,n204,n103);
        sickArrayList.add(sick1);
    }

    @Override
    public String toString() {
        //TODO
        return "String de CovidAgentState";
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof CovidAgentState))
            return false;
        ArrayList<Node> objMap = ((CovidAgentState) obj).getKnownMap();
        Node objPosition = ((CovidAgentState) obj).getPosition();
        ArrayList<Sick> objSick = ((CovidAgentState) obj).getSickArrayList();
        if(!objPosition.equals(position)){
            return false;
        }
        for(int i=0;i<objMap.size();i++){
            if (!objMap.get(i).equals(knownMap.get(i))){
                return false;
            }
        }
        for(int i=0;i<objSick.size();i++){
            if(!objSick.get(i).equals(sickArrayList.get(i))){
                return false;
            }
        }
        return true;
    }
}
