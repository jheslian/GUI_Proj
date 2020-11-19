package object;


import graphics.UserInterface;

import static graphics.UserInterface.titleField;

/**
 * Classe qui représente un objet livre qui est destiné
 * à être stocké dans un objet de type Bibliothèque.
 */
public class Livre {

    private static String titre;
    private String auteur;
    private Integer annee;
    private String editeur;
    private String langue;
    private Integer indiceRef;


    public Livre(String titre, String auteur, int annee, String editeur, String langue, int indiceRef) {
        this.titre = titre;
        this.auteur = auteur;
        this.annee = annee;
        this.editeur = editeur;
        this.langue = langue;
        this.indiceRef = indiceRef;
    }

    public String getTitre() {
        return titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public int getAnnee() {
        return annee;
    }

    public String getEditeur() {
        return editeur;
    }

    public String getLangue() {
        return langue;
    }

    public int getIndiceRef() {
        return indiceRef;
    }


    public static String setTitre(String titre) {
        Livre.titre = titre;
        return titre;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public void setEditeur(String editeur) {
        this.editeur = editeur;
    }

    public void setLangue(String langue) {
        this.langue = langue;
    }

    public void setIndiceRef(int indiceRef) {
        this.indiceRef = indiceRef;
    }
}