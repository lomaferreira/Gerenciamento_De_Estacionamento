package controle_de_entrada_saida_veiculos;


import leit_escr_de_arquivos.LerEscreverArquivos;

public class Controle {
    public static int tempoPermanencia(int horarioEntrada,int horarioSaida){
    //Obtem horario atual do sistema;
    int horaSaida=horarioSaida;

    //Subtrai do horario atual o horario de entrada
    int tempoPermanencia=horaSaida-horarioEntrada;

    return tempoPermanencia;
    }

    public static void registrarEntrada(Veiculo veiculo){
        LerEscreverArquivos.escreverEntradaVeiculo("./banco_de_dados/entradaDeVeiculos.txt", veiculo);
        LerEscreverArquivos.escreverEntradaVeiculo("./banco_de_dados/historicoDeEntradasESaidas.txt", veiculo);
    }

}
