import java.util.Random;

public class Mapa {
    // Atributos
    private char [][] tablero;
    private Posicion posTesoro;
    private Posicion posJugador;
    private Enemigo [] listadoEnemigos;
    private Posicion [] posicionTramapas;

    //Constructor
    public Mapa(Posicion posJugador){

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
            enemigo.moverse();
            tablero[enemigo.getPosicionActual().getCoordenadaFila()][enemigo.getPosicionActual().getCoordenadaCol()] = 'E';
        }

        this.posJugador = posJugador;
        tablero[posJugador.getCoordenadaFila()][posJugador.getCoordenadaCol()] = 'J';


    }
    // Getters Y Setters
    public char[][] getTablero() {
        return tablero;
    }

    public Posicion getPosTesoro() {
        return posTesoro;
    }

    public Enemigo[] getListadoEnemigos() {
        return listadoEnemigos;
    }
    // metodo Mostrar

    public void mostrar(){
        for (int i = 0; i < 6; i++) {
            System.out.println("----------------------------------------------------------------------------------");
            for (int j = 0; j < 20; j++) {
                char c = tablero[i][j];
                String color;
                switch(c){
                    case 'J': color = "\u001B[34m";break;
                    case 'T': color = "\u001B[32m";break;
                    case 'E': color = "\u001B[33m";break;
                    case '*': color = "\u001B[31m";break;
                    default:color = "\u001B[0m";
                }
                System.out.print("\u001B[35m | " + color + c + "\u001B[0m");
            }
            System.out.println(" |");
        }
        System.out.println("----------------------------------------------------------------------------------");
    }

    public boolean actualizarExplorador(Posicion antiguaPosicion) {
        if (tablero[antiguaPosicion.getCoordenadaFila()][antiguaPosicion.getCoordenadaCol()] == 'T' ||
                tablero[antiguaPosicion.getCoordenadaFila()][antiguaPosicion.getCoordenadaCol()] == 'E' ||
                tablero[antiguaPosicion.getCoordenadaFila()][antiguaPosicion.getCoordenadaCol()] == '*') {
            return false; // Juego terminado
        }
        tablero[antiguaPosicion.getCoordenadaFila()][antiguaPosicion.getCoordenadaCol()] = ' ';
        tablero[posJugador.getCoordenadaFila()][posJugador.getCoordenadaCol()] = 'J';
        return true;

    }




}
