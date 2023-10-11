package proyectofinal4tobloque;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

public class ventana extends JFrame {

    JPanel panelInicioSesion, panelNuevoUsuario, panelClientes, panelNuevoCliente;
    JTextField txtUsuario;
    JPasswordField txtContra;
    usuario misUsuarios[] = new usuario[10];
    clientes misClientes[] = new clientes[100];
    int ConteoClientes = 6;

    public ventana() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        //usuarios de prueba
        misUsuarios[0] = new usuario("rosa10", "567");
        misClientes[0] = new clientes("123", "julio", 19, 'M');
        misClientes[1] = new clientes("345", "Rigoberto", 16, 'M');
        misClientes[2] = new clientes("567", "Fernando", 25, 'M');
        misClientes[3] = new clientes("011", "Rosaura", 18, 'F');
        misClientes[4] = new clientes("532", "Oswaldo", 42, 'M');
        misClientes[5] = new clientes("532", "Abigail", 20, 'F');
        misClientes[6] = new clientes("532", "Lucrecia", 25, 'F');
        misClientes[7] = new clientes("532", "Fernada", 36, 'F');
        misClientes[8] = new clientes("532", "Kevin", 28, 'M');
        misClientes[9] = new clientes("532", "Sebastian", 33, 'M');

    }

    //etiquetas y cuadros de texto panel inicio sesion
    public void componentesInicio() {
        panelInicioSesion = new JPanel();
        panelInicioSesion.setLayout(null);
        this.getContentPane().add(panelInicioSesion);
        this.setTitle("Inicio Sesion");
        //etiquetas y cuadro de texto
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
                    panelInicioSesion.setVisible(false);

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
                componentesUsuario();
            }

        };
        btnRegistrar.addActionListener(NuevoRegistro);
        panelInicioSesion.repaint();

    }

    public boolean buscarUsuario(String usuario, String password) {
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

        } else if (usuario.equals("") || password.equals("")) {
            JOptionPane.showMessageDialog(null, "Debe llenar todos los campos");

        } else {
            JOptionPane.showMessageDialog(null, "Datos incorrectos");

        }
        return encontrar;
    }

    public void componentesUsuario() {
        panelNuevoUsuario = new JPanel();
        panelNuevoUsuario.setLayout(null);
        this.getContentPane().add(panelNuevoUsuario);

        this.setTitle("Crear nueva cuenta");
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
                //limpiar casillas
                if (guardarRegistro(usuario, nombre, contra)) {
                    txtUsuarioNuevo.setText("");
                    txtNombreNuevo.setText("");
                    txtContraNueva.setText("");

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
                panelNuevoUsuario.setVisible(false);
                componentesInicio();
            }

        };
        btnVolver.addActionListener(volver);
    }

    public boolean guardarRegistro(String usuario, String nombre, String contra) {
        boolean guardar = false;
        if (usuario.equals("") || nombre.equals("") || contra.equals("")) {
            JOptionPane.showMessageDialog(null, "Debe de llenar todos los campos");
        } else {
            if (comprobarDuplicadosUsuario(usuario)) {
                JOptionPane.showMessageDialog(null, "Este usuario ya existe");
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
        }
        return guardar;

    }

    public boolean comprobarDuplicadosUsuario(String usuario) {
        boolean duplicado = false;
        for (int i = 0; i <= 9; i++) {
            if (misUsuarios[i] != null) {
                if (misUsuarios[i].getNombreUsuario().equals(usuario)) {
                    duplicado = true;
                }
            }
        }
        return duplicado;
    }

    // ---------------------componentes para clientes---------------------------
    public void componentesClientes() {
        char M = 'M';
        char F = 'F';
        int ConteoM = 0;
        int ConteoF = 0;

        panelClientes = new JPanel();
        panelClientes.setLayout(null);
        this.getContentPane().add(panelClientes);
        this.setTitle("Dashboard para clientes");

        //tabla
        JLabel lblClientes = new JLabel("Lista de clientes");
        lblClientes.setBounds(50, 50, 250, 30);
        panelClientes.add(lblClientes);
        //grafico tabla
        DefaultTableModel datos = new DefaultTableModel();
        datos.addColumn("NIT");
        datos.addColumn("Nombre");
        datos.addColumn("Edad");
        datos.addColumn("Genero");
        for (int i = 0; i <= misClientes.length - 1; i++) {
            if (misClientes[i] != null) {
                String tabla[] = {misClientes[i].getNit(), misClientes[i].getNombre(), String.valueOf(misClientes[i].getEdad()), String.valueOf(misClientes[i].getGenero())};
                datos.addRow(tabla);
            }
        }
        //codigo para contar cuantas mujeres y hombres 
        for (int i = 0; i <= misClientes.length - 1; i++) {
            if (misClientes[i] != null) {
                if (misClientes[i].getGenero() == (M)) {
                    ConteoM = ConteoM + 1;
                } else if (misClientes[i].getGenero() == (F)) {
                    ConteoF = ConteoF + 1;
                }
            }
        }
        JTable Clientetabla = new JTable(datos);
        //barra espaciadora(Scroll)
        JScrollPane barraClientes = new JScrollPane(Clientetabla);
        barraClientes.setBounds(50, 80, 450, 250);
        panelClientes.add(barraClientes);
        DefaultPieDataset GraficodeGeneros = new DefaultPieDataset();
        GraficodeGeneros.setValue("Masculino", ConteoM);
        GraficodeGeneros.setValue("Femenino", ConteoF);
        JFreeChart graficoPastel = ChartFactory.createPieChart("Generos", GraficodeGeneros, true, true, false);

        ChartPanel panelCircular = new ChartPanel(graficoPastel);
        panelCircular.setBounds(500, 80, 300, 200);
        panelClientes.add(panelCircular);
        this.setSize(850, 400);

        //Ingresar nuevo cliente boton
        JButton btnCrearCliente = new JButton("Crear Cliente");
        btnCrearCliente.setFont(new Font("arial", Font.ITALIC, 18));
        btnCrearCliente.setBounds(100, 250, 180, 30);
        panelClientes.add(btnCrearCliente);
        ActionListener NuevoCliente = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                componentesNuevoCliente();
                panelClientes.setVisible(false);
            }
        };
        btnCrearCliente.addActionListener(NuevoCliente);
        // boton de volver

        JButton btnvolverCliente = new JButton("Volver");
        btnvolverCliente.setFont(new Font("arial", Font.ITALIC, 18));
        btnvolverCliente.setBounds(240, 250, 180, 30);
        panelClientes.add(btnvolverCliente);
        ActionListener volver = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                componentesInicio();
                panelClientes.setVisible(false);
            }
        };
        btnvolverCliente.addActionListener(volver);

    }

    public void componentesNuevoCliente() {
        panelNuevoCliente = new JPanel();
        panelNuevoCliente.setLayout(null);
        this.getContentPane().add(panelNuevoCliente);
        this.setTitle("Crear nuevo cliente");
        
        JLabel nuevoCliente = new JLabel("Ingrese un nombre");
        nuevoCliente.setFont(new Font("arial", Font.ITALIC, 15));
        nuevoCliente.setBounds(50, 25, 150, 15);
        panelNuevoCliente.add(nuevoCliente);

        JLabel EdadNueva = new JLabel("Ingrese edad");
        EdadNueva.setFont(new Font("arial", Font.ITALIC, 15));
        EdadNueva.setBounds(50, 55, 150, 15);
        panelNuevoCliente.add(EdadNueva);

        JLabel genero = new JLabel("Eligir sexo");
        genero.setFont(new Font("arial", Font.ITALIC, 15));
        genero.setBounds(50, 85, 150, 15);
        panelNuevoCliente.add(genero);

        JLabel NitNuevo = new JLabel("Ingrese NIT");
        NitNuevo.setFont(new Font("arial", Font.ITALIC, 15));
        NitNuevo.setBounds(50, 115, 150, 15);
        panelNuevoCliente.add(NitNuevo);

        JTextField txtNombreNuevo = new JTextField();
        txtNombreNuevo.setBounds(230, 25, 220, 20);
        panelNuevoCliente.add(txtNombreNuevo);
        txtNombreNuevo.setFont(new Font("arial", Font.ITALIC, 15));

        JTextField txtNuevaEdad = new JTextField();
        txtNuevaEdad.setBounds(230, 55, 220, 20);
        panelNuevoCliente.add(txtNuevaEdad);
        txtNuevaEdad.setFont(new Font("arial", Font.ITALIC, 15));

        
        
        
        
        
        
        
        
        
       
            
        

        JTextField txtNIT = new JTextField();
        txtNIT.setBounds(230, 115, 220, 20);
        panelNuevoCliente.add(txtNIT);
        txtNIT.setFont(new Font("arial", Font.ITALIC, 15));

        JButton btnIntegrar = new JButton("Agregar");
        btnIntegrar.setFont(new Font("arial", Font.ITALIC, 18));
        btnIntegrar.setBounds(260, 200, 125, 30);
        panelNuevoUsuario.add(btnIntegrar);

        ActionListener agregarCliente = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = txtNombreNuevo.getText();
                String edad = txtNuevaEdad.getText();
                String nit = txtNIT.getText();
                guardarCliente(nombre, edad, nit, genero);
            }

        };
        btnIntegrar.addActionListener(agregarCliente);
    }

    public void guardarCliente(String nombre, int edad, char genero, String nit) {
        boolean almacenar = false;
        if (nombre.equals("") || edad == 0 || nit.equals("")) {
            JOptionPane.showMessageDialog(null, "Debe de llenar todos los campos");
        } else {
            if (comprobarDuplicadosClientes(nit)) {
                JOptionPane.showMessageDialog(null, "Este cliente ya existe");
            } else {
                boolean vacio = false;
                int posicion = -1;
                for (int i = 0; i <= misClientes.length; i++) {
                    if (misClientes[i] == null) {
                        vacio = true;
                        posicion = i;
                        break;
                    }
                }

                if (vacio) {
                    misClientes[posicion] = new clientes(nit, nombre, edad, genero);
                    JOptionPane.showMessageDialog(null, "Cliente exitosamente almacenado");

                } else {
                    JOptionPane.showMessageDialog(null, "Ya no se pueden almacenar mas clientes");
                }
            }
        }

    }

    public boolean comprobarDuplicadosClientes(String nit) {
        boolean duplicado = false;
        for (int i = 0; i <= misClientes.length; i++) {
            if (misClientes[i] != null) {
                if (misClientes[i].getNit().equals(nit)) {
                    duplicado = true;
                }
            }
        }
        return duplicado;
    }

}
