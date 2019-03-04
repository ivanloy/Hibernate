package casosdeuso;

import boundaries.BorrarRegaloBoundary;
import boundaries.CrearCriaturitaBoundary;
import entidades.Criaturita;
import entidades.Regalo;
import entidades.gateway.CriaturitasEntityGateway;
import entidades.gateway.RegalosEntityGateway;

import javax.inject.Inject;

public class BorrarRegalo implements BorrarRegaloBoundary {
    private RegalosEntityGateway regalosEntityGateway;

    @Override
    public void borrarRegalo(int id) {
        regalosEntityGateway.borrarRegalo(id);
    }

    @Inject
    public void setRegalosEntityGateway(RegalosEntityGateway regalosEntityGateway){
        this.regalosEntityGateway = regalosEntityGateway;
    }
}