package CovidAgent;

import frsf.cidisi.faia.exceptions.PrologConnectorException;
import frsf.cidisi.faia.simulator.SearchBasedAgentSimulator;

public class CovidMain {
    public static void main(String[] args) throws PrologConnectorException {
        CovidAgent covidAgent = new CovidAgent();

        CovidEnvironment covidEnvironment = new CovidEnvironment();

        SearchBasedAgentSimulator simulator =
                new SearchBasedAgentSimulator(covidEnvironment, covidAgent);

        simulator.start();
    }
}
