import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Almacen {
    List <Producto> listaProductos;
    public Almacen()
    {
        this.listaProductos = new ArrayList<Producto>();
    }
    public List<Producto> getProductos() {
        listaProductos= new ArrayList<Producto>();
        Connect bd=new Connect();
        bd.connect();
        ResultSet rs = bd.consultar("SELECT * FROM farmacia");
        try
        {
            while(rs.next())
            {
                String id = rs.getString(1);
                String nombre = rs.getString(2);
                Double temperatura=rs.getDouble(3);
                Double valorBase=rs.getDouble(4);
                Double costo=rs.getDouble(5);
                Producto busqueda;
                busqueda=new Producto(nombre, id, temperatura,valorBase, costo);
                this.listaProductos.add(busqueda);
            }
        }
        catch(Exception e)
        {
            return null;
        }
        bd.closeConnect();
        return listaProductos;
    }
    /**
     * @param producto
     */
    public void agregarProducto(Producto producto){
        Connect dates=new Connect();
        dates.connect();
        dates.insert(producto.getId(),producto.getNombre(), producto.getTemperatura(), producto.getValorBase(), producto.getCostoAlmacenamiento());
    }

    /**
     * @param criterio
     * @return
     */
    public List<Producto> consultar(String criterio)
    {
        listaProductos= new ArrayList<Producto>();
        Connect bd=new Connect();
        bd.connect();
        ResultSet rs = bd.consultar("SELECT Id Nombre FROM farmacia WHERE Id  LIKE \"%"+criterio+"%\""+ "OR marca Nombre \"%"+criterio+"%\"");
        try
        {
            while(rs.next())
            {
                String id = rs.getString(1);
                String nombre = rs.getString(2);
                Double temperatura=rs.getDouble(3);
                Double valorBase=rs.getDouble(4);
                Double costo=rs.getDouble(5);
                Producto busqueda;
                busqueda=new Producto(nombre, id, temperatura,valorBase, costo);
                this.listaProductos.add(busqueda);
            }
        }
        catch(Exception e)
        {
            return null;
        }
        bd.closeConnect();
        return listaProductos;
    }
    public void eliminarProducto(String id){

    }
    public void actualizarProducto(String id){

    }
}
