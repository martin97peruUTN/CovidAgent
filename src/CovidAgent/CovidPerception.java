package CovidAgent;

import frsf.cidisi.faia.agent.Agent;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.environment.Environment;

import java.util.ArrayList;

public class CovidPerception extends Perception {

    private ArrayList<Node> map;
    private Node agentPosition;
    private ArrayList<Sick> sickArrayList;

    public CovidPerception() {
    }

    public CovidPerception(Agent agent, Environment environment) {
        super(agent, environment);
    }

    @Override
    public void initPerception(Agent agent, Environment environment) {
        CovidAgent covidAgent = (CovidAgent) agent;
        CovidEnvironment covidEnvironment = (CovidEnvironment) environment;
        CovidEnvironmentState covidEnvironmentState = (CovidEnvironmentState) covidEnvironment.getEnvironmentState();
        map = covidEnvironmentState.getMap();
        agentPosition = covidEnvironmentState.getAgentPosition();
        sickArrayList = covidEnvironmentState.getSickArrayList();
    }

    @Override
    public String toString() {
        //TODO
        return "String de la percepcion";
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

    public void setAgentPosition(Node agentPosition) {
        this.agentPosition = agentPosition;
    }

    public ArrayList<Sick> getSickArrayList() {
        return sickArrayList;
    }

    public void setSickArrayList(ArrayList<Sick> sickArrayList) {
        this.sickArrayList = sickArrayList;
    }
}
