package CovidAgent;

import frsf.cidisi.faia.exceptions.PrologConnectorException;
import frsf.cidisi.faia.simulator.SearchBasedAgentSimulator;

public class CovidMain {
    public static void main(String[] args) throws PrologConnectorException {

        CovidEnvironment covidEnvironment = new CovidEnvironment();

        CovidAgent covidAgent = new CovidAgent();

        SearchBasedAgentSimulator simulator =
                new SearchBasedAgentSimulator(covidEnvironment, covidAgent);

        simulator.start();
    }
}
