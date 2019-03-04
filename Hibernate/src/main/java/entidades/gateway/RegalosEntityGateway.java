package entidades.gateway;

import entidades.Criaturita;
import entidades.Regalo;

import java.util.ArrayList;

public interface RegalosEntityGateway {
    public ArrayList<Regalo> getListadoRegalos();
    public ArrayList<Regalo> getListadoRegalos(int idCriaturita);
    public void crearRegalo(Regalo regalo);
    public void borrarRegalo(int idRegalo);
}
