package GestionBiblioteca.daos;

import GestionBiblioteca.entities.Libro;

import java.sql.*;
import java.util.Optional;

public class LibroDAO implements EntityDao<Libro> {

    private final Connection connection;

    public LibroDAO(String dbUrl) throws SQLException {
        this.connection = DriverManager.getConnection(dbUrl);
        inicializarTabla();
    }

    private void inicializarTabla() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS libros ("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "titulo TEXT NOT NULL, "
                + "autor TEXT NOT NULL, "
                + "anio INTEGER NOT NULL, "
                + "disponible BOOLEAN NOT NULL DEFAULT 1"
                + ");";
        try (Statement stmt = connection.createStatement()) {
            stmt.execute(sql);
        }
    }


    @Override
    public Optional<Libro> findById(Long id) {
        String sql = "SELECT * FROM libros WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Libro libro = new Libro(
                        rs.getLong("id"),
                        rs.getString("titulo"),
                        rs.getString("autor"),
                        rs.getInt("anio"),
                        rs.getBoolean("disponible")
                );
                return Optional.of(libro);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al buscar libro", e);
        }
        return Optional.empty();
    }

    @Override
    public void Save(Libro libro) {
        String sql = "INSERT INTO libros (titulo, autor, anio, disponible) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, libro.getTitulo());
            stmt.setString(2, libro.getAutor());
            stmt.setInt(3, libro.getAnioPublicacion());
            stmt.setBoolean(4, libro.isDisponible());

            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                libro.setId(rs.getLong(1));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al guardar libro", e);
        }
    }

    public void vaciarTabla() {
        String sql = "DELETE FROM libros";
        try (Statement stmt = connection.createStatement()) {
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            throw new RuntimeException("Error al vaciar tabla libros", e);
        }
    }

}
