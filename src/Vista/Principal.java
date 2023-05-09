
package Vista;

import Modelo.Cliente;
import Modelo.Direccion;
import Modelo.Empresa;
import Modelo.Factura;
import Modelo.Producto;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;


public class Principal {

    static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {
        
        Empresa e = new Empresa();
        char op= 's';
        int seleccion;
        
        System.out.println("Digite el nombre de su empresa");
        e.setNombre(teclado.next());
        System.out.println("Digite el nit de la empresa");
        e.setNit(teclado.next());
        System.out.println("Digite la direccion de la empresa");
        e.setDireccion(teclado.next());
        
        System.out.println("                " + e.getNombre().toUpperCase());
        System.out.println("  ");
        
        while(op == 's'){
            seleccion = menu();
            switch(seleccion){
                case 1 :
                        char op2 = 's';
                         
                        while(op2 == 's'){     
                        System.out.println("-REGISTRAR CLIENTE-"); 
                        
                            Cliente c = new Cliente();
                            System.out.println("Nombre: ");
                            c.setNombre(teclado.next());
                            System.out.println("Id: ");
                            c.setId(teclado.next());
                            System.out.println("Telefono: ");
                            c.setTelefono(teclado.nextLong());
                            System.out.println("Edad: ");
                            c.setEdad(teclado.nextInt());
                            System.out.println("Direccion: ");
                            c.setDireccion(teclado.next());
                            
                           
                            e.registrarCliente(c);
                            
                            System.out.println("Desea agregar otro cliente? (s/n)");
                            op2 = teclado.next().charAt(0);
                        }
                        
                    break;
                    
                case 2 : 
                        char op3 ='s';
                        
                        
                        while(op3 == 's'){
                            System.out.println("-REGISTRAR PRODUCTO-");
                            Producto p = new Producto();
                            
                            System.out.println("Nombre: ");
                            p.setNombre(teclado.next());
                            System.out.println("Cnatidad: ");
                            p.setCantidad(teclado.nextInt());
                            System.out.println("Codigo: ");
                            p.setCodigo(teclado.next());
                            System.out.println("Valor: ");
                            p.setValor(teclado.nextLong());
                            
                            e.registrarProductos(p);
                            
                            System.out.println("Desea agregar otro cliente? (s/n)");
                            op3 = teclado.next().charAt(0);
                        }
                        
                    break;
                case 3 : 
                        char op5 ='s';
                        do{
                            
                            System.out.println("1. reporte de vente por fecha");
                            System.out.println("2. inventario producto");
                            System.out.println("3. total por producto vendido");
                            System.out.println("4. salir");
                            
                            int opcion;
                            do{
                                System.out.println("Digite una opcion");
                                 opcion = teclado.nextInt();
                            }while(opcion < 1 || opcion >4);
                            switch(opcion){
                                case 1 : System.out.println("en proceso de mejoramiento");
                                    
                                        System.out.println("incerte la fecha de inicio con el siguente formato:  AAAA-MM-DD");
                                        String fechainicio = teclado.next();
                                        System.out.println("incerte la fecha final : AAAA-MM-DD");
                                        String fechafin = teclado.next();
                                        System.out.println("");   
                                        
                                        e.obtenerFacturaDeLaempresa(fechainicio, fechafin);
                                    break;
                                case 2 : productosDisponibles(e);
                                    break;
                                case 3 :e.obtenerTotalProductos(e);
                                    break;
                                case 4 : op5 = 'n';    
                                     
                            }

                        }while(op5 == 's' || op5 == 'S');
                    break;
                case 4 : 
                    char op4 = 's';
                        System.out.println("-REALIZAR VENTA-");
                        Factura factura = new Factura();
                        factura.setEmpresa(e);
                        factura.setNumeroFactura("Fv-" + e.getFacturasGuardadas().size());
                        factura.setFechaVenta(LocalDate.now());
                        while(op4 == 's'){
                            System.out.println("Lista de productos disponibles");
                            productosDisponibles(e);
                            System.out.println("Digite el codigo del producto que desea comprar: ");
                            String codigo = teclado.next();
                            System.out.println("digete la cantidad que desea llevar: ");
                            int cantidad = teclado.nextInt();
                            if (e.realizarVenta(codigo, cantidad, factura)) {
                                System.out.println("Desea realizar otra venta4? (s/n)");
                                op4 = teclado.next().charAt(0);
                            }
                        }
                        e.setFacturasGuardadas(factura);
                    break;
                case 5 : 
                        char op6 = 's';
                        System.out.println("-LISTA DE PRODUCTOS DISPONIBLES-");
                        System.out.println("nombre " + "----------" + "codigo ");
                        for(Producto pe : e.getProductos()){
                            System.out.println(pe.getNombre() + "----------"+ pe.getCodigo());
                        }
                        while(op6 == 's'){
                            System.out.println("digite el codigo del producto a borrar");
                            String codigoBorrar = teclado.next();
                            if (e.eliminarProducto(codigoBorrar)) {
                               System.out.println("Desea realizar eliminar otro producto? (s/n)");
                               op6 = teclado.next().charAt(0); 
                            }
                            if (e.getProductos().size() == 0) {
                               op6 = 'n'; 
                            }
                        }   
                    break; 
                case 6 : op = 'n';
                    break;
            }
        }
    }
    
    
    public static int menu(){
        int eleccion;
        
        do{
            System.out.println("--MENU DE OPCIONES--");
            System.out.println("  ");
            System.out.println("1. REGISTRAR CLIENTE");
            System.out.println("2. REGISTRAR PRODUCTO");
            System.out.println("3. CALCULOS DE LA EMPRESA");
            System.out.println("4. REALIZAR VENTA");
            System.out.println("5. ELIMINAR PRODUCTO");
            System.out.println("6. SALIR");
            System.out.println(" ");

            System.out.println("SELECCIONE UNA OPCCION: ");
            eleccion = teclado.nextInt();
                    
        
        }while(eleccion < 1 || eleccion > 6);
        
        return eleccion;
    }
  
    public static void mostrarListado(Empresa e){
        
        if(e.getClientes() == null){
            System.out.println("NO HAY CLIENTES REGISTRADOS");
        }
        else{
            for(Cliente c: e.getClientes()){
            System.out.println(c);
            }
        }
        
        if(e.getProductos() == null){
            System.out.println("NO HAY PRODUCTOS REGISTRADOS");
        }
        else{
            for(Producto p : e.getProductos()){
                System.out.println(p);
            }
                
        }
    }
    
    public static void productosDisponibles(Empresa e){
        if(e.getProductos() == null){
            System.out.println("NO HAY PRODUCTOS REGISTRADOS");
        }
        else{
            for(Producto p : e.getProductos()){
                System.out.println(p);
            }
                
        }
    }
}
/*
    private String nombre;
    private String id;
    private String telefono;
    private int edad;
    private String direccion;
*/