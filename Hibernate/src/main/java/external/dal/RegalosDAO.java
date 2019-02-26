package external.dal;

import entidades.Regalo;
import entidades.gateway.RegalosEntityGateway;
import hibernateutil.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.ArrayList;

public class RegalosDAO implements RegalosEntityGateway {

    private static final SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
    private static final Session session = sessionFactory.openSession();

    public ArrayList<Regalo> getListadoRegalos() {
        String hqlQuery = "FROM Regalo";
        Query query = session.createQuery(hqlQuery);
        return new ArrayList<Regalo>(query.list());
    }

    public ArrayList<Regalo> getListadoRegalos(int idCriaturita){
        Query query = getQueryListadoRegalos(idCriaturita);
        return new ArrayList<Regalo>(query.list());
    }

    private Query getQueryListadoRegalos(int idCriaturita){
        String hqlQuery = "FROM Regalo WHERE goesTo = " + idCriaturita;
        return session.createQuery(hqlQuery);
    }

}
