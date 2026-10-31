package controlador;

import modelo.*;
import vista.DashboardVista;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Dashboard{
private List<Widget> widgets;
private DashboardVista vista;

public Dashboard(){
widgets=new ArrayList<>();
vista=new DashboardVista();

vista.getBotonOrdenar().addActionListener(e->ordenarPorMemoria());

vista.getBotonBuscar().addActionListener(e->{
try{
int id=Integer.parseInt(vista.getIdIngresado());
buscarPorId(id);
}catch(NumberFormatException ex){
vista.mostrarMensaje("Ingresa un ID válido");
}
});

vista.getBotonInteractuar().addActionListener(e->{
try{
int id=Integer.parseInt(vista.getIdIngresado());
interactuarWidget(id);
}catch(NumberFormatException ex){
vista.mostrarMensaje("Ingresa un ID válido");
}
});
}

public void inicializar(){
agregarWidget(new WeatherWidget(1,"Guatemala",25));
agregarWidget(new WeatherWidget(2,"Antigua",22));

TaskWidget tareas1=new TaskWidget(3);
tareas1.agregarTarea("Estudiar Java");
tareas1.agregarTarea("Hacer tarea");
tareas1.agregarTarea("Revisar proyecto");
agregarWidget(tareas1);

TaskWidget tareas2=new TaskWidget(4);
tareas2.agregarTarea("Preparar presentación");
tareas2.agregarTarea("Enviar informe");
agregarWidget(tareas2);

agregarWidget(new AlertWidget(5,"Alerta urgente","Alta"));
agregarWidget(new AlertWidget(6,"Revisar sistema","Media"));
agregarWidget(new ClockWidget(7));
agregarWidget(new ClockWidget(8));
agregarWidget(new QuoteWidget(9,"Nunca dejes de aprender","Anonimo"));
agregarWidget(new QuoteWidget(10,"Sigue adelante","Anonimo"));
}

public void agregarWidget(Widget w){
widgets.add(w);
}

public void mostrarWidgets(){
JPanel panel=vista.getPanelWidgets();
panel.removeAll();

for(Widget w:widgets){
if(w instanceof Renderizable){
JPanel contenedor=new JPanel(new java.awt.BorderLayout());
contenedor.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
JLabel titulo=new JLabel("ID: "+w.getId()+" | "+w.getNombre()+" | "+w.getMemoriaKB()+" KB");
contenedor.add(titulo,java.awt.BorderLayout.NORTH);
contenedor.add(((Renderizable)w).obtenerVista(),java.awt.BorderLayout.CENTER);
panel.add(contenedor);
}
}

panel.revalidate();
panel.repaint();
}

public void buscarPorId(int id){
for(Widget w:widgets){
if(w.getId()==id){
vista.mostrarMensaje("ID: "+w.getId()+"\nNombre: "+w.getNombre()+"\nMemoria: "+w.getMemoriaKB()+" KB");
return;
}
}
vista.mostrarMensaje("Widget no encontrado");
}

public void interactuarWidget(int id){
for(Widget w:widgets){
if(w.getId()==id){
if(w instanceof Interactivo){
((Interactivo)w).interactuar();
mostrarWidgets();
vista.mostrarMensaje("Interacción realizada");
}else{
vista.mostrarMensaje("Este widget no es interactivo");
}
return;
}
}
vista.mostrarMensaje("Widget no encontrado");
}

public void ordenarPorMemoria(){
Collections.sort(widgets);
mostrarWidgets();
}

public void mostrar(){
mostrarWidgets();
vista.setVisible(true);
}
}
