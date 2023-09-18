package example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args){

        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Group.class)
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Group physic = new Group("physic");
        Group maths = new Group("maths");

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.save(physic);
        session.save(maths);

        transaction.commit();

    }
}
