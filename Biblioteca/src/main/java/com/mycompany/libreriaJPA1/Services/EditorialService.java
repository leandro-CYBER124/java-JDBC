package com.mycompany.libreriaJPA1.Services;

import java.util.*;
import com.mycompany.Entities.Editorial;
import com.mycompany.Persistence.EditorialDao;

public class EditorialService {

    private EditorialDao editorialDao;
    private Scanner read = new Scanner(System.in);

    public EditorialService() {
        this.editorialDao = new EditorialDao();

    }

    public Editorial guardarEd(Editorial editorial) {
        return (Editorial) editorialDao.guardar(editorial);
    }

    public Editorial crearEd() {
        Editorial editorial = new Editorial();
        System.out.println("ingrese el nombre de la editorial");
        String eName = read.nextLine();
        try {
            editorial.setNombre(eName);
            editorial.setAlta(true);
            System.out.println(editorial);
            editorialDao.guardar(editorial);
            return editorial;
        } catch (Exception e) {

            System.out.println(e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
    
    
    public Editorial crearEd(String eName) {
        Editorial editorial = new Editorial();
        
        try {
            editorial.setNombre(eName);
            editorial.setAlta(true);
            System.out.println(editorial);
            editorialDao.guardar(editorial);
            return editorial;
        } catch (Exception e) {

            System.out.println(e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    public boolean eliminarId(Integer id) {

        try {
            editorialDao.eliminar(id);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
    
    public Editorial buscarPorID(Integer id) {
        try {
            return editorialDao.buscarId(id);
        } catch (Exception e) {
            
            System.out.println(e.getMessage());
            return null;
        }
    }

    public List<Editorial> listAll() {

        return editorialDao.listAll();

    }

    public Editorial buscarNom(String nombre) {

        return editorialDao.buscarNombre(nombre);
    }

}
