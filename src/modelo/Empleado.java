/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;


/**
 *
 * @author cana0
 */
public class Empleado extends Persona {
    private String codigo_empleado, puesto;
    Conexion c;
    private Puesto p=new Puesto();
    public Empleado() {
        c=new Conexion();
    }
    public Empleado(String id, String codigo_empleado, String nombre, String apellido, String direccion, String telefono, String fecha_nacimiento, String puesto){
        super(id, nombre,apellido, direccion, telefono, fecha_nacimiento);
        this.codigo_empleado = codigo_empleado;
        this.puesto=puesto;
        c=new Conexion();
    }
    public Empleado(String codigo_empleado, String nombre, String apellidos, String direccion, String telefono, String fecha_nacimiento, String puesto) {
        super(nombre, apellidos, direccion, telefono, fecha_nacimiento);
        this.codigo_empleado = codigo_empleado;
        this.puesto = puesto;
        c=new Conexion();
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
            String datos [] = new String[8];
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
        try{
            c.abrir_conexion();
            ResultSet res;
            DefaultTableModel model=new DefaultTableModel();
            String encabezado []={"ID","Codigo de Empleado","Nombres","Apellidos","Dirección","Teléfono","Fecha de Nacimiento", "ID de Puesto"};
            model.setColumnIdentifiers(encabezado);
            res=c.conexionDB.createStatement().executeQuery("Select * from empleados;");
            String datos[]=new String[8];
            while(res.next()){
                datos[0]=res.getString("id_empleado");
                datos[1]=res.getString("codigo");
                datos[2]=res.getString("nombres");
                datos[3]=res.getString("apellidos");
                datos[4]=res.getString("direccion");
                datos[5]=res.getString("telefono");
                datos[6]=res.getString("fecha_nacimiento");
                datos[7]=p.getDes(res.getString("id_puesto"));
                //guardar en tabla de formulario la row y seguir con la consulta
                model.addRow(datos);             
            }
            c.cerrar_conexion();
            return model;
        }catch(SQLException ex){
            System.out.println("Eror:"+ex.getMessage());
            c.cerrar_conexion();
            return null;
        }   
    }
    
    @Override
    public void actualizar(){
        c.abrir_conexion();
        try {
            PreparedStatement parametro;
            String query="UPDATE empleados SET codigo=?, nombres=?, apellidos=?, direccion=?, telefono=?, fecha_nacimiento=?, id_puesto=? where id_empleado=?;";
            parametro=(PreparedStatement) c.conexionDB.prepareStatement(query);
            parametro.setString(1,getCodigo_empleado());
            parametro.setString(2,getNombre());
            parametro.setString(3,getApellido());
            parametro.setString(4,getDireccion());
            parametro.setString(5,getTelefono());
            parametro.setString(6,getFecha_nacimiento());
            parametro.setString(7,p.getId(this.getPuesto()));
            parametro.setString(8,getId());
            int ejecutar = 0;
            ejecutar=parametro.executeUpdate();
            JOptionPane.showMessageDialog(null, "Se han actualizado registros en la tabla empleados. Registros actualizados: "+Integer.toString(ejecutar)+".","Modificación en tabla Empleados",JOptionPane.INFORMATION_MESSAGE);
            c.cerrar_conexion();
        } catch (SQLException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);            
            c.cerrar_conexion();
        }
    }
    @Override
    public void borrar(){
        c.abrir_conexion();
        try {
            PreparedStatement parametro;
            String query="DELETE FROM empleados WHERE id_empleado=?;";
            parametro=(PreparedStatement) c.conexionDB.prepareStatement(query);
            parametro.setString(1,getId());
            int ejecutar = 0;
            ejecutar=parametro.executeUpdate();
            JOptionPane.showMessageDialog(null, "Se han eliminado registros en la tabla empleados. Registros eliminados: "+Integer.toString(ejecutar)+".","Modificación en tabla Empleados",JOptionPane.INFORMATION_MESSAGE);
            c.cerrar_conexion();
        } catch (SQLException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);            
            c.cerrar_conexion();
        }
    }
    @Override
    public void agregar(){
        c.abrir_conexion();
        try {
            PreparedStatement parametro;
            String query="INSERT INTO empleados(codigo,nombres,apellidos,direccion,telefono,fecha_nacimiento,id_puesto) VALUES(?,?,?,?,?,?,?);";
            parametro=(PreparedStatement) c.conexionDB.prepareStatement(query);
            parametro.setString(1,getCodigo_empleado());
            parametro.setString(2,getNombre());
            parametro.setString(3,getApellido());
            parametro.setString(4,getDireccion());
            parametro.setString(5,getTelefono());
            parametro.setString(6,getFecha_nacimiento());
            parametro.setString(7,p.getId(getPuesto()));
            int ejecutar = 0;
            ejecutar=parametro.executeUpdate();
            JOptionPane.showMessageDialog(null, "Se han insertado registros en la tabla empleados. Registros ingresados: "+Integer.toString(ejecutar)+".","Modificación en tabla Empleados",JOptionPane.INFORMATION_MESSAGE);
            c.cerrar_conexion();
        } catch (SQLException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            
            c.cerrar_conexion();
        }        
    }
}
