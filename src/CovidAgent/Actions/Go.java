package CovidAgent.Actions;

import CovidAgent.CovidAgentState;
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
        if(this.objectiveNode.getSuccessors().contains(s)){

        }

        return null;
    }

    @Override
    public Double getCost() {
        return cost;
    }

    @Override
    public EnvironmentState execute(AgentState ast, EnvironmentState est) {
        return null;
    }

    @Override
    public String toString() {
        return null;
    }
}
