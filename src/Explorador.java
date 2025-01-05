import javax.swing.*;

public class Explorador {
    // costantes
    private final int ARRIBA = 1;
    private final int ABAJO = 2;
    private final int DERECHA = 3;
    private final int IZQUIERDA = 4;

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

    public void moverse(int direccion){
        if (direccion >= 1 && direccion <= 4){
            switch (direccion){
                case ARRIBA :
                    if (posicionActual.getCoordenadaFila() > 0) posicionActual.setCoordenadaFila(posicionActual.getCoordenadaFila() - 1);
                    break;
                case ABAJO :
                    if (posicionActual.getCoordenadaFila() < 5) posicionActual.setCoordenadaFila(posicionActual.getCoordenadaFila() + 1);
                    break;
                case DERECHA :
                    if (posicionActual.getCoordenadaCol() < 19) posicionActual.setCoordenadaCol(posicionActual.getCoordenadaCol() + 1);
                    break;
                case IZQUIERDA :
                    if (posicionActual.getCoordenadaCol() > 0) posicionActual.setCoordenadaCol(posicionActual.getCoordenadaCol() - 1);
            }
        }else {
            JOptionPane.showMessageDialog(null,"Direccion no valida.","Error",JOptionPane.ERROR_MESSAGE);
        }
    }


}
