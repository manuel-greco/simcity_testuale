package risorse;

/**
 * Enum che rappresenta i tipi di risorse disponibili nel gioco.
 * Utilizzato per gestire in modo type-safe le risorse della città.
 */
public enum TipoRisorsa {
    // Risorsa principale
    DENARO,

    // Servizi essenziali
    ENERGIA,
    ACQUA,

    // Popolazione
    POPOLAZIONE,

    // Materiali GREZZI (prodotti dalle fabbriche)
    LEGNO,
    METALLO,

    // Materiali LAVORATI (prodotti dai negozi)
    // Prodotti da Negozio materiali da costruzione
    CHIODI,
    ASSI,
    // Prodotti da Negozio di ferramenta
    MARTELLO,
    NASTRO
}