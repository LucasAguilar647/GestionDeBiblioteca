package GestionBiblioteca.daos;

import GestionBiblioteca.entities.Libro;

import java.util.Map;
import java.util.Optional;

public interface EntityDao <T> {
    Map<Long, T> getAll();
    Optional<T> findById(Long id);
    void Save(T newEntity);
}