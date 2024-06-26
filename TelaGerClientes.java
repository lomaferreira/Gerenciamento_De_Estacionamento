import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import design_de_telas.TelaDesign;
import gerenciamento_clientes.GerClientes;

public class TelaGerClientes  extends JFrame implements ActionListener {
    JLabel legenda;
    JButton cadastrar;
    JTextField nome;
    JTextField telefone;
    JTextField email;
    JTextField veiculo;



    JLabel lgInforClientes;
    JTextField novoNome;
    JTextField novoTelefone;
    JTextField novoEmail;
    JTextField novoVeiculo;
    JButton bgAtualizar;

    String valorNome;
    int valorTelefone;
    String valorEmail;
    String valorVeiculo;
    String valorNovoNome;
    int valorNovoTelefone;
    String valorNovoEmail;
    String valorNovoVeiculo;
    public TelaGerClientes(){
        TelaDesign.criarTela(this, "Gerenciamento de Clientes",800,500,2,5, 1,10,10);
        JLabel legenda=TelaDesign.criarLegenda("Qual ação deseja realizar?", 20,0);
        JButton cadastrarClientes=TelaDesign.criarButton("Cadastrar Clientes", 20);
        JButton clientesCadastrados=TelaDesign.criarButton("Atualizar Cadastros", 20);
        
        this.add(legenda);
        this.add(cadastrarClientes);
        this.add(clientesCadastrados);

        /*Ouvinte */
        cadastrarClientes.addActionListener(this);
        clientesCadastrados.addActionListener(this::abrirTelaAtualizarClientes);


        this.setVisible(true); 
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        /*Criando a tela */
        JFrame cadastrarClientes= new JFrame();
        TelaDesign.criarTela(cadastrarClientes, "Cadastro de Clientes", 800, 500, 2, 6, 1, 5, 5);
        
        /*Criando os componentes */
        legenda=TelaDesign.criarLegenda("Preencha as informações do cliente:", 20);
        cadastrar=TelaDesign.criarButton("Cadastrar", 20);
        
        /*Adicionando componentes na tela */
        cadastrarClientes.add(legenda);
         nome= TelaDesign.criarInput("Nome:  ", 15, cadastrarClientes);  
         telefone= TelaDesign.criarInput("Telefone:  ", 15, cadastrarClientes);  
         email= TelaDesign.criarInput("Email:  ", 15, cadastrarClientes);  
         veiculo= TelaDesign.criarInput("Veículo:  ", 15, cadastrarClientes);  
        cadastrarClientes.add(cadastrar);

        cadastrar.addActionListener((ActionEvent event) -> transfereInforCadastroClientes(event));
        cadastrarClientes.setVisible(true);
  
    }



    public void abrirTelaAtualizarClientes(ActionEvent e) {

        /*Criando a tela */
        JFrame atualizarClientes= new JFrame();
        TelaDesign.criarTela(atualizarClientes, "Clientes Cadastrados", 800, 500, 2, 10, 1, 5, 5);
        
        /*Criando os componentes */
        legenda=TelaDesign.criarLegenda("Preencha as informações do cliente:", 20);
        lgInforClientes=TelaDesign.criarLegenda("Atualize as informações do cliente:", 20);
        bgAtualizar=TelaDesign.criarButton("Atualizar", 20);
        
        /*Adicionando componentes na tela */
        atualizarClientes.add(legenda);
        atualizarClientes.add(lgInforClientes);
         nome= TelaDesign.criarInput("Nome:  ", 15, atualizarClientes);  
         novoNome= TelaDesign.criarInput("Nome novo:  ", 15, atualizarClientes);  
         telefone= TelaDesign.criarInput("Telefone:  ", 15, atualizarClientes);  
        
        /*Adicionando componentes na tela */
         novoEmail= TelaDesign.criarInput("Email novo:  ", 15, atualizarClientes);  
         email= TelaDesign.criarInput("Email:  ", 15, atualizarClientes);  
         novoTelefone= TelaDesign.criarInput("Telefone novo:  ", 15, atualizarClientes);  
         veiculo= TelaDesign.criarInput("Veículo:  ", 15, atualizarClientes);  
         novoVeiculo= TelaDesign.criarInput("Veículo novo:  ", 15, atualizarClientes);  
        atualizarClientes.add(bgAtualizar);

        bgAtualizar.addActionListener((ActionEvent event) -> transfereInforAtualizaçãoClientes(event));



        atualizarClientes.setVisible(true);
    }

    private void transfereInforAtualizaçãoClientes(ActionEvent event) {
        valorNome=Excecoes.obterValorString(nome);
        valorEmail=Excecoes.obterValorString(email);
        valorTelefone=Excecoes.obterValorInteiro(telefone);
        valorVeiculo=Excecoes.obterValorString(veiculo);

        valorNovoNome=Excecoes.obterValorString(novoNome);
         valorNovoEmail=Excecoes.obterValorString(novoEmail);
        valorNovoTelefone=Excecoes.obterValorInteiro(novoTelefone);
        valorNovoVeiculo=Excecoes.obterValorString(novoVeiculo);

        if(valorNome!=null &&valorEmail!=null&&valorVeiculo!=null&&valorTelefone!=-1 ){
            if(valorNovoNome!=null &&valorNovoEmail!=null&&valorNovoVeiculo!=null&&valorNovoTelefone!=-1 ){
               boolean clienteAtualizado= GerClientes.atualizarCliente(valorNome,valorTelefone,valorEmail,valorVeiculo,valorNovoNome,valorNovoTelefone,valorNovoEmail,valorNovoVeiculo);
                if(clienteAtualizado){
                    JOptionPane.showMessageDialog(null, "Cliente atualizado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        
        }
     

    }

    private void transfereInforCadastroClientes(ActionEvent event) {
         valorNome=Excecoes.obterValorString(nome);
         valorEmail=Excecoes.obterValorString(email);
        valorTelefone=Excecoes.obterValorInteiro(telefone);
         valorVeiculo=Excecoes.obterValorString(veiculo);

        if(valorNome!=null &&valorEmail!=null&&valorVeiculo!=null&&valorTelefone!=-1 ){
            GerClientes.cadastrarClientes(valorNome,valorTelefone,valorEmail,valorVeiculo);

        }
    }
    

}
