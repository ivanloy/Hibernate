package external.dal;

import entidades.Criaturita;
import entidades.gateway.CriaturitasEntityGateway;
import hibernateutil.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;

public class CriaturitasDAO implements CriaturitasEntityGateway {

    private static final SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
    private static final Session session = sessionFactory.openSession();

    public ArrayList<Criaturita> getListadoCriaturitas() {
        String hqlQuery = "FROM entidades.Criaturita";
        Query query = session.createQuery(hqlQuery);
        return new ArrayList<Criaturita>(query.list());
    }

    public void quitarRegalo(int idRegalo) {
        Transaction transaction = session.beginTransaction();
        try {
            String hqlQuery = "UPDATE Regalo SET goesTo = null WHERE id = " + idRegalo;
            Query query = session.createQuery(hqlQuery);
            System.out.println("res " + query.executeUpdate());
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
        }
    }

}
