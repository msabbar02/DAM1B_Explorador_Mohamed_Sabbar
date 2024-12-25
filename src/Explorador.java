public class Explorador {
    // costantes
    private final int ARRIBA = 1;
    private final int ABAJO = 2;
    private final int IZQUIERDA = 3;
    private final int DERECHA = 4;
    // atributos
    private String nombre ;
    private Posicion posicionActual;

    // constructor
    public Explorador(String queNombre){
        this.nombre = queNombre;
        int fila = (int)(Math.random() * 6);
        this.posicionActual = new Posicion(fila,0);
    }
    // getter y setter
    public String getNombre() {
        return nombre;
    }

    public Posicion getPosicionActual() {
        return posicionActual;
    }

    public void setPosicionActual(Posicion posicionActual) {
        this.posicionActual = posicionActual;
    }

    // Metodo moverse

    public void moverse(int direccon){
        switch (direccon){

        }
    }


}
