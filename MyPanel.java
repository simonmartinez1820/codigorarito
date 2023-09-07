
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class MyPanel extends JPanel implements ActionListener  {
    private JButton botonPlaca;
    private JTextField placa;
    private JLabel LabelEscritorPlacas;
    private JList listaplacas;
    private JButton BotonPanico;
    private JTextField jcomp6;
    private JLabel jcomp7;
    private JButton jcomp8;

    public MyPanel() {
        //construct preComponents
        String[] listaplacasItems = {"Placa1", "Placa2", "Placa3"};

        //construct components
        botonPlaca = new JButton ("Ingresar Denuncia");
        botonPlaca.addActionListener(this);
        placa = new JTextField (5);
        LabelEscritorPlacas = new JLabel ("Denunciar una placa");
        
        listaplacas = new JList (listaplacasItems);
        BotonPanico = new JButton ("Help");
        jcomp6 = new JTextField (5);
        jcomp7 = new JLabel ("Consultar una placa");
        jcomp8 = new JButton ("Consultar");
        jcomp8.addActionListener(this);

        //set components properties
        listaplacas.setToolTipText ("PlacasIngresadas");

        //adjust size and set layout
        setPreferredSize (new Dimension (624, 361));
        setLayout (null);

        //add components
        add (botonPlaca);
        add (placa);
        add (LabelEscritorPlacas);
        add (listaplacas);
        add (BotonPanico);
        add (jcomp6);
        add (jcomp7);
        add (jcomp8);

        //set component bounds (only needed by Absolute Positioning)
        botonPlaca.setBounds (255, 140, 170, 35);
        placa.setBounds (290, 105, 100, 25);
        LabelEscritorPlacas.setBounds (280, 60, 120, 30);
        listaplacas.setBounds (345, 380, 100, 75);
        BotonPanico.setBounds (25, 140, 150, 175);
        jcomp6.setBounds (455, 105, 100, 25);
        jcomp7.setBounds (450, 65, 135, 25);
        jcomp8.setBounds (435, 140, 165, 25);
    }
     public void actionPerformed(ActionEvent e) {
        String n1;
        if (e.getSource() == botonPlaca) {
            n1 = placa.getText();
            n1= n1.toUpperCase();
            ModuloPersistencia.guardar(n1);
                        
            
            
        }
 
        if (e.getSource() == jcomp8) {
            n1 = placa.getText();
            n1= n1.toUpperCase();
            try
            {
                buscadorplacas.leerplacas(n1);
            }
            catch (java.io.IOException ioe)
            {
                ioe.printStackTrace();
            }
                        
            
            
        }
    }

    public static void main (String[] args) {
        JFrame frame = new JFrame ("MyPanel");
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add (new MyPanel());
        frame.pack();
        frame.setVisible (true);
    }
}
