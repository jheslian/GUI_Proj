package application;


import object.Biblio;
import object.Livre;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * La classe Gestion Biblio est notre "Centre de contrôle" qui va
 * instancier nos objets et interagir avec l'utilisateur
 */
public class GestionBiblio {
    public GestionBiblio(){
        System.out.println("Mon application est lancé");

        /***********************************************************************/
        /****** On Créé notre bibliothèque en instanciant l'objet Biblio *******/
        /***********************************************************************/
        Biblio maBiblio = new Biblio();


        /****************************************************************************************/
        /****** On va demander à l'utilisateur de saisir des livres en utilisant un scanner  ****/
        /****************************************************************************************/
        boolean isInProgress = true;
        while (isInProgress){

            //On instancie un scanner
            Scanner myScanner = new Scanner(System.in);

            //On indique à l'utilisateur ce qu'il va devoir saisir dans le Scanner
            System.out.println("Merci d'indiquer les informations de votre livre séparés par le caractère / " +
                    "(titre, auteur, annee, editeur, langue, indiceRef) Pour Quitter la saisie merci de presser la lettre Q");
            //On indique que la saisie utilisateur doit être stocké dans une string
            String result = myScanner.nextLine();
            //On vérifie que l'utilisateur ne souhaite pas arrêter de saisir des livres par l'intermédiaire de la lettre Q
            if(result.equalsIgnoreCase("Q")){
                isInProgress = false;
            }else{//on va diviser notre string en sous string dans un tableau de String
                String livreTab[] = result.split("/");
                if(livreTab.length<6){//On vérifie que notre tableau de sous String dispose du nombre d'argument requis par notre objet livre
                    System.out.println("Le livre qui vient d'être validé ne dispose pas de toutes les infos nécessaire");
                }else{//On sait que le livre contient le nombre d'argument requis, on va donc instancier un objet Livre et l'ajouter à la bibliothèque, mais avant on va vérifier que l'indice n'est déjà pas utilisé par un autre livre
                    boolean isExist = verifyIndiceRefOfBook(livreTab[5], maBiblio.getListDeLivres());
                    if (isExist){
                        System.out.println("Je suis désolé mais l'indiceRef de ce livre existe déjà dans la bibliothèque et doit être unique, Merci de corriger votre saisie");
                    }else{
                        Livre monLivre = new Livre(livreTab[0].trim(), livreTab[1].trim(), Integer.parseInt(livreTab[2].trim()), livreTab[3].trim(), livreTab[4].trim(), Integer.parseInt(livreTab[5].trim()));
                        maBiblio.getListDeLivres().add(monLivre);
                    }
                }
            }

        }
        /******************************************************************************************************************************************/
        /****** La saisie utilisateur est maintenant terminée on va afficher le compte rendu des livres stockés dans notre objet bibliothèque  ****/
        /******************************************************************************************************************************************/
        System.out.println("Ci dessous se trouve la liste complète des livres de la bibliothèque");
        for (int i=0; i<maBiblio.getListDeLivres().size(); i++){

            System.out.println(maBiblio.getListDeLivres().get(i).getTitre() + " / " + maBiblio.getListDeLivres().get(i).getAuteur());
        }
        System.out.println("Ci dessous se trouve la liste complète des livres de la bibliothèque dont le titre commence par A");
        if (maBiblio.getAllBooksWithNameStartByA().size()==0){
            System.out.println("Actuellement aucun livre ne dispose d'un titre commençant par la lettre A");
        }else{
            for (int i=0; i<maBiblio.getAllBooksWithNameStartByA().size(); i++){
                System.out.println(maBiblio.getAllBooksWithNameStartByA().get(i));
            }
        }
        System.out.println("Ci dessous se trouve la liste complète des livres de la bibliothèque dont l'indiceRef est Impair");
        if (maBiblio.getAllBooksWhithIDSNOdd().size()==0){
            System.out.println("Actuellement aucun livre ne dispose d'un indiceRef impair");
        }else{
            for (int i=0; i<maBiblio.getAllBooksWhithIDSNOdd().size(); i++){
                System.out.println(maBiblio.getAllBooksWhithIDSNOdd().get(i));
            }
        }


    }


    /**
     * Méthode qui va s'assurer de l'existence ou non de l'indice Ref spécifié
     * pour le nouveau livre dans la bibliothèque déjà remplie.
     * @param indiceRef         => du livre en train d'être saisi par l'utilisateur
     * @param listDeLivres      => déjà saisie dans la bibliothèque
     */
    private boolean verifyIndiceRefOfBook(String indiceRef, ArrayList<Livre> listDeLivres) {
        boolean isAlredyExist = false;
        for (int i = 0; i<listDeLivres.size() ; i++){
            Livre livreAVerifier = listDeLivres.get(i);
            if (livreAVerifier.getIndiceRef() == Integer.parseInt(indiceRef.trim())){
                isAlredyExist = true;
                return isAlredyExist;
            }

        }
        return isAlredyExist;
    }

}
