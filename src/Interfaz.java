import javax.swing.*;
import java.awt.*;

public class Interfaz extends JFrame {
    private Almacen almacen=new Almacen();
    public JTextField txtId,txtNombre,txtTemperatura,txtValorBase;
    public JButton buttonGuardar,buttonEliminar,buttonActualizar,buttonCancelar;
    private int font;
    public Interfaz(){
        this.font=16;
        setBounds(100,50,1235,620);
        setTitle("Farmacia");
        setLayout(null);

        JPanel panelDeFormulario=new JPanel();
        panelDeFormulario.setBounds(5,5,420,570);
        panelDeFormulario.setBorder(BorderFactory.createEtchedBorder());
        panelDeFormulario.setLayout(null);
        getContentPane().add(panelDeFormulario);

        JPanel panelTablas=new JPanel();
        panelTablas.setBounds(415,5,780,570);
        panelTablas.setBorder(BorderFactory.createEtchedBorder());
        panelTablas.setLayout(null);
        getContentPane().add(panelTablas);

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

        setVisible(true);
    }
    public void menu(){

    }
    public void presentarProducto(){

    }
    public void guardarProducto(){

    }
    public void actualizarProducto(){

    }
    public void buscarProducto(){

    }
    public void eliminarProducto(){

    }
}
