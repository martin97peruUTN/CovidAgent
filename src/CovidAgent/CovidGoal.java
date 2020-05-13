package CovidAgent;

import frsf.cidisi.faia.agent.search.GoalTest;
import frsf.cidisi.faia.state.AgentState;

public class CovidGoal extends GoalTest {

    @Override
    public boolean isGoalState(AgentState agentState) {

        CovidAgentState covidAgentState = (CovidAgentState) agentState;
        for(Sick s:covidAgentState.getSickArrayList()){
            if(!s.getHome().equals(s.getPosition())){
                return false;
            }
        }
        return true;
    }
}
