/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package forme;

import controller.Controller;
import java.util.List;
import java.util.Random;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import model.Autor;
import model.Knjiga;
import model.Zanr;

/**
 *
 * @author Nemanja
 */
public class FormaKnjiga extends javax.swing.JDialog {
    private Controller kontroler;
    private GlavnaForma gf;  // ovo je nadkl u podkl
    private Knjiga knjigaZaIzmenu;
    /**
     * Creates new form FormaKnjiga
     */
    public FormaKnjiga(java.awt.Frame parent, boolean modal,Knjiga knjigaZaIzmenu) {
        super(parent, modal); // nasledjivanje JFrejma
        initComponents();
        kontroler = Controller.getInstance();
        this.gf = (GlavnaForma) parent; // pa se zato radi Cast
        popuniComboBoxAutorima();
        if(knjigaZaIzmenu != null){
            this.knjigaZaIzmenu = knjigaZaIzmenu;
            jTextFieldNaziv.setText(knjigaZaIzmenu.getNaslov());
            jComboBoxAutori.setSelectedItem(knjigaZaIzmenu.getAutor());
            jTextFieldISBN.setText(knjigaZaIzmenu.getISBN());
            jTextFieldISBN.setEnabled(false);
            jTextFieldGodinaIzdanja.setText(String.valueOf(knjigaZaIzmenu.getGodinaIzdanja()));
            jComboBoxZanr.setSelectedItem(knjigaZaIzmenu.getZanr());
            jButtonDodaj.setVisible(false);
        }else{
            jButtonIzmeni.setVisible(false);
            
        }
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextFieldISBN = new javax.swing.JTextField();
        jTextFieldNaziv = new javax.swing.JTextField();
        jTextFieldGodinaIzdanja = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jComboBoxAutori = new javax.swing.JComboBox<>();
        jButtonDodaj = new javax.swing.JButton();
        jButtonOdustani = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jComboBoxZanr = new javax.swing.JComboBox<>();
        jButtonIzmeni = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Naziv:");

        jLabel2.setText("Autor");

        jLabel3.setText("ISBN");

        jLabel4.setText("GodinaIzdanja");

        jButtonDodaj.setText("DODAJ");
        jButtonDodaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDodajActionPerformed(evt);
            }
        });

        jButtonOdustani.setText("Odustani");
        jButtonOdustani.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOdustaniActionPerformed(evt);
            }
        });

        jLabel5.setText("Zanr:");

        jComboBoxZanr.setModel(new DefaultComboBoxModel(Zanr.values()));

        jButtonIzmeni.setText("IZMENI");
        jButtonIzmeni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIzmeniActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonOdustani)
                .addGap(42, 42, 42))
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldNaziv, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                            .addComponent(jComboBoxAutori, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonDodaj)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonIzmeni))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTextFieldGodinaIzdanja, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextFieldISBN, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jComboBoxZanr, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(185, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldNaziv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBoxAutori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldISBN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextFieldGodinaIzdanja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jComboBoxZanr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonDodaj)
                    .addComponent(jButtonOdustani)
                    .addComponent(jButtonIzmeni))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonOdustaniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOdustaniActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButtonOdustaniActionPerformed

    private void jButtonDodajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDodajActionPerformed
        String naziv = jTextFieldNaziv.getText(); 
        if(naziv == null || naziv.trim().isEmpty() || naziv.trim().length()<3){
            JOptionPane.showMessageDialog(this, "Greska pogresan naziv!", "Greska", JOptionPane.ERROR_MESSAGE);
            return;
        }
        Autor a = (Autor) jComboBoxAutori.getSelectedItem();
        String ISBN = jTextFieldISBN.getText();
        
        int godinaIzdanja;
        try{           
            godinaIzdanja = Integer.parseInt(jTextFieldGodinaIzdanja.getText());
            if(godinaIzdanja < 1800 || godinaIzdanja > 2023){
                JOptionPane.showMessageDialog(this, "Greska, pogresnja godina!","Greska",JOptionPane.ERROR_MESSAGE);
                return;
            }
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(this, "Godina mora biti broj!","Greska",JOptionPane.ERROR_MESSAGE);
            return;
        }
        
 
        Zanr zanr = (Zanr) jComboBoxZanr.getSelectedItem();
        Random rand = new Random();
        int id = 101 + rand.nextInt(Integer.MAX_VALUE - 100);
        Knjiga k = new Knjiga(id,naziv,a,ISBN,godinaIzdanja,zanr);
        
             
          
        kontroler.dodajKnjigu(k);
        gf.osveziTabelu();
        JOptionPane.showMessageDialog(this,"Knjiga je uspesno dodata!","Uspesno",JOptionPane.INFORMATION_MESSAGE);
        this.dispose();
    }//GEN-LAST:event_jButtonDodajActionPerformed

    private void jButtonIzmeniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIzmeniActionPerformed
        String naziv = jTextFieldNaziv.getText(); 
        Autor a = (Autor) jComboBoxAutori.getSelectedItem();
        String ISBN = jTextFieldISBN.getText();
        int GodinaIzdanja = Integer.parseInt(jTextFieldGodinaIzdanja.getText());
        Zanr zanr = (Zanr) jComboBoxZanr.getSelectedItem();
        knjigaZaIzmenu.setAutor(a);
        knjigaZaIzmenu.setNaslov(naziv);
        knjigaZaIzmenu.setZanr(zanr);
        knjigaZaIzmenu.setGodinaIzdanja(GodinaIzdanja);
        
        kontroler.azurirajKnjigu(knjigaZaIzmenu);
        gf.osveziTabelu();
        JOptionPane.showMessageDialog(this,"Knjiga je uspesno izmenjena!","Uspesno!",JOptionPane.INFORMATION_MESSAGE);
        this.dispose();
    }//GEN-LAST:event_jButtonIzmeniActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonDodaj;
    private javax.swing.JButton jButtonIzmeni;
    private javax.swing.JButton jButtonOdustani;
    private javax.swing.JComboBox<Autor> jComboBoxAutori;
    private javax.swing.JComboBox<String> jComboBoxZanr;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField jTextFieldGodinaIzdanja;
    private javax.swing.JTextField jTextFieldISBN;
    private javax.swing.JTextField jTextFieldNaziv;
    // End of variables declaration//GEN-END:variables

    private void popuniComboBoxAutorima() {
        jComboBoxAutori.removeAllItems();
        List <Autor> autori = kontroler.ucitajListuAutoraIzBaze();
        for(Autor a : autori){
            jComboBoxAutori.addItem(a);
        }
    }
}
