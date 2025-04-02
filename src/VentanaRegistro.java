import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

public class VentanaRegistro extends JFrame {
    private JTextField txtUsuario, txtNombre, txtApellido, txtTelefono, txtCorreo;
    private JPasswordField txtContrasena, txtConfirmarContrasena;
    private JButton btnRegistrar;
    private Map<String, Usuario> usuariosRegistrados;

    public VentanaRegistro(Map<String, Usuario> usuariosRegistrados) {
        this.usuariosRegistrados = usuariosRegistrados;

        setTitle("Registro de Usuario");
        setSize(400, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new FlowLayout());

        JLabel lblUsuario = new JLabel("Usuario:");
        txtUsuario = new JTextField(20);
        JLabel lblNombre = new JLabel("Nombre:");
        txtNombre = new JTextField(20);
        JLabel lblApellido = new JLabel("Apellido:");
        txtApellido = new JTextField(20);
        JLabel lblTelefono = new JLabel("Teléfono:");
        txtTelefono = new JTextField(20);
        JLabel lblCorreo = new JLabel("Correo:");
        txtCorreo = new JTextField(20);
        JLabel lblContrasena = new JLabel("Contraseña:");
        txtContrasena = new JPasswordField(20);
        JLabel lblConfirmarContrasena = new JLabel("Confirmar Contraseña:");
        txtConfirmarContrasena = new JPasswordField(20);

        btnRegistrar = new JButton("Registrar");

        add(lblUsuario);
        add(txtUsuario);
        add(lblNombre);
        add(txtNombre);
        add(lblApellido);
        add(txtApellido);
        add(lblTelefono);
        add(txtTelefono);
        add(lblCorreo);
        add(txtCorreo);
        add(lblContrasena);
        add(txtContrasena);
        add(lblConfirmarContrasena);
        add(txtConfirmarContrasena);
        add(btnRegistrar);

        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registrarUsuario();
            }
        });
    }

    private void registrarUsuario() {
        String usuario = txtUsuario.getText();
        String nombre = txtNombre.getText();
        String apellido = txtApellido.getText();
        String telefono = txtTelefono.getText();
        String correo = txtCorreo.getText();
        String contrasena = new String(txtContrasena.getPassword());
        String confirmarContrasena = new String(txtConfirmarContrasena.getPassword());

        if (usuario.isEmpty() || nombre.isEmpty() || apellido.isEmpty() || telefono.isEmpty() || correo.isEmpty() || contrasena.isEmpty() || confirmarContrasena.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios.");
            return;
        }

        if (!contrasena.equals(confirmarContrasena)) {
            JOptionPane.showMessageDialog(this, "Las contraseñas no coinciden.");
            return;
        }

        if (usuariosRegistrados.containsKey(usuario)) {
            JOptionPane.showMessageDialog(this, "El usuario ya está registrado.");
            return;
        }

        // Registrar usuario
        Usuario nuevoUsuario = new Usuario(usuario, nombre, apellido, telefono, correo, contrasena);
        usuariosRegistrados.put(usuario, nuevoUsuario);
        JOptionPane.showMessageDialog(this, "¡Usuario registrado exitosamente!");

        // Volver al login
        this.setVisible(false);
        new VentanaLogin(usuariosRegistrados).setVisible(true);
    }
}

class VentanaPrincipall extends JFrame {
    private Map<String, Usuario> usuariosRegistrados;
    private JButton btnCerrarSesion;

    public VentanaPrincipall(Map<String, Usuario> usuariosRegistrados) {
        this.usuariosRegistrados = usuariosRegistrados;

        setTitle("Ventana Principal");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());

        btnCerrarSesion = new JButton("Cerrar Sesión");

        btnCerrarSesion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cerrarSesion();
            }
        });

        add(btnCerrarSesion);
    }

    private void cerrarSesion() {
        JOptionPane.showMessageDialog(this, "Sesión cerrada.");
        this.dispose(); // Cierra la ventana principal
        new VentanaLogin(usuariosRegistrados).setVisible(true);
    }
}
