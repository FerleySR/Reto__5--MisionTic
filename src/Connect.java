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
            return null;
        }
    }
    public void actualizar(String sql)
    {
        try
        {
            ejecutor = conn.createStatement();
            ejecutor.executeUpdate(sql);
        }
        catch (Exception e)
        {

        }
    }
    public void borrar(String sql)
    {
        try
        {
            ejecutor = conn.createStatement();
            ejecutor.executeUpdate(sql);
        }
        catch (Exception e)
        {
        }
    }
    
}