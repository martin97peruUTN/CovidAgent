package CovidAgent;

import frsf.cidisi.faia.agent.Action;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.environment.Environment;

public class CovidEnvironment extends Environment {

    public CovidEnvironment() {
        this.environmentState = new CovidEnvironmentState();
    }

    public CovidEnvironmentState getEnvironmentState(){
        return (CovidEnvironmentState) super.getEnvironmentState();
    }

    @Override
    public Perception getPercept() {
        //Aca se meterian los movimientos de enfermos, cortes de calla, nuevos enfermos, etc.
        //Pero directamente hay que modificar el EnvironmentState y despues generar la percepcion para que actualice al agente

        CovidPerception p = new CovidPerception();

        return p;
    }

    @Override
    public String toString() {
        return environmentState.toString();
    }

    //Hay un metodo agentFailed que no se si tengo que usar o no
}
