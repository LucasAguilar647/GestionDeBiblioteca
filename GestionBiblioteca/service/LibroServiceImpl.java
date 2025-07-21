package service;

import GestionBiblioteca.dao.LibroDAO;
import GestionBiblioteca.dao.EntityDao;
import GestionBiblioteca.dto.LibroDTO;
import GestionBiblioteca.entity.Libro;

public class LibroServiceImpl implements LibroService {

    private final EntityDao<Libro> libroDAO;

    public LibroServiceImpl(EntityDao<Libro> libroDAO) {
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
