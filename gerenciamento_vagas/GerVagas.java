package gerenciamento_vagas;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import leit_escr_de_arquivos.LerEscreverArquivos;

public class GerVagas {
    public static void cadastrarVagas( int numero, String localizacao, String status,String idVaga ,String veiculo){
        LerEscreverArquivos.escreverVaga("./banco_de_dados/vagasCadastradas.txt", numero, localizacao, status, idVaga, veiculo);
        JOptionPane.showMessageDialog(null,"Vaga cadastrada com sucesso","Sucesso",JOptionPane.INFORMATION_MESSAGE);
    }
   
    public static String verificarVagaDisponivel( String tipoVeiculo) {
        List<String[]> vagas = LerEscreverArquivos.lerInformacoesLinha("./banco_de_dados/vagasCadastradas.txt");
        
        for (String[] vaga : vagas) {
            // Ignorar a linha do cabeçalho e verificar se a linha possui o número esperado de elementos
            if (vaga.length == 5) {
                String status = vaga[2];
                String veiculo = vaga[4];
                String idVaga = vaga[3];

                // Verifica se a vaga está livre e é para o tipo de veículo especificado
                if (status.equalsIgnoreCase("livre") && veiculo.equalsIgnoreCase(tipoVeiculo)) {
                    return idVaga;
                }
            }
        }
        return null;
    }

    public static void atualizarStatusVaga( String idVaga, String novoStatus) {
        List<String[]> vagas = LerEscreverArquivos.lerVagas("./banco_de_dados/vagasCadastradas.txt");
        List<String[]> vagasAtualizadas = new ArrayList<>();

        for (String[] vaga : vagas) {
            // Ignorar a linha do cabeçalho
            if (vaga.length == 5) {
                if (vaga[3].equals(idVaga)) {
                    // Atualizar o status da vaga
                    vaga[2] = novoStatus;
                }
                vagasAtualizadas.add(vaga);
            }
        }

        // Reescrever o arquivo com as vagas atualizadas
        LerEscreverArquivos.reescreverArquivoVagas("./banco_de_dados/vagasCadastradas.txt", vagasAtualizadas);
}



}
