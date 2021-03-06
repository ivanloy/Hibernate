package casosdeuso;

import boundaries.ListarRegalosBoundary;
import boundaries.ModificarCriaturitaBoundary;
import boundaries.ModificarRegaloBoundary;
import entidades.gateway.CriaturitasEntityGateway;
import entidades.gateway.RegalosEntityGateway;

import javax.inject.Inject;

public class ModificarCriaturita implements ModificarCriaturitaBoundary {
    private CriaturitasEntityGateway criaturitasEntityGateway;

    public void quitarRegalo(int idRegalo){
        criaturitasEntityGateway.quitarRegalo(idRegalo);
    }

    @Override
    public void asignarRegalo(int idCriaturita, int idRegalo) {
        criaturitasEntityGateway.asignarRegalo(idCriaturita, idRegalo);
    }

    @Inject
    public void setRegalosEntityGateway(CriaturitasEntityGateway criaturitasEntityGateway){
        this.criaturitasEntityGateway = criaturitasEntityGateway;
    }
}
