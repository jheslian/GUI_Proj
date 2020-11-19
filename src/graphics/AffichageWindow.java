package graphics;

import javax.swing.*;
import java.awt.*;

public class AffichageWindow extends  UserInterface{
    JFrame frame = new JFrame();
    static JLabel label = new JLabel();
    
    AffichageWindow(){
        label.setBounds( 0,0,700,700 );
        frame.add( label );
        frame.setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
        frame.setSize( 700,700 );
        frame.setLayout( new FlowLayout() );
        this.setLocationRelativeTo( null );
        frame.setVisible(true);
    }


}
