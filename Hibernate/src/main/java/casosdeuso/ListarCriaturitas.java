package casosdeuso;

import boundaries.ListarCriaturitasBoundary;
import entidades.Criaturita;
import entidades.gateway.CriaturitasEntityGateway;

import javax.inject.Inject;
import java.util.ArrayList;

public class ListarCriaturitas implements ListarCriaturitasBoundary {
    private CriaturitasEntityGateway criaturitasEntityGateway;

    public ArrayList<Criaturita> getListadoCriaturitas() {
        return criaturitasEntityGateway.getListadoCriaturitas();
    }

    @Inject
    public void setCriaturitasEntityGateway(CriaturitasEntityGateway criaturitasEntityGateway){
        this.criaturitasEntityGateway = criaturitasEntityGateway;
    }
}
