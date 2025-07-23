package GestionBiblioteca.controllers;

import GestionBiblioteca.dtos.LibroDTO;
import GestionBiblioteca.entities.Libro;
import org.springframework.web.bind.annotation.*;
import GestionBiblioteca.services.LibroService;

import java.util.Map;


@RestController
@RequestMapping("/")
public class LibroControllerSpring {

    private final LibroService service;

    public LibroControllerSpring(LibroService service){
        this.service = service;
    }

    @GetMapping("/hello")
    public String hello() {
        return "¡Hola desde Spring Boot en GestionBiblioteca!";
    }

    @PostMapping("/libro/cargarLibros")
    public void cargarLibros(){
        service.cargarLibros();
    }

    @GetMapping("/libro/")
    public Map<Long, Libro> traerTodos(){
        return service.traerTodos();
    }

    @PostMapping("/")
    public void agregarLibro(@RequestBody LibroDTO libroDto){
        service.agregarLibro(libroDto);
    }

    @GetMapping("/libro/{id}")
    public LibroDTO getLibro(@PathVariable("id") long id){
        return service.obtenerLibroPorId(id);
    }

}
