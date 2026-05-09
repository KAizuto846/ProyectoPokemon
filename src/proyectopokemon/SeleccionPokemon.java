package proyectopokemon;

public class SeleccionPokemon extends javax.swing.JFrame {

    private String nombreEntrenador; 

    public SeleccionPokemon() {
        initComponents();
    }

    public SeleccionPokemon(String nombre) {
        initComponents();
        this.nombreEntrenador = nombre;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jCheckBoxMenuItem2 = new javax.swing.JCheckBoxMenuItem();
        jLabel1 = new javax.swing.JLabel();
        BotonFinalizar = new javax.swing.JButton();
        Umbreon = new javax.swing.JCheckBox();
        SkarmoryIMG = new javax.swing.JLabel();
        Skarmory = new javax.swing.JCheckBox();
        RaikouIMG = new javax.swing.JLabel();
        Raikou = new javax.swing.JCheckBox();
        GardevoirIMG = new javax.swing.JLabel();
        Gardevoir = new javax.swing.JCheckBox();
        CacturneIMG = new javax.swing.JLabel();
        Cacturne = new javax.swing.JCheckBox();
        UmbreonIMG = new javax.swing.JLabel();
        Charizard = new javax.swing.JCheckBox();
        BlazikenIMG = new javax.swing.JLabel();
        Blaziken = new javax.swing.JCheckBox();
        PiplupIMG = new javax.swing.JLabel();
        Piplup = new javax.swing.JCheckBox();
        SnorlaxIMG = new javax.swing.JLabel();
        Snorlax = new javax.swing.JCheckBox();
        VaporeonIMG = new javax.swing.JLabel();
        Vaporeon = new javax.swing.JCheckBox();
        CharizardIMG = new javax.swing.JLabel();
        Mensaje = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");

        jMenuItem1.setText("jMenuItem1");

        jMenu1.setText("jMenu1");

        jMenuItem2.setText("jMenuItem2");

        jCheckBoxMenuItem2.setSelected(true);
        jCheckBoxMenuItem2.setText("jCheckBoxMenuItem2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("ELIGE 3 POKEMONES");

        BotonFinalizar.setText("FINALIZAR");
        BotonFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonFinalizarActionPerformed(evt);
            }
        });

        Umbreon.setText("UMBREON");
        Umbreon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UmbreonActionPerformed(evt);
            }
        });

        SkarmoryIMG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectopokemon/Imagenes/skarmory.png"))); // NOI18N

        Skarmory.setText("SKARMORY");
        Skarmory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SkarmoryActionPerformed(evt);
            }
        });

        RaikouIMG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectopokemon/Imagenes/raikou.png"))); // NOI18N

        Raikou.setText("RAIKOU");
        Raikou.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RaikouActionPerformed(evt);
            }
        });

        GardevoirIMG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectopokemon/Imagenes/gardevoir.png"))); // NOI18N

        Gardevoir.setText("GARDEVOIR");
        Gardevoir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GardevoirActionPerformed(evt);
            }
        });

        CacturneIMG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectopokemon/Imagenes/cacturne.png"))); // NOI18N

        Cacturne.setText("CACTURNE");
        Cacturne.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CacturneActionPerformed(evt);
            }
        });

        UmbreonIMG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectopokemon/Imagenes/umbreon.png"))); // NOI18N

        Charizard.setText("CHARIZARD");
        Charizard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CharizardActionPerformed(evt);
            }
        });

        BlazikenIMG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectopokemon/Imagenes/blaziken.png"))); // NOI18N

        Blaziken.setText("BLAZIKEN");
        Blaziken.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BlazikenActionPerformed(evt);
            }
        });

        PiplupIMG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectopokemon/Imagenes/piplup.png"))); // NOI18N

        Piplup.setText("PIPLUP");
        Piplup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PiplupActionPerformed(evt);
            }
        });

        SnorlaxIMG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectopokemon/Imagenes/snorlax.png"))); // NOI18N

        Snorlax.setText("SNORLAX");
        Snorlax.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SnorlaxActionPerformed(evt);
            }
        });

        VaporeonIMG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectopokemon/Imagenes/vaporeon.png"))); // NOI18N

        Vaporeon.setText("VAPOREON");
        Vaporeon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VaporeonActionPerformed(evt);
            }
        });

        CharizardIMG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectopokemon/Imagenes/charizard.png"))); // NOI18N

        jMenu2.setText("ELIGE TU POKEMON");

        jMenuItem3.setText("Seleccion Pokemon");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("ELIGE TU PERSONAJE");

        jMenuItem4.setText("Seleccion Entrenador");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem4);

        jMenuBar1.add(jMenu3);

        jMenu5.setText("ELIGE EL ORDEN DE TUS POKEMON");

        jMenuItem5.setText("Seleccion del Orden de tus Pokemones");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem5);

        jMenuBar1.add(jMenu5);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(CharizardIMG)
                                            .addComponent(Charizard))
                                        .addGap(74, 74, 74)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(BlazikenIMG)
                                            .addComponent(Blaziken)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(Umbreon)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(23, 23, 23)
                                                .addComponent(UmbreonIMG)))
                                        .addGap(89, 89, 89)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(Skarmory)
                                            .addComponent(SkarmoryIMG))))
                                .addGap(12, 12, 12)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(63, 63, 63)
                                        .addComponent(Piplup))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(74, 74, 74)
                                        .addComponent(PiplupIMG))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(63, 63, 63)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(RaikouIMG)
                                            .addComponent(Raikou)))))
                            .addComponent(Mensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(57, 57, 57)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(Gardevoir)
                                            .addComponent(GardevoirIMG)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 0, 0)
                                        .addComponent(SnorlaxIMG, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(40, 40, 40)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(17, 17, 17)
                                        .addComponent(VaporeonIMG))
                                    .addComponent(Vaporeon)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(CacturneIMG)
                                        .addComponent(Cacturne)
                                        .addComponent(BotonFinalizar))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(Snorlax))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(329, 329, 329)
                        .addComponent(jLabel1)))
                .addContainerGap(88, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel1)
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(CharizardIMG)
                        .addComponent(PiplupIMG, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(SnorlaxIMG, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(VaporeonIMG, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addComponent(BlazikenIMG))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Charizard)
                    .addComponent(Blaziken)
                    .addComponent(Piplup)
                    .addComponent(Snorlax)
                    .addComponent(Vaporeon))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(UmbreonIMG)
                        .addGap(10, 10, 10))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(RaikouIMG)
                                .addComponent(SkarmoryIMG))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(CacturneIMG)
                                    .addComponent(GardevoirIMG))
                                .addGap(2, 2, 2)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Gardevoir)
                    .addComponent(Raikou)
                    .addComponent(Cacturne)
                    .addComponent(Skarmory)
                    .addComponent(Umbreon))
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BotonFinalizar)
                    .addComponent(Mensaje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(71, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void PiplupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PiplupActionPerformed
        if (Piplup.isSelected()) {
            int count = 0;
            if (Charizard.isSelected()) {
                count = count + 1;
            }
            if (Blaziken.isSelected()) {
                count = count + 1;
            }
            if (Piplup.isSelected()) {
                count = count + 1;
            }
            if (Snorlax.isSelected()) {
                count = count + 1;
            }
            if (Vaporeon.isSelected()) {
                count = count + 1;
            }
            if (Umbreon.isSelected()) {
                count = count + 1;
            }
            if (Skarmory.isSelected()) {
                count = count + 1;
            }
            if (Raikou.isSelected()) {
                count = count + 1;
            }
            if (Gardevoir.isSelected()) {
                count = count + 1;
            }
            if (Cacturne.isSelected()) {
                count = count + 1;
            }

            if (count > 3) {
                Piplup.setSelected(false);
                Mensaje.setText("Solo puedes seleccionar 3 pokemones");
            }
        }
    }//GEN-LAST:event_PiplupActionPerformed

    private void SkarmoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SkarmoryActionPerformed
        if (Skarmory.isSelected()) {
            int count = 0;
            if (Charizard.isSelected()) {
                count = count + 1;
            }
            if (Blaziken.isSelected()) {
                count = count + 1;
            }
            if (Piplup.isSelected()) {
                count = count + 1;
            }
            if (Snorlax.isSelected()) {
                count = count + 1;
            }
            if (Vaporeon.isSelected()) {
                count = count + 1;
            }
            if (Umbreon.isSelected()) {
                count = count + 1;
            }
            if (Skarmory.isSelected()) {
                count = count + 1;
            }
            if (Raikou.isSelected()) {
                count = count + 1;
            }
            if (Gardevoir.isSelected()) {
                count = count + 1;
            }
            if (Cacturne.isSelected()) {
                count = count + 1;
            }

            if (count > 3) {
                Skarmory.setSelected(false);
                Mensaje.setText("Solo puedes seleccionar 3 pokemones");
            }
        }
    }//GEN-LAST:event_SkarmoryActionPerformed

    private void RaikouActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RaikouActionPerformed
        if (Raikou.isSelected()) {
            int count = 0;
            if (Charizard.isSelected()) {
                count = count + 1;
            }
            if (Blaziken.isSelected()) {
                count = count + 1;
            }
            if (Piplup.isSelected()) {
                count = count + 1;
            }
            if (Snorlax.isSelected()) {
                count = count + 1;
            }
            if (Vaporeon.isSelected()) {
                count = count + 1;
            }
            if (Umbreon.isSelected()) {
                count = count + 1;
            }
            if (Skarmory.isSelected()) {
                count = count + 1;
            }
            if (Raikou.isSelected()) {
                count = count + 1;
            }
            if (Gardevoir.isSelected()) {
                count = count + 1;
            }
            if (Cacturne.isSelected()) {
                count = count + 1;
            }

            if (count > 3) {
                Raikou.setSelected(false);
                Mensaje.setText("Solo puedes seleccionar 3 pokemones");
            }
        }
    }//GEN-LAST:event_RaikouActionPerformed

    private void BotonFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonFinalizarActionPerformed
        String poke1 = "", poke2 = "", poke3 = "";
        int i = 0;

        if (Charizard.isSelected()) {
            if (i == 0) {
                poke1 = "Charizard";
            } else if (i == 1) {
                poke2 = "Charizard";
            } else if (i == 2) {
                poke3 = "Charizard";
            }
            i=i+1;
        }
        if (Blaziken.isSelected()) {
            if (i == 0) {
                poke1 = "Blaziken";
            } else if (i == 1) {
                poke2 = "Blaziken";
            } else if (i == 2) {
                poke3 = "Blaziken";
            }
            i=i+1;
        }
        if (Piplup.isSelected()) {
            if (i == 0) {
                poke1 = "Piplup";
            } else if (i == 1) {
                poke2 = "Piplup";
            } else if (i == 2) {
                poke3 = "Piplup";
            }
            i=i+1;
        }
        if (Snorlax.isSelected()) {
            if (i == 0) {
                poke1 = "Snorlax";
            } else if (i == 1) {
                poke2 = "Snorlax";
            } else if (i == 2) {
                poke3 = "Snorlax";
            }
            i=i+1;
        }
        if (Vaporeon.isSelected()) {
            if (i == 0) {
                poke1 = "Vaporeon";
            } else if (i == 1) {
                poke2 = "Vaporeon";
            } else if (i == 2) {
                poke3 = "Vaporeon";
            }
            i=i+1;
        }
        if (Umbreon.isSelected()) {
            if (i == 0) {
                poke1 = "Umbreon";
            } else if (i == 1) {
                poke2 = "Umbreon";
            } else if (i == 2) {
                poke3 = "Umbreon";
            }
            i=i+1;
        }
        if (Skarmory.isSelected()) {
            if (i == 0) {
                poke1 = "Skarmory";
            } else if (i == 1) {
                poke2 = "Skarmory";
            } else if (i == 2) {
                poke3 = "Skarmory";
            }
            i=i+1;
        }
        if (Raikou.isSelected()) {
            if (i == 0) {
                poke1 = "Raikou";
            } else if (i == 1) {
                poke2 = "Raikou";
            } else if (i == 2) {
                poke3 = "Raikou";
            }
            i=i+1;
        }
        if (Gardevoir.isSelected()) {
            if (i == 0) {
                poke1 = "Gardevoir";
            } else if (i == 1) {
                poke2 = "Gardevoir";
            } else if (i == 2) {
                poke3 = "Gardevoir";
            }
            i=i+1;
        }
        if (Cacturne.isSelected()) {
            if (i == 0) {
                poke1 = "Cacturne";
            } else if (i == 1) {
                poke2 = "Cacturne";
            } else if (i == 2) {
                poke3 = "Cacturne";
            }
            i=i+1;
        }

        SeleccionOrdenPokemon ventana = new SeleccionOrdenPokemon(nombreEntrenador, poke1, poke2, poke3);
        ventana.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_BotonFinalizarActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        SeleccionPokemon mostrar = new SeleccionPokemon();
        mostrar.setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        SeleccionEntrenador mostrar = new SeleccionEntrenador();
        mostrar.setVisible(true);        
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        SeleccionOrdenPokemon mostrar = new SeleccionOrdenPokemon();
        mostrar.setVisible(true);        
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void CharizardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CharizardActionPerformed
        if (Charizard.isSelected()) {
            int count = 0;
            if (Charizard.isSelected()) {
                count = count + 1;
            }
            if (Blaziken.isSelected()) {
                count = count + 1;
            }
            if (Piplup.isSelected()) {
                count = count + 1;
            }
            if (Snorlax.isSelected()) {
                count = count + 1;
            }
            if (Vaporeon.isSelected()) {
                count = count + 1;
            }
            if (Umbreon.isSelected()) {
                count = count + 1;
            }
            if (Skarmory.isSelected()) {
                count = count + 1;
            }
            if (Raikou.isSelected()) {
                count = count + 1;
            }
            if (Gardevoir.isSelected()) {
                count = count + 1;
            }
            if (Cacturne.isSelected()) {
                count = count + 1;
            }

            if (count > 3) {
                Charizard.setSelected(false);
                Mensaje.setText("Solo puedes seleccionar 3 pokemones");
            }
        }
    }//GEN-LAST:event_CharizardActionPerformed

    private void BlazikenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BlazikenActionPerformed
        if (Blaziken.isSelected()) {
            int count = 0;
            if (Charizard.isSelected()) {
                count = count + 1;
            }
            if (Blaziken.isSelected()) {
                count = count + 1;
            }
            if (Piplup.isSelected()) {
                count = count + 1;
            }
            if (Snorlax.isSelected()) {
                count = count + 1;
            }
            if (Vaporeon.isSelected()) {
                count = count + 1;
            }
            if (Umbreon.isSelected()) {
                count = count + 1;
            }
            if (Skarmory.isSelected()) {
                count = count + 1;
            }
            if (Raikou.isSelected()) {
                count = count + 1;
            }
            if (Gardevoir.isSelected()) {
                count = count + 1;
            }
            if (Cacturne.isSelected()) {
                count = count + 1;
            }

            if (count > 3) {
                Blaziken.setSelected(false);
                Mensaje.setText("Solo puedes seleccionar 3 pokemones");
            }
        }
    }//GEN-LAST:event_BlazikenActionPerformed

    private void SnorlaxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SnorlaxActionPerformed
        if (Snorlax.isSelected()) {
            int count = 0;
            if (Charizard.isSelected()) {
                count = count + 1;
            }
            if (Blaziken.isSelected()) {
                count = count + 1;
            }
            if (Piplup.isSelected()) {
                count = count + 1;
            }
            if (Snorlax.isSelected()) {
                count = count + 1;
            }
            if (Vaporeon.isSelected()) {
                count = count + 1;
            }
            if (Umbreon.isSelected()) {
                count = count + 1;
            }
            if (Skarmory.isSelected()) {
                count = count + 1;
            }
            if (Raikou.isSelected()) {
                count = count + 1;
            }
            if (Gardevoir.isSelected()) {
                count = count + 1;
            }
            if (Cacturne.isSelected()) {
                count = count + 1;
            }

            if (count > 3) {
                Snorlax.setSelected(false);
                Mensaje.setText("Solo puedes seleccionar 3 pokemones");
            }
        }
    }//GEN-LAST:event_SnorlaxActionPerformed

    private void VaporeonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VaporeonActionPerformed
        if (Vaporeon.isSelected()) {
            int count = 0;
            if (Charizard.isSelected()) {
                count = count + 1;
            }
            if (Blaziken.isSelected()) {
                count = count + 1;
            }
            if (Piplup.isSelected()) {
                count = count + 1;
            }
            if (Snorlax.isSelected()) {
                count = count + 1;
            }
            if (Vaporeon.isSelected()) {
                count = count + 1;
            }
            if (Umbreon.isSelected()) {
                count = count + 1;
            }
            if (Skarmory.isSelected()) {
                count = count + 1;
            }
            if (Raikou.isSelected()) {
                count = count + 1;
            }
            if (Gardevoir.isSelected()) {
                count = count + 1;
            }
            if (Cacturne.isSelected()) {
                count = count + 1;
            }

            if (count > 3) {
                Vaporeon.setSelected(false);
                Mensaje.setText("Solo puedes seleccionar 3 pokemones");
            }
        }
    }//GEN-LAST:event_VaporeonActionPerformed

    private void UmbreonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UmbreonActionPerformed
        if (Umbreon.isSelected()) {
            int count = 0;
            if (Charizard.isSelected()) {
                count = count + 1;
            }
            if (Blaziken.isSelected()) {
                count = count + 1;
            }
            if (Piplup.isSelected()) {
                count = count + 1;
            }
            if (Snorlax.isSelected()) {
                count = count + 1;
            }
            if (Vaporeon.isSelected()) {
                count = count + 1;
            }
            if (Umbreon.isSelected()) {
                count = count + 1;
            }
            if (Skarmory.isSelected()) {
                count = count + 1;
            }
            if (Raikou.isSelected()) {
                count = count + 1;
            }
            if (Gardevoir.isSelected()) {
                count = count + 1;
            }
            if (Cacturne.isSelected()) {
                count = count + 1;
            }

            if (count > 3) {
                Umbreon.setSelected(false);
                Mensaje.setText("Solo puedes seleccionar 3 pokemones");
            }
        }
    }//GEN-LAST:event_UmbreonActionPerformed

    private void GardevoirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GardevoirActionPerformed
        if (Gardevoir.isSelected()) {
            int count = 0;
            if (Charizard.isSelected()) {
                count = count + 1;
            }
            if (Blaziken.isSelected()) {
                count = count + 1;
            }
            if (Piplup.isSelected()) {
                count = count + 1;
            }
            if (Snorlax.isSelected()) {
                count = count + 1;
            }
            if (Vaporeon.isSelected()) {
                count = count + 1;
            }
            if (Umbreon.isSelected()) {
                count = count + 1;
            }
            if (Skarmory.isSelected()) {
                count = count + 1;
            }
            if (Raikou.isSelected()) {
                count = count + 1;
            }
            if (Gardevoir.isSelected()) {
                count = count + 1;
            }
            if (Cacturne.isSelected()) {
                count = count + 1;
            }

            if (count > 3) {
                Gardevoir.setSelected(false);
                Mensaje.setText("Solo puedes seleccionar 3 pokemones");
            }
        }
    }//GEN-LAST:event_GardevoirActionPerformed

    private void CacturneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CacturneActionPerformed
        if (Cacturne.isSelected()) {
            int count = 0;
            if (Charizard.isSelected()) {
                count = count + 1;
            }
            if (Blaziken.isSelected()) {
                count = count + 1;
            }
            if (Piplup.isSelected()) {
                count = count + 1;
            }
            if (Snorlax.isSelected()) {
                count = count + 1;
            }
            if (Vaporeon.isSelected()) {
                count = count + 1;
            }
            if (Umbreon.isSelected()) {
                count = count + 1;
            }
            if (Skarmory.isSelected()) {
                count = count + 1;
            }
            if (Raikou.isSelected()) {
                count = count + 1;
            }
            if (Gardevoir.isSelected()) {
                count = count + 1;
            }
            if (Cacturne.isSelected()) {
                count = count + 1;
            }

            if (count > 3) {
                Cacturne.setSelected(false);
                Mensaje.setText("Solo puedes seleccionar 3 pokemones");
            }
        }
    }//GEN-LAST:event_CacturneActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SeleccionPokemon().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox Blaziken;
    private javax.swing.JLabel BlazikenIMG;
    private javax.swing.JButton BotonFinalizar;
    private javax.swing.JCheckBox Cacturne;
    private javax.swing.JLabel CacturneIMG;
    private javax.swing.JCheckBox Charizard;
    private javax.swing.JLabel CharizardIMG;
    private javax.swing.JCheckBox Gardevoir;
    private javax.swing.JLabel GardevoirIMG;
    private javax.swing.JTextField Mensaje;
    private javax.swing.JCheckBox Piplup;
    private javax.swing.JLabel PiplupIMG;
    private javax.swing.JCheckBox Raikou;
    private javax.swing.JLabel RaikouIMG;
    private javax.swing.JCheckBox Skarmory;
    private javax.swing.JLabel SkarmoryIMG;
    private javax.swing.JCheckBox Snorlax;
    private javax.swing.JLabel SnorlaxIMG;
    private javax.swing.JCheckBox Umbreon;
    private javax.swing.JLabel UmbreonIMG;
    private javax.swing.JCheckBox Vaporeon;
    private javax.swing.JLabel VaporeonIMG;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    // End of variables declaration//GEN-END:variables
}
