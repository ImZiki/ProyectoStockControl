package com.es.stockcontrol.model;

import jakarta.persistence.*;

import java.util.List;
@Entity
@Table
public class Proveedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long idProvedor;
    @Column(length = 50, nullable = false)
    private String nombre;
    @Column(nullable = false)
    private String direccion;

    @OneToMany(mappedBy = "proveedor", fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    private List<Producto> productos;

    public Proveedor() {
    }

    public Proveedor(String nombre, String direccion, List<Producto> productos) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.productos = productos;
    }

    public Long getIdProvedor() {
        return idProvedor;
    }

    public void setIdProvedor(Long idProducto) {
        this.idProvedor = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Proveedor{" +
                "idProvedor=" + idProvedor +
                ", nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", productos=" + productos +
                '}';
    }
}
