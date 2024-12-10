
package org.educastur.eduardocl.agenda_2024;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Agenda_2024 {

     //DECLARO UN ARRAYLIST llamado contactos como atributo de la clase Agenda2024
    ArrayList<Contacto> contactos;
    
    //constructor de la clase Agenda2024
    public Agenda_2024(){
        contactos=new ArrayList();
    }
    
    public static void main(String[] args) {
        /*creo un ÚNICO objeto de la clase Agenda2024 y llamo a cargaDatos() y menu()
        es necesario aquí poner agenda.cargaDatos() y agenda.menu() ya que desde un método static
        como el main no se puede llamar directamente a métodos no static */
        Agenda_2024 agenda=new Agenda_2024();
        agenda.cargaDatos();
        agenda.menu();
    }
    
    public void menu(){
        Scanner sc=new Scanner (System.in);
        int opcion=0;
        do{
            System.out.println("\n\n\n\n\n\t\t\t\tMENU DE OPCIONES\n");
            System.out.println("\t\t\t\t1 - NUEVO CONTACTO");
            System.out.println("\t\t\t\t2 - LISTA DE CONTACTOS");
            System.out.println("\t\t\t\t3 - MODIFICAR CONTACTO");
            System.out.println("\t\t\t\t4 - BORRAR CONTACTO");
            System.out.println("\t\t\t\t5 - LISTAR CUMPLEAÑOS");
            System.out.println("\t\t\t\t6 - QUIEN CUMPLE HOY");
            System.out.println("\t\t\t\t7 - BORRAR CONTACTOS");
            System.out.println("\t\t\t\t8 - CONTACTO DE MAYOR Y MENOR EDAD");
            System.out.println("\t\t\t\t9 - SALIR");
            opcion=sc.nextInt();
            switch (opcion){
                case 1:{
                    nuevoContacto();
                    break;
                }    
                case 2:{
                    listaContactos();
                    break;
                } 
                case 3:{
                    modificarContacto();
                    break;
                } 
                case 4:{
                    borrarContacto();
                    break;
                } 
                case 5:{
                    listaCumpleaños();
                    break;
                } 
                case 6:{
                    cumpleHoy();
                    break;
                } 
                case 7:{
                    borrarContactos();
                    break;
                } 
                case 8:{
                    mayorMenorEdad();
                    break;
                } 
            }
        }while (opcion != 9);
    }
       
    public void cargaDatos(){
        contactos.add(new Contacto("Ana","666666000","ana@hotmail.com ",LocalDate.parse("2000-01-01")));
        contactos.add(new Contacto("Pepe","666666111","pepe@hotmail.com",LocalDate.parse("2001-01-01")));
        contactos.add(new Contacto("Eva","666666222","eva@hotmail.com ", LocalDate.parse("2002-02-02")));
        contactos.add(new Contacto("Julia","666666333","julia@hotmail.com", LocalDate.parse("2003-12-02")));
        contactos.add(new Contacto("Luis","666666444","luis@hotmail.com", LocalDate.parse("2004-04-04")));
        contactos.add(new Contacto("Bea","666666555","bea@hotmail.com ", LocalDate.parse("2005-05-05")));
        contactos.add(new Contacto("Lucas","666666666","lucas@hotmail.com", LocalDate.parse("2006-12-02")));
        contactos.add(new Contacto("Olivia","666666777","olivia@hotmail.com", LocalDate.parse("2007-02-28")));
        contactos.add(new Contacto("Tomas","666666888","tomas@hotmail.com", LocalDate.parse("2008-12-02")));
        contactos.add(new Contacto("Marta","666666999","marta@hotmail.com", LocalDate.parse("2009-03-07")));
        Collections.sort(contactos);   
    }
    
    public void nuevoContacto(){
        String  nombre, telefono, email, fechaNac;
        Scanner sc=new Scanner(System.in);
        
        System.out.println("Nuevo Contacto:");
        //Entrada del Nombre del nuevo contacto - SIN VALIDACIÓN
        System.out.println("Nombre:");
        nombre=sc.nextLine();
        //Entrada del TELEFONO del nuevo contacto - CON VALIDACIÓN MEDIANTE EXPRESIÓN REGULAR
        do{
                System.out.println("TELEFONO:");
                telefono=sc.next();
        }while(!telefono.matches("[6-7][0-9]{8}")); 
        //Entrada del EMAIL del nuevo contacto - CON VALIDACIÓN MEDIANTE EXPRESIÓN REGULAR
        do{
                System.out.println("EMAIL:");
                email=sc.next();
        }while(!email.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")); 
         //Entrada de LA FECHA de nacimiento del nuevo contacto - CON VALIDACIÓN MEDIANTE EXPRESIÓN REGULAR
        do{
            System.out.println("FECHA DE NACIMIENTO: (AÑO-MES-DÍA)");
            //SI QUEREMOS USAR OTRO FORMATO DE FECHA DISTINTO (Dia-mes-año) hay que usar un DateTimeFormatter
            fechaNac = sc.next();
        }while(!fechaNac.matches("(19|20)(((([02468][048])|([13579][26]))-02-29)|(\\d{2})-((02-((0[1-9])|1\\d|2[0-8]))|((((0[13456789])|1[012]))-((0[1-9])|((1|2)\\d)|30))|(((0[13578])|(1[02]))-31)))"));      

        contactos.add(new Contacto(nombre,telefono,email,LocalDate.parse(fechaNac)));
        Collections.sort(contactos);
    }

    public void listaContactos() {
        for (Contacto c : contactos) {
            System.out.println(c);
        }
    }

    public void modificarContacto() {
        Scanner sc=new Scanner (System.in);
        System.out.println("Nombre del contacto a modificar: ");
        String nombre=sc.nextLine();
        int pos=buscaContacto(nombre);
        if (pos==-1){
            System.out.println("El nombre ue buscas no está en la agenda"); 
        }else{
            System.out.println("Teclea el nuevo teléfono:)");
            contactos.get(pos).setTelefono(sc.nextLine());
        }
    }

    public void borrarContacto() {
        Scanner sc=new Scanner (System.in);
        System.out.println("Nombre del contacto a Borrar: ");
        String nombre=sc.nextLine();
        int pos=buscaContacto(nombre);
        if (pos==-1){
            System.out.println("El nombre que buscas no está en la agenda"); 
        }else{
            contactos.remove(pos);
        }
    }
    
    public void listaCumpleaños(){
        Scanner sc=new Scanner (System.in);
        int dias=0;
        LocalDate hoy=LocalDate.now();
        System.out.println(hoy);
        System.out.println("Cumpleaños en los próximos X días:");
        System.out.println("Valor de X?");
        dias=sc.nextInt();
        
        if (hoy.isLeapYear() && hoy.getDayOfYear()>59){
            System.out.println("Estamos en año bisiesto");
            hoy=hoy.minusDays(1);
        }
        
        for (Contacto c : contactos) {
            int dif= c.getFechaNac().getDayOfYear()-hoy.getDayOfYear();
            if (dif>=0 && dif<=dias){
                System.out.println(c);
            }
        }
    }
    
    
    //PRIMERA PREGUNTA DE LA PRUEBA OBJETIVA INDIVIDUAL LUNES 1/12/2024
    public void cumpleHoy(){
        LocalDate hoy=LocalDate.now();
        int mes=hoy.getMonthValue();
        int diaMes=hoy.getDayOfMonth();
        
        System.out.println("Estos son los amigos/as que cumplen años hoy:");
        for (Contacto contacto : contactos) {
            if ((contacto.getFechaNac().getDayOfMonth()==diaMes) && 
                    (contacto.getFechaNac().getMonthValue()==mes)){
                System.out.println(contacto);
            }
        }
    }
    
       
    //SEGUNDA PREGUNTA DE LA PRUEBA OBJETIVA INDIVIDUAL LUNES 1/12/2024
    public void borrarContactos(){
        Scanner sc=new Scanner (System.in);
        ArrayList <String> nombresBorrar = new ArrayList();
        
        System.out.println("Introduce los nombres a Borrar, uno a uno 'FIN' PARA TERMINAR");
        System.out.println("NOMBRE:");
        String nombre=sc.next();
        while (!nombre.equalsIgnoreCase("FIN")){
            nombresBorrar.add(nombre);
            System.out.println("NOMBRE:");
            nombre=sc.next();
        }
        
        for (String n : nombresBorrar) {
            int pos=buscaContacto(n);
            if(pos!=-1){
                contactos.remove(pos);
            }
        }
    }
    
    //TERCERA PREGUNTA DE LA PRUEBA OBJETIVA INDIVIDUAL LUNES 1/12/2024
    public void mayorMenorEdad(){
        LocalDate hoy=LocalDate.now();
        /*TENEMOS LOS CONTACTOS ORDENADOS POR FECHA DE NACIMIENTO
        pOR LO TANTO EL MÁS VIEJO ES EL PRIMERO Y EL MÁS JOVEN EL ÚLTIMO*/
        System.out.println("El/la más viejo/a es: " + contactos.get(0).getNombre() + " que tiene " + 
              ChronoUnit.YEARS.between(contactos.get(0).getFechaNac(),hoy)  + " años");
        System.out.println("El/la más joven es: " + contactos.get(contactos.size()-1).getNombre() + " que tiene " + 
              ChronoUnit.YEARS.between(contactos.get(contactos.size()-1).getFechaNac(),hoy) + " años");
    }    
    
    
    public int buscaContacto (String nombre){
        int pos=-1;
        for (int i = 0; i < contactos.size(); i++) {
            if(contactos.get(i).getNombre().equalsIgnoreCase(nombre)){
                pos=i;
                break;
            }
        }
        return pos;
    }
}
