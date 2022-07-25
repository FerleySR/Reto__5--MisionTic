import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
public class BaseDatos {
    private String conectorInstalado = "jdbc:sqlite:";
    private String rutaBaseDatos = "BaseDatos/datos.db";
    private Connection conexion;
    private Statement ejecutor;

    public void crearConexion() {
        try {
            this.conexion = DriverManager.getConnection(conectorInstalado + rutaBaseDatos);
            this.ejecutor = conexion.createStatement();
            this.ejecutor.setQueryTimeout(30);
        } catch (Exception e) {

        }
    }

    public void cerrarConexion() {
        try {
            this.conexion.close();
        } catch (Exception e) {

        }
    }

    public int insertar(String sql) {
        try {
            int cant = ejecutor.executeUpdate(sql);
            return cant;
        } catch (Exception e) {
            return 0;

        }
    }
}
