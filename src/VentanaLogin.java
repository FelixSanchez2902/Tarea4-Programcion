import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

public class VentanaLogin extends JFrame {
 private JTextField txtUsuario;
 private JPasswordField txtContrasena;
 private JButton btnIniciarSesion;
 private JButton btnRegistrar;
 private Map<String, Usuario> usuariosRegistrados;

 public VentanaLogin(Map<String, Usuario> usuariosRegistrados) {
  this.usuariosRegistrados = usuariosRegistrados;

  setTitle("Login");
  setSize(300, 200);
  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  setLocationRelativeTo(null);

  setLayout(new FlowLayout());

  JLabel lblUsuario = new JLabel("Usuario:");
  txtUsuario = new JTextField(20);

  JLabel lblContrasena = new JLabel("Contraseña:");
  txtContrasena = new JPasswordField(20);

  btnIniciarSesion = new JButton("Iniciar Sesión");
  btnRegistrar = new JButton("Registrar");

  add(lblUsuario);
  add(txtUsuario);
  add(lblContrasena);
  add(txtContrasena);
  add(btnIniciarSesion);
  add(btnRegistrar);

  btnIniciarSesion.addActionListener(new ActionListener() {
   @Override
   public void actionPerformed(ActionEvent e) {
    iniciarSesion();
   }
  });

  btnRegistrar.addActionListener(new ActionListener() {
   @Override
   public void actionPerformed(ActionEvent e) {
    irARegistrar();
   }
  });
 }

 private void iniciarSesion() {
  String usuario = txtUsuario.getText();
  String contrasena = new String(txtContrasena.getPassword());

  if (usuario.isEmpty() || contrasena.isEmpty()) {
   JOptionPane.showMessageDialog(this, "Debe ingresar su usuario y contraseña.");
   return;
  }

  Usuario usuarioRegistrado = usuariosRegistrados.get(usuario);

  if (usuarioRegistrado != null && usuarioRegistrado.getContrasena().equals(contrasena)) {
   // Login exitoso
   JOptionPane.showMessageDialog(this, "¡Login exitoso!");
   // Cerrar ventana de login
   this.setVisible(false);
   new VentanaPrincipal(usuariosRegistrados).setVisible(true);
  } else {
   JOptionPane.showMessageDialog(this, "Usuario o contraseña incorrectos.");
  }
 }

 private void irARegistrar() {
  this.setVisible(false);
  new VentanaRegistro(usuariosRegistrados).setVisible(true);
 }

 public static void main(String[] args) {
  // Usamos un mapa para almacenar usuarios registrados
  Map<String, Usuario> usuariosRegistrados = new java.util.HashMap<>();
  new VentanaLogin(usuariosRegistrados).setVisible(true);
 }
}
