package casosdeuso;

import boundaries.CrearCriaturitaBoundary;
import boundaries.CrearRegaloBoundary;
import entidades.Criaturita;
import entidades.Regalo;
import entidades.gateway.CriaturitasEntityGateway;
import entidades.gateway.RegalosEntityGateway;

import javax.inject.Inject;

public class CrearRegalo implements CrearRegaloBoundary {
    private RegalosEntityGateway regalosEntityGateway;

    @Override
    public void crearRegalo(Regalo regalo) {
        regalosEntityGateway.crearRegalo(regalo);
    }

    @Inject
    public void setRegalosEntityGateway(RegalosEntityGateway regalosEntityGateway){
        this.regalosEntityGateway = regalosEntityGateway;
    }

}
