package GestionBiblioteca.services;

import GestionBiblioteca.dtos.LibroDTO;
import GestionBiblioteca.entities.Libro;

import java.util.Map;

public interface LibroService {
    void cargarLibros();
    Map<Long, Libro> traerTodos();
    void agregarLibro(LibroDTO libroDTO);
    LibroDTO obtenerLibroPorId(long id);
}
