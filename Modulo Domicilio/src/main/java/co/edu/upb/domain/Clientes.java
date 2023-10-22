package co.edu.upb.domain;

import java.io.Serializable;
/**
 * Clase de de clientes, la cual permitira serializar objetos.
 *@author ChristianRodriguez
 */
public class Clientes  implements Serializable {

    int idClientes;
    String nombre;
    String apellido;
    String calle;
    String carrera;
    String barrio;
    String municipio;
    String telefono;
    String correo;
    int tipoCliente;

    /**
     *  Atributos de la clase clientes, estos son la misma informacion que hay en la base de datos en SQL
     * @param idClientes
     * @param nombre
     * @param apellido
     * @param calle
     * @param carrera
     * @param barrio
     * @param municipio
     * @param telefono
     * @param correo
     * @param tipoClien
     */



    public Clientes(int idClientes, String nombre, String apellido, String calle, String carrera, String barrio, String municipio, String telefono, String correo, int tipoClien) {
        this.idClientes = idClientes;
        this.nombre = nombre;
        this.apellido = apellido;
        this.calle = calle;
        this.carrera = carrera;
        this.barrio = barrio;
        this.municipio = municipio;
        this.telefono = telefono;
        this.correo = correo;
        this.tipoCliente = tipoClien;
    }

    public Clientes() {

    }

    public Clientes(String nombre, String apellido, String calle, String carrera, String barrio, String municipio, String telefono, String correo, int tipoCliente) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.calle = calle;
        this.carrera = carrera;
        this.barrio = barrio;
        this.municipio = municipio;
        this.telefono = telefono;
        this.correo = correo;
        this.tipoCliente = tipoCliente;
    }

    public Clientes(String nombre, String apellido, String telefono, String correo, int tipoCliente) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.correo = correo;
        this.tipoCliente = tipoCliente;
    }

    /**
     * Getters y setters de los atributos de la clase Clientes
     * @return
     */
    public int getIdClientes() {
        return idClientes;
    }

    public void setIdClientes(int idClientes) {
        this.idClientes = idClientes;
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

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }


    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(int tipoCliente) {
        this.tipoCliente = tipoCliente;
    }
}
