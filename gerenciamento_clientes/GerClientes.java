package gerenciamento_clientes;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import leit_escr_de_arquivos.LerEscreverArquivos;

public class GerClientes {
    public static void cadastrarClientes( String nome, int telefone, String email, String veiculo){
        LerEscreverArquivos.escreverCliente("./banco_de_dados/clientesCadastrados.txt", nome, telefone, email, veiculo);
        JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

    }
    
    // Função para consultar se um cliente existe no arquivo
    public static boolean consultarCliente( String nome, int telefone, String email, String veiculo) {
        List<String[]> informacoesClientes = LerEscreverArquivos.lerInformacoesLinha("./banco_de_dados/clientesCadastrados.txt");

        for (String[] cliente : informacoesClientes) {
            String nomeCliente = cliente[0];
            int telefoneCliente = Integer.parseInt(cliente[1]);
            String emailCliente = cliente[2];
            String veiculoCliente=cliente[3];

            // Comparar se os dados do cliente atual são iguais aos fornecidos
            if (nomeCliente.equals(nome) && telefoneCliente == telefone && emailCliente.equals(email) &&veiculoCliente.equals(veiculo)) {
                return true; // Cliente encontrado
            }
        }

        return false; // Cliente não encontrado
    }

    // Função para atualizar um cliente no arquivo
public static boolean atualizarCliente(String nomeAntigo, int telefoneAntigo, String emailAntigo, String veiculoAntigo,
                                       String novoNome, int novoTelefone, String novoEmail, String novoVeiculo) {
    List<String[]> informacoesClientes = LerEscreverArquivos.lerInformacoesLinha("./banco_de_dados/clientesCadastrados.txt");
    List<String[]> novasInformacoesClientes = new ArrayList<>();
    boolean clienteEncontrado = false;

    // Percorre todas as informações de clientes
    for (String[] cliente : informacoesClientes) {
        // Verifica se o telefone é um número válido antes de tentar a conversão
        int telefone;
        try {
            telefone = Integer.parseInt(cliente[1]);
        } catch (NumberFormatException e) {
            System.err.println("Telefone inválido encontrado: " + cliente[1] + " para cliente " + cliente[0]);
            continue; // Pula este cliente inválido
        }

        String nome = cliente[0];
        String email = cliente[2];
        String veiculo = cliente[3];

        // Verifica se os dados do cliente correspondem ao cliente a ser atualizado
        if (nome.equals(nomeAntigo) && telefone == telefoneAntigo && email.equals(emailAntigo) && veiculo.equals(veiculoAntigo)) {
            // Atualiza as informações do cliente
            cliente[0] = novoNome;
            cliente[1] = String.valueOf(novoTelefone);
            cliente[2] = novoEmail;
            cliente[3] = novoVeiculo;
            clienteEncontrado = true;
        }

        // Adiciona o cliente (atualizado ou não) à lista de novas informações
        novasInformacoesClientes.add(cliente);
    }

    // Se o cliente foi encontrado e atualizado, reescreve o arquivo com as novas informações
    if (clienteEncontrado) {
        LerEscreverArquivos.reescreverArquivoClientes("./banco_de_dados/clientesCadastrados.txt", novasInformacoesClientes);
    }

    return clienteEncontrado;
}

}
