
package org.educastur.eduardocl.agenda_2024;

import java.time.LocalDate;

/**
 *
 * @author edu
 */
public class Contacto implements Comparable<Contacto>{
     //ATRIBUTOS
    private String nombre;
    private String telefono;
    private String email;
    private LocalDate fechaNac;

    public Contacto(String nombre, String telefono, String email, LocalDate fechaNac) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
        this.fechaNac = fechaNac;
    }
      
    public Contacto(String nombre, String telefono) {
        /*this.nombre = nombre;
        this.telefono = telefono;
        this.email = null;
        this.fechaNac=null*/
        this(nombre,telefono,null,null);
    }

    public String getNombre() {
        return nombre;
    }
    public String getTelefono() {
        return telefono;
    }
    public String getEmail() {
        return email;
    }
    public LocalDate getFechaNac() {
        return fechaNac;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setFechaNac(LocalDate fechaNac) {
        this.fechaNac = fechaNac;
    }

    @Override
    public String toString() {
        return nombre + "\t" + telefono + "\t" + email + "\t" + fechaNac;
    }

    @Override
    public int compareTo(Contacto c) {
        return this.getFechaNac().compareTo(c.getFechaNac());
    }
}
