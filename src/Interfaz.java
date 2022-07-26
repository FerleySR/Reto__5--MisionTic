import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.List;

public class Interfaz extends JFrame {
    private Almacen almacen;
    public JTextField txtId,txtNombre,txtTemperatura,txtValorBase,txtFiltro;
    public JButton buttonGuardar,buttonEliminar,buttonActualizar,buttonCancelar,buttonFiltrar,buttonCancelarFiltrado;

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
        //Formulario Tabla
        this.txtFiltro=new JTextField();
        this.txtFiltro.setBounds(50,515,400,40);
        panelTablas.add(txtFiltro);

        this.buttonFiltrar=new JButton("Buscar");
        this.buttonFiltrar.setBounds(470,515,120,40);
        panelTablas.add(this.buttonFiltrar);

        this.buttonCancelarFiltrado=new JButton("Cancelar");
        this.buttonCancelarFiltrado.setBounds(610,515,120,40);
        panelTablas.add(this.buttonCancelarFiltrado);

        //Tabla de la seccion Panel Tabla
        Object[][] datos = null;
        String[] columnas = {"Id", "Nombre", "Temperatura", "Valor Base", "Costo Almacenamiento"};
        dtm= new DefaultTableModel(datos, columnas);

        JTable tablaFarmacia = new JTable(dtm);
        tablaFarmacia.setPreferredScrollableViewportSize(new Dimension(700, 490));//dimension de la tabla
        tablaFarmacia.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);//seleccion de las filas
        tablaFarmacia.setFillsViewportHeight(true);//vacio o lleno
        JScrollPane scroll = new JScrollPane(tablaFarmacia);

        JPanel contenidoTabla = new JPanel();//panel que envuelvetodo
        contenidoTabla.setBounds(40, 10, 705, 495);
        contenidoTabla.setLayout(new GridLayout(1,0));
        contenidoTabla.add(scroll);
        panelTablas.add(contenidoTabla);

        listenerGuardar();

        setVisible(true);
    }
    public void listenerGuardar(){
        buttonGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardarProducto();
            }
        });
    }
    public void presentarProducto(ResultSet rs){
        try {
            while (rs.next()){

            }
        }
        catch (Exception e){

        }
    }
    public void guardarProducto(){
        Producto p;
        p=new Producto(this.txtId.getText(),this.txtNombre.getText(),Double.parseDouble(this.txtTemperatura.getText()),Double.parseDouble(this.txtValorBase.getText()));
        this.almacen.agregarProducto(p);
        p.calcularCostoDeAlmacenamiento();
    }
    public void actualizarProducto(){

    }
    public void buscarProducto(){

    }
    public void eliminarProducto(){

    }
}
