import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author sqlitetutorial.net
 */
public class Connect {
    Connection conn = null;
    Statement ejecutor;
    public void connect() {
        try {
            // db parameters
            String url = "jdbc:sqlite:sqlite/db/sqlitetutorialdatosFarmacia.db";
            // create a connection to the database
            conn = DriverManager.getConnection(url);
            
            System.out.println("Connection to SQLite has been established.");
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    /**
     * 
     */
    public void closeConnect() {
        try {
            conn.close();
            System.out.println("Close.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    /**
     * @param id
     * @param nombre
     * @param temperatura
     * @param valorBase
     * @param costo
     */
    public void insert(String id, String nombre, double temperatura,double valorBase, double costo){
        String sql="INSERT INTO Farmacia(Id, Nombre, Temperatura, ValorBase,Costo) VALUES(?,?,?,?,?)";
        try (PreparedStatement prsql=conn.prepareStatement(sql)){
                prsql.setString(2, id);
                prsql.setString(1, nombre);
                prsql.setDouble(3, temperatura);
                prsql.setDouble(4, valorBase);
                prsql.setDouble(5, costo);
                prsql.executeUpdate();
                System.out.println("Insert");
            }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public ResultSet consultar(String sql)
    {
        try
        {
            ejecutor = conn.createStatement();
            System.out.println("Consult");
            ResultSet rs=ejecutor.executeQuery(sql);
            return  rs;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        }
    }
    public void actualizar(String id, String nombre, double temperatura,double valorBase, double costo)
    {
        String sql="UPDATE farmacia SET Nombre=?,Temperatura=?,ValorBase=?,Costo=? WHERE Id=?";
        try(PreparedStatement prsql=conn.prepareStatement(sql))
        {
            prsql.setString(1, nombre);
            prsql.setDouble(2, temperatura);
            prsql.setDouble(3, valorBase);
            prsql.setDouble(4, costo);
            prsql.setString(5,id);
            prsql.executeUpdate();
            System.out.println("Update");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    public void delete(String sql)
    {
        String delet="DELETE FROM farmacia WHERE Id=?";
        try(PreparedStatement prsql=conn.prepareStatement(delet))
        {
            prsql.setString(1, sql);
            prsql.executeUpdate();
            System.out.println("Delete");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    public ResultSet busqueda(String sql)
    {
        String buscar="SELECT * FROM farmacia WHERE Id LIKE \"%"+sql+"%\""+"OR nombre LIKE \"%"+sql+"%\" "; 
        try
        {
            ejecutor = conn.createStatement();
            System.out.println("Consultas");
            ResultSet rs=ejecutor.executeQuery(buscar);
            return  rs;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        }
    }
}