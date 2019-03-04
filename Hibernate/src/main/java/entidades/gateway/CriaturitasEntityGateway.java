package entidades.gateway;

import entidades.Criaturita;

import java.util.ArrayList;

public interface CriaturitasEntityGateway {
    public ArrayList<Criaturita> getListadoCriaturitas();
    public void quitarRegalo(int idRegalo);
    public void asignarRegalo(int idCriaturita, int idRegalo);
    public void crearCriaturita(Criaturita criaturita);
    public void borrarCriaturita(int idCriaturita);
}
