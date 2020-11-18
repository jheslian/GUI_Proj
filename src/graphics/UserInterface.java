package graphics;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserInterface extends JFrame implements ActionListener{
    public UserInterface() {
        JPanel container = new JPanel();
        // frame settings
        this.setDefaultCloseOperation( DISPOSE_ON_CLOSE );
        this.setSize( 700,700 );
        this.setTitle( "Library" );
        this.setLocationRelativeTo( null );
        this.setResizable( false );
        container.setLayout( null );
        this.add( container );

        //creation of menu
        JMenuBar menu = new JMenuBar();

        //creation of items on menu bar
        JMenu mangaBookMenu = new JMenu("Manga");
        JMenu romanBookMenu = new JMenu("Roman  |");
        JMenu magazineBookMenu = new JMenu("Magazine  |");

        //adding for availability
        menu.add( magazineBookMenu );
        menu.add( romanBookMenu );
        menu.add( mangaBookMenu );
        this.setJMenuBar( menu );


        // title
        JLabel titleLabel = new JLabel( "Title" );
        titleLabel.setBounds( 150,100,150,30 );
        container.add(titleLabel);

        // title input
        JTextField titleField = new JTextField();
        titleField.setBounds( 250, 100, 250, 30 );
        container.add( titleField );

        // author label
        JLabel authorLabel = new JLabel( "Author" );
        authorLabel.setBounds( 150, 150, 150, 30 );
        container.add( authorLabel );

        // author input
        JTextField authorField = new JTextField();
        authorField.setBounds( 250, 150, 250, 30 );
        container.add( authorField );

        // year label
        JLabel yearLabel = new JLabel( "Year" );
        yearLabel.setBounds( 150, 200, 150, 30 );
        container.add( yearLabel );

        // year input
        JTextField yearField = new JTextField();
        yearField.setBounds( 250, 200, 250, 30 );
        container.add( yearField );

        // editor label
        JLabel editorLabel = new JLabel( "Editor" );
        editorLabel.setBounds( 150, 250, 150, 30 );
        container.add( editorLabel );

        // editor input
        JTextField editorField = new JTextField();
        editorField.setBounds( 250, 250, 250, 30 );
        container.add( editorField );

        // language label
        JLabel langLabel = new JLabel( "Language" );
        langLabel.setBounds( 150, 300, 150, 30 );
        container.add( langLabel );

        // language input
        JTextField langField = new JTextField();
        langField.setBounds( 250, 300, 250, 30 );
        container.add( langField );

        // reference number label
        JLabel refLabel = new JLabel( "Reference #" );
        refLabel.setBounds( 150, 350, 150, 30 );
        container.add( refLabel );

        // reference number input
        JTextField refField = new JTextField();
        refField.setBounds( 250, 350, 250, 30 );
        container.add( refField );
        

    }



    @Override
    public void actionPerformed(ActionEvent e) {

    }
}

