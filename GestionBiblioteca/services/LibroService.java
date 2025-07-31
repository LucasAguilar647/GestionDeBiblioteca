package GestionBiblioteca.services;

import GestionBiblioteca.dtos.LibroDTO;
import  GestionBiblioteca.dtos.LibroDTO;

public interface LibroService {

    void agregarLibro(LibroDTO libroDTO);
    LibroDTO obtenerLibroPorId(long id);
}
