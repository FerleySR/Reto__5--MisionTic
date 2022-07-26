import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class BaseDatos {
    private String urlConector = "jdbc:sqlite:datosFarmacia.db";
    private Connection conexion;
    private Statement ejecutor;

    public boolean crearConexion() {
        try {
            Class.forName("org.sqlite.JDBC");
            conexion = DriverManager.getConnection(urlConector);
            ejecutor = conexion.createStatement();
            ejecutor.setQueryTimeout(30);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 
     */
    public void cerrarConexion() {
        try {
            conexion.close();
        } catch (Exception e) {
            
        }
    }

    public int insertar(String sql) {
        try {
            return ejecutor.executeUpdate(sql);
        } catch (Exception e) {
            return 0;
        }
    }
    public ResultSet consultar(String sql)
    {
        try
        {
            return ejecutor.executeQuery(sql);
        }
        catch (Exception e)
        {
            return null;
        }
    }

}
