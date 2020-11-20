package object;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Classe qui va nous permettre de stocker des livres et retourner
 * différentes statistique sur le contenu de la bibliothèque.
 */

public class Biblio {
    private ArrayList<Livre> listDeLivres = null;
    private HashMap<Integer, Livre> listDeLivresHashMap = null;

    /**
     * Méthode constructeur de l'objet Bibliothèque
     * Ici on ne demande pas d'argument
     * Car on va réer une bibliothèque qui va subir un
     * inventaire au lancement de l'application
     * On instanciera simplement Une arraylist Vide.
     */
    public Biblio() {
        listDeLivres = new ArrayList<>();
        listDeLivresHashMap = new HashMap<>();
    }


    /**
     * Méthode getter de la variable liste de livre qui
     * va nous permettres de consulter et Ajouter des livres
     * et eventuellement en modifier.
     * @return          => une ArrayList de Livre
     */
    public ArrayList<Livre> getListDeLivres() {
        return listDeLivres;
    }



    /**
     * Méthode qui va à partir de la liste complète des livres de la
     * bibliothèque retourner une sous liste de titre de livres qui commence
     * strictement par la lettre A
     * @return   Une ArrayList de Titre de livre commençant par la lettre A
     */
    public ArrayList<String> getAllBooksWithNameStartByA(){
        ArrayList<String> maSousListe = new ArrayList<>();
        for (int i = 0; i<this.getListDeLivres().size(); i++){
            Livre monLivreATester = this.getListDeLivres().get(i);
            if (monLivreATester.getTitre().toLowerCase().startsWith("a")) {
                maSousListe.add( monLivreATester.getTitre() + " / " + monLivreATester.getAuteur() + " / " + monLivreATester.getAuteur()
                        + " / " + monLivreATester.getLangue() + " / " + monLivreATester.getEditeur() + " / " + monLivreATester.getIndiceRef() );
            }
        }

        return maSousListe;
    }

    /**
     * Méthode qui va à partir de la liste complète des livres de la
     * bibliothèque retourner une sous liste de titre et d'indice de livres qui ont
     * un indiceRef strictement impair
     * @return   Une ArrayList de Titre de livre et son indice Ref qui est Impair
     */
    public ArrayList<String> getAllBooksWhithIDSNOdd(){
        ArrayList<String> maSousListe = new ArrayList<>();
        for (int i = 0; i<this.getListDeLivres().size(); i++){
            Livre monLivreATester = this.getListDeLivres().get(i);
            if (monLivreATester.getIndiceRef() % 2 == 1){
                maSousListe.add( monLivreATester.getIndiceRef() +" / " +monLivreATester.getTitre() + " / "+ monLivreATester.getAuteur()+
                                " / "+monLivreATester.getAuteur() + " / " + monLivreATester.getLangue() + " / " + monLivreATester.getEditeur());
            }

        }
        return maSousListe;
    }

    public static boolean verifyIndiceRefOfBook(int indiceRef, ArrayList<Livre> listDeLivres) {
        boolean isAlreadyExist = false;
        for (int i = 0; i<listDeLivres.size() ; i++){
            Livre livreAVerifier = listDeLivres.get(i);
            if (livreAVerifier.getIndiceRef() == Integer.parseInt(String.valueOf(indiceRef))){
                isAlreadyExist = true;
                return isAlreadyExist;
            }
        }return isAlreadyExist;
    }
    public static void affichLivreA(Biblio maBiblio, JLabel labelCR){
        String result = "";
        for (int i = 0; i < maBiblio.getAllBooksWithNameStartByA().size(); i++) {
            result += maBiblio.getAllBooksWithNameStartByA().get(i)+" ";
        }

        labelCR.setText(result);

    }
    public static void afficherIndexImpair(Biblio maBiblio, JLabel labelCR){
        String result = "";
        for (int i = 0; i < maBiblio.getAllBooksWhithIDSNOdd().size(); i++) {
            result += maBiblio.getAllBooksWhithIDSNOdd().get(i)+" ";
        }
        labelCR.setText(result);
    }
    // function to show the lists of the books
    public static void afficheLivreBiblio(Biblio maBiblio, JLabel labelCR) {
        String cr = "";

        for (int i = 0; i < maBiblio.getListDeLivres().size(); i++) {
            cr += maBiblio.getListDeLivres().get( i ).getTitre() + " / " + maBiblio.getListDeLivres().get( i ).getAuteur() + "/" +
                    maBiblio.getListDeLivres().get( i ).getAnnee() + " / " + maBiblio.getListDeLivres().get( i ).getEditeur() + "/" +
                    maBiblio.getListDeLivres().get( i ).getLangue() + " / " + maBiblio.getListDeLivres().get( i ).getIndiceRef();
        }
        labelCR.setText( cr );
    }


    /* FOR RADIO BUTTON
    public ArrayList<String> getAllBookType(Biblio maBiblio, JLabel label) {
        ArrayList<String> maSousListe = new ArrayList<>();
            for (int i = 0; i<this.getListDeLivres().size(); i++){
                Livre monLivreATester = this.getListDeLivres().get(i);
                if (getType=="manga") {
                    maSousListe.add( monLivreATester.getTitre() + " / " + monLivreATester.getAuteur() + " / " + monLivreATester.getAuteur()
                            + " / " + monLivreATester.getLangue() + " / " + monLivreATester.getEditeur() + " / " + monLivreATester.getIndiceRef() );
                }
            }
            return maSousListe;
        }
    public static void afficheTypeBook(Biblio maBiblio, JLabel labelCR){
        String result = "";
        for (int i = 0; i < maBiblio.getAllBooksWithNameStartByA().size(); i++) {
            result += maBiblio.getAllBooksWithNameStartByA().get(i)+" ";
        }
        labelCR.setText(result);
    }

     */
}
