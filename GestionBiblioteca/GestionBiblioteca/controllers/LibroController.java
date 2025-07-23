package GestionBiblioteca.controllers;

import GestionBiblioteca.dtos.LibroDTO;
import GestionBiblioteca.services.LibroService;

public class LibroController {
    private final LibroService service;

    public LibroController(LibroService service) {
        this.service = service;
    }

    public LibroDTO getLibro(long id) {
        return service.obtenerLibroPorId(id);
    }

    public void PostLibro(LibroDTO libroDto) {
        service.agregarLibro(libroDto);
    }
}
