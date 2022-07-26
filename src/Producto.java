public class Producto {
    private String nombre;
    private String id;
    private double temperatura;
    private double valorBase;
    private double costoAlmacenamiento;

    public Producto(){
        this.nombre="";
        this.id="";
        this.temperatura=0;
        this.valorBase=0;
    }
    public Producto(String nombre,String id,double temperatura,double valorBase){
        this.nombre=nombre;
        this.id=id;
        this.temperatura=temperatura;
        this.valorBase=valorBase;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getTemperatura() {
        return this.temperatura;
    }

    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }

    public double getValorBase() {
        return this.valorBase;
    }

    public double getCostoAlmacenamiento() {
        return this.costoAlmacenamiento;
    }

    public void setValorBase(double valorBase) {
        this.valorBase = valorBase;
    }
    public String toString() {
        return this.getClass().getName() + "{" + "nombre=" + nombre + ", id=" + id + ", temperatura=" + temperatura + ", valorBase=" + valorBase + '}';
    }
    public void calcularCostoDeAlmacenamiento(){
        if (this.temperatura > -1){
            this.costoAlmacenamiento=valorBase*1.10;
        }
        else{
            this.costoAlmacenamiento= valorBase*1.20;
        }
    }
}
