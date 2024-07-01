package model;
import model.Producto;

public class GestorProducto extends Producto{
    private float precioCompra;
    
    public GestorProducto(String codigo, String nombre, float precioVenta, float precioCompra, int cantidad, String marca){
        super(codigo, nombre, precioVenta, precioCompra, cantidad, marca);
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
