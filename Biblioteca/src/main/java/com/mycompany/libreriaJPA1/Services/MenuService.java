package com.mycompany.libreriaJPA1.Services;

import java.util.Scanner;
import com.mycompany.Entities.Autor;
import com.mycompany.Entities.Editorial;
import com.mycompany.Entities.Libro;

public class MenuService {

    private Scanner read = new Scanner(System.in);
    private AutorService autorServ = new AutorService(); 
    private EditorialService editorialServ = new EditorialService();
    private LibroService libroServ = new LibroService();
    private Libro libro = new Libro();
    private int aux;
   

    public void menu() throws Exception {

        do {
            System.out.println(" --------------------ingrese una opcion----------------------------------- ");
            System.out.println(" 1) INGRESE LOS DATOS DE AUTORES - EDITORIALES o LIBROS A LA BASE DE DATOS.");
            System.out.println(" 2) BUSCAR AUTOR POR NOMBRE.");
            System.out.println(" 3) BUSCAR LIBRO POR ISBN.");
            System.out.println(" 4) BUSCAR LIBRO POR TITULO.");
            System.out.println(" 5) BUSCAR LIBRO POR NOMBRE DE AUTOR.");
            System.out.println(" 6) BUSCAR LIBRO POR NOMBRE DE EDITORIAL.");
            System.out.println(" 7) Salir.");
            aux = read.nextInt();
             read.nextLine();
            switch (aux) {
                case 1:
                    System.out.println(" --------------------ingrese una opcion----------------------------------- ");
                    System.out.println(" 1) CARGAR DATOS DE UN AUTOR NUEVO.");
                    System.out.println(" 2) CARGAR DATOS DE UNA EDITORIAL NUEVA.");
                    System.out.println(" 3) CARGAR DATOS DE LIBRO NUEVO.");
                    System.out.println(" 4) SALIR.");
                    int aux2 = read.nextInt();
                    read.nextLine();
                    switch (aux2) {
                        case 1:
                            System.out.println("INGRESE EL NOMBRE DEL AUTOR A CREAR.");
                            String nomAut = read.nextLine();
                            Autor autor = autorServ.buscarNombre(nomAut);
                            if (autor == null) {
                                autor = autorServ.crearAutor(nomAut);
                            } else {
                                System.out.println("EL AUTOR YA EXISTE.");
                            }
                            break;
                        case 2:
                            System.out.println("INGRESE EL NOMBRE DE LA EDITORIAL A CREAR.");
                            String nomEd = read.nextLine();
                            Editorial editorial = editorialServ.buscarNom(nomEd);
                            if (editorial == null) {
                                editorial = editorialServ.crearEd(nomEd);
                            } else {
                                System.out.println("LA EDITORIAL YA EXISTE.");
                            }
                            break;
                        case 3:
                            System.out.println("INGRESE NOMBRE DEL LIBRO.");
                            String nombrelib = read.nextLine();
                            Libro libro = libroServ.buscarTit(nombrelib);
                            if (libro == null) {
                                libro = libroServ.crearLib(nombrelib);
                            } else {
                                System.out.println("EL LIBRO YA EXISTE.");
                            }
                            break;
                            
                            case 4:
                                System.out.println("VOLVIENDO AL MENU PRINCIPAL...");
                            break;
                        default:
                            System.out.println("INGRESE OPCION CORRECTA.");
                    }

                    break;

                case 2:
                    System.out.println("INGRESE EL NOMBRE DEL AUTOR A BUSCAR.");
                    Autor autor = autorServ.buscarNombre(read.nextLine());
                    System.out.println(autor);
                    break;
                case 3:
                    System.out.println("INGRESE EL ISBN DEL LIBRO A BUSCAR.");
                     libro = libroServ.buscarIsbn(read.nextInt());
                    System.out.println(libro);
                    read.nextLine();
                    break;
                case 4:
                    System.out.println("INGRESE EL TITULO DEL LIBRO A BUSCAR.");
                    String titulo =read.nextLine();
                    libro = libroServ.buscarTit(titulo.trim());
                    System.out.println(libro);
                    break;
                case 5:
                    System.out.println("INGRESE EL NOMBRE DEL AUTOR DEL LIBRO A BUSCAR.");
                    String nomAut = read.nextLine();
                    libro = libroServ.buscarAut(autorServ.buscarNombre(nomAut));
                    System.out.println(libro);
                    break;
                case 6:
                    System.out.println("INGRESE EL NOMBRE DE LA EDITORIAL DEL LIBRO A BUSCAR.");
                    String nomEdit = read.nextLine();
                    libro = libroServ.buscarEdit(editorialServ.buscarNom(nomEdit));
                    System.out.println(libro);
                    break;
                case 7:
                    System.out.println("cerrando programa....");
                    break;

                default:
                    System.out.println("INGRESE UNA OPCION CORRECTA... ");

            }
        } while (aux != 7);
    }
}
