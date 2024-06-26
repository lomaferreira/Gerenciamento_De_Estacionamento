package controle_de_entrada_saida_veiculos;

public class Veiculo {
    protected int horarioEntrada;
    protected String idVaga;
    // Construtor
    public Veiculo(int horarioEntrada,String idVaga) {
        this.horarioEntrada = horarioEntrada;
        this.idVaga=idVaga;
    }

    // Getter
    public int getHorarioEntrada() {
        return horarioEntrada;
    }

    public String getIdVaga() {
        return idVaga;
    }  
}
