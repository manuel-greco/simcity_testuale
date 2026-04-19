package edifici.residenziali;

import edifici.Edificio;

public abstract class EdificioResidenziale extends Edificio {
    protected int abitanti;

    public EdificioResidenziale(String nome, int costo, int abitanti) {
        super(nome, costo);
        this.abitanti = abitanti;
    }

    public int getAbitanti() {
        return abitanti;
    }

    @Override
    public String toString() {
        return nome + "| Costo: " + costo + "| Abitanti: " + abitanti;
    }
}