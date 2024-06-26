import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import controle_de_entrada_saida_veiculos.Caminhao;
import controle_de_entrada_saida_veiculos.Carro;
import controle_de_entrada_saida_veiculos.Controle;
import controle_de_entrada_saida_veiculos.Moto;
import design_de_telas.TelaDesign;
import gerenciamento_clientes.GerClientes;
import gerenciamento_vagas.GerVagas;
import reservar_vagas.GerReservas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;;

public class TelaEstacionamento extends JFrame implements ActionListener{
    int valorNumero;
    String valorLocalizacao;
    String valorStatus;
    String valorVeiculo;
    String valorIdVaga;
   
    int valorHorarioEntrada;
    int valorTempoReservado;
    String valorCor;
    String valorMarca;
    String valorModelo;
    int valorCargaMax;
    int valorCmpVeiculo;
    int valorCilindradas;

    JPanel inforVeiculos;
    JTextField veiculo;
    JTextField horarioEntrada;
    JTextField tempoReservado;
    JTextField cor;
    JTextField marca;
    JTextField modelo;
    JTextField cargaMax;
    JTextField comprimento;
    JTextField cilindradas;
    
    JFrame cadastrarVagas;
    JTextField localizacao;
    JTextField numero;
    JTextField status;
    JTextField idVaga;

    JTextField nome;
    JTextField email;
    JTextField telefone;
    JTextField veiculoCliente;
 
    String valorNome;
    int valorTelefone;
    String valorEmail;
    String valorVeiculoCliente;
    public TelaEstacionamento(){
        /*Criando a tela */
        TelaDesign.criarTela(this, "Estacionamento",800,500,2,5, 1,10,10);
        
        /*Criando os componentes */
        JLabel legenda=TelaDesign.criarLegenda("Qual ação deseja realizar?", 20, 0);
        JButton alocarVaga=TelaDesign.criarButton("Alocar Vaga", 20);
        JButton reservarVagas=TelaDesign.criarButton("Reservar Vagas", 20);
        JButton cadastrarVagas=TelaDesign.criarButton("Cadastrar Novas Vagas", 20);
        
        /*Adicionando componentes na tela */
        this.add(legenda);
        this.add(alocarVaga);
        this.add(reservarVagas);
        this.add(cadastrarVagas);

        /*Ouvinte */
        alocarVaga.addActionListener(this);
        reservarVagas.addActionListener(this::abrirTelaReservaVagas);
        cadastrarVagas.addActionListener(this::abrirTelaCadastroVagas);
      


        this.setVisible(true);
    }
    /*Alocar uma vaga */
    @Override
    public void actionPerformed(ActionEvent e) {
        /*Criando a tela */
        JFrame alocarVaga= new JFrame();
        TelaDesign.criarTela(alocarVaga, " ", 800, 500, 2, 15, 1, 5, 5);
        
        /*Criando os componentes */
        JLabel legenda=TelaDesign.criarLegenda("Qual o veículo?", 20);
        JLabel legenda2=TelaDesign.criarLegenda("Se o seu veículo for um caminhão:", 20);
        JLabel legenda3=TelaDesign.criarLegenda("Se o seu veículo for uma moto:", 20);
        JLabel legenda4=TelaDesign.criarLegenda("Se o seu veículo for um carro:", 20);
        JButton btAlocarVaga=TelaDesign.criarButton("Cadastrar", 20);

        
        /*Adicionando componentes na tela */
        alocarVaga.add(legenda);
        veiculo= TelaDesign.criarInput("Veículo:  ", 15, alocarVaga);  
        horarioEntrada= TelaDesign.criarInput("Horário de Entrada:  ", 15, alocarVaga);  
        /*SE FOR UM CARRO */
        alocarVaga.add(legenda4);
        cor= TelaDesign.criarInput("Cor:  ", 15, alocarVaga);  
        marca= TelaDesign.criarInput("Marca:  ", 15, alocarVaga);  
        modelo= TelaDesign.criarInput("Modelo:  ", 15, alocarVaga);  
        /*SE FOR UM CAMINHAO */
        alocarVaga.add(legenda2);
        cargaMax= TelaDesign.criarInput("Carga Máxima:  ", 15, alocarVaga);
        comprimento= TelaDesign.criarInput("Comprimento do Veículo:  ", 15, alocarVaga);
        /*SE FOR UMA MOTO*/
        alocarVaga.add(legenda3);
        cilindradas= TelaDesign.criarInput("Cilindradas:  ", 15, alocarVaga);  
        alocarVaga.add(btAlocarVaga);
      
        btAlocarVaga.addActionListener((ActionEvent event) -> transfereInforAlocacaoDeVagas(event));
        alocarVaga.setVisible(true);
        
    }
     public void abrirTelaReservaVagas(ActionEvent e) {
             /*Criando a tela */
        JFrame reservaVagas= new JFrame();
        TelaDesign.criarTela(reservaVagas, " ", 800, 500, 2, 20, 1, 5, 5);
        
        /*Criando os componentes */
        JLabel legenda=TelaDesign.criarLegenda("Qual o veículo?", 20);
        JLabel legenda2=TelaDesign.criarLegenda("Se o seu veículo for um caminhão:", 20);
        JLabel legenda3=TelaDesign.criarLegenda("Se o seu veículo for uma moto:", 20);
        JLabel legenda4=TelaDesign.criarLegenda("Se o seu veículo for um carro:", 20);
        JLabel legenda5=TelaDesign.criarLegenda("Insira as informações do cliente:", 20);
        JButton btReservaVagas=TelaDesign.criarButton("Cadastrar", 20);

        
        /*Adicionando componentes na tela */
        /*informações do cliente */
        reservaVagas.add(legenda5);
        nome= TelaDesign.criarInput("Nome:  ", 15, reservaVagas);  
        telefone= TelaDesign.criarInput("Telefone:  ", 15, reservaVagas);  
        email= TelaDesign.criarInput("Email:  ", 15, reservaVagas);  
        veiculoCliente= TelaDesign.criarInput("Veículo:  ", 15, reservaVagas); 
        
        reservaVagas.add(legenda);
        veiculo= TelaDesign.criarInput("Veículo:  ", 15, reservaVagas);  
        horarioEntrada= TelaDesign.criarInput("Horário de Entrada:  ", 15, reservaVagas);  
        tempoReservado= TelaDesign.criarInput("Tempo reservado:  ", 15, reservaVagas);  
        /*SE FOR UM CARRO */
        reservaVagas.add(legenda4);
        cor= TelaDesign.criarInput("Cor:  ", 15, reservaVagas);  
        marca= TelaDesign.criarInput("Marca:  ", 15, reservaVagas);  
        modelo= TelaDesign.criarInput("Modelo:  ", 15, reservaVagas);  
        /*SE FOR UM CAMINHAO */
        reservaVagas.add(legenda2);
        cargaMax= TelaDesign.criarInput("Carga Máxima:  ", 15, reservaVagas);
        comprimento= TelaDesign.criarInput("Comprimento do Veículo:  ", 15, reservaVagas);
        /*SE FOR UMA MOTO*/
        reservaVagas.add(legenda3);
        cilindradas= TelaDesign.criarInput("Cilindradas:  ", 15, reservaVagas);  
        reservaVagas.add(btReservaVagas);
      
        btReservaVagas.addActionListener((ActionEvent event) -> transfereInforReservaDeVagas(event));
        reservaVagas.setVisible(true);
     }
 
    public void abrirTelaCadastroVagas(ActionEvent e) {
       /*Criando a tela */
        cadastrarVagas= new JFrame();
        TelaDesign.criarTela(cadastrarVagas, "Cadastro de Vagas", 800, 500, 2, 20, 1, 2, 2);
        
        
        /*Criando os componentes */
        JLabel legenda=TelaDesign.criarLegenda("Preencha as informações da vaga:", 20);
        JLabel legenda2=TelaDesign.criarLegenda("Qual o veículo?", 20);
        JButton btCadastrarVagas=TelaDesign.criarButton("Cadastrar", 20);
        
        /*Adicionando componentes na tela */
        cadastrarVagas.add(legenda);
        localizacao= TelaDesign.criarInput("Localização:  ", 15, cadastrarVagas);  
        numero= TelaDesign.criarInput("Número:  ", 15, cadastrarVagas);  
        status= TelaDesign.criarInput("Status:  ", 15, cadastrarVagas);   
        idVaga= TelaDesign.criarInput("Id da Vaga:  ", 15, cadastrarVagas);
        cadastrarVagas.add(legenda2);
        veiculo= TelaDesign.criarInput("carro/moto/caminhao:  ", 15, cadastrarVagas);

        cadastrarVagas.add(btCadastrarVagas);
        
      
        btCadastrarVagas.addActionListener((ActionEvent event) -> transfereInforDeCadastroDeVagas(event));
      
        
        
        
        cadastrarVagas.setVisible(true);


    }

   


     /*Funções de tranferencias de informações da interface*/ 
    private void transfereInforAlocacaoDeVagas(ActionEvent event) {     
       // Verificar e liberar vagas expiradas antes de realizar a alocação
         GerReservas.verificarReservasExpiradas();
       
        valorVeiculo = Excecoes.obterValorString(veiculo);
        valorHorarioEntrada = Excecoes.obterValorInteiro(horarioEntrada);
        
        String id = GerVagas.verificarVagaDisponivel(valorVeiculo);
        /* Ver se existe uma vaga disponível e retorna o id dela */
        if (id != null) {
            if (valorVeiculo != null && valorHorarioEntrada != -1) {
                /* Cria um novo veículo e coloca no arquivo de entrada */
                if (valorVeiculo.equalsIgnoreCase("carro")) {
                    String valorCor = Excecoes.obterValorString(cor);
                    String valorMarca = Excecoes.obterValorString(marca);
                    String valorModelo = Excecoes.obterValorString(modelo);
                    
                    // Valores padrão para campos opcionais
                    valorCor = (valorCor != null) ? valorCor : "Desconhecida";
                    valorMarca = (valorMarca != null) ? valorMarca : "Desconhecida";
                    valorModelo = (valorModelo != null) ? valorModelo : "Desconhecido";
                    
                    Carro novoCarro = new Carro(valorHorarioEntrada, id, valorCor, valorMarca, valorModelo);
                    Controle.registrarEntrada(novoCarro);
                    
                } else if (valorVeiculo.equalsIgnoreCase("caminhao")) {
                    int valorCargaMax = Excecoes.obterValorInteiro(cargaMax);
                    int valorCmpVeiculo = Excecoes.obterValorInteiro(comprimento);
                    
                    // Valores padrão para campos opcionais
                    valorCargaMax = (valorCargaMax != -1) ? valorCargaMax : 0;
                    valorCmpVeiculo = (valorCmpVeiculo != -1) ? valorCmpVeiculo : 0;
                    
                    Caminhao novoCaminhao = new Caminhao(valorHorarioEntrada, id, valorCargaMax, valorCmpVeiculo);
                    Controle.registrarEntrada(novoCaminhao);
                    
                } else if (valorVeiculo.equalsIgnoreCase("moto")) {
                    int valorCilindradas = Excecoes.obterValorInteiro(cilindradas);
                    
                    // Valores padrão para campos opcionais
                    valorCilindradas = (valorCilindradas != -1) ? valorCilindradas : 0;
                    
                    Moto novaMoto = new Moto(valorHorarioEntrada, id, valorCilindradas);
                    Controle.registrarEntrada(novaMoto);
                }else{
                    JOptionPane.showMessageDialog(null, "Seu veiculo não pode estacionar aqui, tente carro,moto ou caminhao!"+ id, "Error", JOptionPane.ERROR_MESSAGE);

                }
            GerVagas.atualizarStatusVaga(id,"ocupada");    
            JOptionPane.showMessageDialog(null, "Parabéns,o id da sua vaga é "+ id, "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Não existe vagas disponíveis para esse veículo", "Falha", JOptionPane.OK_CANCEL_OPTION);
        }
}

   private void transfereInforReservaDeVagas(ActionEvent event) {
        valorVeiculo = Excecoes.obterValorString(veiculo);
        valorHorarioEntrada = Excecoes.obterValorInteiro(horarioEntrada);
        valorTempoReservado=Excecoes.obterValorInteiro(tempoReservado);
        valorNome=Excecoes.obterValorString(nome);
        valorEmail=Excecoes.obterValorString(email);
        valorTelefone=Excecoes.obterValorInteiro(telefone);
        valorVeiculoCliente=Excecoes.obterValorString(veiculo);
        
        String id = GerVagas.verificarVagaDisponivel(valorVeiculo);
        boolean clienteAutorizado=GerClientes.consultarCliente(valorNome,valorTelefone,valorEmail,valorVeiculoCliente);
        if(clienteAutorizado){
            /* Ver se existe uma vaga disponível e retorna o id dela */
            if (id != null) {
                if (valorVeiculo != null && valorHorarioEntrada != -1 && valorTempoReservado != -1) {
                    /* Cria um novo veículo e coloca no arquivo de entrada */
                    if (valorVeiculo.equalsIgnoreCase("carro")) {
                        String valorCor = Excecoes.obterValorString(cor);
                        String valorMarca = Excecoes.obterValorString(marca);
                        String valorModelo = Excecoes.obterValorString(modelo);
                        
                        // Valores padrão para campos opcionais
                        valorCor = (valorCor != null) ? valorCor : "Desconhecida";
                        valorMarca = (valorMarca != null) ? valorMarca : "Desconhecida";
                        valorModelo = (valorModelo != null) ? valorModelo : "Desconhecido";
                        
                        Carro novoCarro = new Carro(valorHorarioEntrada, id, valorCor, valorMarca, valorModelo);
                        GerReservas.reservarVagas(novoCarro,valorTempoReservado);
                        
                    } else if (valorVeiculo.equalsIgnoreCase("caminhao")) {
                        int valorCargaMax = Excecoes.obterValorInteiro(cargaMax);
                        int valorCmpVeiculo = Excecoes.obterValorInteiro(comprimento);
                        
                        // Valores padrão para campos opcionais
                        valorCargaMax = (valorCargaMax != -1) ? valorCargaMax : 0;
                        valorCmpVeiculo = (valorCmpVeiculo != -1) ? valorCmpVeiculo : 0;
                        
                        Caminhao novoCaminhao = new Caminhao(valorHorarioEntrada, id, valorCargaMax, valorCmpVeiculo);
                        GerReservas.reservarVagas(novoCaminhao,valorTempoReservado);                   
                    } else if (valorVeiculo.equalsIgnoreCase("moto")) {
                        int valorCilindradas = Excecoes.obterValorInteiro(cilindradas);
                        
                        // Valores padrão para campos opcionais
                        valorCilindradas = (valorCilindradas != -1) ? valorCilindradas : 0;
                        
                        Moto novaMoto = new Moto(valorHorarioEntrada, id, valorCilindradas);
                        GerReservas.reservarVagas(novaMoto,valorTempoReservado);                   
                    }else{
                        JOptionPane.showMessageDialog(null, "Seu veiculo não pode reservar uma vaga, tente carro,moto ou caminhao!"+ id, "Erro", JOptionPane.ERROR_MESSAGE);
    
                    }
                GerVagas.atualizarStatusVaga(id,"ocupada");    
                JOptionPane.showMessageDialog(null, "Parabéns,o id da sua vaga é "+ id, "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Não existe vagas disponíveis para esse veículo", "Falha", JOptionPane.OK_CANCEL_OPTION);
            }

        }else{
            JOptionPane.showMessageDialog(null, "Cliente não cadastrado!", "Error", JOptionPane.OK_CANCEL_OPTION);

        }
    }

    /*Funções de tranferencias de informações da interface*/ 
    private void transfereInforDeCadastroDeVagas(ActionEvent event) {
        valorLocalizacao=Excecoes.obterValorString(localizacao);
        valorNumero=Excecoes.obterValorInteiro(numero);
        valorStatus=Excecoes.obterValorString(status);  
        valorIdVaga=Excecoes.obterValorString(idVaga);
        valorVeiculo=Excecoes.obterValorString(veiculo);
        if(valorLocalizacao!=null && valorStatus!=null && valorIdVaga!=null && valorVeiculo!=null && valorNumero!=-1){
            GerVagas.cadastrarVagas(valorNumero, valorLocalizacao, valorStatus, valorIdVaga, valorVeiculo);
        } 
    }



}
