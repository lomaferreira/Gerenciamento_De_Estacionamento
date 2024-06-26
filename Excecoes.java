import java.util.InputMismatchException;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Excecoes {
    
    public static int obterValorInteiro(JTextField inteiro){
        int num=-1;
        try{
            num=Integer.parseInt(inteiro.getText());
        }catch(NumberFormatException exception){
            JOptionPane.showMessageDialog(null,"Valor inválido, digite um número inteiro positivo!","Error",JOptionPane.WARNING_MESSAGE);

        }
        return num;
    }

    public static String obterValorString(JTextField string){
        String str=null;
        try{
            str=string.getText().toLowerCase();
        }catch(InputMismatchException exception){
            JOptionPane.showMessageDialog(null,"Valor inválido!","Error",JOptionPane.WARNING_MESSAGE);

        }
        return str; 
    }


}
