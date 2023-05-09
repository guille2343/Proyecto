
package Modelo;


public class Direccion {
    
    private String ciudad;
    private String direccion;

    public Direccion() {
    }

    public Direccion(String ciudad, String direccion) {
        this.ciudad = ciudad;
        this.direccion = direccion;
    }

    /**
     * @return the ciudad
     */
    public String getCiudad() {
        return ciudad;
    }

    /**
     * @param ciudad the ciudad to set
     */
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
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
        return "-DATOS DE UBICACION-" + "\nCIUDAD: " + ciudad
                + "\nDIRECCION: " + direccion ;
    }
    
    
}
