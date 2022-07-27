import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
public class BaseDatos {
    private String urlConector = "jdbc:sqlite:datosFarmacia.db";
    private Connection conexion;
    private Statement ejecutor;

    /**
     * @return
     */
    public boolean crearConexion() {
        try {
            Class.forName("org.sqlite.JDBC");
            conexion = DriverManager.getConnection(urlConector);
            ejecutor=conexion.createStatement();
            ejecutor.setQueryTimeout(30);
            return true;
        } catch (SQLException | ClassNotFoundException  e) {
            return false;
        }
    }

    /**
     * 
     */
    public boolean cerrarConexion() {
        try {
            conexion.close();
            return true;
        } catch (Exception e) {
            return false;
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
            e.printStackTrace();
            return null;
        }
    }

}
