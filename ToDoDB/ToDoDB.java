package todoapp;

import java.sql.*;

public class TodoDB {

    private static final String DB_URL = "jdbc:sqlite:todo.db";

    public TodoDB() {
        initSchema();
    }

    private Connection connect() throws SQLException {
        return DriverManager.getConnection(DB_URL);
    }

    private void initSchema() {

        String sql = """
            CREATE TABLE IF NOT EXISTS todo (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                task TEXT NOT NULL
            );
        """;

        try (Connection conn = connect();
             Statement stmt = conn.createStatement()) {

            stmt.execute(sql);

        } catch (SQLException e) {
            throw new RuntimeException("Schema init failed: " + e.getMessage());
        }
    }

    // ADD
    public void add(String task) {

        String sql = "INSERT INTO todo(task) VALUES(?)";

        try (Connection conn = connect();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, task);
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // FIND ALL
    public void findAll() {

        String sql = "SELECT * FROM todo";

        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + ": " +
                        rs.getString("task")
                );
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // REMOVE
    public void removeById(int id) {

        String sql = "DELETE FROM todo WHERE id = ?";

        try (Connection conn = connect();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}