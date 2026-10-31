package modelo;

public interface Widget extends Comparable<Widget>{
int getId();
String getNombre();
int getMemoriaKB();

@Override
default int compareTo(Widget otro){
return Integer.compare(getMemoriaKB(),otro.getMemoriaKB());
}
}
