/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ana Tapias
 */
public class Factura {
    private String numeroFactura;
    private Empresa empresa;
    private Cliente cliente;
    private LocalDate fechaVenta;
    private List<DetalleFactura> vendidos;
    private long total;
    

    public Factura() {
        this.vendidos = new ArrayList<DetalleFactura>();
    }

    public Factura(String numeroFactura, Empresa empresa, Cliente cliente, long total, LocalDate fechaVenta) {
        this.numeroFactura = numeroFactura;
        this.empresa = empresa;
        this.cliente = cliente;
        this.total = total;
        this.vendidos = new ArrayList<DetalleFactura>();
        this.fechaVenta = fechaVenta;
    }

    /**
     * @return the numeroFactura
     */
    public String getNumeroFactura() {
        return numeroFactura;
    }

    /**
     * @param numeroFactura the numeroFactura to set
     */
    public void setNumeroFactura(String numeroFactura) {
        this.numeroFactura = numeroFactura;
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

    /**
     * @return the cliente
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     * @return the total
     */
    public long getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(long total) {
        this.total = total;
    }

    /**
     * @return the vendidos
     */
    public List<DetalleFactura> getVendidos() {
        return vendidos;
    }

    /**
     * @param vendidos the vendidos to set
     */
    public void setVendidos(DetalleFactura vendidos) {
        this.getVendidos().add(vendidos);
    }

    /**
     * @return the fechaVenta
     */
    public LocalDate getFechaVenta() {
        return fechaVenta;
    }

    /**
     * @param fechaVenta the fechaVenta to set
     */
    public void setFechaVenta(LocalDate fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    /**
     * @param vendidos the vendidos to set
     */
    public void setVendidos(List<DetalleFactura> vendidos) {
        this.vendidos = vendidos;
    }

}
