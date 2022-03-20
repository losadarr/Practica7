package com.losadarr.Practica7;

import java.io.Serializable;

public class Contacto implements Serializable {

    private String correo;
    private int id;

    public Contacto(int id, String correo) {
  
        this.correo = correo;
        this.id = id;
    }

    public String getcorreo() {
        return correo;
    }
    public void setcorreo(String correo) {
        this.correo = correo;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }



    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Contacto) {
            Contacto other = (Contacto) obj;
            if (other.correo == this.getcorreo()) {
                return true;
            }
        }
        return false;
    }
}
