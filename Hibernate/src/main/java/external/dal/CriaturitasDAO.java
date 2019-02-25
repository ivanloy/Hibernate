package external.dal;

import entidades.Criaturita;
import entidades.gateway.CriaturitasEntityGateway;
import hibernateutil.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.ArrayList;

public class CriaturitasDAO implements CriaturitasEntityGateway {

    private static final SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
    private static final Session session = sessionFactory.openSession();

    public ArrayList<Criaturita> getListadoCriaturitas() {
        String hqlQuery = "FROM entidades.Criaturita";
        Query query = session.createQuery(hqlQuery);
        return new ArrayList<>(query.list());
    }
}
