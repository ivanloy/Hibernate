import boundaries.ListarCriaturitasBoundary;
import casosdeuso.ListarCriaturitas;
import com.google.inject.AbstractModule;
import entidades.gateway.CriaturitasEntityGateway;
import external.dal.CriaturitasDAO;

public class AppModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(CriaturitasEntityGateway.class).to(CriaturitasDAO.class);
        bind(ListarCriaturitasBoundary.class).to(ListarCriaturitas.class);
    }
}
