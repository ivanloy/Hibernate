package external.dal;

import entidades.Criaturita;
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

    @Override
    public void crearRegalo(Regalo regalo) {
        byte id = (byte)session.createQuery("SELECT MAX(id) FROM Regalo ").uniqueResult();
        regalo.setId(++id);
        session.beginTransaction();
        session.save(regalo);
        session.getTransaction().commit();
    }

    @Override
    public void borrarRegalo(int idRegalo) {
        session.beginTransaction();
        Regalo regalo = session.get(Regalo.class, idRegalo);
        session.delete(regalo);
        session.getTransaction().commit();
    }

    private Query getQueryListadoRegalos(int idCriaturita){
        String hqlQuery = "FROM Regalo WHERE goesTo = " + idCriaturita;
        return session.createQuery(hqlQuery);
    }

}
