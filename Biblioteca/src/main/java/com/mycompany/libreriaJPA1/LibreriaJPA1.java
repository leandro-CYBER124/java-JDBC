package com.mycompany.libreriaJPA1;

import com.mycompany.libreriaJPA1.Services.MenuService;

public class LibreriaJPA1 {

   
    public static void main(String[] args) throws Exception{
        MenuService menu = new MenuService();
        menu.menu();
    }
}
