import controllers.LibroController;
import daos.LibroDAO;
import dtos.LibroDTO;
import services.LibroServiceImpl;

public class Main {
    public static void main(String[] args) {


        LibroDAO dao = new LibroDAO();
        LibroServiceImpl service = new LibroServiceImpl(dao);
        LibroController controller = new LibroController(service);


        try {
            controller.PostLibro(new LibroDTO(null, "El Principito", "Saint-Exupéry", 1943));
            controller.PostLibro(new LibroDTO(null, "1984", "George Orwell", 1949));
            controller.PostLibro(new LibroDTO(null, "Sin título", "Desconocido", 2020)); // válido
        } catch (IllegalArgumentException e) {
            System.out.println("Error al agregar libro: " + e.getMessage());
        }


        try {
            LibroDTO libro1 = controller.getLibro(1);
            System.out.println("Libro con ID 1: " + libro1.getTitulo());

            LibroDTO libro2 = controller.getLibro(2);
            System.out.println("Libro con ID 2: " + libro2.getTitulo());
        } catch (IllegalArgumentException e) {
            System.out.println("Error al obtener libro: " + e.getMessage());
        }


        try {
            LibroDTO libroInexistente = controller.getLibro(99);
            System.out.println("Libro con ID 99: " + libroInexistente);
        } catch (IllegalArgumentException e) {
            System.out.println("No se encontró el libro con ID 99: " + e.getMessage());
        }
    }
}
