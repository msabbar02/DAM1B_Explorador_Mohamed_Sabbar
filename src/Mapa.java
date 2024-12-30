import java.awt.*;
import java.util.Random;

public class Mapa {
    // Atributos
    private char [][] tablero;
    private Posicion posTesoro;
    private Posicion posJugador;
    private Enemigo [] listadoEnemigos;
    private Posicion [] posicionTramapas;

    //Constructor
    public Mapa(){

        tablero = new char[6][20];
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 20; j++) {
                tablero[i][j] = ' ';
            }
        }

        //tesoro
        Random rand = new Random();
        posTesoro = new Posicion(rand.nextInt(6),rand.nextInt(20));
        tablero[posTesoro.getCoordenadaFila()][posTesoro.getCoordenadaCol()] = ' ';

        // trampas
        posicionTramapas = new Posicion[3];
        for (int i = 0; i < 3; i++) {
            Posicion trampa;
            do {
                trampa = new Posicion(rand.nextInt(6), rand.nextInt(20) );
            }while (tablero[trampa.getCoordenadaFila()][trampa.getCoordenadaCol()] != ' ');
            posicionTramapas[i] = trampa;
            tablero[trampa.getCoordenadaFila()][trampa.getCoordenadaCol()] = 'T';
        }

        // Enemigo
        listadoEnemigos = new Enemigo[3];
        for (int i = 0; i < 3; i++) {
            Enemigo enemigo;
            do {
                enemigo = new Enemigo();
            }while (tablero[enemigo.getPosicionActual().getCoordenadaFila()][enemigo.getPosicionActual().getCoordenadaCol()] != ' ');
            listadoEnemigos[i] = enemigo;
            tablero[enemigo.getPosicionActual().getCoordenadaFila()][enemigo.getPosicionActual().getCoordenadaCol()] = 'E';
        }
    }
    // Getters Y Setters
    public char[][] getTablero() {
        return tablero;
    }

    public Posicion getPosTesoro() {
        return posTesoro;
    }

    // metodo Mostrar

    public void mostrar(){
        for (int i = 0; i < 6; i++) {
            System.out.println("----------------------------------------------------------------------------------");
            for (int j = 0; j < 20; j++) {
                System.out.print("| "+ tablero[i][j] + " ");
            }
            System.out.println(" |");
        }
        System.out.println("-----------------------------------------------------------------------------------");
    }


}
