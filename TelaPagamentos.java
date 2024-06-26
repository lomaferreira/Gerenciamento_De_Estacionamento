import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import design_de_telas.TelaDesign;
import gerenciamento_pagamentos.GerPagamento;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;;

public class TelaPagamentos extends JFrame implements ActionListener{

    JTextField pagamento;
    JTextField tipoPagamento;
    JTextField idVaga;
    JTextField horarioSaida;

    int valorPagamento;
    String valorTipoPagamento;
    String valorIdVaga;
    int valorHorarioSaida;


    public TelaPagamentos(){
        /*Criando a tela */
        TelaDesign.criarTela(this, "Pagamentos",800,500,2,10,1,10,10);
        
        /*Criando os componentes */
        JLabel legenda=TelaDesign.criarLegenda("Qual a forma de pagamento?", 20);
        JButton bgPagar=TelaDesign.criarButton("Pagar", 20);
        
        /*Adicionando componentes na tela */
        this.add(legenda);
        tipoPagamento= TelaDesign.criarInput("Tipo de Pagamento:  ", 15, this);  
        pagamento= TelaDesign.criarInput("Digite o valor:  ", 15, this);
        idVaga= TelaDesign.criarInput("Id da Vaga:  ", 15, this);
        horarioSaida= TelaDesign.criarInput("Digite o horario de saida:  ", 15, this);

        this.add(bgPagar);
        
        
        
        /*Ouvinte*/
        bgPagar.addActionListener(this);
        
        
        
        
        this.setVisible(true);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        /*Obtém input já tratados */
        valorPagamento=Excecoes.obterValorInteiro(pagamento);
        valorIdVaga=Excecoes.obterValorString(idVaga);
        valorTipoPagamento=Excecoes.obterValorString(tipoPagamento);
        valorHorarioSaida=Excecoes.obterValorInteiro(horarioSaida);

        GerPagamento.pagar(valorPagamento, valorIdVaga, valorTipoPagamento,valorHorarioSaida);


       
    }

    public void exibirReciboPagamento(String[] arr){
        System.out.println("TESTE");
    }
}
