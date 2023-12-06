package repositories;
import org.example.Dbconfiguration;
import org.example.models.Laptop;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class LaptopRepository {
    private final SessionFactory sessionFactory = Dbconfiguration.getSessionFactory();

    public void save(Laptop laptop) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(laptop);
        transaction.commit();
        session.close();
    }
    public void deleteAll(){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query <Laptop> query= session.createQuery("delete  from Laptop ");
        query.executeUpdate();
        transaction.commit();
        session.close();
    }
    public void update(Long id, Laptop laptop){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Laptop laptop1 = session.get(Laptop.class,id);
        laptop1.setModel(laptop.getModel());
        laptop1.setInvented_by(laptop.getInvented_by());
        session.update(laptop1);
    }

    public Laptop findById(Long id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Laptop laptop = session.get(Laptop.class, id);
        session.close();
        return laptop;
    }
}
