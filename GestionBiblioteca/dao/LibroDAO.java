package GestionBiblioteca.dao;

import GestionBiblioteca.entity.Libro;
import jdk.jshell.spi.ExecutionControl;

import java.util.Map;
import java.util.Optional;

public class LibroDAO {
    private final Map<Long, Libro> data;

    public LibroDAO(Map<Long, Libro> data) {
        this.data = data;
    }


    public Optional<Libro> findById(Long id) {
        throw new ExecutionControl.NotImplementedException("");
    }

    public void Save(Libro newLibro) {
        throw new ExecutionControl.NotImplementedException("");
    }
}
