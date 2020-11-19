package application;

import object.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class UserInterface extends JFrame{
    JTextField titleField;
    JTextField authorField;
    JTextField editorField;
    JTextField yearField;
    JTextField langField;
    JTextField refField;
    JLabel titleLabel;
    JLabel authorLabel;
    JLabel editorLabel;
    JLabel yearLabel;
    JLabel langLabel;
    JLabel refLabel;
    JLabel infoTitle;
    JLabel infoAuthor;
    JLabel infoYear;
    JLabel infoEditor;
    JLabel infoLang;
    JLabel infoRef;
    JLabel info;

    public UserInterface(){
        super( "Library" );


        // frame settings
        this.setDefaultCloseOperation( DISPOSE_ON_CLOSE );
        this.setSize( 700, 700 );
        this.setLocationRelativeTo( null );
        this.setResizable( false );
        JPanel container = (JPanel)this.getContentPane();
        container.setLayout( null );

        //creation of menu
        JMenuBar menu = new JMenuBar();

        //creation of items on menu bar
        //JMenu bookLetterA = new JMenu("Books starts A");
        //JMenu bookOdd = new JMenu("Book Odd reference");
        JMenu bookMenu = new JMenu("Books");

        //adding for availability

        JMenuItem showBooks = new JMenuItem("show all books");
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
        refLabel = new JLabel( "Ref ID No." );
        refLabel.setBounds( 150, 350, 150, 30 );
        container.add( refLabel );

        // reference number input
        refField = new JTextField();
        refField.setBounds( 250, 350, 250, 30 );
        container.add( refField );

        //button
        JButton createButton = new JButton( "Create" );
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
        showBook.setBounds( 50,50,150,35 );
        container.add( showBook );

        JButton oddBookButton = new JButton("Odd Books");
        oddBookButton.setBounds( 250,50,150,35 );
        container.add( oddBookButton );

        JButton lettreABookBtn = new JButton("Start with \"A\" Books");
        lettreABookBtn.setBounds( 450,50,150,35 );
        container.add( lettreABookBtn );

        Biblio maBiblio = new Biblio();


        // accepts only a numerical value for year
        yearField.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyChar() >= '0' && e.getKeyChar() <= '9') {
                    yearField.setEditable(true);
                } else {
                    yearField.setEditable(false);
                    yearField.setToolTipText("Enter only numeric digits(0-9)");
                }
            }
        });
        // accepts only a numerical value for reference
        refField.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyChar() >= '0' && e.getKeyChar() <= '9') {
                    refField.setEditable(true);
                } else {
                    refField.setEditable(false);
                    refField.setToolTipText("Enter only numeric digits(0-9)");
                }
            }
        });


        //show list of the books
        showBook.addActionListener( e -> {
             Biblio.afficheLivreBiblio( maBiblio,AffichageWindow.label );
             new AffichageWindow();
        } );

        // creates a book and print when created successfully
        createButton.addActionListener( e -> {
            summary();

            if((Biblio.verifyIndiceRefOfBook( Integer.parseInt( refField.getText() ), maBiblio.getListDeLivres()))==true){
                JOptionPane.showMessageDialog( null,"Reference number already exist","Error reference #", JOptionPane.ERROR_MESSAGE);
            }else
                createBook(titleField.getText(), authorField.getText(),Integer.parseInt( yearField.getText() ),editorField.getText(),langField.getText(),Integer.parseInt( refField.getText() ) ,maBiblio  );
        });

        // open a new window w/ the list of all books that has odd number as reference
        oddBookButton.addActionListener( new ActionListener() {
             public void actionPerformed(ActionEvent e) {
                  Biblio.afficherIndexImpair( maBiblio,AffichageWindow.label );
                  new AffichageWindow();
             }
        });
        // open a new window w/ the list of all books that start w/ letter A
        lettreABookBtn.addActionListener( new ActionListener() {
             public void actionPerformed(ActionEvent e) {
                  Biblio.affichLivreA( maBiblio,AffichageWindow.label );
                  new AffichageWindow();
             }
        });
    }

    // function to create a book and print the content
    private void createBook( String titre, String auteur, int annee,String editeur, String langue, int indiceRef,   Biblio maBiblio) {
        Livre monLivre = new Livre( titre, auteur,annee,editeur,langue,indiceRef);
        maBiblio.getListDeLivres().add(monLivre);
    }

    // show the summary of the book that was created
    private void summary(){
        info.setText( "Summary :" );
        infoTitle.setText( titleLabel.getText() + "     :     " + titleField.getText() );
        infoAuthor.setText( authorLabel.getText() + "     :     " + authorField.getText() );
        infoYear.setText( yearLabel.getText() + "     :     " + yearField.getText() );
        infoEditor.setText( editorLabel.getText() + "     :     " + editorField.getText() );
        infoLang.setText( langLabel.getText() + "     :     " + langField.getText() );
        infoRef.setText( refLabel.getText() + "     :     " + refField.getText() );
        titleField.setText( "" );
        authorField.setText( "" );
        yearField.setText( "" );
        editorField.setText( "" );
        langField.setText( "" );
        refField.setText( "" );
    }

}














