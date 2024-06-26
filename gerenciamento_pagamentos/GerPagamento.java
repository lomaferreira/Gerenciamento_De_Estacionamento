package gerenciamento_pagamentos;

import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;

import controle_de_entrada_saida_veiculos.Controle;
import gerenciamento_vagas.GerVagas;
import leit_escr_de_arquivos.LerEscreverArquivos;

public class GerPagamento {
      static Map<Integer, Integer> tabelaPagamentos= Map.of(
        1, 15,
        2, 20,
        3, 25,
        4, 30,
        5, 35,
        6, 40
    );

  
  
    // Função para realizar o pagamento de um veículo
public static void pagar(int valorPago, String idVaga, String tipoPagamento, int horarioSaida) {
    // Variáveis para armazenar as informações do veículo e vaga
    String horarioEntrada = null;

    int numLinha = 0;
    String veiculo = "";

    // Ler informações do arquivo de vagas de veiculos para encontrar a vaga
    List<String[]> informacoesVagas = LerEscreverArquivos.lerInformacoesLinha("./banco_de_dados/vagasCadastradas.txt");
    //"localizacao;numero;status;idVaga;veiculo\n"
    for (String[] linha : informacoesVagas) {
        if (linha[3].equals(idVaga)) {
            break;
        }
    }

    // Ler informações do arquivo de entrada para encontrar o veículo
    List<String[]> informacoesEntradas = LerEscreverArquivos.lerInformacoesLinha("./banco_de_dados/entradaDeVeiculos.txt");
    for (String[] linha : informacoesEntradas) {
        try {
            // Verifica se o array tem pelo menos 2 elementos
            if (linha.length > 1) {
               if (linha[1].equals(idVaga)) {
                 horarioEntrada = linha[0];
                veiculo = linha[2];
                break;
            }
        } else {
            // Lida com o caso onde o array não tem o tamanho esperado
            System.err.println("Erro: Tamanho do array menor que o esperado.");
        }
    } catch (ArrayIndexOutOfBoundsException e) {
        // Captura a exceção caso o índice esteja fora dos limites
        System.err.println("Erro ao acessar o índice do array: " + e.getMessage());
    }
    numLinha++;
        
    }


 

    if (horarioEntrada != null) {
        // Calcular tempo de permanência
        int tempoPermanencia = Controle.tempoPermanencia(Integer.parseInt(horarioEntrada),horarioSaida);

        // Verificar o valor correto a ser pago
        int valorCorreto = tabelaPagamentos.getOrDefault(tempoPermanencia, -1);

        if (valorCorreto == -1) {
            JOptionPane.showMessageDialog(null, "Tempo de permanência inválido!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Verificar se o valor pago corresponde ao valor correto
        if (valorPago >= valorCorreto) {
            // Atualizar status da vaga para "livre"
            GerVagas.atualizarStatusVaga( idVaga, "livre");

            // Escrever no arquivo de saída do veículo
            LerEscreverArquivos.escreverSaidaVeiculo("./banco_de_dados/saidaDeVeiculos.txt", veiculo, tempoPermanencia, valorCorreto,horarioSaida);
            // Escrever no arquivo de histórico a saída do veículo
            LerEscreverArquivos.escreverSaidaVeiculo("./banco_de_dados/historicoDeEntradasESaidas.txt", veiculo, tempoPermanencia, valorCorreto,horarioSaida);

            // Remover a linha correspondente do arquivo de vagas cadastradas
            LerEscreverArquivos.deletarLinhaPorNumero("./banco_de_dados/entradaDeVeiculos.txt", numLinha);

            // Registrar pagamento
            LerEscreverArquivos.escreverPagamento("./banco_de_dados/pagamentos.txt", valorCorreto, tipoPagamento);

            JOptionPane.showMessageDialog(null, "Valor recebido: "+ valorPago+" Valor pago: "+ valorCorreto+" Tipo de pagamento: "+ tipoPagamento, "Recibo de pagamento", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Valor pago insuficiente!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    } else {
        JOptionPane.showMessageDialog(null, "Veículo não encontrado!", "Erro", JOptionPane.ERROR_MESSAGE);
    }
}



}
