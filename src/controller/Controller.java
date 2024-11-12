/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import java.util.List;
import model.Autor;
import model.Knjiga;
import model.Zanr;

/**
 *
 * @author Nemanja
 */
public class Controller {
    private List<Knjiga> listaKnjiga;
    private List<Autor> listaAutora;
    
    private static Controller instance;

    public static Controller getInstance() {
        if(instance == null){
            instance = new Controller();
        }
        return instance;
    }
    
    private Controller() {
        Autor a1 = new Autor("Ivo","Andric",1945,"Biografija autora Ive Andrica..");
        Autor a2 = new Autor("Danilo","Kis",1935,"Biografija autora Danila Kisa..");
        Autor a3 = new Autor("Mesa","Selimovic",1910,"Biografija autora Mese Selimovica..");
        
        Knjiga k1 = new Knjiga("Na Drini Cuprija",a1,"1234567890",1945,Zanr.ROMAN);
        Knjiga k2 = new Knjiga("Basta, pepeo",a2,"0987654321",1982,Zanr.POEZIJA);
        Knjiga k3 = new Knjiga("Tvrdjava",a3,"1122334455",1970,Zanr.ISTORIJSKI);
        
        listaKnjiga = new ArrayList<>();
        listaAutora = new ArrayList<>();
        
        listaKnjiga.add(k1);
        listaKnjiga.add(k2);
        listaKnjiga.add(k3);
        
        listaAutora.add(a1);
        listaAutora.add(a2);
        listaAutora.add(a3);
    }

    public List<Knjiga> getListaKnjiga() {
        return listaKnjiga;
    }

    public void setListaKnjiga(List<Knjiga> listaKnjiga) {
        this.listaKnjiga = listaKnjiga;
    }

    public List<Autor> getListaAutora() {
        return listaAutora;
    }

    public void setListaAutora(List<Autor> listaAutora) {
        this.listaAutora = listaAutora;
    }

    public void obrisiKnjigu(int selektovaniRed) {
        listaKnjiga.remove(selektovaniRed);
    }

    public void dodajKnjigu(Knjiga k) {
        listaKnjiga.add(k);
    }

    
    
    
}
