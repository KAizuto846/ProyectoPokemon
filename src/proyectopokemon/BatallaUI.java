package proyectopokemon;

import java.util.Random;


public class BatallaUI extends javax.swing.JFrame {

    private String p1;
    private String p2;
    private String p3;
    
    private Pokemon pokemonAliado;
    private Pokemon pokemonRival;
    private Batalla batalla;
    private int pokemonActualIndex = 0;

    public BatallaUI() {
        initComponents();
    }

    BatallaUI(String poke1, String poke2, String poke3) {
        initComponents();
        this.p1 = poke1;
        this.p2 = poke2;
        this.p3 = poke3;
        inicializarBatalla();
        conectarBotones();
    }

 
    private void inicializarBatalla() {
        pokemonAliado = crearPokemon(p1);
        pokemonAliado.agregarHabilidad(new Habilidad("Ataque Básico", "Golpe normal", 40, 100));
        pokemonAliado.agregarHabilidad(new Habilidad("Ataque Especial", "Golpe poderoso", 70, 85));
        pokemonAliado.agregarHabilidad(new Habilidad("Carga", "Embestida", 50, 95));
        pokemonAliado.agregarHabilidad(new Habilidad("Golpe Final", "Máximo poder", 100, 60));

        pokemonRival = crearRivalAleatorio();
        pokemonRival.agregarHabilidad(new Habilidad("Ataque Básico", "Golpe normal", 40, 100));
        pokemonRival.agregarHabilidad(new Habilidad("Ataque Especial", "Golpe poderoso", 70, 85));
        pokemonRival.agregarHabilidad(new Habilidad("Carga", "Embestida", 50, 95));
        pokemonRival.agregarHabilidad(new Habilidad("Golpe Final", "Máximo poder", 100, 60));

        batalla = new Batalla(pokemonAliado, pokemonRival);
        actualizarUI();
    }

    
    private void conectarBotones() {
        LuchaBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lucharActionPerformed(evt);
            }
        });
        CambioBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cambiarPokemonActionPerformed(evt);
            }
        });
        HuirBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dispose();
            }
        });
    }

    // Ataca con la primera habilidad — @riztutov
    private void lucharActionPerformed(java.awt.event.ActionEvent evt) {
        if (batalla == null || batalla.isTerminada()) {
            CuadroDeMensajes.setText("La batalla ha terminado.");
            return;
        }
        if (!pokemonAliado.estaVivo()) {
            CuadroDeMensajes.setText(pokemonAliado.getNombre() + " no puede luchar.");
            return;
        }

        String resultado = batalla.ejecutarAtaque(pokemonAliado, pokemonRival, 0);

        if (!batalla.isTerminada() && pokemonRival.estaVivo()) {
            String turnoRival = batalla.turnoRival();
            CuadroDeMensajes.setText(resultado + " | " + turnoRival);
        } else {
            CuadroDeMensajes.setText(resultado);
        }

        actualizarUI();

        if (batalla.isTerminada()) {
            String ganador = pokemonAliado.estaVivo() ? pokemonAliado.getNombre() : pokemonRival.getNombre();
            CuadroDeMensajes.setText("¡" + ganador + " gana la batalla!");
        }
    }

    // Cambia al siguiente Pokémon del equipo — @isai
    private void cambiarPokemonActionPerformed(java.awt.event.ActionEvent evt) {
        String[] equipo = {p1, p2, p3};
        pokemonActualIndex = (pokemonActualIndex + 1) % 3;
        String nuevoNombre = equipo[pokemonActualIndex];

        Pokemon nuevoPokemon = crearPokemon(nuevoNombre);
        nuevoPokemon.agregarHabilidad(new Habilidad("Ataque Básico", "Golpe normal", 40, 100));
        nuevoPokemon.agregarHabilidad(new Habilidad("Ataque Especial", "Golpe poderoso", 70, 85));
        nuevoPokemon.agregarHabilidad(new Habilidad("Carga", "Embestida", 50, 95));
        nuevoPokemon.agregarHabilidad(new Habilidad("Golpe Final", "Máximo poder", 100, 60));

        pokemonAliado = nuevoPokemon;
        batalla = new Batalla(pokemonAliado, pokemonRival);
        CuadroDeMensajes.setText("¡Cambiaste a " + nuevoNombre + "!");
        actualizarUI();
    }

    // Crea un Pokémon según su nombre — @riztutov
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

    // Genera un rival aleatorio — @isai
    private Pokemon crearRivalAleatorio() {
        Random rnd = new Random();
        String[] nombres = {"Charizard", "Blaziken", "Piplup", "Snorlax", "Raikou", "Gardevoir", "Cacturne"};
        String rival = nombres[rnd.nextInt(nombres.length)];
        return crearPokemon(rival);
    }

    // Cambia la imagen de un JLabel según el Pokémon — @riztutov
    private void setImagenPokemon(javax.swing.JLabel label, String nombre, boolean back) {
        String ruta = "/proyectopokemon/Imagenes/" + nombre.toLowerCase() + (back ? "Back" : "") + ".png";
        label.setIcon(new javax.swing.ImageIcon(getClass().getResource(ruta)));
    }

    // Actualiza toda la interfaz con los datos actuales — @isai
    private void actualizarUI() {
        NombrePokemonElegido.setText(pokemonAliado.getNombre());
        BarraVidaPokemonAliado.setMaximum(pokemonAliado.getHpMax());
        BarraVidaPokemonAliado.setValue(Math.max(0, pokemonAliado.getHp()));
        BarraVidaPokemonAliado.setStringPainted(true);
        BarraVidaPokemonAliado.setString(pokemonAliado.getHp() + "/" + pokemonAliado.getHpMax());
        setImagenPokemon(jLabel2, pokemonAliado.getNombre(), false);

        NombrePokemonRivalç.setText(pokemonRival.getNombre());
        BarraVidaPokemonRival.setMaximum(pokemonRival.getHpMax());
        BarraVidaPokemonRival.setValue(Math.max(0, pokemonRival.getHp()));
        BarraVidaPokemonRival.setStringPainted(true);
        BarraVidaPokemonRival.setString(pokemonRival.getHp() + "/" + pokemonRival.getHpMax());
        setImagenPokemon(jLabel1, pokemonRival.getNombre(), true);

        CuadroDeMensajes.setText("¡Comienza la batalla! " + pokemonAliado.getNombre() + " vs " + pokemonRival.getNombre());
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
        MochilaBotonç = new javax.swing.JButton();
        CambioBoton = new javax.swing.JButton();
        HuirBoton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        BarraVidaPokemonRival = new javax.swing.JProgressBar();
        BarraVidaPokemonAliado = new javax.swing.JProgressBar();
        NombrePokemonRivalç = new javax.swing.JTextField();
        NombrePokemonElegido = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        LuchaBoton.setText("LUCHAR");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectopokemon/Imagenes/blazikenBack.png"))); // NOI18N

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectopokemon/Imagenes/blaziken.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(CuadroDeMensajes, javax.swing.GroupLayout.PREFERRED_SIZE, 524, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(NombrePokemonElegido, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BarraVidaPokemonAliado, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(103, 103, 103)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(LuchaBoton)
                            .addComponent(CambioBoton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(MochilaBotonç)
                            .addComponent(HuirBoton))
                        .addGap(48, 48, 48))))
            .addGroup(layout.createSequentialGroup()
                .addGap(199, 199, 199)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(NombrePokemonRivalç, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BarraVidaPokemonRival, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(69, 69, 69))
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
                .addComponent(NombrePokemonRivalç, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BarraVidaPokemonRival, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LuchaBoton)
                    .addComponent(MochilaBotonç))
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CambioBoton)
                    .addComponent(HuirBoton))
                .addGap(56, 56, 56))
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
    private javax.swing.JButton MochilaBotonç;
    private javax.swing.JTextField NombrePokemonElegido;
    private javax.swing.JTextField NombrePokemonRivalç;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
