package services;

import daos.EntityDao;
import dtos.LibroDTO;
import entities.Libro;

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
