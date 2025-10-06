package com.mycompany.libreriaJPA1.Services;

import java.util.List;
import java.util.Scanner;
import com.mycompany.Entities.Autor;
import com.mycompany.Persistence.AutorDAO;
import javax.persistence.NoResultException;

public class AutorService {

    private AutorDAO autorDao;
    private Scanner read = new Scanner(System.in);

    public Autor guardarAutor(Autor autor) {
        return (Autor) autorDao.guardar(autor);
    }

    public AutorService() {
        this.autorDao = new AutorDAO();
    }

    public Autor crearAutor() {
        Autor autor = new Autor();

        System.out.println("ingrese el nombre del autor");
        String nombre = read.nextLine();

        try {
            autor.setNombre(nombre);
            autor.setAlta(true);
            System.out.println(autor);
            autorDao.guardar(autor);
            return autor;
        } catch (Exception e) {

            System.out.println(e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    public Autor crearAutor(String nombre) {
        Autor autor = new Autor();

        try {
            autor.setNombre(nombre);
            autor.setAlta(true);
            System.out.println(autor);
            autorDao.guardar(autor);

        } catch (Exception e) {

            System.out.println(e.getMessage());
            e.printStackTrace();

        }

        return autor;

    }

    public Autor buscarPorID(Integer id) {

        try {
            return autorDao.buscarId(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    public boolean eliminarId(Integer id) {

        try {
            autorDao.eliminar(id);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public List<Autor> listarAutores() {
        try {
            return autorDao.listAll();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;

        }
    }

    public Autor buscarNombre(String nombre) {
        try {
            return autorDao.buscarPorNombre(nombre);
        } catch (NoResultException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            return null;
        }

    }

}
