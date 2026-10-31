package modelo;

import javax.swing.*;
import java.awt.*;

public class QuoteWidget implements Widget,Renderizable{
private String frase;
private String autor;
private int id;

public QuoteWidget(String frase,String autor){
this(6,frase,autor);
}

public QuoteWidget(int id,String frase,String autor){
this.id=id;
this.frase=frase;
this.autor=autor;
}

public void mostrarFrase(){
System.out.println("Frase: "+frase);
System.out.println("Autor: "+autor);
}

@Override
public int getId(){
return id;
}

@Override
public String getNombre(){
return "QuoteWidget";
}

@Override
public int getMemoriaKB(){
return 30;
}

@Override
public void mostrar(){
mostrarFrase();
}

@Override
public JComponent obtenerVista(){
JPanel panel=new JPanel(new BorderLayout(5,5));
panel.setBorder(BorderFactory.createTitledBorder("Frase del día"));
JLabel etiqueta=new JLabel("<html><center>"+frase+"<br><br>Autor: "+autor+"</center></html>",SwingConstants.CENTER);
panel.add(etiqueta,BorderLayout.CENTER);
return panel;
}
}
