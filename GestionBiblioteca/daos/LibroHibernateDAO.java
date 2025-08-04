package GestionBiblioteca.daos;

import GestionBiblioteca.entities.Libro;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Optional;

public class LibroHibernateDAO implements EntityDao<Libro> {

    private final SessionFactory sessionFactory;

    public LibroHibernateDAO() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    @Override
    public Optional<Libro> findById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return Optional.ofNullable(session.get(Libro.class, id));
        }
    }

    @Override
    public void Save(Libro libro) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.merge(libro);
            session.getTransaction().commit();
        }
    }

    public void vaciarTabla() {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.createMutationQuery("DELETE FROM Libro").executeUpdate();
            session.getTransaction().commit();
        }
    }
}
