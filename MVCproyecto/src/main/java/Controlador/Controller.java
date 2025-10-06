package Controlador;
import Modelo.Consumidor;
import Modelo.Ventas;
import Vista.FormPrecio;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Controller implements ActionListener{
    private Ventas Model;
    public Consumidor Consu;
    private FormPrecio view;
    public Controller() {
    }

    public Controller(Ventas Model, FormPrecio view) {
        this.Model = Model;
        this.Consu = Consu;
        this.view = view;
        this.view.btnCalcular.addActionListener(this);
        this.view.btnLimpiar.addActionListener(this);
    }
    
    

   
    public void iniciar(){
     view.setTitle("formulario iniciado");
     view.setLocationRelativeTo(null);
    }
    @Override
    public void actionPerformed(ActionEvent event){
       
        Model.setPrecioProd(Integer.parseInt(view.txtPrecio.getText()));
        Model.setDescuento(Integer.parseInt(view.txtDescuento.getText()));
        Model.CalculoFinal();
        view.txtPrecioTotal.setText(String.valueOf(Model.getPrecioTotal()));
    } 
}
