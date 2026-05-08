package proyectopokemon;

/**
 * Enum con 3 o más campos — REQUISITO #1
 * Representa los tipos de Pokémon/Personajes en el juego.
 */
public enum TipoPokemon {
    FUEGO("Fuego", "fuego.png", 120,50,65),
    AGUA("Agua", "agua.png", 110, 45,45),
    PLANTA("Planta","planta.png", 130, 70,55),
    ELECTRICO("Eléctrico", "electrico.png", 100, 55,90),
    SINIESTRO("Siniestro", "siniestro.png", 120,87,67 ),
    TLUCHA("Lucha", "siniestro.png", 140, 35,78),
    VOLADOR("Siniestro", "siniestro.png", 120, 55,68),
    PSQUICO("Siniestro", "siniestro.png", 150, 25,80),
    NORMAL("Siniestro", "siniestro.png", 100, 100,40);


    // -- Campos del enum (requisito: 3 o más) --
    private final String nombre;
    private final String iconoRuta;
    private final int hpBase;
    private final int ataqueBase;
    private final int velocidadBase;

    // Constructor del enum

    private TipoPokemon(String nombre, String iconoRuta, int hpBase, int ataqueBase, int velocidadBase) {
        this.nombre = nombre;
        this.iconoRuta = iconoRuta;
        this.hpBase = hpBase;
        this.ataqueBase = ataqueBase;
        this.velocidadBase = velocidadBase;
    }

    public String getNombre() {
        return nombre;
    }
    public String getIconoRuta() {
        return iconoRuta;
    }

    public int getHpBase() {
        return hpBase;
    }

    public int getAtaqueBase() {
        return ataqueBase;
    }

    // -- Getters --
    public int getVelocidadBase() {   
        return velocidadBase;
    }

    /**
     * Método estático — REQUISITO #4
     * Devuelve un tipo aleatorio.
     */
    public static TipoPokemon aleatorio() {
        TipoPokemon[] tipos = values();
        return tipos[(int) (Math.random() * tipos.length)];
    }

   
    }

