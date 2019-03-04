package external.dal;

import entidades.Criaturita;
import entidades.Regalo;
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

    @Override
    public ArrayList<Criaturita> getListadoCriaturitas() {
        String hqlQuery = "FROM entidades.Criaturita";
        Query query = session.createQuery(hqlQuery);
        return new ArrayList<Criaturita>(query.list());
    }

    @Override
    public void quitarRegalo(int idRegalo) {
        Transaction transaction = session.beginTransaction();
        try {
            Regalo regalo = session.get(Regalo.class, idRegalo);
            regalo.setGoesTo(null);
            session.update(regalo);
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
        }
    }

    @Override
    public void asignarRegalo(int idCriaturita, int idRegalo) {
        Transaction transaction = session.beginTransaction();
        try {
            Regalo regalo = session.get(Regalo.class, idRegalo);
            regalo.setGoesTo(idCriaturita);
            session.update(regalo);
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
        }
    }

    @Override
    public void crearCriaturita(Criaturita criaturita) {
        byte id = (byte)session.createQuery("SELECT MAX(id) FROM Criaturita").uniqueResult();
        criaturita.setId(++id);
        session.beginTransaction();
        session.save(criaturita);
        session.getTransaction().commit();
    }

    @Override
    public void borrarCriaturita(int idCriaturita) {
        session.beginTransaction();
        Criaturita criaturita = session.get(Criaturita.class, idCriaturita);
        quitarRegalosDeCriaturita(idCriaturita);
        session.delete(criaturita);
        session.getTransaction().commit();
    }

    private void quitarRegalosDeCriaturita(int idCriaturita){
    }

}
