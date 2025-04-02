import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class VentanaPrincipal extends JFrame {
    private JButton btnCerrarSesion;
    private JTable tablaUsuarios;
    private Map<String, Usuario> usuariosRegistrados;

    public VentanaPrincipal(Map<String, Usuario> usuariosRegistrados) {
        this.usuariosRegistrados = usuariosRegistrados;
        setTitle("Lista de Usuarios");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout());

        String[] columnas = {"Usuario", "Nombre", "Teléfono", "Correo"};
        Object[][] datos = new Object[usuariosRegistrados.size()][4];

        int i = 0;
        for (Usuario usuario : usuariosRegistrados.values()) {
            datos[i][0] = usuario.getNombreUsuario();
            datos[i][1] = usuario.getNombre() + " " + usuario.getApellido();
            datos[i][2] = usuario.getTelefono();
            datos[i][3] = usuario.getCorreo();
            i++;
        }

        tablaUsuarios = new JTable(datos, columnas);
        JScrollPane scrollPane = new JScrollPane(tablaUsuarios);

        btnCerrarSesion = new JButton("Cerrar Sesión");
        btnCerrarSesion.addActionListener(e -> {
            this.setVisible(false);
            new VentanaLogin(usuariosRegistrados).setVisible(true);
        });

        add(scrollPane, BorderLayout.CENTER);
        add(btnCerrarSesion, BorderLayout.SOUTH);
    }
}
