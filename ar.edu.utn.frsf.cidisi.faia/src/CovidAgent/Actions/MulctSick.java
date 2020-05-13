package CovidAgent.Actions;

import CovidAgent.CovidAgentState;
import CovidAgent.CovidEnvironmentState;
import CovidAgent.Node;
import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;

public class MulctSick extends SearchAction {

    Double cost = 1.0;

    public MulctSick() {
    }

    @Override
    public SearchBasedAgentState execute(SearchBasedAgentState s) {
        CovidAgentState agentState = (CovidAgentState) s;
        for(int i=0;i<agentState.getSickArrayList().size();i++){
            if(agentState.getSickArrayList().get(i).getPosition().equals(agentState.getPosition())){
                agentState.getSickArrayList().get(i).addMulct();
                agentState.getSickArrayList().get(i).setPosition(agentState.getSickArrayList().get(i).getHome());
                return agentState;
            }
        }
        //No se si aca tambien tendria que retornar agenteState tambien o no
        return null;
    }

    @Override
    public Double getCost() {
        return cost;
    }

    @Override
    public EnvironmentState execute(AgentState ast, EnvironmentState est) {
        CovidAgentState agentState = (CovidAgentState) ast;
        CovidEnvironmentState covidEnvironmentState = (CovidEnvironmentState) est;
        for(int i=0;i<covidEnvironmentState.getSickArrayList().size();i++){
            if(covidEnvironmentState.getSickArrayList().get(i).getPosition().equals(covidEnvironmentState.getAgentPosition())){
                agentState.getSickArrayList().get(i).addMulct();
                agentState.getSickArrayList().get(i).setPosition(agentState.getSickArrayList().get(i).getHome());
                covidEnvironmentState.getSickArrayList().get(i).addMulct();
                covidEnvironmentState.getSickArrayList().get(i).setPosition(covidEnvironmentState.getSickArrayList().get(i).getHome());
                return covidEnvironmentState;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        //TODO
        return "String del mulct";
    }
}
