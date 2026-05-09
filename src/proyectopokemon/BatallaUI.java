/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package proyectopokemon;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author LCE 2-13
 */
public class BatallaUI extends javax.swing.JFrame {

    // -- Datos del entrenador — @isai
    private String nombreEntrenador;
    private ArrayList<Pokemon> equipo; // @riztutov — ArrayList con los 3 Pokémon
    
    // -- Datos de la batalla — @isai
    private Pokemon pokemonAliado;
    private Pokemon pokemonRival;
    private boolean terminada;
    private int pokemonActualIndex;

    // Constructor vacío (para menús) — @riztutov
    public BatallaUI() {
        initComponents();
    }

    // Constructor principal — @isai
    BatallaUI(String nombre, String poke1, String poke2, String poke3) {
        initComponents();
        this.nombreEntrenador = nombre;
        
        // @riztutov — crear ArrayList con los 3 Pokémon del equipo
        equipo = new ArrayList<>();
        equipo.add(crearPokemon(poke1));
        equipo.add(crearPokemon(poke2));
        equipo.add(crearPokemon(poke3));
        
        pokemonActualIndex = 0;
        pokemonAliado = equipo.get(0);
        pokemonRival = crearRivalAleatorio();
        terminada = false;
        
        // @isai — cambiar items del combo box a pociones curativas
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(
            new String[] { "Poción (+30 HP)", "Superpoción (+60 HP)", "Poción Total (llena HP)" }
        ));
        
        // @riztutov — mostrar el nombre del entrenador
        NombreUsuario.setText(nombreEntrenador);
        
        conectarBotones();
        actualizarUI();
    }

    // Conecta todos los botones y el combo box — @isai
    private void conectarBotones() {
        LuchaBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lucharActionPerformed();
            }
        });
        CambioBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cambiarPokemonActionPerformed();
            }
        });
        HuirBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                System.exit(0);
            }
        });
        // @riztutov — al seleccionar un item del combo box, se usa
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usarItemActionPerformed();
            }
        });
    }

    // @riztutov — ataque normal (sin habilidades)
    private void lucharActionPerformed() {
        if (terminada) {
            CuadroDeMensajes.setText("|| La batalla ha terminado. Cierra la ventana. ||");
            return;
        }
        if (!pokemonAliado.estaVivo()) {
            CuadroDeMensajes.setText("|| " + pokemonAliado.getNombre() + " no puede luchar. ¡Cambia de Pokémon! ||");
            return;
        }

        // -- Daño del jugador al rival — @isai
        double danioBase = (pokemonAliado.getAtaque() * 2.0 / pokemonRival.getDefensa()) * 20;
        double variacion = Math.random() * (1.15 - 0.85) + 0.85;
        int danioJugador = (int) (danioBase * variacion);
        pokemonRival.setHp(Math.max(0, pokemonRival.getHp() - danioJugador));

        String mensaje = "¡" + pokemonAliado.getNombre() + " ataca! → " + danioJugador + " de daño.";

        // @riztutov — verificar si el rival cayó
        if (!pokemonRival.estaVivo()) {
            CuadroDeMensajes.setText("|| ¡" + pokemonRival.getNombre() + " se debilitó! Tú ganas. ||");
            terminada = true;
            actualizarUI();
            return;
        }

        // -- Turno del rival — @isai
        danioBase = (pokemonRival.getAtaque() * 2.0 / pokemonAliado.getDefensa()) * 20;
        variacion = Math.random() * (1.15 - 0.85) + 0.85;
        int danioRival = (int) (danioBase * variacion);
        pokemonAliado.setHp(Math.max(0, pokemonAliado.getHp() - danioRival));

        mensaje += " || " + pokemonRival.getNombre() + " contraataca → " + danioRival + " de daño.";

        // @riztutov — verificar si el aliado cayó
        if (!pokemonAliado.estaVivo()) {
            mensaje += " || ¡" + pokemonAliado.getNombre() + " se debilitó!";

            if (todosDebilitados()) {
                CuadroDeMensajes.setText("|| ¡Todos tus Pokémon están debilitados! Tú pierdes. ||");
                terminada = true;
                actualizarUI();
                return;
            }
            mensaje += " ¡Cambia de Pokémon! ||";
        }

        CuadroDeMensajes.setText(mensaje);
        actualizarUI();
    }

    // @isai — cambia al siguiente Pokémon vivo del equipo
    private void cambiarPokemonActionPerformed() {
        if (terminada) {
            CuadroDeMensajes.setText("|| La batalla ha terminado. ||");
            return;
        }

        int intentos = 0;
        do {
            pokemonActualIndex = (pokemonActualIndex + 1) % equipo.size();
            pokemonAliado = equipo.get(pokemonActualIndex);
            intentos++;
            if (intentos > equipo.size()) break;
        } while (!pokemonAliado.estaVivo());

        if (!pokemonAliado.estaVivo()) {
            CuadroDeMensajes.setText("|| ¡Todos tus Pokémon están debilitados! Tú pierdes. ||");
            terminada = true;
            return;
        }

        CuadroDeMensajes.setText("|| ¡Cambiaste a " + pokemonAliado.getNombre() + "! ||");
        actualizarUI();
    }

    // @riztutov — usar item del combo box de la mochila
    private void usarItemActionPerformed() {
        if (terminada) {
            CuadroDeMensajes.setText("|| La batalla ha terminado. ||");
            return;
        }
        if (!pokemonAliado.estaVivo()) {
            CuadroDeMensajes.setText("|| " + pokemonAliado.getNombre() + " está debilitado. Cámbialo primero. ||");
            return;
        }
        if (pokemonAliado.getHp() >= pokemonAliado.getHpMax()) {
            CuadroDeMensajes.setText("|| " + pokemonAliado.getNombre() + " ya tiene la vida al máximo. ||");
            return;
        }

        String itemSeleccionado = (String) jComboBox1.getSelectedItem();

        if (itemSeleccionado == null) return;

        int hpAnterior = pokemonAliado.getHp();

        if (itemSeleccionado.equals("Poción (+30 HP)")) {
            pokemonAliado.setHp(Math.min(pokemonAliado.getHp() + 30, pokemonAliado.getHpMax()));
        } else if (itemSeleccionado.equals("Superpoción (+60 HP)")) {
            pokemonAliado.setHp(Math.min(pokemonAliado.getHp() + 60, pokemonAliado.getHpMax()));
        } else if (itemSeleccionado.equals("Poción Total (llena HP)")) {
            pokemonAliado.setHp(pokemonAliado.getHpMax());
        }

        int curado = pokemonAliado.getHp() - hpAnterior;
        CuadroDeMensajes.setText("|| Usaste " + itemSeleccionado + " en "
            + pokemonAliado.getNombre() + " → +" + curado + " HP. ||");
        actualizarUI();
    }

    // @isai — verifica si todos los Pokémon del equipo están debilitados
    private boolean todosDebilitados() {
        for (Pokemon p : equipo) {
            if (p.estaVivo()) return false;
        }
        return true;
    }

    // @riztutov — crea un Pokémon según su nombre usando TipoPokemon
    private Pokemon crearPokemon(String nombre) {
        switch (nombre) {
            case "Charizard": return new Pokemon("Charizard", TipoPokemon.FUEGO, 5);
            case "Blaziken":  return new Pokemon("Blaziken", TipoPokemon.TLUCHA, 5);
            case "Piplup":    return new Pokemon("Piplup", TipoPokemon.AGUA, 5);
            case "Snorlax":   return new Pokemon("Snorlax", TipoPokemon.NORMAL, 5);
            case "Vaporeon":  return new Pokemon("Vaporeon", TipoPokemon.AGUA, 5);
            case "Umbreon":   return new Pokemon("Umbreon", TipoPokemon.SINIESTRO, 5);
            case "Skarmory":  return new Pokemon("Skarmory", TipoPokemon.VOLADOR, 5);
            case "Raikou":    return new Pokemon("Raikou", TipoPokemon.ELECTRICO, 5);
            case "Gardevoir": return new Pokemon("Gardevoir", TipoPokemon.PSIQUICO, 5);
            case "Cacturne":  return new Pokemon("Cacturne", TipoPokemon.PLANTA, 5);
            default:          return new Pokemon(nombre, TipoPokemon.NORMAL, 5);
        }
    }

    // @isai — genera un rival aleatorio
    private Pokemon crearRivalAleatorio() {
        String[] nombres = {"Charizard", "Blaziken", "Piplup", "Snorlax", "Raikou", "Gardevoir", "Cacturne"};
        int indice = (int) (Math.random() * nombres.length);
        return crearPokemon(nombres[indice]);
    }

    // @riztutov — cambia la imagen del JLabel según el Pokémon
    private void setImagenPokemon(javax.swing.JLabel label, String nombre, boolean back) {
        String ruta = "/proyectopokemon/Imagenes/" + nombre.toLowerCase() + (back ? "Back" : "") + ".png";
        label.setIcon(new javax.swing.ImageIcon(getClass().getResource(ruta)));
    }

    // @isai — actualiza toda la interfaz con los datos actuales
    private void actualizarUI() {
        // Pokémon aliado
        NombrePokemonElegido.setText(pokemonAliado.getNombre() + " (" + nombreEntrenador + ")");
        BarraVidaPokemonAliado.setMaximum(pokemonAliado.getHpMax());
        BarraVidaPokemonAliado.setValue(Math.max(0, pokemonAliado.getHp()));
        BarraVidaPokemonAliado.setStringPainted(true);
        BarraVidaPokemonAliado.setString(pokemonAliado.getHp() + "/" + pokemonAliado.getHpMax());
        setImagenPokemon(jLabel2, pokemonAliado.getNombre(), false);

        // Pokémon rival
        NombrePokemonRival.setText(pokemonRival.getNombre());
        BarraVidaPokemonRival.setMaximum(pokemonRival.getHpMax());
        BarraVidaPokemonRival.setValue(Math.max(0, pokemonRival.getHp()));
        BarraVidaPokemonRival.setStringPainted(true);
        BarraVidaPokemonRival.setString(pokemonRival.getHp() + "/" + pokemonRival.getHpMax());
        setImagenPokemon(jLabel1, pokemonRival.getNombre(), true);

        if (CuadroDeMensajes.getText().isEmpty()) {
            CuadroDeMensajes.setText("|| ¡Comienza la batalla! "
                + pokemonAliado.getNombre() + " vs " + pokemonRival.getNombre() + " ||");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        CuadroDeMensajes = new javax.swing.JTextField();
        LuchaBoton = new javax.swing.JButton();
        CambioBoton = new javax.swing.JButton();
        HuirBoton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        BarraVidaPokemonRival = new javax.swing.JProgressBar();
        BarraVidaPokemonAliado = new javax.swing.JProgressBar();
        NombrePokemonRival = new javax.swing.JTextField();
        NombrePokemonElegido = new javax.swing.JTextField();
        PersonajeIMG = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        NombreUsuario = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        CuadroDeMensajes.setFont(new java.awt.Font("Noto Sans", 0, 24)); // NOI18N

        LuchaBoton.setText("LUCHAR");

        CambioBoton.setText("CAMBIO");

        HuirBoton.setText("HUIR");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectopokemon/Imagenes/blazikenBack.png"))); // NOI18N

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectopokemon/Imagenes/blaziken.png"))); // NOI18N

        PersonajeIMG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectopokemon/Imagenes/PersonajeMasculino1_x2.png"))); // NOI18N

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pastel del Heroe", "Tarta de Caracol", "Hot Dog", "Bola de Nieve" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(199, 199, 199)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(NombrePokemonElegido, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(BarraVidaPokemonAliado, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(CuadroDeMensajes, javax.swing.GroupLayout.PREFERRED_SIZE, 524, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LuchaBoton)
                            .addComponent(CambioBoton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(HuirBoton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(NombrePokemonRival, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(BarraVidaPokemonRival, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(119, 119, 119)
                                        .addComponent(NombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(66, 66, 66))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(70, 70, 70)
                                .addComponent(PersonajeIMG)
                                .addGap(46, 46, 46))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 120, Short.MAX_VALUE)
                .addComponent(NombrePokemonElegido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BarraVidaPokemonAliado, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(CuadroDeMensajes, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(NombrePokemonRival, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BarraVidaPokemonRival, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(PersonajeIMG)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(NombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LuchaBoton)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CambioBoton)
                    .addComponent(HuirBoton))
                .addGap(37, 37, 37))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BatallaUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BatallaUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BatallaUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BatallaUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BatallaUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar BarraVidaPokemonAliado;
    private javax.swing.JProgressBar BarraVidaPokemonRival;
    private javax.swing.JButton CambioBoton;
    private javax.swing.JTextField CuadroDeMensajes;
    private javax.swing.JButton HuirBoton;
    private javax.swing.JButton LuchaBoton;
    private javax.swing.JTextField NombrePokemonElegido;
    private javax.swing.JTextField NombrePokemonRival;
    private javax.swing.JTextField NombreUsuario;
    private javax.swing.JLabel PersonajeIMG;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
