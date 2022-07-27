import java.sql.ResultSet;
import java.util.List;

public class Almacen {

    /*public ResultSet getProductos() {
        Connect bd=new Connect();
        bd.connect();
        ResultSet rs = bd.consultar("SELECT Id, Nombre, Temperatura, ValorBase, Costo"+
                "FROM Farmacia");
        return rs;
    }*/
    /**
     * @param producto
     */
    public void agregarProducto(Producto producto){
        Connect dates=new Connect();
        producto.calcularCostoDeAlmacenamiento();
        String sql = "INSERT INTO Farmacia(Id, Nombre, Temperatura, ValorBase, Costo) "+
                "VALUES (\""+producto.getId()+"\", \""+producto.getNombre()+"\", "+producto.getTemperatura()+", "+producto.getValorBase()+", "+producto.getCostoAlmacenamiento()+")";
        dates.connect();
        dates.insert(sql);
        dates.connect();

    }

    public List<Producto> buscarProductos(String valorBusqueda){

        return null;
    }
    public void eliminarProducto(String id){

    }
    public void actualizarProducto(String id){

    }
}
