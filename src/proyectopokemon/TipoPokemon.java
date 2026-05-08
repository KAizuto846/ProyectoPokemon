package proyectopokemon;

/**
 * Enum con 3 o más campos — REQUISITO #1
 * Representa los tipos de Pokémon/Personajes en el juego.
 */
public enum TipoPokemon {
    FUEGO("Fuego", "Ataca con llamas ardientes", "fuego.png", 120, 50),
    AGUA("Agua", "Domina torrentes y oleajes", "agua.png", 110, 45),
    PLANTA("Planta", "Controla la naturaleza", "planta.png", 130, 40),
    ELECTRICO("Eléctrico", "Golpea con rayos fulminantes", "electrico.png", 100, 55),
    TIERRA("Tierra", "Inquebrantable como la roca", "tierra.png", 140, 35),
    NORMAL("Normal", "Ataques básicos y equilibrados", "normal.png", 100, 40),
    VOLADOR("Volador", "Domina los cielos", "volador.png", 100, 45),
    PSIQUICO("Psíquico", "Poderes mentales", "psiquico.png", 90, 55),
    SINIESTRO("Siniestro", "Ataques oscuros", "siniestro.png", 110, 50);

    // -- Campos del enum (requisito: 3 o más) --
    private final String nombre;
    private final String descripcion;
    private final String iconoRuta;
    private final int hpBase;
    private final int ataqueBase;

    // Constructor del enum
    private TipoPokemon(String nombre, String descripcion, String iconoRuta,
                        int hpBase, int ataqueBase) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.iconoRuta = iconoRuta;
        this.hpBase = hpBase;
        this.ataqueBase = ataqueBase;
    }

    // -- Getters --
    public String getNombre() { return nombre; }
    public String getDescripcion() { return descripcion; }
    public String getIconoRuta() { return iconoRuta; }
    public int getHpBase() { return hpBase; }
    public int getAtaqueBase() { return ataqueBase; }

    /**
     * Método estático — REQUISITO #4
     * Devuelve un tipo aleatorio.
     */
    public static TipoPokemon aleatorio() {
        TipoPokemon[] tipos = values();
        return tipos[(int) (Math.random() * tipos.length)];
    }

    @Override
    public String toString() {
        return nombre + " (" + descripcion + ")";
    }
}
