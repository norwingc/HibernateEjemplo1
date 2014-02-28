/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernatedemo;

/**
 *
 * @author Norwin
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ContactosDao dao = new ContactosDao();

        Contacto contacto1 = new Contacto("Contacto 5", "contacto1@contacto.com", "12345678");
        Contacto contacto2 = new Contacto("Contacto 2", "contacto2@contacto.com", "87654321");
        Contacto contacto3 = new Contacto("Contacto 3", "contacto3@contacto.com", "45612378");
        String guardaContacto3 = dao.guardaContacto(contacto3);
        String guardaContacto1 = dao.guardaContacto(contacto2);
        String guardaContacto2 = dao.guardaContacto(contacto1);

        System.out.println(guardaContacto3);
        System.out.println(guardaContacto2);
        System.out.println(guardaContacto1);
    }
}
