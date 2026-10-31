import controlador.Dashboard;
import javax.swing.SwingUtilities;

public class Main{
public static void main(String[] args){
SwingUtilities.invokeLater(()->{
Dashboard dashboard=new Dashboard();
dashboard.inicializar();
dashboard.mostrar();
});
}
}
