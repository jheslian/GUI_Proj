package IHM;

import object.Biblio;
import object.Livre;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GraphicalApplication extends JFrame {

    public GraphicalApplication(){

        /********************************************/
        /******** Configuration de la JFrame ********/
        /*********************************************/
        super("Ma première appli graphique");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(600,400);

        /********************************************************/
        /********* Instantiation de l'objet Bibliothèque ********/
        /********************************************************/

        Biblio maBiblio = new Biblio();
        /***********************************************************/
        /********* Configuration du JPanel (seconde couche) ********/
        /***********************************************************/
        JPanel container = (JPanel)this.getContentPane();



        /***********************************************************/
        /********* Configuration du Layout (troisième couche) ******/
        /***********************************************************/
        FlowLayout monLayout = new FlowLayout();
        container.setLayout(monLayout);


        /***********************************************************/
        /********* Configuration des Composants (4ème Couches   ****/
        /***********************************************************/

        JLabel labelTitre = new JLabel();
        labelTitre.setText("Titre : ");

        JTextField maJTextField = new JTextField();
        maJTextField.setPreferredSize(new Dimension(60,25));
        maJTextField.setText("");

        JButton monPremierBoutton = new JButton();
        monPremierBoutton.setToolTipText("Information que va réaliser le boutton");
        monPremierBoutton.setText("Valider");


        JButton monSecondBoutton = new JButton();
        monSecondBoutton.setText("Afficher");

        JButton monTroisiemeBoutton = new JButton();
        monTroisiemeBoutton.setText("Livres A");

        JButton monQuatriemeBoutton = new JButton();
        monQuatriemeBoutton.setText("Livres impairs");


        JLabel labelCR = new JLabel();
        /***********************************************************/
        /********* Gestion des actions de l'utilisateurs     ******/
        /***********************************************************/

        //monPremierBoutton.setToolTipText("Ici il faut indiquer ici le titre du livre");

        container.add(labelTitre);
        container.add(maJTextField);
        container.add(monPremierBoutton);
        container.add(monSecondBoutton);
        container.add(monTroisiemeBoutton);
        container.add(monQuatriemeBoutton);

        container.add(labelCR);

        /***********************************************************/
        /********* Gestion des actions de l'utilisateurs     ******/
        /***********************************************************/

        monPremierBoutton.addActionListener( new ActionListener() {
                                                 public void actionPerformed(ActionEvent e) {
                                                     createBook (maJTextField.getText().split("/"),maBiblio);
                                                 }
                                             }
        );
        monSecondBoutton.addActionListener( new ActionListener() {
                                                public void actionPerformed(ActionEvent e) {
                                                    affichLivreBiblio(maBiblio, labelCR);
                                                }
                                            }
        );

        monTroisiemeBoutton.addActionListener( new ActionListener() {
                                                   public void actionPerformed(ActionEvent e) {
                                                       affichLivreA(maBiblio, labelCR);
                                                   }
                                               }
        );

        monQuatriemeBoutton.addActionListener( new ActionListener() {
                                                   public void actionPerformed(ActionEvent e) {
                                                       afficherIndexImpair(maBiblio, labelCR);
                                                   }
                                               }
        );


        /***********************************************************/
        /********* Configuration du Menu de l'application     ******/
        /***********************************************************/

        JMenuBar monMenu = new JMenuBar();
        this.setJMenuBar(monMenu);

        JMenu menuFichier = new JMenu("Fichier");
        monMenu.add(menuFichier);

        JMenuItem subMenuExit = new JMenuItem("Exit");
        JMenuItem subMenuNew = new JMenuItem("Nouveau");

        menuFichier.add(subMenuNew);
        menuFichier.add(subMenuExit);



        JMenu menuEdition = new JMenu("Edition");
        monMenu.add(menuEdition);

        JMenuItem subMenuCopy = new JMenuItem("Copier");
        JMenuItem subMenuPaste = new JMenuItem("Coller");

        menuEdition.add(subMenuCopy);
        menuEdition.add(subMenuPaste);


        /***********************************************************/
        /********* Gestion des actions de l'utilisateurs     ******/
        /***********************************************************/

        subMenuExit.addActionListener( new ActionListener() {
                                           public void actionPerformed(ActionEvent e) {
                                               System.exit(0);
                                           }
                                       }
        );
    }

    private void affichLivreBiblio(Biblio maBiblio, JLabel labelCR) {
        String cr = "";
        for (int i = 0; i< maBiblio.getListDeLivres().size(); i++){
            cr += maBiblio.getListDeLivres().get(i).getTitre() +"/"+ maBiblio.getListDeLivres().get(i).getAuteur() + "/"
                    + maBiblio.getListDeLivres().get(i).getAnnee()+ "/" + maBiblio.getListDeLivres().get(i).getEditeur()+"/"
                    + maBiblio.getListDeLivres().get(i).getLangue()+"/" + maBiblio.getListDeLivres().get(i).getIndiceRef();

        }
        labelCR.setText(cr);
    }

    private void affichLivreA(Biblio maBiblio, JLabel labelCR){
        String result = "";
        for (int i = 0; i < maBiblio.getAllBooksWithNameStartByA().size(); i++) {
            result += maBiblio.getAllBooksWithNameStartByA();
        }

        labelCR.setText(result);
    }

    private void afficherIndexImpair(Biblio maBiblio, JLabel labelCR){
        String result = "";
        for (int i = 0; i < maBiblio.getAllBooksWhithIDSNOdd().size(); i++) {
            result += maBiblio.getAllBooksWhithIDSNOdd();
        }
        labelCR.setText(result);
    }

    private void createBook(String []livreTab, Biblio maBiblio) {

        Livre monLivre  = null;

        for (int i = 0; i < livreTab.length; i++) {
            monLivre = new Livre(livreTab[0].trim(),livreTab[1].trim(), Integer.parseInt(livreTab[2].trim()),
                    livreTab[3].trim(), livreTab[4].trim(), Integer.parseInt(livreTab[5].trim()));
        }
        maBiblio.getListDeLivres().add(monLivre);




    }



}
