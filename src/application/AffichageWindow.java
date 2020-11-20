package application;

import object.Biblio;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

public class AffichageWindow extends JFrame{
    public static JLabel label = new JLabel();

    public AffichageWindow(){

        this.setDefaultCloseOperation( DISPOSE_ON_CLOSE );
        this.setSize( 700, 700 );
        JPanel container = (JPanel)this.getContentPane();
        container.setLayout( new FlowLayout() );
        label.setBounds(100,100,400,400);
        container.add( label );

/*
        JRadioButton mangaRadioBtn = new JRadioButton("Manga");
        //mangaRadioBtn.setBounds( 150,65, 100, 35 );
        container.add( mangaRadioBtn );

        JRadioButton magazineRadioBtn = new JRadioButton("Magazine");
        //magazineRadioBtn.setBounds( 250,65, 100, 35 );
        container.add( magazineRadioBtn );

        JRadioButton romanRadioBtn = new JRadioButton("Roman");
        //romanRadioBtn.setBounds( 350,65, 100, 35 );
        container.add( romanRadioBtn );

        JRadioButton otherRadioBtn = new JRadioButton("Other");
        //otherRadioBtn.setBounds( 450,65, 100, 35 );
        container.add( otherRadioBtn );

 */

        this.setVisible(true);

    }



}
