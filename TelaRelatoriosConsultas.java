
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import design_de_telas.TelaDesign;
import relatorios_e_consultas.RelatoriosConsultas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class TelaRelatoriosConsultas extends JFrame implements ActionListener{
        JPanel infoVeiculos;
        JPanel entradasVeiculos;
        JLabel historico;
        
 
    public TelaRelatoriosConsultas(){
        TelaDesign.criarTela(this, "Relatórios e Consultas",800,500,2,5, 1,10,10);
        JLabel legenda=TelaDesign.criarLegenda("Qual ação deseja realizar?", 20,0);
        JButton relatorioOcupacao=TelaDesign.criarButton("Relatório de Ocupação", 20);
        JButton historicoVeiculos=TelaDesign.criarButton("Histórico de Entrada e Saída de Veiculos", 20);
        JButton relatorioFinanceiro=TelaDesign.criarButton("Relatório Finaceiro", 20);
        

        this.add(legenda);
        this.add(relatorioOcupacao);
        this.add(historicoVeiculos);
        this.add(relatorioFinanceiro);
  

        relatorioOcupacao.addActionListener(this);
        relatorioFinanceiro.addActionListener(this::abrirTelaRelatorioFinanceiro);
        historicoVeiculos.addActionListener(this::abrirTelaHistoricoVeiculos);


        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        /*Criando a tela */
        JFrame relatorioOcupacao= new JFrame();
        TelaDesign.criarTela(relatorioOcupacao, "Relatório de Ocupação", 800, 500, 2, 2, 2, 5, 5);
        RelatoriosConsultas.relatorioDeOcupacao(relatorioOcupacao);

        relatorioOcupacao.setVisible(true);
       
    }
    public void abrirTelaRelatorioFinanceiro(ActionEvent e) {
         /*Criando a tela */
        JFrame relatorioFinanceiro= new JFrame();
        TelaDesign.criarTela(relatorioFinanceiro, "Relatório Financeiro", 800, 500, 2, 4, 2, 5, 5);
        RelatoriosConsultas.relatorioFinanceiro(relatorioFinanceiro);
        relatorioFinanceiro.setVisible(true);
    }
    public void abrirTelaHistoricoVeiculos(ActionEvent e) {
        int qtVeiculos=2;
        /*Criando a tela */
        JFrame relatorioFinanceiro= new JFrame();
        TelaDesign.criarTela(relatorioFinanceiro, "Histórico", 800, 500, 2, qtVeiculos, 1, 5, 5);
        RelatoriosConsultas.consultarHistoricoVeiculos(relatorioFinanceiro);
        relatorioFinanceiro.setVisible(true);
    }
    





}
