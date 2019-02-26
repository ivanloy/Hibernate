package casosdeuso;

import boundaries.ListarCriaturitasBoundary;
import boundaries.ListarRegalosBoundary;
import entidades.Criaturita;
import entidades.Regalo;
import entidades.gateway.CriaturitasEntityGateway;
import entidades.gateway.RegalosEntityGateway;

import javax.inject.Inject;
import java.util.ArrayList;

public class ListarRegalos implements ListarRegalosBoundary {
    private RegalosEntityGateway regalosEntityGateway;

    public ArrayList<Regalo> getListadoRegalos() {
        return regalosEntityGateway.getListadoRegalos();
    }

    public ArrayList<Regalo> getListadoRegalos(int idCriaturita) {
        return regalosEntityGateway.getListadoRegalos(idCriaturita);
    }

    @Inject
    public void setRegalosEntityGateway(RegalosEntityGateway regalosEntityGateway){
        this.regalosEntityGateway = regalosEntityGateway;
    }
}
