# 🏙️ SimCity BuildIt - Versione Java Terminale

Un simulatore di città ispirato a SimCity BuildIt, giocabile da terminale.

## 💡 L'Idea

Ricreare le meccaniche base di SimCity BuildIt in Java. Non è una copia esatta del gioco originale, ma una simulazione.

Il giocatore può costruire una città, gestire risorse, edifici e servizi, il tutto attraverso un'interfaccia testuale da terminale.

## 🎮 Cosa Puoi Fare

- Costruire edifici residenziali per aumentare la popolazione
- Creare fabbriche per produrre materiali
- Aprire negozi commerciali
- Gestire servizi essenziali come energia e acqua
- Amministrare risorse e materiali nei depositi
- Monitorare le statistiche della tua città

## 🏗️ Tipi di Edifici

**Residenziali** 🏠
- Zone Residenziali, Case Accoglienti

**Industriali** 🏭
- Fabbriche che producono materiali grezzi

**Commerciali** 🏪
- Negozi che vendono oggetti lavorati

**Servizi** ⚙️
- Centrali elettriche (carbone, eolica)
- Torri idriche

## 📦 Struttura del Progetto

    src/
    ├── Main.java
    │
    ├── Simulatore.java
    │
    ├── Citta.java
    │
    ├── edifici/
    │   ├── Edificio.java (abstract)
    │   ├── commerciali/
    │   │   ├── EdificioCommerciale.java (abstract)
    │   │   ├── NegozioMaterialiDaCostruzione.java
    │   │   └── NegozioDiFerramenta.java
    │   ├── industriali/
    │   │   ├── EdificioIndustriale.java (abstract)
    │   │   ├── FabbricaPiccola.java
    │   │   └── FabbricaBase.java
    │   └── residenziali/
    │       ├── EdificioResidenziale.java (abstract)
    │       ├── ZonaResidenziale.java
    │       └── CaseAccoglienti.java
    │
    └── servizi/
        ├── Servizio.java (abstract)
        ├── energia/
        │   ├── CentraleCarbone.java
        │   └── CentraleEolica.java
        └── acqua/
            └── TorreIdricaBase.java