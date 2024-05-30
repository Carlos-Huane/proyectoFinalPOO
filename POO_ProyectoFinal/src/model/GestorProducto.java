package model;
import model.Producto;

public class GestorProducto extends Producto{
    private float precioCompra;
    
    public GestorProducto(String nombre, String codigo, int cantidadProductos, float precioVenta, String marca, float precioCompra){
        super(codigo, nombre, cantidadProductos, precioVenta, marca);
        this.precioCompra = precioCompra;
    }
    
    //Funciones para realizar consultas a la base de datos
    public void agregarProducto(){
        
    }
    public void modificarProducto(){
        
    }
    public void eliminarProducto(){
        
    }
    public void agregarMercancia(){
        
    }

    public float getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(float precioCompra) {
        this.precioCompra = precioCompra;
    }

}
