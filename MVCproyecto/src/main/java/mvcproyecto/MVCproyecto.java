 package mvcproyecto;

import Controlador.Controller;
import Modelo.Ventas;
import Vista.FormPrecio;


public class MVCproyecto {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        
   
        FormPrecio view = new FormPrecio();
        Ventas precio = new Ventas();
        Controller ctr = new Controller(precio,view);
        
        ctr.iniciar();
        view.setVisible(true);
        
    }
}
