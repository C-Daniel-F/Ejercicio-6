package modelo;

import javax.swing.*;
import java.awt.*;

public class WeatherWidget implements Widget,Renderizable,Interactivo{
private String ciudad;
private double temperatura;
private boolean fahrenheit;
private int id;

public WeatherWidget(String ciudad,double temperatura){
this(1,ciudad,temperatura);
}

public WeatherWidget(int id,String ciudad,double temperatura){
this.id=id;
this.ciudad=ciudad;
this.temperatura=temperatura;
this.fahrenheit=false;
}

public void mostrarTemperatura(){
if(fahrenheit){
double tempF=(temperatura*9/5)+32;
System.out.println(tempF+" °F");
}else{
System.out.println(temperatura+" °C");
}
}

public void cambiarUnidad(){
fahrenheit=!fahrenheit;
}

public String getCiudad(){
return ciudad;
}

@Override
public int getId(){
return id;
}

@Override
public String getNombre(){
return "WeatherWidget";
}

@Override
public int getMemoriaKB(){
return 100;
}

@Override
public void mostrar(){
System.out.println("Ciudad: "+ciudad);
mostrarTemperatura();
}

@Override
public void interactuar(){
cambiarUnidad();
}

@Override
public JComponent obtenerVista(){
JPanel panel=new JPanel(new BorderLayout(5,5));
panel.setBorder(BorderFactory.createTitledBorder("Clima: "+ciudad));
JLabel etiqueta=new JLabel("",SwingConstants.CENTER);
JButton boton=new JButton("Cambiar °C / °F");

Runnable actualizar=()->{
if(fahrenheit){
etiqueta.setText(((temperatura*9/5)+32)+" °F");
}else{
etiqueta.setText(temperatura+" °C");
}
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
