import com.sdm.cliente.RMICliente;
import com.sdm.view.frmprincipal.FrmPrincipal;
import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args){
       try{

           RMICliente.start("localhost", 1099);

           FrmPrincipal tela = new FrmPrincipal();
           tela.setVisible(true);

       } catch (Exception e){
       e.printStackTrace();
       JOptionPane.showMessageDialog(null,
               "Erro ao conectar ao servidor RMI:\n" + e.getMessage());
       }
    }
}