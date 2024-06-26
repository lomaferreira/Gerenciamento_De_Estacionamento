import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import design_de_telas.TelaDesign;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;;
public class TelaInicial extends JFrame implements ActionListener{
    
    public TelaInicial(){
        /*Criando a tela */
        TelaDesign.criarTela(this,"Gerenciamento de Estacionamento",800,500,3,5,1,10,10);
        JLabel titulo=TelaDesign.criarLegenda("BEM VINDO!", 40,0);
        JButton estacionamento=TelaDesign.criarButton("Estacionamento", 20);
        JButton gerClientes=TelaDesign.criarButton("Gerenciamento de Clientes", 20);
        JButton pagamentos=TelaDesign.criarButton("Realizar Pagamentos", 20);
        JButton relatorioConsultas=TelaDesign.criarButton("Relatório e Consultas", 20);

        this.add(titulo);
        this.add(estacionamento);
        this.add(gerClientes);
        this.add(pagamentos);
        this.add(relatorioConsultas);

         /*Ouvintes */
        estacionamento.addActionListener(this);
        gerClientes.addActionListener(this::abrirTelaCliente);
        relatorioConsultas.addActionListener(this::abrirTelarelatorioConsultas);
        pagamentos.addActionListener(this::abrirTelaPagamentos);
        this.setVisible(true);
    }
     
    @Override
    public void actionPerformed(ActionEvent e) {
         new TelaEstacionamento();
    }
     /*Funções dos Ouvintes */
    public void abrirTelaCliente(ActionEvent e) {
        new TelaGerClientes();
    }
    
     public void abrirTelarelatorioConsultas(ActionEvent e) {
        new TelaRelatoriosConsultas();
    }
    public void abrirTelaPagamentos(ActionEvent e) {
        new TelaPagamentos();
    }
    
    
    
    
    
    
    
    
    
    
    
    
   
    
}
