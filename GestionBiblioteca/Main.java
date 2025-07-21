import controllers.LibroController;
import daos.LibroDAO;
import dtos.LibroDTO;
import services.LibroServiceImpl;

public class Main {
    public static void main(String[] args) {

        LibroDAO dao = new LibroDAO();
        LibroServiceImpl service = new LibroServiceImpl(dao);
        LibroController controller = new LibroController(service);


        controller.agregarLibro(new LibroDTO(null, "El Principito", "Saint-Exupéry", 1943));
        controller.agregarLibro(new LibroDTO(null, "", "Sin Título", 2020));

        controller.obtenerLibroPorId(1);
        controller.obtenerLibroPorId(99); 
    }
}
