package design_de_telas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;


public class TelaDesign extends JFrame{
    
    public static void criarTela(JFrame tela,String titulo,int larguraTela,int alturaTela,int btFechar,int linha,int coluna, int hgap, int vgap){
        /*Configurações da janela */
        tela.setTitle("Estacionamento");
        tela.setSize(larguraTela,alturaTela);
        tela.setDefaultCloseOperation(btFechar);
        tela.setLocationRelativeTo(null);
        /*Layouts */
        tela.setLayout(new GridLayout(linha, coluna,hgap,vgap));
        tela.setFont(new Font("Times New Roman ", Font.BOLD, 20));
        tela.setForeground(new Color(237,241,238));
        tela.setBackground(new Color(70,130,180));
      
      // tela.setLayout(new BorderLayout());
        /*Fundo da tela */
        tela.setBackground(new Color(176,196,222));
        
    }
    public static JPanel criarPanel( int larguraPanel, int alturaPanel){
        JPanel panel= new JPanel(new FlowLayout((int) LEFT_ALIGNMENT));
        panel.setPreferredSize(new Dimension(larguraPanel,alturaPanel));
      
        return panel;
    }

    public static JLabel criarLegenda(String legenda, int tamanhoFonte ,int alinhamento){
        JLabel genericaLegenda=new JLabel(legenda,alinhamento);
        genericaLegenda.setFont(new Font("Times New Roman ", Font.BOLD, tamanhoFonte));
        return genericaLegenda;
    }
     
    public static JLabel criarLegenda(String legenda, int tamanhoFonte){
        JLabel genericaLegenda=new JLabel(legenda);
        genericaLegenda.setFont(new Font("Times New Roman ", Font.BOLD, tamanhoFonte));
        return genericaLegenda;
    }

    public static JRadioButton criarCheckBox(String opcao, int tamanhoFonte){
        JRadioButton genericoCheckBox=new JRadioButton(opcao);
        genericoCheckBox.setFont(new Font("Arial", Font.BOLD, tamanhoFonte));
        genericoCheckBox.setFocusPainted(false);      
        return genericoCheckBox;
    }

    public static JButton criarButton(String nome, int tamanhoFonte){
        JButton genericoButton=new JButton(nome);
        genericoButton.setFont(new Font("Times New Roman ", Font.BOLD, tamanhoFonte));
        genericoButton.setForeground(new Color(237,241,238));
        genericoButton.setBackground(new Color(70,130,180));
        genericoButton.setFocusPainted(false);
        return genericoButton;
    }

    public static JTextField criarInput(String legenda,int tamanhoFonte,JFrame tela){
        Box genericaCaixa= Box.createHorizontalBox();
        JLabel genericaLegenda=TelaDesign.criarLegenda(legenda, tamanhoFonte);
        JTextField genericoInput=new JTextField();
        genericaCaixa.add(genericaLegenda);
        genericaCaixa.add(genericoInput);
        tela.add(genericaCaixa);
        return genericoInput;

    }

    public static JTextField criarInput(String legenda,int tamanhoFonte,JPanel tela){
    Box genericaCaixa= Box.createHorizontalBox();
    JLabel genericaLegenda=TelaDesign.criarLegenda(legenda, tamanhoFonte);
    JTextField genericoInput=new JTextField();
    genericaCaixa.add(genericaLegenda);
    genericaCaixa.add(genericoInput);
    tela.add(genericaCaixa);
    return genericoInput;

    }
}
