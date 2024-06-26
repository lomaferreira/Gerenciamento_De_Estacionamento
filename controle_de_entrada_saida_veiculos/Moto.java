package controle_de_entrada_saida_veiculos;

public class Moto extends Veiculo {
    private int cilindradas;

    public Moto(int horarioEntrada,String idVaga, int cilindradas) {
        super(horarioEntrada,idVaga);
        this.cilindradas = cilindradas;
    }

    public int getCilindradas() {
        return cilindradas;
    }
}
