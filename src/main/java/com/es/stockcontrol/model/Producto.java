package com.es.stockcontrol.model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;
@Entity
@Table
public class Producto {
    @Id
    private String idProducto;
    @Column(length = 10, nullable = false)
    private String categoria;
    @Column(length = 50, nullable = false)
    private String nombre;
    @Column
    private String descripcion;
    @Column(nullable = false)
    private float precioSinIva;
    @Column(nullable = false)
    private float precioConIva;
    @Column(nullable = false)
    private Date fechaAlta;
    @Column
    private int stock;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
    @JoinColumn(name = "idProveedor")
    private Proveedor proveedor;

    public Producto() {
    }

    public Producto(String idProducto,String categoria, String nombre, String descripcion, float precioSinIva, float precioConIva, Date fechaAlta, int stock, Proveedor proveedor) {
        this.idProducto = idProducto;
        this.categoria = categoria;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precioSinIva = precioSinIva;
        this.precioConIva = precioConIva;
        this.fechaAlta = fechaAlta;
        this.stock = stock;
        this.proveedor = proveedor;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getPrecioSinIva() {
        return precioSinIva;
    }

    public void setPrecioSinIva(float precioSinIva) {
        this.precioSinIva = precioSinIva;
    }

    public float getPrecioConIva() {
        return precioConIva;
    }

    public void setPrecioConIva(float precioConIva) {
        this.precioConIva = precioConIva;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }
}
