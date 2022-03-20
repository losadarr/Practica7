package com.losadarr.Practica7;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactoController {
    private ArrayList<Contacto> contactos = new ArrayList<Contacto>();

    @GetMapping("/contactos")
    public ResponseEntity<ArrayList<Contacto>> getContactos() {
        return new ResponseEntity<ArrayList<Contacto>>(contactos, HttpStatus.OK);
    }

    @PostMapping("/contactos")
    public ResponseEntity<Contacto> postContacto(@RequestBody Contacto contacto) {
        int id = contactos.size();
        contacto.setId(id);
        contactos.add(contacto);

        return new ResponseEntity<Contacto>(contacto, HttpStatus.OK);
    }

    @DeleteMapping("/contactos/{idString}")
    public ResponseEntity<ArrayList<Contacto>> deleteContacto(@PathVariable String idString) throws Exception {
        int id = Integer.parseInt(idString);
        Contacto clone = new Contacto(id, "");
        contactos.remove(clone);
        throw new Exception();
        // return new ResponseEntity<ArrayList<Task>>(new ArrayList<Task>(), HttpStatus.NO_CONTENT);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> exceptionHandler() {
        return new ResponseEntity<String>("Ha habido un error", HttpStatus.BAD_REQUEST);
    }
}