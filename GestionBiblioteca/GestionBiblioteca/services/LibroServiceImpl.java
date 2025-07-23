package GestionBiblioteca.services;

import GestionBiblioteca.daos.EntityDao;
import GestionBiblioteca.dtos.LibroDTO;
import GestionBiblioteca.entities.Libro;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;
@Service("libroServiceImpl")
public class LibroServiceImpl implements LibroService {

    private final EntityDao<Libro> libroDAO;

    public LibroServiceImpl(EntityDao<Libro> libroDAO) {
        this.libroDAO = libroDAO;
    }

    @Override
    public void cargarLibros() {
        libroDAO.Save(new Libro(0, "¿Cómo formatear una PC?", "Luisina de Paula", 2000, true));
        libroDAO.Save(new Libro(0, "¿Cómo mantener la seguridad?", "Gabriel Guismín", 1990, true));
    }

    public Map<Long, Libro> traerTodos(){
        return libroDAO.getAll();
    }

    @Override
    public void agregarLibro(LibroDTO libroDTO) {

        if (libroDTO == null) {
            throw new IllegalArgumentException("El libro no puede ser nulo");
        }
        if (libroDTO.getTitulo() == null || libroDTO.getTitulo().isEmpty()) {
            throw new IllegalArgumentException("El título del libro no puede estar vacío");
        }
        if (libroDTO.getAutor() == null || libroDTO.getAutor().isEmpty()) {
            throw new IllegalArgumentException("El autor del libro no puede estar vacío");
        }
        if (libroDTO.getAnioPublicacion() < 0) {
            throw new IllegalArgumentException("El año de publicación debe ser un número positivo");
        }

        Libro libro = new Libro(
                libroDTO.getId(),
                libroDTO.getTitulo(),
                libroDTO.getAutor(),
                libroDTO.getAnioPublicacion(),
                true // Asumimos que el libro está disponible al agregarlo
        );

        libroDAO.Save(libro);
    }

    @Override
    public LibroDTO obtenerLibroPorId(long id) {

        Optional<Libro> libroOptional = libroDAO.findById(id);
        if (libroOptional.isEmpty()) {
            throw new IllegalArgumentException("No se encontró un libro con el ID proporcionado");
        }
        Libro libro = libroOptional.get();

        return new LibroDTO(
                libro.getId(),
                libro.getTitulo(),
                libro.getAutor(),
                libro.getAnioPublicacion()
        );
    }
}
