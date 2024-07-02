package model;
import model.Producto;

public class ListaProductos {
   private Producto[] listaProductos;
   private int cantidadProductos=0;
   
   public ListaProductos(Producto[] arreglo){
       this.listaProductos = arreglo;
       this.cantidadProductos = arreglo.length;
   }
   public float total(){
       float total=0;
       for (int i=0; i<cantidadProductos; i++){
           total = total + listaProductos[i].getPrecioVenta()*listaProductos[i].getCantidad();
       }
       return total;
   }
   
   
}

