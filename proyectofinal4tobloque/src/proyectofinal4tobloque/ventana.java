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
        misUsuarios[0] = new usuario("donsecilio", "0987");
        misUsuarios[1] = new usuario("rosa10", "567");

    }

    public void iniciarComponentes() {
        panelInicioSesion = new JPanel();
        panelInicioSesion.setLayout(null);
        this.getContentPane().add(panelInicioSesion);
        componentesInicio();

        panelNuevoUsuario = new JPanel();
        panelNuevoUsuario.setLayout(null);
        this.getContentPane().add(panelNuevoUsuario);
        panelNuevoUsuario.setVisible(false);
        componentesUsuario();

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

                if (buscarUsuario(usuario, contra)) {
                   txtUsuario.setText("");
                   txtContra.setText("");
                }

            }
        };
        btnIngresar.addActionListener(inicioSesion);

        //botn para ingresar nuevo usuario
        JButton btnRegistrar = new JButton("Registrar");
        btnRegistrar.setFont(new Font("arial", Font.ITALIC, 18));
        btnRegistrar.setBounds(275, 150, 125, 30);
        panelInicioSesion.add(btnRegistrar);

        ActionListener NuevoRegistro = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelInicioSesion.setVisible(false);
                panelNuevoUsuario.setVisible(true);
            }

        };
        btnRegistrar.addActionListener(NuevoRegistro);
        panelInicioSesion.repaint();

    }

    public boolean buscarUsuario(String usuario, String password) {
        boolean ingresar = false;
        boolean encontrar = false;
        String nombre = "";
        for (int i = 0; i <= 9; i++) {
            if (misUsuarios[i] != null) {
                if (misUsuarios[i].getNombreUsuario().equals(usuario) && misUsuarios[i].getContraUsuario().equals(password)) {
                    encontrar = true;
                    nombre = misUsuarios[i].getNombreUsuario();
                    break;
                }
            }
        }
        if (encontrar) {
            JOptionPane.showMessageDialog(null, "Bienvenido " + nombre);
          ingresar= true;
        } else if (usuario.equals("") || password.equals("")) {
            JOptionPane.showMessageDialog(null, "Debe llenar todos los campos");
            
        } else {
            JOptionPane.showMessageDialog(null, "Datos incorrectos");
            ingresar = true;
        }
        return ingresar;
    }

    public void componentesUsuario() {
        JLabel nuevoUsuario = new JLabel("Ingrese un usuario");
        nuevoUsuario.setFont(new Font("arial", Font.ITALIC, 15));
        nuevoUsuario.setBounds(50, 25, 150, 15);
        panelNuevoUsuario.add(nuevoUsuario);

        JLabel nuevoNombre = new JLabel("Ingrese un nombre");
        nuevoNombre.setFont(new Font("arial", Font.ITALIC, 15));
        nuevoNombre.setBounds(50, 55, 150, 15);
        panelNuevoUsuario.add(nuevoNombre);

        JLabel nuevoContra = new JLabel("Ingrese Password");
        nuevoContra.setFont(new Font("arial", Font.ITALIC, 15));
        nuevoContra.setBounds(50, 85, 150, 15);
        panelNuevoUsuario.add(nuevoContra);

        JLabel confirmarContra = new JLabel("Confirme Password");
        confirmarContra.setFont(new Font("arial", Font.ITALIC, 15));
        confirmarContra.setBounds(50, 115, 150, 15);
        panelNuevoUsuario.add(confirmarContra);

        JTextField txtUsuarioNuevo = new JTextField();
        txtUsuarioNuevo.setBounds(230, 25, 220, 20);
        panelNuevoUsuario.add(txtUsuarioNuevo);
        txtUsuarioNuevo.setFont(new Font("arial", Font.ITALIC, 15));

        JTextField txtNombreNuevo = new JTextField();
        txtNombreNuevo.setBounds(230, 55, 220, 20);
        panelNuevoUsuario.add(txtNombreNuevo);
        txtNombreNuevo.setFont(new Font("arial", Font.ITALIC, 15));

        JPasswordField txtContraNueva = new JPasswordField();
        txtContraNueva.setBounds(230, 85, 220, 20);
        panelNuevoUsuario.add(txtContraNueva);
        txtContraNueva.setFont(new Font("arial", Font.ITALIC, 15));

        JPasswordField txtConfirmar = new JPasswordField();
        txtConfirmar.setBounds(230, 115, 220, 20);
        panelNuevoUsuario.add(txtConfirmar);
        txtConfirmar.setFont(new Font("arial", Font.ITALIC, 15));

        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.setFont(new Font("arial", Font.ITALIC, 18));
        btnGuardar.setBounds(260, 200, 125, 30);
        panelNuevoUsuario.add(btnGuardar);

        ActionListener almacenar = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usuario = txtUsuarioNuevo.getText();
                String nombre = txtNombreNuevo.getText();
                String contra = txtContraNueva.getText();
                String confirmar = txtConfirmar.getText();
                if (guardarRegistro(usuario, nombre, contra, confirmar)) {
                    txtUsuarioNuevo.setText("");
                    txtNombreNuevo.setText("");
                    txtContraNueva.setText("");
                    txtConfirmar.setText("");
                }

            }

        };
        btnGuardar.addActionListener(almacenar);

        JButton btnVolver = new JButton("Volver");
        btnVolver.setFont(new Font("arial", Font.ITALIC, 18));
        btnVolver.setBounds(95, 200, 125, 30);
        panelNuevoUsuario.add(btnVolver);

        ActionListener volver = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelInicioSesion.setVisible(true);
                panelNuevoUsuario.setVisible(false);
            }

        };
        btnVolver.addActionListener(volver);
    }

    public boolean guardarRegistro(String usuario, String nombre, String contra, String confirmar) {
        boolean guardar = false;
        if (usuario.equals("") || nombre.equals("") || contra.equals("") || confirmar.equals("")) {
            JOptionPane.showMessageDialog(null, "Debe de llenar todos los campos");
        } else {
            boolean vacio = false;
            int posicion = -1;
            for (int i = 0; i <= 9; i++) {
                if (misUsuarios[i] == null) {
                    vacio = true;
                    posicion = i;
                    break;

                }
            }
            if (vacio) {
                misUsuarios[posicion] = new usuario(nombre, contra);
                JOptionPane.showMessageDialog(null, "Usuario exitosamente almacenado");
                guardar = true;
            } else {
                JOptionPane.showMessageDialog(null, "Ya no se pueden almacenar mas usuarios");
            }
        }
        return guardar;

    }
}
