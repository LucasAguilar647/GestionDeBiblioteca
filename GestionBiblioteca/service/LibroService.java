package service;

import GestionBiblioteca.dto.LibroDTO;

public interface LibroService {

    void agregarLibro(LibroDTO libroDTO);
    LibroDTO obtenerLibroPorId(long id);
}
