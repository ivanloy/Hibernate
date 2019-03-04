import boundaries.*;
import casosdeuso.*;
import com.google.inject.AbstractModule;
import entidades.gateway.CriaturitasEntityGateway;
import entidades.gateway.RegalosEntityGateway;
import external.dal.CriaturitasDAO;
import external.dal.RegalosDAO;

public class AppModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(CriaturitasEntityGateway.class).to(CriaturitasDAO.class);
        bind(ListarCriaturitasBoundary.class).to(ListarCriaturitas.class);
        bind(RegalosEntityGateway.class).to(RegalosDAO.class);
        bind(ListarRegalosBoundary.class).to(ListarRegalos.class);
        bind(ModificarCriaturitaBoundary.class).to(ModificarCriaturita.class);
        bind(CrearCriaturitaBoundary.class).to(CrearCriaturita.class);
        bind(CrearRegaloBoundary.class).to(CrearRegalo.class);
        bind(BorrarRegaloBoundary.class).to(BorrarRegalo.class);
    }
}
