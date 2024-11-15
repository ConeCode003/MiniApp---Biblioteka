/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baza;

import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;
import model.Autor;
import model.Knjiga;
import model.Zanr;

/**
 *
 * @author Nemanja
 */


public class DBBroker {

    public List<Knjiga> ucitajListuKnjigaIzBaze() {
        List<Knjiga> lista = new ArrayList<>();
        try {
            String upit = "SELECT * FROM KNJIGA K JOIN AUTOR A ON k.autorId=a.id";
            Statement st = Konekcija.getInstance().getConnection().createStatement();
            ResultSet rs = st.executeQuery(upit);
            while(rs.next()){
                int id = rs.getInt("k.id");
                String naslov = rs.getString("k.naslov");
                int godinaIzdanja = rs.getInt("k.godinaIzdanja");
                String ISBN = rs.getString("k.ISBN");
                String zanr = rs.getString("k.zanr");
                Zanr z = Zanr.valueOf(zanr);
                String ime = rs.getString("a.ime");
                String prezime = rs.getString("a.prezime");
                String biografija = rs.getString("a.biografija");
                int godR = rs.getInt("a.godinaRodjenja");
                int idA = rs.getInt("a.id");
                Autor autor = new Autor(idA, ime, prezime, godR, biografija);
                Knjiga k = new Knjiga(id, naslov, autor, ISBN, godinaIzdanja, z);
                lista.add(k);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return lista;
    }

    public List<Autor> ucitajListuAutoraIzBaze() {
        List<Autor> lista = new ArrayList<>();
        try {
            String upit = "SELECT * FROM autor a";
            Statement st = Konekcija.getInstance().getConnection().createStatement(); // createStatement
            ResultSet rs = st.executeQuery(upit);
            while(rs.next()){
                String ime = rs.getString("a.ime");
                String prezime = rs.getString("a.prezime");
                String biografija = rs.getString("a.biografija");
                int godR = rs.getInt("a.godinaRodjenja");
                int idA = rs.getInt("a.id");
                Autor autor = new Autor(idA, ime, prezime, godR, biografija);
                lista.add(autor);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return lista;
    }

    public void obrisiKnjigu(int id) {
        try {
            String upit = "DELETE FROM KNJIGA WHERE id=?"; // 1, 2 ,. . .  //  ?, ? , ...
            PreparedStatement ps = Konekcija.getInstance().getConnection().prepareStatement(upit); // preparedStatement for preventing SQLInjection
            ps.setInt(1,id); // 1 , 1. ?  (na 1. ? postavlja id )
            ps.executeUpdate();
            Konekcija.getInstance().getConnection().commit();
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public void dodajKnjigu(Knjiga k) {
        String upit = "INSERT INTO knjiga(id, naslov, autorid, ISBN,godinaIzdanja, zanr)"
                + " VALUES(?,?,?,?,?,?)";
        try {
            PreparedStatement ps = Konekcija.getInstance().getConnection().prepareStatement(upit);
            ps.setInt(1,k.getId());
            ps.setString(2, k.getNaslov());
            ps.setInt(3, k.getAutor().getId());
            ps.setString(4, k.getISBN());
            ps.setInt(5, k.getGodinaIzdanja());
            ps.setString(6, String.valueOf(k.getZanr()));
            ps.executeUpdate();
            Konekcija.getInstance().getConnection().commit();
            System.out.println("Uspesno dodato!");
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
         
    }

    public void azurirajKnjigu(Knjiga knjigaZaIzmenu) {
       
        try {
            String upit = "UPDATE KNJIGA SET naslov=?, autorid=?, godinaIzdanja=?, "
                + "zanr=? where id=?";
            PreparedStatement ps = Konekcija.getInstance().getConnection().prepareStatement(upit); 
            
            ps.setString(1, knjigaZaIzmenu.getNaslov());
            ps.setInt(2, knjigaZaIzmenu.getAutor().getId());
            ps.setInt(3, knjigaZaIzmenu.getGodinaIzdanja());
            ps.setString(4, String.valueOf(knjigaZaIzmenu.getZanr()));
            ps.setInt(5, knjigaZaIzmenu.getId());
            
            ps.executeUpdate();
            Konekcija.getInstance().getConnection().commit();
            System.out.println("Uspesno dodato!");
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean login(String username, String pass) {
        try {
            String upit = "SELECT * FROM USER WHERE username=? AND PASSWORD=?";
            PreparedStatement ps = Konekcija.getInstance().getConnection().prepareStatement(upit);
            ps.setString(1, username);
            ps.setString(2, pass);
            ResultSet rs = ps.executeQuery(); // executeQuery() vraca result set
            
            // 1. nacin za iteraciju  - redundantan
            /*if(rs.next()){ // iteracija kroz result set
                return true;
            }else{
                return false;
            }*/
            //2. nacin - optimizovan 
            return rs.next();
       
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public List<Knjiga> filtriraj(String autor, String naslov) {
        List<Knjiga> rezultat = new ArrayList<>();
              
        try {
                  String upit ="SELECT * \n" +
                         "FROM KNJIGA K \n" +
                         "JOIN AUTOR A ON K.AUTORID=A.ID WHERE 1=1"; //k.naslov=? AND a.ime=? AND a.prezime=?"; // 1=1 uslov je uvek zadovoljen!
            if(naslov!=null){
                upit+=" AND k.naslov='"+naslov+"'";
            }
            if(autor != null){    
                String[] podaci = autor.split(" ");
                if(podaci[0]!=null){
                     upit+=" AND a.ime='"+podaci[0]+"'";
                }
                if(podaci.length >= 2 && podaci[1]!=null){
                     upit+=" AND a.prezime='"+podaci[1]+"'";
                }   
            }
            Statement st = Konekcija.getInstance().getConnection().createStatement();
            ResultSet rs = st.executeQuery(upit);
             while(rs.next()){
                int id = rs.getInt("k.id");
                String naslov1 = rs.getString("k.naslov");
                int godinaIzdanja = rs.getInt("k.godinaIzdanja");
                String ISBN = rs.getString("k.ISBN");
                String zanr = rs.getString("k.zanr");
                Zanr z = Zanr.valueOf(zanr);
                String ime = rs.getString("a.ime");
                String prezime = rs.getString("a.prezime");
                String biografija = rs.getString("a.biografija");
                int godR = rs.getInt("a.godinaRodjenja");
                int idA = rs.getInt("a.id");
                Autor autor1 = new Autor(idA, ime, prezime, godR, biografija);
                Knjiga k = new Knjiga(id, naslov1, autor1, ISBN, godinaIzdanja, z);
                rezultat.add(k);
            }
           
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return rezultat;
    }
    
}
