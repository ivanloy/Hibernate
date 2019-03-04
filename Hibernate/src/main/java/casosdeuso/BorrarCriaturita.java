package casosdeuso;

import boundaries.BorrarCriaturitaBoundary;
import boundaries.BorrarRegaloBoundary;
import entidades.gateway.CriaturitasEntityGateway;
import entidades.gateway.RegalosEntityGateway;

import javax.inject.Inject;

public class BorrarCriaturita implements BorrarCriaturitaBoundary {
    private CriaturitasEntityGateway criaturitasEntityGateway;

    @Override
    public void borrarCriaturita(int id) {
        criaturitasEntityGateway.borrarCriaturita(id);
    }

    @Inject
    public void setRegalosEntityGateway(CriaturitasEntityGateway criaturitasEntityGateway){
        this.criaturitasEntityGateway = criaturitasEntityGateway;
    }
}