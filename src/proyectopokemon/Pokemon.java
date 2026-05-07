package rpg.simulador;

import java.util.ArrayList;

/**
 * Clase principal del Pokémon — con constructores, getters, setters.
 */
public class Pokemon {

    // -- Atributos --
    private String nombre;
    private TipoPokemon tipo;
    private int nivel;
    private int hp;
    private int hpMax;
    private int ataque;
    private int defensa;
    private ArrayList<Habilidad> habilidades; // REQUISITO #2: ArrayList

    // -- Constructor con argumentos (Requisito #3) --
    public Pokemon(String nombre, TipoPokemon tipo, int nivel) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.nivel = nivel;
        this.hpMax = tipo.getHpBase() + (nivel * 5);
        this.hp = this.hpMax;
        this.ataque = tipo.getAtaqueBase() + (nivel * 3);
        this.defensa = 30 + (nivel * 2);
        this.habilidades = new ArrayList<>();
    }

    // -- Getters y Setters (Requisito #3) --
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public TipoPokemon getTipo() { return tipo; }
    public void setTipo(TipoPokemon tipo) { this.tipo = tipo; }

    public int getNivel() { return nivel; }
    public void setNivel(int nivel) { this.nivel = nivel; }

    public int getHp() { return hp; }
    public void setHp(int hp) {
        this.hp = Math.max(0, Math.min(hp, this.hpMax));
    }

    public int getHpMax() { return hpMax; }
    public int getAtaque() { return ataque; }
    public int getDefensa() { return defensa; }

    public ArrayList<Habilidad> getHabilidades() { return habilidades; }

    // -- Métodos de instancia --

    /** Agrega una habilidad al ArrayList */
    public void agregarHabilidad(Habilidad h) {
        if (habilidades.size() < 4) {
            habilidades.add(h);
        }
    }

    /** Muestra las habilidades disponibles */
    public String mostrarHabilidades() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < habilidades.size(); i++) {
            sb.append(i + 1).append(". ").append(habilidades.get(i)).append("\n");
        }
        return sb.toString();
    }

    public boolean estaVivo() {
        return hp > 0;
    }

    @Override
    public String toString() {
        return nombre + " [" + tipo.getNombre() + "] LV." + nivel
             + " HP: " + hp + "/" + hpMax;
    }
}
