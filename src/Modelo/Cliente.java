
package Modelo;


public class Cliente {
    
    private String nombre;
    private String id;
    private long telefono;
    private int edad;
    private String direccion;

    public Cliente() {
    }

    public Cliente(String nombre, String id, long telefono, int edad, String direccion) {
        this.nombre = nombre;
        this.id = id;
        this.telefono = telefono;
        this.edad = edad;
        this.direccion = direccion;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the telefono
     */
    public long getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    /**
     * @return the edad
     */
    public int getEdad() {
        return edad;
    }

    /**
     * @param edad the edad to set
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }

    /**
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    


    @Override
    public String toString() {
        return "-CLIENTE-" + "\nNOMBRE: " + getNombre() 
                + "\nID: " + getId()
                + "\nTELEFONO: " + getTelefono()
                + "\nEDAD: " + getEdad()
                + "\nDIRECCION: " + getDireccion();
    }

}
