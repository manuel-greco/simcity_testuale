# 🏙️ SimCity Testuale – Progetto OOP (Java)

Un gestionale/simulatore ispirato a **SimCity**, interamente realizzato in Java e progettato per dimostrare in modo chiaro e completo i principi fondamentali della **Programmazione Orientata agli Oggetti (OOP)**.

Il giocatore può costruire edifici, gestire risorse, far evolvere la città e affrontare eventi casuali che influenzano la partita.

---

## 📌 Caratteristiche principali

### 🧱 Edifici con ereditarietà
Gli edifici derivano tutti da una classe astratta:

- `Edificio` (astratta)
  - `Casa` 🏠
  - `Fabbrica` 🏭
  - `Centrale` ⚡

Ogni edificio implementa il metodo `effetto(Citta)` con comportamenti diversi → **polimorfismo reale**.

---

## 🧠 Interfacce

- **Produttore** → implementata da edifici che producono energia/soldi  
- **Consumatore** → implementata da edifici che consumano risorse  

Aumentano modularità e voto finale.

---

## 🎲 Eventi casuali

Il sistema simula ogni giorno la possibilità che accada un evento:

- `Incendio` 🔥 → distruzione edifici / perdita popolazione
- `BoomEconomico` 💰 → aumento soldi
- `Blackout` ⚡ → perdita energia

Tutti ereditano da:

- `Evento` (classe astratta con probabilità + metodo `applica()`)

---

## 🏛️ Struttura package

    src/
    ├── model/
    │   ├── Citta.java
    │   ├── Edificio.java
    │   ├── Casa.java
    │   ├── Fabbrica.java
    │   ├── Centrale.java
    │   ├── Evento.java
    │   ├── Incendio.java
    │   ├── BoomEconomico.java
    │   ├── Blackout.java
    │   ├── Produttore.java
    │   ├── Consumatore.java
    │   └── TipoEdificio.java
    │
    ├── service/
    │   └── Simulatore.java
    │
    └── main/
        └── Main.java

---

## 🎮 Menu di gioco

===== SIM CITY =====

    Costruisci edificio
    Visualizza città
    Simula giorno
    Statistiche
    Demolisci edificio
    Esci

---

## ⚙️ Logica di simulazione

Ogni giorno:

1. Ogni edificio applica il suo effetto
2. I consumi vengono detratti
3. Gli eventi vengono verificati
4. La città aggiorna felicità, inquinamento e risorse 
5. Il giorno avanza
