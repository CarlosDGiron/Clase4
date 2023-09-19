/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author cana0
 */
abstract class Persona {
    private String id, nombre, apellido, direccion,telefono,fecha_nacimiento;

    public Persona() {
    }

    public Persona(String id, String nombre, String apellido, String direccion, String telefono, String fecha_nacimiento) {
        this.nombre = nombre;
        this.id = id;
        this.apellido = apellido;
        this.direccion = direccion;
        this.telefono = telefono;
        this.fecha_nacimiento = fecha_nacimiento;
    }
    public Persona(String nombre, String apellido, String direccion, String telefono, String fecha_nacimiento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.telefono = telefono;
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }
    protected String [] crear(){        
        return null;
    }
    protected DefaultTableModel leer(){
        return null;
    }
    protected void actualizar(){
        
    }
    protected void borrar(){
        
    }
    protected void agregar(){
                
    }
}
