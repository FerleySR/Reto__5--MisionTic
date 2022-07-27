import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Interfaz extends JFrame {
    private Almacen almacen;
    public JTextField txtId,txtNombre,txtTemperatura,txtValorBase,txtFiltro;
    public JButton buttonGuardar,buttonEliminar,buttonActualizar,buttonCancelar,buttonFiltrar,buttonCancelarFiltrado;
    public JTable tablaFarmacia;
    public DefaultTableModel dtm;
    private int font;
    public Interfaz(){
        this.font=16;
        this.almacen=new Almacen();
        //Pantalla Principal
        setBounds(100,50,1235,620);
        setTitle("Farmacia");
        setLayout(null);

        //Paneles Agregados a la pantalla Principal
        JPanel panelDeFormulario=new JPanel();
        panelDeFormulario.setBounds(5,5,420,570);
        panelDeFormulario.setBorder(BorderFactory.createEtchedBorder());
        panelDeFormulario.setLayout(null);
        getContentPane().add(panelDeFormulario);

        JPanel panelTablas=new JPanel();
        panelTablas.setBounds(435,5,780,570);
        panelTablas.setBorder(BorderFactory.createEtchedBorder());
        panelTablas.setLayout(null);
        getContentPane().add(panelTablas);

        //Panel Formularios
        JLabel id = new JLabel("Id: ");
        id.setBounds(15,15,140,40);
        Font auxId=id.getFont();
        id.setFont(new Font(auxId.getName(),auxId.getStyle(),this.font));
        panelDeFormulario.add(id);

        this.txtId=new JTextField();
        this.txtId.setBounds(160,15,220,40);
        panelDeFormulario.add(this.txtId);

        JLabel nombre = new JLabel("Nombre: ");
        nombre.setBounds(15,65,140,40);
        Font auxNombre= nombre.getFont();
        nombre.setFont(new Font( auxNombre.getName(), auxNombre.getStyle(),this.font));
        panelDeFormulario.add(nombre);

        this.txtNombre=new JTextField();
        this.txtNombre.setBounds(160,65,220,40);
        panelDeFormulario.add(this.txtNombre);

        JLabel temperatura = new JLabel("Temperatura: ");
        temperatura.setBounds(15,115,140,40);
        Font auxTemperatura= temperatura.getFont();
        temperatura.setFont(new Font( auxTemperatura.getName(), auxTemperatura.getStyle(),this.font));
        panelDeFormulario.add(temperatura);

        this.txtTemperatura=new JTextField();
        this.txtTemperatura.setBounds(160,115,220,40);
        panelDeFormulario.add(this.txtTemperatura);

        JLabel valorBase = new JLabel("Valor Base: ");
        valorBase.setBounds(15,165,140,40);
        Font auxValorBase= temperatura.getFont();
        valorBase.setFont(new Font( auxValorBase.getName(), auxValorBase.getStyle(),this.font));
        panelDeFormulario.add(valorBase);

        this.txtValorBase=new JTextField();
        this.txtValorBase.setBounds(160,165,220,40);
        panelDeFormulario.add(this.txtValorBase);

        this.buttonGuardar=new JButton("Guardar");
        this.buttonGuardar.setBounds(100,240,200,40);
        panelDeFormulario.add(this.buttonGuardar);

        this.buttonEliminar=new JButton("Eliminar");
        this.buttonEliminar.setBounds(100,290,200,40);
        panelDeFormulario.add(this.buttonEliminar);

        this.buttonActualizar=new JButton("Actualizar");
        this.buttonActualizar.setBounds(100,340,200,40);
        panelDeFormulario.add(this.buttonActualizar);

        this.buttonCancelar=new JButton("Cancelar");
        this.buttonCancelar.setBounds(100,390,200,40);
        panelDeFormulario.add(this.buttonCancelar);

        //Panel Tabla

        //Tabla de la seccion Panel Tabla
        Object[][] datos = null;
        String[] columnas = {"Id", "Nombre", "Temperatura", "Valor Base", "Costo Almacenamiento"};
        dtm= new DefaultTableModel(datos, columnas);

        this.tablaFarmacia = new JTable(dtm);
        this.tablaFarmacia.setPreferredScrollableViewportSize(new Dimension(700, 590));//dimension de la tabla
        this.tablaFarmacia.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);//seleccion de las filas
        this.tablaFarmacia.setFillsViewportHeight(true);//vacio o lleno
        JScrollPane scroll = new JScrollPane(tablaFarmacia);

        JPanel contenidoTabla = new JPanel();//panel que envuelvetodo
        contenidoTabla.setBounds(40, 10, 705, 600);
        contenidoTabla.setLayout(new GridLayout(1,0));
        contenidoTabla.add(scroll);
        panelTablas.add(contenidoTabla);

        listenerGuardar();
        listenerCancelar();
        presentarProducto();
        listenerTabla();
        listenerActualizar();
        listenerEliminar();
        setVisible(true);
    }
    public void listenerGuardar(){
        this.buttonGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardarProducto();
            }
        });
    }
    public void listenerActualizar(){
        this.buttonActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarTabla();
            }
        });
    }
    public void listenerCancelar(){
        this.buttonCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limpiarFormulario();
            }
        });
    }
    public void listenerEliminar(){
        this.buttonEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminarProducto();
            }
        });
    }
    
    public void listenerTabla(){
        tablaFarmacia.getSelectionModel().addListSelectionListener(new ListSelectionListener() 
        {
            public void valueChanged(ListSelectionEvent e) 
            {
                if (tablaFarmacia.getSelectedRowCount() > 0)
                {
                    int row = tablaFarmacia.getSelectedRow();
                    String codigo = dtm.getValueAt(row, 0).toString();
                    cargarProductoEnFormulario(codigo);
                }
            }

        });
    }
    
    public void presentarProducto(){
        dtm.setRowCount(0);
        Almacen almacen = new Almacen();
        List<Producto> productos = almacen.getProductos();
        for (Producto p : productos)
        {
            Object[] row = {p.getId(), p.getNombre(), p.getTemperatura(), p.getValorBase(), p.getCostoAlmacenamiento()};
            dtm.addRow(row);
        }
    }
    public void mostrarProducto(List<Producto> productos){
        dtm.setRowCount(0);
        for (Producto p : productos)
        {
            String[] columnas = {"Id", "Nombre", "Temperatura", "Valor Base", "Costo Almacenamiento"};
            Object[] row = {p.getNombre(), p.getId(), p.getTemperatura(), p.getValorBase(), p.getCostoAlmacenamiento()};
            dtm.addRow(row);
        }
    }
    public void guardarProducto(){
        Producto p;
        p=new Producto(this.txtId.getText(),this.txtNombre.getText(),Double.parseDouble(this.txtTemperatura.getText()),Double.parseDouble(this.txtValorBase.getText()));
        this.almacen.agregarProducto(p);
        presentarProducto();
        limpiarFormulario();
    }

    public void limpiarFormulario()
    {
        this.txtId.setText("");
        this.txtNombre.setText("");
        this.txtTemperatura.setText("");
        this.txtValorBase.setText("");
    }
    public void cargarProductoEnFormulario(String codigo) {
        Almacen almacen = new Almacen();
        Producto p;
        p=almacen.consultar(codigo);
        txtId.setText(p.getId());
        txtNombre.setText(p.getNombre());
        txtTemperatura.setText(p.getTemperatura()+"");
        txtValorBase.setText(p.getValorBase()+"");
    }
    public void actualizarTabla(){
        Producto p;
        p=new Producto(txtNombre.getText(),txtId.getText(),Double.parseDouble(txtTemperatura.getText()),Double.parseDouble(txtValorBase.getText()));
        this.almacen.actualizarProducto(p);
        presentarProducto();
        limpiarFormulario();
    }
    public void eliminarProducto(){
        this.almacen.eliminarProducto(this.txtId.getText());
        presentarProducto();
        limpiarFormulario();
    }
    
}
