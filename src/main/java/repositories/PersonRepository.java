package repositories;
import org.example.Dbconfiguration;
import org.example.models.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class PersonRepository {
    private final SessionFactory sessionFactory= Dbconfiguration.getSessionFactory();

    public void save (Person person ){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(person);
        transaction.commit();
        session.close();
    }
    public List<Person> findAll(){
        Session session = sessionFactory.openSession();
        Query<Person>query = session.createQuery("select p from Person p");
        List<Person >list = query.getResultList();
        session.close();
        return list;
    }
    public void update(Long id, Person person){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Person person1 = session.get(Person.class,id);
        person1.setInfo(person.getInfo());
        person1.setAge(person.getAge());
        session.update(person1);
    }
    public void deleteById(Long id){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Person person = session.get(Person.class,id);
        session.delete(person);
        transaction.commit();
        session.close();
    }

}
