import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Almacen {

    public ResultSet getProductos() {
        BaseDatos bd=new BaseDatos();
        bd.crearConexion();
        ResultSet rs = bd.consultar("SELECT Id, Nombre, Temperatura, ValorBase, Costo"+
                "FROM Farmacia");
        return rs;
    }
    public void agregarProducto(Producto producto){
        BaseDatos dates=new BaseDatos();
        producto.calcularCostoDeAlmacenamiento();
        String sql = "INSERT INTO datosFarmacia(Id, Nombre, Temperatura, ValorBase, Costo) "+
                "VALUES (\""+producto.getId()+"\", \""+producto.getNombre()+"\", "+producto.getTemperatura()+", "+producto.getValorBase()+", "+producto.getCostoAlmacenamiento()+")";
        System.out.println(dates.crearConexion());
        dates.insertar(sql);
        dates.cerrarConexion();
    }

    public List<Producto> buscarProductos(String valorBusqueda){

        return null;
    }
    public void eliminarProducto(String id){

    }
    public void actualizarProducto(String id){

    }
}
