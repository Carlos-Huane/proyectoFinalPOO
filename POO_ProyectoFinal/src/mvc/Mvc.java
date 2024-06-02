package mvc;
import controller.login.ControladorInicio;
import model.Usuario;
import view.VentanaInicio;
public class Mvc {
    public static void main (String[] args){
        //Usuario usuario = new Usuario("", "");
        VentanaInicio ventanaInicio = new VentanaInicio();
        //ControladorInicio controladorInicio = new ControladorInicio(ventanaInicio, usuario);
        ControladorInicio controladorInicio = new ControladorInicio(ventanaInicio);

    }
}
