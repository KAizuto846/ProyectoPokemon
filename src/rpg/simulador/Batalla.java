package rpg.simulador;

import java.util.Random;

/**
 * Lógica de batalla — contiene métodos estáticos y métodos con argumentos que retornan valor.
 */
public class Batalla {

    private static final Random RNG = new Random();
    public static final int MAX_TURNOS = 20; // static final (Requisito #7)

    private Pokemon pokemonJugador;
    private Pokemon pokemonRival;
    private int turno;
    private boolean terminada;

    // -- Constructor --
    public Batalla(Pokemon jugador, Pokemon rival) {
        this.pokemonJugador = jugador;
        this.pokemonRival = rival;
        this.turno = 0;
        this.terminada = false;
    }

    // -- Getters --
    public Pokemon getPokemonJugador() { return pokemonJugador; }
    public Pokemon getPokemonRival() { return pokemonRival; }
    public int getTurno() { return turno; }
    public boolean isTerminada() { return terminada; }

    /**
     * Método con argumentos que retorna valor — REQUISITO #5
     * Calcula el daño infligido basado en ataque, defensa, poder y un factor aleatorio.
     *
     * @param ataque   valor de ataque del atacante
     * @param defensa  valor de defensa del defensor
     * @param poder    poder de la habilidad usada
     * @return         daño final calculado (mínimo 1)
     */
    public static int calcularDanio(int ataque, int defensa, int poder) {
        double base = (ataque * 2.0 / defensa) * (poder / 10.0);
        double variacion = 0.85 + (RNG.nextDouble() * 0.3); // 85% - 115%
        int danio = (int) Math.round(base * variacion);
        return Math.max(1, danio);
    }

    /**
     * Método estático — REQUISITO #4
     * Determina si un ataque acierta según la precisión.
     */
    public static boolean acierta(int precision) {
        return RNG.nextInt(100) < precision;
    }

    /**
     * Método con argumentos que retorna valor — REQUISITO #5
     * Calcula un multiplicador de tipo (fortalezas/debilidades).
     * 
     * @param atacante tipo del atacante
     * @param defensor tipo del defensor
     * @return         multiplicador (2.0 = súper efectivo, 0.5 = no muy efectivo, 1.0 = normal)
     */
    public static double calcularVentajaTipo(TipoPokemon atacante, TipoPokemon defensor) {
        // Lógica simple de tipos
        switch (atacante) {
            case FUEGO:
                return (defensor == TipoPokemon.PLANTA) ? 2.0
                     : (defensor == TipoPokemon.AGUA) ? 0.5
                     : 1.0;
            case AGUA:
                return (defensor == TipoPokemon.FUEGO) ? 2.0
                     : (defensor == TipoPokemon.PLANTA || defensor == TipoPokemon.ELECTRICO) ? 0.5
                     : 1.0;
            case PLANTA:
                return (defensor == TipoPokemon.AGUA || defensor == TipoPokemon.TIERRA) ? 2.0
                     : (defensor == TipoPokemon.FUEGO) ? 0.5
                     : 1.0;
            case ELECTRICO:
                return (defensor == TipoPokemon.AGUA) ? 2.0
                     : (defensor == TipoPokemon.TIERRA || defensor == TipoPokemon.PLANTA) ? 0.5
                     : 1.0;
            case TIERRA:
                return (defensor == TipoPokemon.ELECTRICO || defensor == TipoPokemon.FUEGO) ? 2.0
                     : (defensor == TipoPokemon.AGUA || defensor == TipoPokemon.PLANTA) ? 0.5
                     : 1.0;
            default:
                return 1.0;
        }
    }

    /**
     * Ejecuta un turno de ataque del atacante hacia el defensor.
     * 
     * @param atacante el Pokémon que ataca
     * @param defensor el Pokémon que recibe el ataque
     * @param habilidadIndex índice de la habilidad a usar
     * @return mensaje describiendo lo ocurrido
     */
    public String ejecutarAtaque(Pokemon atacante, Pokemon defensor, int habilidadIndex) {
        if (habilidadIndex < 0 || habilidadIndex >= atacante.getHabilidades().size()) {
            return "❌ Habilidad inválida.";
        }

        Habilidad habilidad = atacante.getHabilidades().get(habilidadIndex);

        if (!acierta(habilidad.getPrecision())) {
            return "💨 ¡" + atacante.getNombre() + " falló el ataque!";
        }

        double ventaja = calcularVentajaTipo(atacante.getTipo(), defensor.getTipo());
        int danioBase = calcularDanio(atacante.getAtaque(), defensor.getDefensa(), habilidad.getPoder());
        int danioFinal = (int) Math.round(danioBase * ventaja);

        defensor.setHp(defensor.getHp() - danioFinal);

        String efectividad = (ventaja > 1.5) ? "💥 ¡Es súper efectivo!" 
                           : (ventaja < 0.8) ? "🔽 No es muy efectivo..."
                           : "✅ Golpe normal.";

        return String.format("%s usó %s → %d de daño. %s",
                atacante.getNombre(), habilidad.getNombre(), danioFinal, efectividad);
    }

    /**
     * Avanza un turno de la batalla (rival ataca automáticamente).
     */
    public String turnoRival() {
        turno++;
        if (turno >= MAX_TURNOS) {
            terminada = true;
            return "⏰ ¡La batalla terminó por límite de turnos!";
        }

        if (!pokemonRival.estaVivo() || !pokemonJugador.estaVivo()) {
            terminada = true;
            String ganador = pokemonJugador.estaVivo() ? pokemonJugador.getNombre() : pokemonRival.getNombre();
            return "🏆 ¡" + ganador + " gana la batalla!";
        }

        // El rival elige una habilidad al azar
        int idx = RNG.nextInt(pokemonRival.getHabilidades().size());
        return ejecutarAtaque(pokemonRival, pokemonJugador, idx);
    }

    public String estadoBatalla() {
        return "═══ Turno " + turno + " ═══\n"
             + "🟢 " + pokemonJugador + "\n"
             + "🔴 " + pokemonRival;
    }
}
