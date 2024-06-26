package controle_de_entrada_saida_veiculos;

public class Caminhao extends Veiculo {
    private int cargaMaxima;
    private int comprimento;

    public Caminhao(int horarioEntrada,String idVaga, int cargaMaxima, int comprimento) {
        super(horarioEntrada,idVaga);
        this.cargaMaxima = cargaMaxima;
        this.comprimento = comprimento;
    }

    public int getCargaMaxima() {
        return cargaMaxima;
    }

    public int getComprimento() {
        return comprimento;
    }
}
