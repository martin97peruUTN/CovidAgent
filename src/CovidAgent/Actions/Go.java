package CovidAgent.Actions;

import CovidAgent.CovidAgentState;
import CovidAgent.CovidEnvironmentState;
import CovidAgent.Node;
import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;

public class Go extends SearchAction {

    Double cost = 1.0;
    Node objectiveNode;

    public Go(Node objectiveNode) {
        this.objectiveNode = objectiveNode;
    }

    @Override
    public SearchBasedAgentState execute(SearchBasedAgentState s) {
        CovidAgentState agentState = (CovidAgentState) s;
        if(agentState.getPosition().getSuccessors().contains(objectiveNode)) {
            agentState.setPosition(objectiveNode);
            return agentState;
        }
        return null;
    }

    @Override
    public Double getCost() {
        return cost;
    }

    @Override
    public EnvironmentState execute(AgentState ast, EnvironmentState est) {
        CovidAgentState covidAgentState = (CovidAgentState) ast;
        CovidEnvironmentState covidEnvironmentState = (CovidEnvironmentState) est;
        if(this.execute((SearchBasedAgentState) ast)!=null) {
            ((CovidEnvironmentState) est).setAgentPosition(this.objectiveNode);
        }
        return covidEnvironmentState;
    }

    @Override
    public String toString() {
        //TODO
        return "String del Go del nodo "+objectiveNode.getId().toString();
    }
}
