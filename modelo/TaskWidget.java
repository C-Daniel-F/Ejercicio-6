package modelo;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class TaskWidget implements Widget,Renderizable,Interactivo{
private ArrayList<String> tareas;
private ArrayList<Boolean> completadas;
private int siguiente;
private int id;

public TaskWidget(){
this(2);
}

public TaskWidget(int id){
this.id=id;
tareas=new ArrayList<>();
completadas=new ArrayList<>();
siguiente=0;
}

public void agregarTarea(String tarea){
tareas.add(tarea);
completadas.add(false);
}

public void mostrarTareas(){
for(int i=0;i<tareas.size();i++){
if(completadas.get(i)){
System.out.println("[X] "+tareas.get(i));
}else{
System.out.println("[ ] "+tareas.get(i));
}
}
}

public void completarTarea(){
if(siguiente<tareas.size()){
completadas.set(siguiente,true);
siguiente++;
}
}

@Override
public int getId(){
return id;
}

@Override
public String getNombre(){
return "TaskWidget";
}

@Override
public int getMemoriaKB(){
return 100;
}

@Override
public void mostrar(){
mostrarTareas();
}

@Override
public void interactuar(){
completarTarea();
}

@Override
public JComponent obtenerVista(){
JPanel panel=new JPanel(new BorderLayout(5,5));
panel.setBorder(BorderFactory.createTitledBorder("Tareas"));
JTextArea texto=new JTextArea(6,20);
texto.setEditable(false);
JButton boton=new JButton("Completar tarea");

Runnable actualizar=()->{
String contenido="";
for(int i=0;i<tareas.size();i++){
contenido+=(completadas.get(i)?"[X] ":"[ ] ")+tareas.get(i)+"\n";
}
texto.setText(contenido);
};

actualizar.run();

boton.addActionListener(e->{
interactuar();
actualizar.run();
});

panel.add(new JScrollPane(texto),BorderLayout.CENTER);
panel.add(boton,BorderLayout.SOUTH);
return panel;
}
}