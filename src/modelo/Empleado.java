/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;

/**
 *
 * @author cana0
 */
public class Empleado extends Persona {
    private String codigo_empleado, puesto;

    public Empleado() {
    }

    public Empleado(String codigo_empleado, String puesto, String nombre, String apellidos, String direccion, String telefono, String fecha_nacimiento) {
        super(nombre, apellidos, direccion, telefono, fecha_nacimiento);
        this.codigo_empleado = codigo_empleado;
        this.puesto = puesto;
    }

    public String getCodigo_empleado() {
        return codigo_empleado;
    }

    public void setCodigo_empleado(String codigo_empleado) {
        this.codigo_empleado = codigo_empleado;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }
    @Override
    public String [] crear(){
        try{
            String datos [] = new String[7];
            datos[0]=this.getCodigo_empleado();
            datos[1]=this.getNombre();
            datos[2]=this.getApellido();
            datos[3]=this.getDireccion();
            datos[4]=this.getTelefono();
            datos[5]=this.getFecha_nacimiento(); 
            datos[6]=this.getPuesto();
            return datos;
        }catch(Exception ex){
            return null;
            //JOptionPane.showConfirmDialog(null,"Error", ex);
        }
    }
    @Override
    public DefaultTableModel leer(){
      /*  System.out.println("Codigo de Empleado: "+this.getCodigo_empleado());
        System.out.println("Nombre: "+this.getNombre());
        System.out.println("Apellidos: "+this.getApellido());
        System.out.println("Dirección: "+this.getDireccion());
        System.out.println("Teléfono: "+this.getTelefono());
        System.out.println("Fecha de Nacimiento: "+this.getFecha_nacimiento());
        System.out.println("Puesto: "+this.getPuesto()); */       
        return null;
    }
    @Override
    protected void actualizar(){
        
    }
    @Override
    protected void borrar(){
        
    }
}
