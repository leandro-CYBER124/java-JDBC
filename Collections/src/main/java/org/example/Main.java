package org.example;

import javax.swing.*;
import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        //hashMap
        Map<Integer,String> mapaEmpleaodo = new HashMap<>();
        //agregar elementos a la hasmap
        mapaEmpleaodo.put(1567,"leandro");
        mapaEmpleaodo.put(1568,"mini");
        mapaEmpleaodo.put(1569,"aron");
        mapaEmpleaodo.put(1570,"negra");
        mapaEmpleaodo.put(1571,"señor");

        System.out.println("MAP"+mapaEmpleaodo);
       
        System.out.println("hola"+mapaEmpleaodo.values());
        System.out.println("id"+mapaEmpleaodo.keySet() );
        System.out.println("hola "+mapaEmpleaodo.get(1570));
        mapaEmpleaodo.remove(1571);
        System.out.println("MAP"+mapaEmpleaodo);

/*boolean esta = mapaEmpleaodo.containsValue("negra");
        boolean esta2 = mapaEmpleaodo.containsKey(1570);


        if (esta2 == true){
            System.out.println("si");

        }
        else{

            System.out.println("no");
        }*/










        /*  //pilas de objetos
        //class rapers
        Stack<Integer> pila = new Stack<Integer>();
        System.out.println("pila vacia"+ pila);
        System.out.println("esta vacia"+pila.isEmpty());
        //agregar datos

        pila.push(1);
        pila.push(2);
        pila.push(3);
        pila.push(4);
        pila.push(5);

        //recorrido
        for (Integer pilita : pila){
            System.out.println(pilita);
        }
        //mostrar
        System.out.println("pila "+ pila);
        System.out.println("esta vacia pila "+pila.isEmpty());

        //Metodo pop
        //Elimina ultimo registro que entro a la lista
        pila.pop();
        //si esta en la pila entrega un numero positivo sino uno neggativo
        System.out.println("esta el 3? "+ pila.search(3));
        System.out.println("ultimo agregado "+ pila.peek());















      /*  List<Persona> lista = new LinkedList<Persona>();

        lista.add(new Persona(1, "leandro", 23));
        lista.add(new Persona(2, "aron", 3));
        lista.add(new Persona(3, "negra", 5));
        lista.add(new Persona(4, "mini", 4));

        //lista.remove(0);

        List<Persona> lista1 = new ArrayList<Persona>();
        lista.add(new Persona(1, "1leandro", 23));
        lista.add(new Persona(2, "11aron", 3));
        lista.add(new Persona(3, "1negra", 5));
        lista.add(new Persona(4, "1mini", 4));

        JOptionPane.showMessageDialog(null,""+lista.getFirst().toString());
        JOptionPane.showMessageDialog(null,""+lista.getLast().toString());
        /*String nombreborrar = "leandro";

        for (Persona nombres1 : lista1) {
            if (nombres1.getNombre().equals(nombreborrar)) {
                lista1.remove(nombres1);
                break;
            }

        }
        //agregar a la lista en la primera posicion
        //lista.add(4,new Persona(5,"coca",1));

        for (int i =0; i< lista.size();i ++){
            JOptionPane.showMessageDialog(null,"ID: " + lista.get(i).id+"\nHOLA: " +lista.get(i).nombre+"\ntiene:"+ lista.get(i).edad+" Años");
        }*/
    }
}


