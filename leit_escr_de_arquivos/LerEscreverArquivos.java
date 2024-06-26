package leit_escr_de_arquivos;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import controle_de_entrada_saida_veiculos.*;



public class LerEscreverArquivos {
// Método para escrever uma vaga em um arquivo
public static void escreverVaga(String caminhoArquivo, int numero, String localizacao, String status, String idVaga, String veiculo) {
    try (BufferedWriter escrita = new BufferedWriter(new FileWriter(caminhoArquivo, true))) {
        // Verificar se o arquivo está vazio para escrever o cabeçalho
        boolean isEmpty = new java.io.File(caminhoArquivo).length() == 0;
        if (isEmpty) {
            escrita.write("localizacao;numero;status;idVaga;veiculo\n");
        }

        // Escrever os valores separados por ponto e vírgula
        escrita.write(localizacao + ";" +
                      numero + ";" +
                      status + ";" +
                      idVaga + ";" +
                      veiculo +  "\n");
    } catch (IOException e) {
        JOptionPane.showMessageDialog(null, "Erro ao escrever no arquivo!", "Error", JOptionPane.WARNING_MESSAGE);
        System.err.println("Erro ao escrever no arquivo: " + e.getMessage());
    }
}

    public static void reescreverArquivoVagas(String caminhoArquivo, List<String[]> vagasAtualizadas) {
    try (BufferedWriter escrita = new BufferedWriter(new FileWriter(caminhoArquivo))) {
        //  cabeçalho
        //"localizacao;numero;status;idVaga;veiculo\n"
        
        // Escrever cada vaga
        for (String[] vaga : vagasAtualizadas) {
            escrita.write(String.join(";", vaga) + "\n");
        }
    } catch (IOException e) {
        JOptionPane.showMessageDialog(null, "Erro ao reescrever o arquivo de vagas!", "Error", JOptionPane.WARNING_MESSAGE);
        System.err.println("Erro ao reescrever o arquivo: " + e.getMessage());
    }
}

public static List<String[]> lerVagas(String caminhoArquivo) {
    return LerEscreverArquivos.lerInformacoesLinha(caminhoArquivo);
}

  // Método para escrever um cliente em um arquivo
    public static void escreverCliente(String caminhoArquivo, String nome, int telefone, String email, String veiculo) {
        try (BufferedWriter escrita = new BufferedWriter(new FileWriter(caminhoArquivo, true))) {
            //"nome;telefone;email;tipoVeiculo\n"
            // Escrevendo os valores separados por ponto e vírgula
            escrita.write(nome + ";" +
                          telefone + ";" +
                          email + ";" +
                          veiculo + "\n");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro ao escrever no arquivo!", "Error", JOptionPane.WARNING_MESSAGE);
            System.err.println("Erro ao escrever no arquivo: " + e.getMessage());
        }
    }

        // Função para reescrever o arquivo de clientes com as novas informações
    public static void reescreverArquivoClientes(String caminhoArquivo, List<String[]> novasInformacoesClientes) {
        try (BufferedWriter escrita = new BufferedWriter(new FileWriter(caminhoArquivo))) {
            //"nome;telefone;email;tipoVeiculo\n"
            // Escreve cada cliente com as novas informações
            for (String[] cliente : novasInformacoesClientes) {
                escrita.write(cliente[0] + ";" +
                              cliente[1] + ";" +
                              cliente[2] + ";" +
                              cliente[3] + "\n");
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro ao escrever no arquivo!", "Error", JOptionPane.WARNING_MESSAGE);
            System.err.println("Erro ao escrever no arquivo: " + e.getMessage());
        }
    }

// Método para escrever a entrada de um único veículo em um arquivo
public static void escreverEntradaVeiculo(String caminhoArquivo, Veiculo veiculo) {
    try (BufferedWriter escrita = new BufferedWriter(new FileWriter(caminhoArquivo, true))) {
        //"horarioEntrada;idVaga;tipoVeiculo;atributosEspecificos\n"
        StringBuilder linha = new StringBuilder();
        linha.append(veiculo.getHorarioEntrada()).append(";")
             .append(veiculo.getIdVaga()).append(";");

        if (veiculo instanceof Carro) {
            Carro carro = (Carro) veiculo;
            linha.append("carro;")
                .append(carro.getCor()).append(";")
                .append(carro.getMarca()).append(";")
                .append(carro.getModelo());
        } else if (veiculo instanceof Moto) {
            Moto moto = (Moto) veiculo;
            linha.append("moto;")
                .append(moto.getCilindradas());
        } else if (veiculo instanceof Caminhao) {
            Caminhao caminhao = (Caminhao) veiculo;
            linha.append("caminhao;")
                .append(caminhao.getCargaMaxima()).append(";")
                .append(caminhao.getComprimento());
        }

        linha.append("\n");
        escrita.write(linha.toString());
    } catch (IOException e) {
        JOptionPane.showMessageDialog(null, "Erro ao escrever no arquivo!", "Error", JOptionPane.WARNING_MESSAGE);
        System.err.println("Erro ao escrever no arquivo: " + e.getMessage());
    }
}


// Método para escrever a saída de um único veículo em um arquivo
public static void escreverSaidaVeiculo(String caminhoArquivo, String veiculo, int tempoPermanencia, int valorPago,int horarioSaida) {
    try (BufferedWriter escrita = new BufferedWriter(new FileWriter(caminhoArquivo, true))) {
        //"tempoPermanencia;valorPago;veiculo;horarioSaida\n"
        StringBuilder linha = new StringBuilder();
        linha.append(tempoPermanencia).append(";");
        linha.append(valorPago).append(";");
        linha.append(veiculo).append(";"); // Adiciona a quebra de linha ao final
        linha.append(horarioSaida).append("\n");

        escrita.write(linha.toString());
    } catch (IOException e) {
        JOptionPane.showMessageDialog(null, "Erro ao escrever no arquivo!", "Error", JOptionPane.WARNING_MESSAGE);
        System.err.println("Erro ao escrever no arquivo: " + e.getMessage());
    }
}

// Função para escrever pagamentos em um arquivo
    public static void escreverPagamento(String caminhoArquivo, int valorPago, String tipoPagamento) {
        try (BufferedWriter escrita = new BufferedWriter(new FileWriter(caminhoArquivo, true))) {
            // Escreve o pagamento no arquivo
            escrita.write(valorPago + ";" + tipoPagamento + "\n");
        } catch (IOException e) {
            System.err.println("Erro ao escrever no arquivo: " + e.getMessage());
        }
    }

     // Função para deletar uma linha do arquivo pelo número da linha
    public static String deletarLinhaPorNumero(String caminhoArquivo, int numeroLinha) {
        List<String> linhas = new ArrayList<>();
        String linhaDeletada="";
        // Ler todas as linhas do arquivo
        try (BufferedReader leitura = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;
            int numeroLinhaAtual = 0;
            while ((linha = leitura.readLine()) != null) {
                numeroLinhaAtual++;
                // Adiciona a linha à lista apenas se não for a linha a ser deletada
                if (numeroLinhaAtual != numeroLinha) {
                    linhas.add(linha);
                }else{
                    linhaDeletada=linha;
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
            return null;
        }

        // Reescrever todas as linhas no arquivo, exceto a linha deletada
        try (BufferedWriter escrita = new BufferedWriter(new FileWriter(caminhoArquivo))) {
            for (String linha : linhas) {
                escrita.write(linha);
                escrita.newLine();
            }
        } catch (IOException e) {
            System.err.println("Erro ao escrever no arquivo: " + e.getMessage());
        }
        return linhaDeletada;
    }

    public static List<String[]> lerInformacoesLinha(String caminhoArquivo) {
        List<String[]> informacoes = new ArrayList<>();
        try (BufferedReader leitura = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;
            while ((linha = leitura.readLine()) != null) {
                String[] partes = linha.split(";");
                informacoes.add(partes);
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }
        return informacoes;
    }

    public static void escreverTempoReservado(String caminhoArquivo, int tempo) {
        try (BufferedWriter escrita = new BufferedWriter(new FileWriter(caminhoArquivo, true))) {
            escrita.write(String.valueOf(tempo));
            escrita.newLine();
        } catch (IOException e) {
            System.err.println("Erro ao escrever no arquivo: " + e.getMessage());
        }
    }

    public static List<Integer> lerTemposReservados(String caminhoArquivo) {
        List<Integer> tempos = new ArrayList<>();
        
        try (BufferedReader leitura = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;
            while ((linha = leitura.readLine()) != null) {
                int tempo = Integer.parseInt(linha.trim());
                tempos.add(tempo);
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Erro de formato ao converter para inteiro: " + e.getMessage());
        }
        
        return tempos;
    }

    public static void reescreverArquivo(String caminhoArquivo, List<String[]> informacoes) {
    try (BufferedWriter escritor = new BufferedWriter(new FileWriter(caminhoArquivo))) {
        for (String[] info : informacoes) {
            escritor.write(String.join(";", info));
            escritor.newLine();
        }
    } catch (IOException e) {
        System.err.println("Erro ao escrever no arquivo: " + e.getMessage());
    }
}

}
