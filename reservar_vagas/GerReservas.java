package reservar_vagas;

import java.util.ArrayList;
import java.util.List;

import controle_de_entrada_saida_veiculos.Veiculo;
import gerenciamento_vagas.GerVagas;
import leit_escr_de_arquivos.LerEscreverArquivos;

public class GerReservas {
// Método para reservar vagas, considerando clientes cadastrados com carros ou caminhões
public static void reservarVagas(Veiculo veiculo, int tempoReserva) {
    // Verifica se o cliente está cadastrado e se possui carro ou caminhão
    if (clienteAutorizado()) {
        // Escrever o veículo no arquivo de entrada
        LerEscreverArquivos.escreverEntradaVeiculo("./banco_de_dados/vagasReservadas.txt", veiculo);
        // Escrever o tempo de reserva no arquivo de tempos reservados
        LerEscreverArquivos.escreverTempoReservado("./banco_de_dados/tempoReserva.txt", tempoReserva);
    } else {
        System.err.println("Reserva não autorizada: cliente não cadastrado ou veículo não permitido.");
    }
}

// Função para verificar se o cliente está cadastrado e se possui carro ou caminhão
private static boolean clienteAutorizado() {
    List<String[]> clientesCadastrados = LerEscreverArquivos.lerInformacoesLinha("./banco_de_dados/clientesCadastrados.txt");

    // Itera pela lista de clientes cadastrados
    for (String[] cliente : clientesCadastrados) {
        // String nome = cliente[0];
        // int telefone = Integer.parseInt(cliente[1]);
        // String email = cliente[2];
        String tipoVeiculo = cliente[3];

        // Verifica se o cliente é o proprietário do veículo e se o veículo é um carro ou caminhão
        if ((tipoVeiculo.equals("carro") || tipoVeiculo.equals("caminhao"))) {
            return true;
        }
    }
    return false;
}
   // Função para verificar se as reservas expiraram e liberar as vagas
    public static void verificarReservasExpiradas() {
        List<String[]> reservas = LerEscreverArquivos.lerInformacoesLinha("./banco_de_dados/vagasReservadas.txt");
        List<String[]> temposReservados = LerEscreverArquivos.lerInformacoesLinha("./banco_de_dados/tempoReserva.txt");

        long currentTime = System.currentTimeMillis(); // Obtém o tempo atual

        List<String[]> novasReservas = new ArrayList<>();
        List<String[]> novosTemposReservados = new ArrayList<>();

        for (int i = 0; i < reservas.size(); i++) {
            String[] reserva = reservas.get(i);
            String[] tempoReservado = temposReservados.get(i);

            try {
                long horarioEntrada = Long.parseLong(reserva[0]); // Supondo que o horário de entrada está na posição 1
                int tempoReserva = Integer.parseInt(tempoReservado[0]);

                long tempoExpiracao = horarioEntrada + (tempoReserva * 60 * 1000); // Convertendo minutos para milissegundos

                if (currentTime < tempoExpiracao) {
                    // Adiciona as reservas e tempos ainda válidos
                    novasReservas.add(reserva);
                    novosTemposReservados.add(tempoReservado);
                } else {
                    // Libera a vaga, marcando-a como disponível
                    String idVaga = reserva[0];
                    GerVagas.atualizarStatusVaga(idVaga, "livre");
                }
            } catch (NumberFormatException e) {
                System.err.println("Erro ao converter dados: " + e.getMessage());
                // Ignorar esta entrada e não adicionar às novas listas
            }
        }

        // Reescrever os arquivos com as novas listas
        LerEscreverArquivos.reescreverArquivo("./banco_de_dados/vagasReservadas.txt", novasReservas);
        LerEscreverArquivos.reescreverArquivo("./banco_de_dados/tempoReserva.txt", novosTemposReservados);
    }


}
