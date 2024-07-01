package model;

public class Producto {
    
    private String codigo;
    private String nombre;
    private int cantidad;
    private float precioVenta;
    private float precioCompra;
    private String marca;
    
    public Producto(String codigo, String nombre, float precioVenta, float precioCompra, int cantidad, String marca) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precioVenta = precioVenta;
        this.precioCompra = precioCompra;
        this.marca = marca;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public float getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(float precioVenta) {
        this.precioVenta = precioVenta;
    }

    public float getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(float precioCompra) {
        this.precioCompra = precioCompra;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void mostrarInfoProducto() {
        System.out.println("Producto: " + this.nombre);
        System.out.println("Código: " + this.codigo);
        System.out.println("Precio de Venta: " + this.precioVenta);
        System.out.println("Precio de Compra: " + this.precioCompra);
        System.out.println("Cantidad: " + this.cantidad);
        System.out.println("Marca: " + this.marca);
    }
}
