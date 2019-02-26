package boundaries;

import entidades.Criaturita;
import entidades.Regalo;

import java.util.ArrayList;

public interface ListarRegalosBoundary {
    public ArrayList<Regalo> getListadoRegalos();
    public ArrayList<Regalo> getListadoRegalos(int idCriaturita);
}
