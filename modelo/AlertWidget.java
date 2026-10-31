package modelo;

import javax.swing.*;
import java.awt.*;

public class AlertWidget implements Widget,Renderizable,Interactivo{
private String mensaje;
private String prioridad;
private boolean leida;
private int id;

public AlertWidget(String mensaje,String prioridad){
this(3,mensaje,prioridad);
}

public AlertWidget(int id,String mensaje,String prioridad){
this.id=id;
this.mensaje=mensaje;
this.prioridad=prioridad;
this.leida=false;
}

public void marcarLeida(){
leida=true;
}

@Override
public int getId(){
return id;
}

@Override
public String getNombre(){
return "AlertWidget";
}

@Override
public int getMemoriaKB(){
return 100;
}

@Override
public void mostrar(){
System.out.println("Alerta: "+mensaje);
System.out.println("Prioridad: "+prioridad);
System.out.println("Leida: "+leida);
}

@Override
public void interactuar(){
marcarLeida();
}

@Override
public JComponent obtenerVista(){
JPanel panel=new JPanel(new BorderLayout(5,5));
panel.setBorder(BorderFactory.createTitledBorder("Alerta"));
JLabel etiqueta=new JLabel("",SwingConstants.CENTER);
JButton boton=new JButton("Marcar como leída");

Runnable actualizar=()->{
etiqueta.setText("<html><center>"+mensaje+"<br>Prioridad: "+prioridad+"<br>Leída: "+(leida?"Sí":"No")+"</center></html>");
boton.setEnabled(!leida);
};

actualizar.run();

boton.addActionListener(e->{
interactuar();
actualizar.run();
});

panel.add(etiqueta,BorderLayout.CENTER);
panel.add(boton,BorderLayout.SOUTH);
return panel;
}
}
