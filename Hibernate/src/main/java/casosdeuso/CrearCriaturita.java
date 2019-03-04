package casosdeuso;

import boundaries.CrearCriaturitaBoundary;
import entidades.Criaturita;
import entidades.gateway.CriaturitasEntityGateway;

import javax.inject.Inject;

public class CrearCriaturita implements CrearCriaturitaBoundary {
    private CriaturitasEntityGateway criaturitasEntityGateway;

    @Override
    public void crearCriaturita(Criaturita criaturita) {
        criaturitasEntityGateway.crearCriaturita(criaturita);
    }

    @Inject
    public void setCriaturitasEntityGateway(CriaturitasEntityGateway criaturitasEntityGateway){
        this.criaturitasEntityGateway = criaturitasEntityGateway;
    }
}
