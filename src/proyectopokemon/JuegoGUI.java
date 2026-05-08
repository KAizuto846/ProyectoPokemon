package proyectopokemon;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

/**
 * Interfaz gráfica del simulador de batallas — REQUISITO #6 (Swing)
 */
public class JuegoGUI extends JFrame {

    // -- Componentes de la UI --
    private JLabel lblJugador, lblRival, lblMensaje;
    private JProgressBar barraJugador, barraRival;
    private JButton[] botonesHabilidad;
    private JButton btnNuevaBatalla;
    private JTextField txtNombrePokemon;
    private JComboBox<TipoPokemon> comboTipo;

    // -- Datos del juego --
    private ArrayList<Pokemon> pokemonesDisponibles; // REQUISITO #2: ArrayList
    private Batalla batallaActual;
    private Pokemon pokemonJugador;

    public JuegoGUI() {
        setTitle("⚔️ Simulador de Batallas Pokémon");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 500);
        setLocationRelativeTo(null);
        setResizable(false);

        pokemonesDisponibles = new ArrayList<>();
        inicializarPokemones();

        initUI();
        setVisible(true);
    }

    private void inicializarPokemones() {
        // Datos iniciales cargados con static (implícito en el bloque)
        Pokemon p1 = new Pokemon("Incinerador", TipoPokemon.FUEGO, 5);
        p1.agregarHabilidad(new Habilidad("Llamarada", "Una llama intensa", 90, 85));
        p1.agregarHabilidad(new Habilidad("Ascuas", "Pequeñas brasas", 40, 100));
        p1.agregarHabilidad(new Habilidad("Giro Fuego", "Gira envuelto en llamas", 60, 90));

        Pokemon p2 = new Pokemon("Aquos", TipoPokemon.AGUA, 5);
        p2.agregarHabilidad(new Habilidad("Hidrobomba", "Potente chorro de agua", 110, 80));
        p2.agregarHabilidad(new Habilidad("Pistola Agua", "Disparo de agua", 40, 100));
        p2.agregarHabilidad(new Habilidad("Surf", "Ola gigante", 90, 85));

        Pokemon p3 = new Pokemon("Electro", TipoPokemon.ELECTRICO, 5);
        p3.agregarHabilidad(new Habilidad("Rayo", "Descarga eléctrica", 90, 85));
        p3.agregarHabilidad(new Habilidad("Chispa", "Pequeña descarga", 40, 100));
        p3.agregarHabilidad(new Habilidad("Trueno", "Rayos del cielo", 120, 70));

        pokemonesDisponibles.add(p1);
        pokemonesDisponibles.add(p2);
        pokemonesDisponibles.add(p3);
    }

    private void initUI() {
        setLayout(new BorderLayout(10, 10));

        // === Panel superior: Estado de los Pokémon ===
        JPanel panelEstado = new JPanel(new GridLayout(2, 1, 5, 5));
        panelEstado.setBorder(BorderFactory.createTitledBorder("⚔️ Batalla"));

        // Panel jugador
        JPanel panelJugador = new JPanel(new BorderLayout());
        lblJugador = new JLabel("🟢 [Tu Pokémon] — Pendiente de selección");
        barraJugador = new JProgressBar(0, 100);
        barraJugador.setValue(100);
        barraJugador.setStringPainted(true);
        barraJugador.setForeground(new Color(50, 200, 50));
        panelJugador.add(lblJugador, BorderLayout.WEST);
        panelJugador.add(barraJugador, BorderLayout.CENTER);

        // Panel rival
        JPanel panelRival = new JPanel(new BorderLayout());
        lblRival = new JLabel("🔴 [Rival] — Pendiente");
        barraRival = new JProgressBar(0, 100);
        barraRival.setValue(100);
        barraRival.setStringPainted(true);
        barraRival.setForeground(new Color(200, 50, 50));
        panelRival.add(lblRival, BorderLayout.WEST);
        panelRival.add(barraRival, BorderLayout.CENTER);

        panelEstado.add(panelJugador);
        panelEstado.add(panelRival);

        add(panelEstado, BorderLayout.NORTH);

        // === Panel central: Mensajes ===
        lblMensaje = new JLabel("🎮 ¡Bienvenido! Crea tu Pokémon para empezar.");
        lblMensaje.setBorder(BorderFactory.createTitledBorder("📜 Registro"));
        lblMensaje.setVerticalAlignment(SwingConstants.TOP);
        add(lblMensaje, BorderLayout.CENTER);

        // === Panel inferior: Controles ===
        JPanel panelControles = new JPanel(new GridBagLayout());
        panelControles.setBorder(BorderFactory.createTitledBorder("🎮 Controles"));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(3, 3, 3, 3);

        // Creación de Pokémon
        gbc.gridx = 0; gbc.gridy = 0;
        panelControles.add(new JLabel("Nombre:"), gbc);

        txtNombrePokemon = new JTextField(10);
        gbc.gridx = 1;
        panelControles.add(txtNombrePokemon, gbc);

        gbc.gridx = 2;
        panelControles.add(new JLabel("Tipo:"), gbc);

        comboTipo = new JComboBox<>(TipoPokemon.values());
        gbc.gridx = 3;
        panelControles.add(comboTipo, gbc);

        JButton btnCrear = new JButton("✨ Crear Pokémon");
        btnCrear.addActionListener(this::crearPokemon);
        gbc.gridx = 4;
        panelControles.add(btnCrear, gbc);

        // Botones de habilidad (4 botones)
        JPanel panelHabilidades = new JPanel(new GridLayout(1, 4, 5, 5));
        botonesHabilidad = new JButton[4];
        for (int i = 0; i < 4; i++) {
            final int idx = i;
            botonesHabilidad[i] = new JButton("—");
            botonesHabilidad[i].setEnabled(false);
            botonesHabilidad[i].addActionListener(e -> usarHabilidad(idx));
            panelHabilidades.add(botonesHabilidad[i]);
        }

        gbc.gridx = 0; gbc.gridy = 1; gbc.gridwidth = 5;
        panelControles.add(panelHabilidades, gbc);

        // Botón nueva batalla
        btnNuevaBatalla = new JButton("⚔️ Nueva Batalla");
        btnNuevaBatalla.addActionListener(e -> iniciarNuevaBatalla());
        gbc.gridx = 0; gbc.gridy = 2; gbc.gridwidth = 5;
        panelControles.add(btnNuevaBatalla, gbc);

        add(panelControles, BorderLayout.SOUTH);
    }

    private void crearPokemon(ActionEvent e) {
        String nombre = txtNombrePokemon.getText().trim();
        if (nombre.isEmpty()) {
            lblMensaje.setText("⚠️ Escribe un nombre para tu Pokémon.");
            return;
        }

        TipoPokemon tipo = (TipoPokemon) comboTipo.getSelectedItem();
        pokemonJugador = new Pokemon(nombre, tipo, 5);

        // Agregar habilidades por defecto según tipo
        pokemonJugador.agregarHabilidad(
            new Habilidad("Ataque Básico", "Golpe normal", 40, 100));
        pokemonJugador.agregarHabilidad(
            new Habilidad("Ataque Especial", "Golpe poderoso", 70, 85));
        pokemonJugador.agregarHabilidad(
            new Habilidad("Defensa", "Se prepara", 20, 100));
        pokemonJugador.agregarHabilidad(
            new Habilidad("Golpe Final", "Máximo poder", 100, 60));

        actualizarUI();
        lblMensaje.setText("✅ " + pokemonJugador.getNombre() + " ha sido creado!");
        actualizarBotonesHabilidad();
    }

    private void usarHabilidad(int index) {
        if (batallaActual == null || batallaActual.isTerminada() || pokemonJugador == null) {
            lblMensaje.setText("⚠️ No hay batalla activa.");
            return;
        }

        String resultado = batallaActual.ejecutarAtaque(pokemonJugador,
                batallaActual.getPokemonRival(), index);

        if (!batallaActual.isTerminada() && pokemonJugador.estaVivo()) {
            String turnoRival = batallaActual.turnoRival();
            lblMensaje.setText("<html>" + resultado + "<br>" + turnoRival + "</html>");
        } else {
            lblMensaje.setText(resultado);
        }

        actualizarUI();

        if (batallaActual.isTerminada()) {
            lblMensaje.setText(lblMensaje.getText()
                + "<br>🎮 Presiona 'Nueva Batalla' para jugar de nuevo.");
            deshabilitarBotonesHabilidad();
        }
    }

    private void iniciarNuevaBatalla() {
        if (pokemonJugador == null) {
            lblMensaje.setText("⚠️ Primero crea tu Pokémon.");
            return;
        }

        // Elegir rival al azar de los disponibles
        Pokemon rival = pokemonesDisponibles.get(
            (int) (Math.random() * pokemonesDisponibles.size()));

        batallaActual = new Batalla(pokemonJugador, rival);
        actualizarUI();
        actualizarBotonesHabilidad();
        lblMensaje.setText("⚔️ ¡Comienza la batalla contra " + rival.getNombre() + "!");
    }

    private void actualizarUI() {
        if (pokemonJugador != null) {
            lblJugador.setText("🟢 " + pokemonJugador.getNombre()
                + " [" + pokemonJugador.getTipo().getNombre() + "]");
            barraJugador.setMaximum(pokemonJugador.getHpMax());
            barraJugador.setValue(pokemonJugador.getHp());
            barraJugador.setString(pokemonJugador.getHp() + "/" + pokemonJugador.getHpMax());
        }

        if (batallaActual != null && batallaActual.getPokemonRival() != null) {
            Pokemon rival = batallaActual.getPokemonRival();
            lblRival.setText("🔴 " + rival.getNombre()
                + " [" + rival.getTipo().getNombre() + "]");
            barraRival.setMaximum(rival.getHpMax());
            barraRival.setValue(rival.getHp());
            barraRival.setString(rival.getHp() + "/" + rival.getHpMax());
        }
    }

    private void actualizarBotonesHabilidad() {
        if (pokemonJugador != null) {
            ArrayList<Habilidad> habs = pokemonJugador.getHabilidades();
            for (int i = 0; i < 4; i++) {
                if (i < habs.size()) {
                    botonesHabilidad[i].setText(habs.get(i).getNombre());
                    botonesHabilidad[i].setEnabled(true);
                } else {
                    botonesHabilidad[i].setText("—");
                    botonesHabilidad[i].setEnabled(false);
                }
            }
        }
    }

    private void deshabilitarBotonesHabilidad() {
        for (JButton btn : botonesHabilidad) {
            btn.setEnabled(false);
        }
    }

    // -- Main: punto de entrada --
    public static void main(String[] args) {
        SwingUtilities.invokeLater(JuegoGUI::new);
    }
}
