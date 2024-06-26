package controle_de_entrada_saida_veiculos;

public class Carro extends Veiculo {
    protected String cor;
    protected String marca;
    protected String modelo;

    public Carro(int horarioEntrada,String idVaga, String cor, String marca, String modelo) {
        super(horarioEntrada,idVaga);
        this.cor = cor;
        this.marca = marca;
        this.modelo = modelo;
    }

    public String getCor() {
        return cor;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }
}