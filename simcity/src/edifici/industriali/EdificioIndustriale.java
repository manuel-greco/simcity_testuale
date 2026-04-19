package edifici.industriali;

import edifici.Edificio;

public abstract class EdificioIndustriale extends Edificio {
    protected int inquinamento;
    protected int consumoEnergia;

    public EdificioIndustriale(String nome, int costo, int inquinamento, int consumoEnergia) {
        super(nome, costo);
        this.inquinamento = inquinamento;
        this.consumoEnergia = consumoEnergia;
    }

    public int getInquinamento() {
        return inquinamento;
    }

    public int getConsumoEnergia() {
        return consumoEnergia;
    }

    @Override
    public String toString() {
        return nome + " | Costo: " + costo + " | Inquinamento: " + inquinamento + " | Energia: " + consumoEnergia;
    }
}