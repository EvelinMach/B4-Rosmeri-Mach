package proyectofinal4tobloque;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class ventana extends JFrame {

    JPanel panelInicioSesion, panelNuevoUsuario;
    JTextField txtUsuario;
    JPasswordField txtContra;
    usuario misUsuarios[] = new usuario[10];

    public ventana() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        //usuarios de prueba
        misUsuarios[0] = new usuario("jorgeSecilio10", "0987");
        misUsuarios[1] = new usuario("Maria Lupe", "567");

    }

    public void iniciarComponentes() {
        panelInicioSesion = new JPanel();
        panelInicioSesion.setLayout(null);
        this.getContentPane().add(panelInicioSesion);
        componentesInicio();
        
        panelNuevoUsuario= new JPanel();
        panelNuevoUsuario.setLayout(null);
        this.getContentPane().add(panelNuevoUsuario);
        panelNuevoUsuario.setVisible(false);

    }

    //etiquetas y cuadros de texto panel inicio sesion
    public void componentesInicio() {
        JLabel lblUsuario = new JLabel("Ingrese Usuario");
        lblUsuario.setBounds(50, 25, 150, 15);
        lblUsuario.setFont(new Font("arial", Font.ITALIC, 15));
        panelInicioSesion.add(lblUsuario);

        JLabel lblpassword = new JLabel("Ingrese Password");
        lblpassword.setBounds(50, 55, 150, 15);
        lblpassword.setFont(new Font("arial", Font.ITALIC, 15));
        panelInicioSesion.add(lblpassword);

        txtUsuario = new JTextField();
        txtUsuario.setBounds(220, 25, 200, 20);
        panelInicioSesion.add(txtUsuario);
        txtUsuario.setFont(new Font("arial", Font.ITALIC, 15));

        txtContra = new JPasswordField();
        txtContra.setBounds(220, 55, 200, 20);
        panelInicioSesion.add(txtContra);
        txtContra.setFont(new Font("arial", Font.ITALIC, 15));

        //boton de ingresar y dar bienvenida
        JButton btnIngresar = new JButton("Ingresar");
        btnIngresar.setFont(new Font("arial", Font.ITALIC, 18));
        btnIngresar.setBounds(100, 150, 125, 30);
        panelInicioSesion.add(btnIngresar);

        ActionListener inicioSesion = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usuario = txtUsuario.getText();
                String contra = txtContra.getText();
                buscarUsuario(usuario, contra);
            }
        };
        btnIngresar.addActionListener(inicioSesion);
        
        //botn para ingresar nuevo usuario
        JButton btnRegistrar =new JButton("Registrar");
         btnRegistrar.setFont(new Font("arial", Font.ITALIC, 18));
         btnRegistrar.setBounds(275, 150, 125, 30);
        panelInicioSesion.add(btnRegistrar);

        ActionListener NuevoRegistro =new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("siiiiii"); 
                panelInicioSesion.setVisible(false);
            }
            
        };
        btnRegistrar.addActionListener(NuevoRegistro);
        panelInicioSesion.repaint();

    }

    public void buscarUsuario(String usuario, String password) {
        boolean encontrar = false;
        for (int i = 0; i <= 9; i++) {
            if (misUsuarios[i] != null) {
                if (misUsuarios[i].getNombreUsuario().equals(usuario) && misUsuarios[i].getContraUsuario().equals(password)) {
                    encontrar = true;
                    break;
                }
            }
        }
        if (encontrar) {
            JOptionPane.showMessageDialog(null, "Bienvenido");
        } else if (usuario.equals("") || password.equals("")) {
            JOptionPane.showMessageDialog(null, "Debe llenar todos los campos");

        } else {
            JOptionPane.showMessageDialog(null, "Datos incorrectos");
        }

    }

}
