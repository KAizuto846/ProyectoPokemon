# 📋 LISTA DE TAREAS — Proyecto Integrador: Simulador Pokémon

> **Equipo:** Rivera Corona Víctor Eduardo & Rodríguez Vilaseca Isai — 4IM6
> **Materia:** Programación Modular
> **IDE:** Apache NetBeans

---

## 🐛 FASE 1: CORREGIR ERRORES DE PAQUETE

- [ ] **#1 — Cambiar package de `rpg.simulador` a `proyectopokemon`**
  - Archivos: `Pokemon.java`, `Habilidad.java`, `TipoPokemon.java`, `JuegoGUI.java`, `Main.java`
  - Están en `package rpg.simulador;` pero deben estar en `package proyectopokemon;`

- [ ] **#2 — Corregir imports en `JuegoGUI.java`**
  - Actualizar imports después del cambio de paquete

---

## 🖼️ FASE 2: CONECTAR LAS PANTALLAS (FLUJO DE NAVEGACIÓN)

```
inicio → SeleccionEntrenador → SeleccionPokemon → SeleccionOrdenPokemon → BatallaUI
```

- [ ] **#3 — Botón COMENZAR** (`inicio.java`)
  - Al presionar `BotonComenzar` → abrir `SeleccionEntrenador` y cerrar `inicio`

- [ ] **#4 — Seleccionar personaje** (`SeleccionEntrenador.java`)
  - Los checkboxes deben seleccionar entre personaje masculino/femenino (solo uno a la vez)
  - Leer el campo `NombreUsuario`

- [ ] **#5 — Botón GUARDAR** (`SeleccionEntrenador.java`)
  - Validar que haya nombre y personaje seleccionado
  - Abrir `SeleccionPokemon`

- [ ] **#6 — Seleccionar 3 Pokémon** (`SeleccionPokemon.java`)
  - Mostrar los Pokémon disponibles
  - Permitir elegir 3 (con checkboxes, lista, etc.)
  - Confirmar y abrir `SeleccionOrdenPokemon`

- [ ] **#7 — Ordenar Pokémon** (`SeleccionOrdenPokemon.java`)
  - Mostrar los 3 Pokémon elegidos
  - Permitir reordenarlos (botones subir/bajar)

- [ ] **#8 — Iniciar batalla** (`SeleccionOrdenPokemon.java`)
  - Botón "Listo": crear una `Batalla` con el primer Pokémon del jugador y un rival aleatorio
  - Abrir `BatallaUI`

---

## ⚔️ FASE 3: LÓGICA DE BATALLA

- [ ] **#9 — Botón LUCHA** (`BatallaUI.java`)
  - Al presionar `LuchaBoton` → abrir la ventana `Lucha` con las habilidades del Pokémon

- [ ] **#10 — Botones de ataque** (`Lucha.java`)
  - Conectar `jButton1` (Ataque Simple), `jButton2` (Defender), `jButton3` (Super Ataque), `jButton4` (Pasar Turno)
  - Usar `Batalla.ejecutarAtaque()` para la lógica

- [ ] **#11 — Cuadro de mensajes** (`BatallaUI.java`)
  - `CuadroDeMensajes` debe mostrar lo que ocurre en la batalla (daño, efectividad, ganador)

- [ ] **#12 — Barras de vida** (`BatallaUI.java`)
  - `BarraVidaPokemonAliado` y `BarraVidaPokemonRival` deben actualizarse según el HP

- [ ] **#13 — Nombres en batalla** (`BatallaUI.java`)
  - `NombrePokemonElegido` y `NombrePokemonRival` deben mostrar los nombres correctos

- [ ] **#14 — Botón CAMBIO** (`BatallaUI.java`)
  - `CambioBoton` debe permitir cambiar al siguiente Pokémon del equipo

- [ ] **#15 — Botón HUIR** (`BatallaUI.java`)
  - `HuirBoton` debe terminar la batalla y volver al inicio

- [ ] **#16 — Botón MOCHILA** (`BatallaUI.java`)
  - (Opcional) Curar algo de HP o mostrar items

---

## 🎨 FASE 4: DETALLES Y PULIDO

- [ ] **#17 — Corregir typos** (`BatallaUI.java`)
  - `MochilaBotonç` → `MochilaBoton`
  - `NombrePokemonRivalç` → `NombrePokemonRival`

- [ ] **#18 — Sprites dinámicos** (`BatallaUI.java`)
  - Las imágenes (`jLabel1`, `jLabel2`) están hardcodeadas a blaziken
  - Deben mostrar el sprite del Pokémon elegido y del rival

- [ ] **#19 — Unificar BatallaUI y Lucha**
  - Son dos JFrame de batalla. Decidir cuál usar y fusionarlas

- [ ] **#20 — Usar GIFs corregidos**
  - Los GIFs fijos están en `Imagenes/gifs_fixed/`
  - Usar `*_fixed.gif` en lugar de los originales para evitar pantallazos

- [ ] **#21 — Punto de entrada** (`ProyectoPokemon.java`)
  - Debe lanzar `inicio` (actualmente está vacío)

---

## 🌐 FASE 5: EXTRAS (para subir de nivel)

- [ ] **#22 — Sonidos**: Efectos de sonido (ataque, victoria, derrota)
- [ ] **#23 — Más tipos**: Agregar más tipos al enum (Hielo, Volador, Psíquico...)
- [ ] **#24 — Más Pokémon**: Agregar más Pokémon con sprites y habilidades
- [ ] **#25 — Animaciones**: Sprites que se muevan o parpadeen al atacar

---

## 📌 NOTAS

- **No modifiques** el código generado automáticamente por NetBeans (entre `//GEN-BEGIN:initComponents` y `//GEN-END:initComponents`). Los ActionListeners sí se modifican.
- Trabajar en **ramas separadas** o turnarse para evitar conflictos.
- Siempre hacer `git pull` antes de empezar y `git push` al terminar.
