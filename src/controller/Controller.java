/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import baza.DBBroker;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import model.Autor;
import model.Knjiga;
import model.User;
import model.Zanr;

/**
 *
 * @author Nemanja
 */
public class Controller {
    private DBBroker dbb;
    private List<Knjiga> listaKnjiga = new ArrayList<>();
    private List<Autor> listaAutora = new ArrayList<>();;
    private List<User> listaUsera = new ArrayList<>();;
    
    private static Controller instance;

    public static Controller getInstance() {
        if(instance == null){
            instance = new Controller();
        }
        return instance;
    }
    
    private Controller() {
        dbb = new DBBroker();
        // za Lokalnu Memoriju: 
        /*
        User u1 = new User(1,"nemanja","nemanja");
        User u2 = new User(2,"pera","pera");
        User u3 = new User(3,"sara","sara");
        listaUsera.add(u1);
        listaUsera.add(u2);
        listaUsera.add(u3);
        */
        
        /*
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
        */
    }

    public List<User> getListaUsera() {
        return listaUsera;
    }

    public void setListaUsera(List<User> listaUsera) {
        this.listaUsera = listaUsera;
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

    public void obrisiKnjigu(int id) {
        dbb.obrisiKnjigu(id);
       // listaKnjiga.remove(selektovaniRed);
    }

    public void dodajKnjigu(Knjiga k) {
        dbb.dodajKnjigu(k);
        // listaKnjiga.add(k);
    }

    public List<Knjiga> ucitajListuKnjigaIzBaze() {
       this.listaKnjiga = dbb.ucitajListuKnjigaIzBaze(); // na ovaj nacin se cuva kopija listeKnjiga u lok mem,osim sto se prosleduje u formu (standardno)
       return dbb.ucitajListuKnjigaIzBaze();
    }

    public List<Autor> ucitajListuAutoraIzBaze() {
        return dbb.ucitajListuAutoraIzBaze();
    }

    public void azurirajKnjigu(Knjiga knjigaZaIzmenu) {
        dbb.azurirajKnjigu(knjigaZaIzmenu);
    }
    // za lokalnu memoriju
    /*
    public boolean login1(String username, String pass) {
        for(User u: listaUsera){
            if(u.getUsername().equals(username) && u.getPassword().equals(pass)){
                return true;
            }
        }
        return false;
    }
    */

    public boolean login2(String username, String pass) {
        return dbb.login(username,pass);
    }

    public List<Knjiga> filtriraj(String autor, String naslov) {
        
        //lok memorija
        List<Knjiga> rezultat = new ArrayList<>();
          
         if(autor != null && naslov == null){
              for(Knjiga k: listaKnjiga){
                  String autorKnjige = k.getAutor().getIme()+" "+k.getAutor().getPrezime();
                  if(autorKnjige.contains(autor)){
                      rezultat.add(k);
                  }
              }
          }
          
          if(naslov != null && autor == null){
              for(Knjiga k: listaKnjiga){
                  String naslovKnjige = k.getNaslov();
                  if(naslovKnjige.contains(naslov)){
                      rezultat.add(k);
                  }
              }
          }
          if(autor!=null && naslov!=null){
              for(Knjiga k: listaKnjiga){
                  String autorKnjige = k.getAutor().getIme()+" "+k.getAutor().getPrezime();
                  String naslovKnjige = k.getNaslov();
                  if(naslovKnjige.contains(naslov) && autorKnjige.contains(autor)){
                      rezultat.add(k);
                  }
              }
          }
          //filtriranje preko collections ugradjene fje
          //stream() pretvara listu u kolekciju nad kojom se moze pozvati filter
          //filter() filtrira ,prolazi sa for petljom kroz listu knjiga,gde je k element listaKnjiga
          // slicno kao for(Knjiga k : listaKnjiga)
          /*List<Knjiga> rezultat2 = new ArrayList<>();
          rezultat2 = listaKnjiga.stream().filter(k->(naslov!=null && k.getNaslov().contains(naslov))&&
                  (autor!=null && (k.getAutor().getIme()+" "+k.getAutor().getPrezime()).contains(autor))).collect(Collectors.toList()); */
          //na kraju uz pomoc collect(Collectors.toList())
          //se filtrirani elementi tipa stream() prebacuju nazad u listu
          
          return rezultat;
    }

    public List<Knjiga> filtriraj2(String autor, String naslov) {
            return dbb.filtriraj(autor,naslov);
    }
    
}
