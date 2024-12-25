import java.util.Random;

public class Enemigo {
    // Costantes
    private final int ARRIBA = 1;
    private final int ABAJO = 2;
    private final int DERECHA = 3;
    private final int IZQUIERDA = 4;

    // Atributos
    private Posicion posicionActual;

    // COnstructor
    public Enemigo(){
        Random random = new Random();
        posicionActual = new Posicion(random.nextInt(6), random.nextInt(20));
    }

    // Metodo moverse

    public void moverse(){
        int direccion = (int)(Math.random() * 4) + 1;
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
    }

    public Posicion getPosicionActual() {
        return posicionActual;
    }

    public void setPosicionActual(Posicion posicionActual) {
        this.posicionActual = posicionActual;
    }
}
