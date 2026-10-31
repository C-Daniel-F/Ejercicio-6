package vista;

import javax.swing.*;
import java.awt.*;

public class DashboardVista extends JFrame{
private JPanel panelWidgets;
private JButton botonOrdenar;
private JButton botonBuscar;
private JButton botonInteractuar;
private JTextField campoId;

public DashboardVista(){
setTitle("Dashboard de Widgets");
setSize(900,650);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setLocationRelativeTo(null);
setLayout(new BorderLayout());

panelWidgets=new JPanel(new GridLayout(0,2,10,10));
JScrollPane scroll=new JScrollPane(panelWidgets);

JPanel menu=new JPanel();
campoId=new JTextField(5);
botonBuscar=new JButton("Buscar ID");
botonInteractuar=new JButton("Interactuar");
botonOrdenar=new JButton("Ordenar por memoria");

menu.add(new JLabel("ID:"));
menu.add(campoId);
menu.add(botonBuscar);
menu.add(botonInteractuar);
menu.add(botonOrdenar);

add(menu,BorderLayout.NORTH);
add(scroll,BorderLayout.CENTER);
}

public JPanel getPanelWidgets(){
return panelWidgets;
}

public JButton getBotonOrdenar(){
return botonOrdenar;
}

public JButton getBotonBuscar(){
return botonBuscar;
}

public JButton getBotonInteractuar(){
return botonInteractuar;
}

public String getIdIngresado(){
return campoId.getText();
}

public void mostrarMensaje(String mensaje){
JOptionPane.showMessageDialog(this,mensaje);
}
}
