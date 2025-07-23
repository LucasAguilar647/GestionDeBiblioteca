package GestionBiblioteca.daos;

import GestionBiblioteca.entities.Libro;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
@Component
public class LibroDAO implements EntityDao<Libro> {
    private final Map<Long, Libro> data;
    private Long lastIdAdded = 0L;

    public LibroDAO() {
        this.data = new HashMap<>();
    }


    @Override
    public Map<Long, Libro> getAll() {
        return data;
    }

    public Optional<Libro> findById(Long id) {
        if (!data.containsKey(id)) {
            return Optional.empty();
        }
        return Optional.of(data.get(id));
    }

    public void Save(Libro newLibro) {
        if (newLibro.getId() != 0) {
            throw new IndexOutOfBoundsException("El libro ya posee un Id distinto de cero. Esto no está soportado.");
        }
        newLibro.setId(nextId());
        data.putIfAbsent(newLibro.getId(), newLibro);
    }

    private Long nextId() {
        return ++lastIdAdded;
    }
}
