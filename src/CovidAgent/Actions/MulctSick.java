package CovidAgent.Actions;

import CovidAgent.Node;
import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;

public class MulctSick extends SearchAction {

    Double cost = 1.0;

    @Override
    public SearchBasedAgentState execute(SearchBasedAgentState s) {
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
