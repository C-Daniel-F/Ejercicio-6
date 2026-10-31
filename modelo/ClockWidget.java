package modelo;

import javax.swing.*;
import java.awt.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class ClockWidget implements Widget,Renderizable{
private boolean formato24Horas;
private int id;

public ClockWidget(){
this(5);
}

public ClockWidget(int id){
this.id=id;
this.formato24Horas=true;
}

public void mostrarHora(){
System.out.println("Hora actual: "+obtenerHora());
}

private String obtenerHora(){
String patron=formato24Horas?"HH:mm:ss":"hh:mm:ss a";
return LocalTime.now().format(DateTimeFormatter.ofPattern(patron));
}

@Override
public int getId(){
return id;
}

@Override
public String getNombre(){
return "ClockWidget";
}

@Override
public int getMemoriaKB(){
return 50;
}

@Override
public void mostrar(){
mostrarHora();
}

@Override
public JComponent obtenerVista(){
JPanel panel=new JPanel(new BorderLayout());
panel.setBorder(BorderFactory.createTitledBorder("Reloj"));
JLabel etiqueta=new JLabel(obtenerHora(),SwingConstants.CENTER);
etiqueta.setFont(new Font("Arial",Font.BOLD,26));

Timer timer=new Timer(1000,e->etiqueta.setText(obtenerHora()));
timer.start();

panel.add(etiqueta,BorderLayout.CENTER);
return panel;
}
}
