package CovidAgent;

import CovidAgent.Actions.Go;
import CovidAgent.Actions.MulctSick;
import frsf.cidisi.faia.agent.Action;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.agent.search.Problem;
import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgent;
import frsf.cidisi.faia.solver.search.DepthFirstSearch;
import frsf.cidisi.faia.solver.search.Search;

import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CovidAgent extends SearchBasedAgent {

    public CovidAgent() {
        CovidGoal goal = new CovidGoal();
        CovidAgentState covidAgentState = new CovidAgentState();
        this.setAgentState(covidAgentState);
        Vector<SearchAction> operators = new Vector<SearchAction>();

        for (Node n: ((CovidAgentState)this.getAgentState()).getKnownMap()){
            operators.add(new Go(n));
        }
        operators.add(new MulctSick());

        Problem problem = new Problem(goal,covidAgentState,operators);
        this.setProblem(problem);
    }

    @Override
    public void see(Perception p) {
        this.getAgentState().updateState(p);
    }

    @Override
    public Action selectAction() {
        //TODO aca como estoy probando lo hice solo con Depth First Search, despues hay que agregar todas las otras
        //Esto esta copiado de la otra version, confio en que ande jaja
        DepthFirstSearch depthFirstSearch = new DepthFirstSearch();
        Search dfsSolver = new Search(depthFirstSearch);
        dfsSolver.setVisibleTree(Search.EFAIA_TREE);
        this.setSolver(dfsSolver);

        Action selectedAction = null;
        try {
            selectedAction = this.getSolver().solve(new Object[]{this.getProblem()});
        } catch (Exception ex) {
            Logger.getLogger(CovidAgent.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Regresar la acción definida
        return selectedAction;
    }
}
