package relatorios_e_consultas;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JPanel;
import javax.swing.JScrollPane;


import java.awt.BorderLayout;
import java.util.Arrays;
import java.util.List;

import design_de_telas.TelaDesign;
import leit_escr_de_arquivos.LerEscreverArquivos;

public class RelatoriosConsultas {
    

    public static void relatorioDeOcupacao(JFrame tela) {
        // Ler informações dos arquivos de entrada e saída de veículos
        List<String[]> entradas = LerEscreverArquivos.lerInformacoesLinha("./banco_de_dados/entradaDeVeiculos.txt");
        List<String[]> saidas = LerEscreverArquivos.lerInformacoesLinha("./banco_de_dados/saidaDeVeiculos.txt");

        // Criar os componentes para exibição
        JLabel lgVeiculoAtual = TelaDesign.criarLegenda("Veículos Atuais:", 20);
        JLabel lgVeiculoRetirado = TelaDesign.criarLegenda("Veículos Retirados:", 20);
        JPanel panelVeiculosAtuais = new JPanel();
        JPanel panelVeiculosRetirados = new JPanel();

        panelVeiculosAtuais.setLayout(new BoxLayout(panelVeiculosAtuais, BoxLayout.Y_AXIS));
        panelVeiculosRetirados.setLayout(new BoxLayout(panelVeiculosRetirados, BoxLayout.Y_AXIS));

        // Processar entradas
        for (String[] entrada : entradas) {
            if (entrada.length >= 3) { // Verifica se há pelo menos três elementos
                String horarioEntrada = entrada[0];
                String idVaga = entrada[1];
                String veiculo = entrada[2];
                String detalhesVeiculo = "Horário de Entrada: " + horarioEntrada + " | ID da Vaga: " + idVaga + " | Veículo: " + veiculo;

                JLabel lblVeiculo = TelaDesign.criarLegenda(detalhesVeiculo, 15);
                panelVeiculosAtuais.add(lblVeiculo);
            } else {
                System.err.println("Entrada inválida: o array não possui elementos suficientes.");
            }
        }

        // Processar saídas
        for (String[] saida : saidas) {
            if (saida.length >= 5) { // Verifica se há pelo menos cinco elementos
                String tempoPermanencia = saida[0];
                String valorPago = saida[1];
                String horarioEntrada = saida[2];
                String idVaga = saida[3];
                String veiculo = saida[4];
                String detalhesVeiculo = "Horário de Entrada: " + horarioEntrada + " | ID da Vaga: " + idVaga + " | Veículo: " + veiculo + " | Tempo de Permanência: " + tempoPermanencia + " | Valor Pago: " + valorPago;

                JLabel lblVeiculo = TelaDesign.criarLegenda(detalhesVeiculo, 15);
                panelVeiculosRetirados.add(lblVeiculo);
            } else {
                System.err.println("Saída inválida: o array não possui elementos suficientes.");
            }
        }

        JScrollPane scrollAtual = new JScrollPane(panelVeiculosAtuais);
        JScrollPane scrollRetirado = new JScrollPane(panelVeiculosRetirados);

        // Adicionando componentes na tela
        tela.setLayout(new BoxLayout(tela.getContentPane(), BoxLayout.Y_AXIS));
        tela.add(lgVeiculoAtual);
        tela.add(scrollAtual);
        tela.add(lgVeiculoRetirado);
        tela.add(scrollRetirado);

        tela.pack();
        tela.setVisible(true);
    }



public static void relatorioFinanceiro(JFrame tela) {
    int totalCaixa = 0;
    List<String[]> pagamentos = LerEscreverArquivos.lerInformacoesLinha("./banco_de_dados/pagamentos.txt");

    // Criar os componentes para exibição
    JLabel legenda = TelaDesign.criarLegenda("Relatório Financeiro", 20);
    JPanel panelPagamentos = new JPanel();
    panelPagamentos.setLayout(new BoxLayout(panelPagamentos, BoxLayout.Y_AXIS));

    // Processar pagamentos
    for (String[] linha : pagamentos) {
        try {
            if (linha.length >= 2) {
                int valorPago = Integer.parseInt(linha[0]);
                String tipoPagamento = linha[1];

                totalCaixa += valorPago;

                String detalhesPagamento = "Tipo de Pagamento: " + tipoPagamento + " | Valor Pago: R$ " + valorPago;
                JLabel lblPagamento = TelaDesign.criarLegenda(detalhesPagamento, 15);
                panelPagamentos.add(lblPagamento);
            } else {
                System.err.println("Linha de pagamento inválida: " + Arrays.toString(linha));
            }
        } catch (NumberFormatException e) {
            System.err.println("Erro ao converter valor para inteiro: " + e.getMessage());
        }
    }

    JLabel total = TelaDesign.criarLegenda("Total: R$ " + totalCaixa, 15);

    JScrollPane scroll = new JScrollPane(panelPagamentos);

    // Adicionando componentes na tela
    tela.setLayout(new BoxLayout(tela.getContentPane(), BoxLayout.Y_AXIS));
    tela.add(legenda);
    tela.add(scroll);
    tela.add(total);

    tela.pack();
    tela.setVisible(true);
}


public static void consultarHistoricoVeiculos(JFrame tela) {
    // Painel para exibir informações dos veículos
    JPanel infoVeiculos = new JPanel();
    infoVeiculos.setLayout(new BoxLayout(infoVeiculos, BoxLayout.Y_AXIS));

    // Cabeçalho do relatório
    JLabel legenda = TelaDesign.criarLegenda("Histórico de Entradas e Saídas", 20);

    // Lendo informações do arquivo de histórico
    List<String[]> historicoVeiculos = LerEscreverArquivos.lerInformacoesLinha("./banco_de_dados/historicoDeEntradasESaidas.txt");

    // Verificar se há dados no histórico
    if (historicoVeiculos.isEmpty()) {
        JLabel lblNenhumDado = TelaDesign.criarLegenda("Nenhum dado encontrado no histórico.", 15);
        infoVeiculos.add(lblNenhumDado);
    } else {
        // Ignorar a primeira e a segunda linha
        int linhaIndex = 0;

        // Processar cada linha do arquivo de histórico e adicionar ao painel
        for (String[] linha : historicoVeiculos) {
            linhaIndex++;
            if (linhaIndex <= 2) {
                continue; // Ignorar a primeira e a segunda linha
            }

            StringBuilder detalhesVeiculo = new StringBuilder();

            // Verificar o tipo de veículo para formatar os detalhes corretamente
            if (linha.length >= 6) {
                String horarioEntrada = linha[0];
                String idVaga = linha[1];
                String tipoVeiculo = linha[2];
                String atributosEspecificos = linha[3];
                String horarioSaida = linha[4];
                String valorPago = linha[5];

                detalhesVeiculo.append("Tipo: ").append(tipoVeiculo)
                               .append(" | Atributos: ").append(atributosEspecificos)
                               .append(" | Entrada: ").append(horarioEntrada)
                               .append(" | Atributos Especifico: ").append(horarioSaida)
                               .append(" | Vaga: ").append(idVaga)
                               .append(" | Atributos: R$ ").append(valorPago);
            } else {
                // Formato inválido, exibir a linha como texto de formato inválido
                detalhesVeiculo.append("Horário de Entrada: ").append(linha[0])
                               .append(" | Valor Pago: ").append(linha[1])
                               .append(" | Veículo: ").append(linha[2])
                               .append(" | Horário de Saída: ").append(linha[3]);
            }

            JLabel lblVeiculo = TelaDesign.criarLegenda(detalhesVeiculo.toString(), 15);
            infoVeiculos.add(lblVeiculo);
        }
    }

    // Adicionar os componentes na tela
    tela.getContentPane().removeAll(); // Limpar qualquer conteúdo anterior
    tela.setLayout(new BorderLayout());
    tela.add(legenda, BorderLayout.NORTH);
    
    JScrollPane scrollHistorico = new JScrollPane(infoVeiculos);
    scrollHistorico.setBorder(null);
    tela.add(scrollHistorico, BorderLayout.CENTER);

    tela.pack();
    tela.setVisible(true);
}


}
