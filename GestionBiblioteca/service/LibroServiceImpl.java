package service;

import GestionBiblioteca.dao.LibroDAO;
import GestionBiblioteca.dto.LibroDTO;

public class LibroServiceImpl implements LibroService {

    private final LibroDAO libroDAO;

    public LibroServiceImpl(LibroDAO libroDAO) {
        this.libroDAO = libroDAO;
    }

    @Override
    public void agregarLibro(LibroDTO libroDTO) {

    }

    @Override
    public LibroDTO obtenerLibroPorId(long id) {
        return null;
    }
}
