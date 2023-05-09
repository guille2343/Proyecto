
package Modelo;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
//import java.util.Scanner;


public class Empresa {
   // Scanner entrada = new Scanner(System.in);
    private String nombre;
    private String nit;
    private String direccion;
    private List<Factura> facturasGuardadas;
    private ArrayList<Producto> productos;
    private ArrayList<Cliente> clientes;
    private int sumador =1;

    public Empresa() {
       this.facturasGuardadas = new ArrayList<Factura>();
       this.clientes = new ArrayList();
       this.productos = new ArrayList();
    }

    public Empresa(String nombre, String nit, String direccion) {
        this.nombre = nombre;
        this.nit = nit;
        this.direccion = direccion;
        this.clientes = new ArrayList();
        this.productos = new ArrayList();
        this.facturasGuardadas = new ArrayList<Factura>();
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
     * @return the nit
     */
    public String getNit() {
        return nit;
    }

    /**
     * @param nit the nit to set
     */
    public void setNit(String nit) {
        this.nit = nit;
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

    /**
     * @return the productos
     */
    public ArrayList<Producto> getProductos() {
        return productos;
    }

    /**
     * @param productos the productos to set
     */
    public void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;
    }

    /**
     * @return the clientes
     */
    public List<Cliente> getClientes() {
        return clientes;
    }

    /**
     * @param clientes the clientes to set
     */
    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }
    
       /**
     * @return the sumador
     */
    public int getSumador() {
        return sumador;
    }

    /**
     * @param sumador the sumador to set
     */
    public void setSumador(int sumador) {
        this.sumador = sumador;
    }

    /**
     * @return the facturasGuardadas
     */
    public List<Factura> getFacturasGuardadas() {
        return facturasGuardadas;
    }

    /**
     * @param facturasGuardadas the facturasGuardadas to set
     */
    public void setFacturasGuardadas(Factura facturasGuardadas) {
        this.facturasGuardadas.add(facturasGuardadas);
    }
    

    public void registrarCliente (Cliente c){
       
        boolean user = false;
        
        for(int i = 0; i < getClientes().size() ; i++){
            if(getClientes().size() <= 0 ){
                this.getClientes().add(c);
            }
            else{
                if(getClientes().get(i).getId().equals(c.getId())){
                    user = true;
                }
            }
        }
        
        if(user == false){
            this.getClientes().add(c);
        }
        
    } 
    
    
    public void registrarProductos(Producto p){
        
        boolean respuesta = false;
        
        for(int i = 0 ; i < this.getProductos().size() ; i++){
            if(this.getProductos().size() <= 0){
                this.getProductos().add(p);
            }
            else{
                if(this.getProductos().get(i).getCodigo().equals(p.getCodigo())){
                    respuesta = true;
                }
            }
        }
        if(respuesta == false ){
            this.getProductos().add(p);
        }
    }
    
    public boolean  realizarVenta(String codigo, int cant,Factura factura){
        long cantidad = cant;
        boolean respuesta = false;
        boolean puntero = true;
        long total =0;
        if(getProductos().size() == 0){
            System.out.println("No hay productos disponibles");
            puntero = false;    
        }
        if (puntero) {
            puntero = false;
            for (Producto p: getProductos()) {
                if (p.getCodigo().equalsIgnoreCase(codigo)) {
                    puntero = true;
                    if (cantidad > p.getCantidad()) {
                        respuesta =false;
                    }else{
                        respuesta =true;
                        total = p.getValor()*cantidad;
                        p.setCantidad(p.getCantidad()-(int)cantidad);
                        DetalleFactura detalle = new  DetalleFactura(factura,(int)cantidad,p.getValor(),p.getNombre());
                        factura.setVendidos(detalle);
                        factura.setTotal(factura.getTotal()+total);
                    }
                }
            }      
            if (!puntero){
                System.out.println("No se encuentra el producto");
            }else{
                if (!respuesta)System.out.println("No hay suficientes productos");
            } 
        }
        for (DetalleFactura f: factura.getVendidos()) {
            System.out.println("nombre . " +f.getNombreProducto() + " cantidad : " 
                    + f.getCantidad() + " valor :" + f.getValor() +" Total :" + factura.getTotal() 
                    +" codigo factura : " + factura.getNumeroFactura() +"Fecha :" + factura.getFechaVenta());
        }
        return respuesta;
    }
    
    
    public void obtenerFacturaDeLaempresa (String inicio,String fin){
        LocalDate fechaInicio = LocalDate.parse(inicio);
        LocalDate fechaTermino = LocalDate.parse(fin);
        for (Factura f: this.facturasGuardadas) {
            if( (!f.getFechaVenta().isBefore(fechaInicio))  && (!f.getFechaVenta().isAfter(fechaTermino)))
            {
               System.out.println("numero Factura : " +f.getNumeroFactura()+ " Empresa : " 
                    + f.getEmpresa().nombre+ " Total :" + f.getTotal());
            }
             //System.out.println("Factura "+f.getNumeroFactura() +"Total "+ f.getTotal() +"Empresa "+f.getEmpresa().getNombre());
        }
    }
    
    public boolean eliminarProducto(String codigo){
        int index = 0;
        int indexEliminar=0;
        boolean puntero = false;
        for(Producto p : this.getProductos()){
            if (p.getCodigo().equalsIgnoreCase(codigo)) {
                puntero=true;
                indexEliminar = index;
            }
            index++;
        }
        if (puntero) {
            productos.remove(indexEliminar);
        }else{
            System.out.println("No se encontro el codigo");
        }
        
        return puntero;
    }
    public void obtenerTotalProductos (Empresa e){
        List<Listado> lista = new ArrayList<Listado>();
        boolean puntero = false;
        for (Factura f: e.getFacturasGuardadas()) {
            for (DetalleFactura d: f.getVendidos()) {
                puntero = false;
                if (lista.size() == 0) {
                    Listado listProducto =new Listado(d.getValor()*d.getCantidad(),d.getNombreProducto());
                    lista.add(listProducto);
                }else{ 
                    for (Listado l: lista) {
                        if (l.getNombreProducto().equalsIgnoreCase(d.getNombreProducto())){
                            puntero = true;
                            l.setTotal(l.getTotal()+(d.getValor()*d.getCantidad()));
                        }   
                    }
                    
                    if (!puntero) {
                        Listado listProducto =new Listado(d.getValor()*d.getCantidad(),d.getNombreProducto());
                        lista.add(listProducto);
                    }
                }
            }
        }
        
        if (lista.size() >0) {
            System.out.println("NOMBRE PRODUCTO------TOTAL");
           for (Listado l2: lista) {
                System.out.println(l2.getNombreProducto()+"----------------"+l2.getTotal());
            }  
        }
        
    }
    
    class Listado{
        private long total;
        private String nombreProducto;

        public long getTotal() {
            return total;
        }

        public Listado(long total, String nombreProducto) {
            this.total = total;
            this.nombreProducto = nombreProducto;
        }

        public void setTotal(long total) {
            this.total = total;
        }

        public void setNombreProducto(String nombreProducto) {
            this.nombreProducto = nombreProducto;
        }
        public String getNombreProducto() {
            return nombreProducto;
        }
      
    }
}


