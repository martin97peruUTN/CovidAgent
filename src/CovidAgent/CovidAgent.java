package CovidAgent;

import CovidAgent.Actions.Go;
import frsf.cidisi.faia.agent.Action;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.agent.search.Problem;
import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgent;

import java.util.Vector;

public class CovidAgent extends SearchBasedAgent {

    public CovidAgent() {
        CovidGoal goal = new CovidGoal();
        CovidAgentState covidAgentState = new CovidAgentState();
        this.setAgentState(covidAgentState);
        Vector<SearchAction> operators = new Vector<SearchAction>();

        for (Node n: ((CovidAgentState)this.getAgentState()).getMap()){
            operators.add(new Go(n));
        }

        Problem problem = new Problem(goal,covidAgentState,operators);
        this.setProblem(problem);
    }

    @Override
    public void see(Perception p) {

    }

    @Override
    public Action selectAction() {
        return null;
    }
}
