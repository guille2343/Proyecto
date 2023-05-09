
package Modelo;


public class Producto {
    
    private String nombre;
    private int cantidad;
    private String codigo;
    private long valor;
    private Empresa empresa;

    public Producto() {
    }

    public Producto(String nombre, int cantidad, String codigo, long valor, Empresa empresa) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.codigo = codigo;
        this.valor = valor;
        this.empresa = empresa;
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
     * @return the cantidad
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * @param cantidad the cantidad to set
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * @return the codigo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the valor
     */
    public long getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(long valor) {
        this.valor = valor;
    }
    
        /**
     * @return the empresa
     */
    public Empresa getEmpresa() {
        return empresa;
    }

    /**
     * @param empresa the empresa to set
     */
    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
    

    @Override
    public String toString() {
        return "-PRODUCTO-" + "\nNOMBRE: " + getNombre() 
                + "\nCANTIDAD: " + getCantidad() 
                + "\nCODIGO: " + getCodigo() 
                + "\nVALOR: " + getValor();
    }


    
}
