import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import java.awt.event.MouseEvent;
import java.awt.*;
import javax.swing.*;

public class Main {

  public static void  main(String[] args) {
    JFrame fenetre = new  JFrame("Gestion de liste");

    GestionListe panneauGL1 = new GestionListe();
    GestionListe panneauGL2 = new GestionListe();
    JButton b1 = new JButton(">");
    JButton b2 = new JButton("<");

    b1.addActionListener(new BoutonListener(panneauGL1, panneauGL2));
    b2.addActionListener(new BoutonListener(panneauGL2, panneauGL1));
    
    JPanel panel = new JPanel();
    panel.add(panneauGL1);
    panel.add(b1);
    panel.add(b2);
    panel.add(panneauGL2);
//    fenetre.setContentPane(panneauGL1);
//    fenetre.setContentPane(panneauGL2);
    fenetre.setContentPane(panel);
    fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    fenetre.pack();

    fenetre.setVisible(true);
  }

}



class BoutonListener implements ActionListener {

  GestionListe dest, prov;

  public BoutonListener(GestionListe prov, GestionListe dest) {
    this.dest = dest;
    this.prov = prov;
  }

  public void actionPerformed(ActionEvent e) {
    dest.addElement(prov.removeSelection());
  }
}







class GestionListe extends JPanel {
 private JList list;
 private DefaultListModel listModel;

 private JTextField nomPersonne;
 private JButton enlever;

 public GestionListe() {
   setBorder(BorderFactory.createTitledBorder("Personnel"));
   setLayout(new BorderLayout(5,5));

     // création de la liste et de ses barres de défilement
   listModel = new DefaultListModel();
   listModel.addElement("Nicolas");
   listModel.addElement("Maurice");
   listModel.addElement("Jacques");
   listModel.addElement("Mauro");
   list = new JList(listModel);
   list.setSelectedIndex(0);
   list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
   list.addListSelectionListener(new GestionSelection());
   JScrollPane listScrollPane = new JScrollPane(list);
   add(listScrollPane, BorderLayout.CENTER);

     // panneau contenant le textfield et les 2 boutons
     // (FlowLayout par defaut)
   JPanel panneauBouton = new JPanel();
   add(panneauBouton, BorderLayout.SOUTH);

     // création des boutons et du champs de saisie
   nomPersonne = new JTextField(10);
   panneauBouton.add(nomPersonne);
   nomPersonne.setText(list.getSelectedValue().toString());

   JButton ajout = new JButton("Ajouter");
   panneauBouton.add(ajout);
   ajout.addActionListener(new AjoutListener());

   enlever = new JButton("Enlever");
   panneauBouton.add(enlever);
   enlever.addActionListener(new EnleveListener());
 }

   // gestion de la selection de la liste
 private class GestionSelection implements ListSelectionListener {
   public void valueChanged(ListSelectionEvent e) {
       // une fois la selection fixe
     if (!e.getValueIsAdjusting()) {
      Object item = list.getSelectedValue();
      if (item != null) {
        enlever.setEnabled(true);
        nomPersonne.setText(item.toString());
      }
      else {
        enlever.setEnabled(false);
        nomPersonne.setText("");
      }
    }
  }
}

   // gestion du bouton "enlever"
private class EnleveListener implements ActionListener {
 public void actionPerformed(ActionEvent e) {
       // retrait de l'element selectionne
   int index = list.getSelectedIndex();
   if (index != -1) {
    listModel.remove(index);
    
    
    int size = listModel.getSize();
        // si la liste est vide on desactive le bouton "enlever"
    if (size == 0) {
      enlever.setEnabled(false);
      nomPersonne.setText("");
    }
    else {
          // reajustement de la selection
      if (index == size)
        index--;
      list.setSelectedIndex(index);
    }
  }
}
}

   // gestion du bouton "ajout"
private class AjoutListener implements ActionListener {
   public void actionPerformed(ActionEvent e) {
     String contenuChampsPersonne = nomPersonne.getText().trim();
         // si on rentre un nom vide : Beeeeeeeeeeeeeeeeeeeeeeeeeep
     if (contenuChampsPersonne.equals("")) {
      Toolkit.getDefaultToolkit().beep();
      return;
    }
    
    int index = list.getSelectedIndex();
    int size  = listModel.getSize();
    
         // si on ajoute en fin de liste ou dans une liste vide
    if ( index == -1 || (index+1 == size) ) {
      listModel.addElement(contenuChampsPersonne);
      list.setSelectedIndex(size);
    }
         // si on ajoute en milieu de liste
    else {
      listModel.insertElementAt(contenuChampsPersonne, index+1);
      list.setSelectedIndex(index+1);
    }
  }
}

public void addElement(String elt) {
  String contenuChampsPersonne = elt;

  if (!elt.equals("")) {
    
    int index = list.getSelectedIndex();
    int size  = listModel.getSize();
    
       // si on ajoute en fin de liste ou dans une liste vide
    if ( index == -1 || (index+1 == size) ) {
      listModel.addElement(contenuChampsPersonne);
      list.setSelectedIndex(size);
    }
       // si on ajoute en milieu de liste
    else {
      listModel.insertElementAt(contenuChampsPersonne, index+1);
      list.setSelectedIndex(index+1);
    }
  }
}

public String removeSelection() {
  int index = list.getSelectedIndex();
  if (index != -1) {
    String result = (String)listModel.getElementAt(index);
    listModel.remove(index);
    
    int size = listModel.getSize();
        // si la liste est vide on desactive le bouton "enlever"
    if (size == 0) {
      enlever.setEnabled(false);
      nomPersonne.setText("");
    }
    else {
          // reajustement de la selection
      if (index == size)
        index--;
      list.setSelectedIndex(index);
    }
    return result;
  }
  return null;
}

}
