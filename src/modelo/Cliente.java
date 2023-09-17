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
public class Cliente extends Persona {
    private String nit;
    private Conexion c;

    public Cliente() {
        c=new Conexion();
    }

    public Cliente(String nit, String nombre, String apellido, String direccion, String telefono, String fecha_nacimiento) {
        super(nombre, apellido, direccion, telefono, fecha_nacimiento);
        this.nit = nit;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    @Override
    public String [] crear(){
        try{
            String datos [] = new String[6];
            datos[0]=this.getNit();
            datos[1]=this.getNombre();
            datos[2]=this.getApellido();
            datos[3]=this.getDireccion();
            datos[4]=this.getTelefono();
            datos[5]=this.getFecha_nacimiento();            
            return datos;
        }catch(Exception ex){
            return null;
        }
    }
    @Override
    public DefaultTableModel leer(){
        try{
            ResultSet res;
            DefaultTableModel model=new DefaultTableModel();
            String encabezado []={"ID","NIT","Nombre","Apellido","Dirección","Teléfono","Fecha de Nacimiento"};
            model.setColumnIdentifiers(encabezado);
            res=c.conexionDB.createStatement().executeQuery("Select * from clientes;");
            String datos[]=new String[7];
            while(res.next()){
                datos[0]=res.getString("id_cliente");
                datos[1]=res.getString("nit");
                datos[2]=res.getString("nombres");
                datos[3]=res.getString("apellidos");
                datos[4]=res.getString("direccion");
                datos[5]=res.getString("telefono");
                datos[6]=res.getString("fecha_nacimiento");
                //guardar en tabla de formulario la row y seguir con la consulta
                model.addRow(datos);
            }
            return model;
        }catch(SQLException ex){
            System.out.println("Eror:"+ex.getMessage());
            return null;
        }   
    }
    
    @Override
    public void actualizar(){
        
    }
    @Override
    public void borrar(){
        
    }
    @Override
    public void agregar(){
        c.abrir_conexion();
        try {
            PreparedStatement parametro;
            String query="INSERT INTO clientes(nit,nombres,apellidos,direccion,telefono,fecha_nacimiento) VALUES(?,?,?,?,?,?);";
            parametro=(PreparedStatement) c.conexionDB.prepareStatement(query);
            parametro.setString(1,getNit());
            parametro.setString(2,getNombre());
            parametro.setString(3,getApellido());
            parametro.setString(4,getDireccion());
            parametro.setString(5,getTelefono());
            parametro.setString(6,getFecha_nacimiento());
            int ejecutar = 0;
            ejecutar=parametro.executeUpdate();
            JOptionPane.showMessageDialog(null, "Se han insertado registros en la tabla clientes. Registros ingresados: "+Integer.toString(ejecutar)+".","Modificación en tabla Clientes",JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        c.cerrar_conexion();
    }
}
