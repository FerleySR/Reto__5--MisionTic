import java.util.ArrayList;
import java.util.List;

public class Almacen {
    private List<Producto> productos;
    private BaseDatos datos;
    public Almacen(){
        productos=new ArrayList<Producto>();
    }

    public List<Producto> getProductos() {
        return this.productos;
    }
    public void agregarProducto(Producto producto){
        String sql= "INSERT INTO Farmacia(Id, Nombre, Temperatura, Valor Base, Costo" +
                    "VALUES(\""+producto.getId()+"\",\""+producto.getNombre()+"\","+producto.getTemperatura()+","+producto.getValorBase()+","+producto.getCostoAlmacenamiento()+")";
        this.datos.crearConexion();
        this.datos.insertar(sql);
        this.datos.cerrarConexion();
    }
    public void agregarProductos(Producto producto){

    }
    public List<Producto> buscarProductos(String valorBusqueda){

        return null;
    }
    public void eliminarProducto(String id){

    }
    public void actualizarProducto(String id){

    }
}
