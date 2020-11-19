package graphics;

import object.Biblio;
import object.Livre;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class UserInterface extends JFrame {
    public static JTextField titleField;
    public static JTextField authorField;
    public static JTextField editorField;
    public static JTextField yearField;
    public static JTextField langField;
    public static JTextField refField;
    JLabel titleLabel;
    JLabel authorLabel;
    JLabel editorLabel;
    JLabel yearLabel;
    JLabel langLabel;
    JLabel refLabel;
    JButton createButton;
    JLabel infoTitle;
    JLabel infoAuthor;
    JLabel infoYear;
    JLabel infoEditor;
    JLabel infoLang;
    JLabel infoRef;
    JLabel info;
    JMenuItem showBooks;
    public UserInterface(){
        super( "Library" );


        // frame settings
        this.setDefaultCloseOperation( DISPOSE_ON_CLOSE );
        this.setSize( 700, 700 );
        this.setLocationRelativeTo( null );
        this.setResizable( false );

        Biblio maBiblio = new Biblio();

        JPanel container = (JPanel)this.getContentPane();

        container.setLayout( null );
        //this.add( container );


        //creation of menu
        JMenuBar menu = new JMenuBar();

        //creation of items on menu bar
        //JMenu bookLetterA = new JMenu("Books starts A");
        //JMenu bookOdd = new JMenu("Book Odd reference");
        JMenu bookMenu = new JMenu("Books");

        //adding for availability

        showBooks = new JMenuItem("show all books");
        bookMenu.add( showBooks );
        menu.add( bookMenu );
        //menu.add( bookOdd );
        //menu.add( bookLetterA );
        this.setJMenuBar( menu );

        // title
        titleLabel = new JLabel( "Title" );
        titleLabel.setBounds( 150,100,150,30 );
        container.add(titleLabel);

        // title input
        titleField = new JTextField();
        titleField.setBounds( 250, 100, 250, 30 );
        container.add( titleField );


        // author label
        authorLabel = new JLabel( "Author" );
        authorLabel.setBounds( 150, 150, 150, 30 );
        container.add( authorLabel );

        // author input
        authorField = new JTextField();
        authorField.setBounds( 250, 150, 250, 30 );
        container.add( authorField );

        // year label
        yearLabel = new JLabel( "Year" );
        yearLabel.setBounds( 150, 200, 150, 30 );
        container.add( yearLabel );

        // year input
         yearField = new JTextField();
        yearField.setBounds( 250, 200, 250, 30 );
        container.add( yearField );

        // editor label
        editorLabel = new JLabel( "Editor" );
        editorLabel.setBounds( 150, 250, 150, 30 );
        container.add( editorLabel );

        // editor input
        editorField = new JTextField();
        editorField.setBounds( 250, 250, 250, 30 );
        container.add( editorField );

        // language label
        langLabel = new JLabel( "Language" );
        langLabel.setBounds( 150, 300, 150, 30 );
        container.add( langLabel );

        // language input
        langField = new JTextField();
        langField.setBounds( 250, 300, 250, 30 );
        container.add( langField );

        // reference number label
        refLabel = new JLabel( "Reference #" );
        refLabel.setBounds( 150, 350, 150, 30 );
        container.add( refLabel );

        // reference number input
        refField = new JTextField();
        refField.setBounds( 250, 350, 250, 30 );
        container.add( refField );

        //button
        createButton = new JButton("Create");
        createButton.setBounds( 350, 400, 150,35 );
        container.add( createButton );
        //createButton.addActionListener( (ActionListener) this );

        //info
        info = new JLabel();
        info.setBounds( 150,450,400,35 );
        info.setFont( new Font( "default",Font.BOLD, 14 ) );
        container.add( info );
        //information label
        infoTitle = new JLabel();
        infoTitle.setBounds( 180,470,400,35 );
        container.add( infoTitle );
        // info author
        infoAuthor = new JLabel();
        infoAuthor.setBounds( 180,490,400,35 );
        container.add( infoAuthor );
        //info year
        infoYear= new JLabel();
        infoYear.setBounds( 180,510,400,35 );
        container.add( infoYear );
        // info editor
        infoEditor = new JLabel();
        infoEditor.setBounds( 180,530,400,35 );
        container.add( infoEditor );
        // info lang
        infoLang = new JLabel();
        infoLang.setBounds( 180,550,400,35 );
        container.add( infoLang );
        //info reference
        infoRef= new JLabel();
        infoRef.setBounds( 180,570,400,35 );
        container.add( infoRef );

        JButton showBook = new JButton("All Books");
        showBook.setBounds( 100,50,150,35 );
        container.add( showBook );



        showBook.addActionListener( new ActionListener() {
                                            public void actionPerformed(ActionEvent e) {
                                                afficheLivreBiblio( maBiblio,AffichageWindow.label );
                                                new AffichageWindow();

                                            }
                                        }
        );

        createButton.addActionListener( new ActionListener() {
                                    public void actionPerformed(ActionEvent e) {
                                        info.setText( "Book you've created" );
                                        infoTitle.setText( titleLabel.getText() + "     :     " + titleField.getText() );
                                        infoAuthor.setText( authorLabel.getText() + "     :     " + authorField.getText() );
                                        infoYear.setText( yearLabel.getText() + "     :     " + yearField.getText() );
                                        infoEditor.setText( editorLabel.getText() + "     :     " + editorField.getText() );
                                        infoLang.setText( langLabel.getText() + "     :     " + langField.getText() );
                                        infoRef.setText( refLabel.getText() + "     :     " + refField.getText() );

                                        createBook(titleField.getText(), authorField.getText(),Integer.parseInt( yearField.getText() ),editorField.getText(),langField.getText(),Integer.parseInt( refField.getText() ) ,maBiblio  );

                                    }
                                }
        );

    }

    private void createBook( String titre, String auteur, int annee,String editeur, String langue, int indiceRef,   Biblio maBiblio) {
        System.out.println(titre + " " + auteur);
        Livre monLivre = new Livre( titre, auteur,annee,editeur,langue,indiceRef);
        maBiblio.getListDeLivres().add(monLivre);
        System.out.println(maBiblio);
        System.out.println(monLivre.getTitre());
        System.out.println(monLivre.getAuteur());
        System.out.println(monLivre.getAnnee());
        System.out.println(monLivre.getEditeur());
        System.out.println(monLivre.getLangue());
        System.out.println(monLivre.getIndiceRef());
        titleField.setText( "" );
        authorField.setText( "" );
        yearField.setText( "" );
        editorField.setText( "" );
        langField.setText( "" );
        refField.setText( "" );

    }

    private void afficheLivreBiblio(Biblio maBiblio, JLabel labelCR) {
        String cr = "";

        for (int i = 0; i < maBiblio.getListDeLivres().size(); i++) {
            cr += maBiblio.getListDeLivres().get( i ).getTitre() + " / " + maBiblio.getListDeLivres().get( i ).getAuteur() + "/" +
                    maBiblio.getListDeLivres().get( i ).getAnnee() + " / " + maBiblio.getListDeLivres().get( i ).getEditeur() + "/" +
                    maBiblio.getListDeLivres().get( i ).getLangue() + " / " + maBiblio.getListDeLivres().get( i ).getIndiceRef();
        }
        labelCR.setText( cr );
    }
}
/*
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==createButton) {
            //information

            info.setText( "Book you've created" );
            infoTitle.setText( titleLabel.getText() + "     :     " + titleField.getText() );
            infoAuthor.setText( authorLabel.getText() + "     :     " + authorField.getText() );
            infoYear.setText( yearLabel.getText() + "     :     " + yearField.getText() );
            infoEditor.setText( editorLabel.getText() + "     :     " + editorField.getText() );
            infoLang.setText( langLabel.getText() + "     :     " + langField.getText() );
            infoRef.setText( refLabel.getText() + "     :     " + refField.getText() );
            Biblio library = new Biblio();

            createBook( library );
            affichLivreBiblio( library, AffichageWindow.label);
            new AffichageWindow();

            //System.out.println(monLivre.getAuteur());
            //System.out.println(monLivre2.getTitre());
            //createBook(library);
        }
            //printlibrary


                //new AffichageWindow();
                //System.out.println("working");


            //affichLivreBiblio( library, AffichageWindow.label);
            //new AffichageWindow();


    }

 */



/*
    private void createBook(Biblio library) {
        int yr = Integer.parseInt( yearField.getText());
        int ref = Integer.parseInt( refField.getText());

        Livre book = new Livre(titleField.getText(),
                authorField.getText(),
                234,
                editorField.getText(),
                langField.getText(),
                 23456
        );
        System.out.println(book.getTitre());
        System.out.println(book.getAnnee());
        library.getListDeLivres().add( book );

    }
*/











