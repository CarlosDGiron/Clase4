/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.DefaultComboBoxModel;
import java.sql.ResultSet;

/**
 *
 * @author cana0
 */
public class Puesto {
    private String puesto, descripcion;
    Conexion c;
    public Puesto() {
        c= new Conexion();
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public String getId(String des){
        try{
            c.abrir_conexion();
            ResultSet res;
            res=c.conexionDB.createStatement().executeQuery("Select id_puesto from puestos where puesto =\""+des+"\";");
            res.next();
            String x=res.getString("id_puesto");
            c.cerrar_conexion();
            return x;
        }catch(SQLException ex){
            System.out.println("Eror Id:"+ex.getMessage());
            c.cerrar_conexion();
            return null;
        }
    }
    
    public String getDes(String id){
        try{
            c.abrir_conexion();
            ResultSet res;
            res=c.conexionDB.createStatement().executeQuery("Select puesto from puestos where id_puesto ="+id+";");
            res.next();
            String x=res.getString("puesto");
            c.cerrar_conexion();
            return x;
        }catch(SQLException ex){
            System.out.println("Eror Des:"+ex.getMessage());
            c.cerrar_conexion();
            return null;
        }
    }
    
    public DefaultComboBoxModel leer(){
        try{
            c.abrir_conexion();
            ResultSet res;
            DefaultComboBoxModel model=new DefaultComboBoxModel();
            res=c.conexionDB.createStatement().executeQuery("Select puesto from puestos;");
            while(res.next()){
                model.addElement(res.getString("puesto"));
            }
            c.cerrar_conexion();
            return model;
        }catch(SQLException ex){
            System.out.println("Eror leer:"+ex.getMessage());
            c.cerrar_conexion();
            return null;
        }   
    }
    
}
