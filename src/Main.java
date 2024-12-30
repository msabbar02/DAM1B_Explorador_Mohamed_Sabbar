//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Mapa mapa = new Mapa();
        Explorador explorador = new Explorador("Jugador");

        Posicion posJugador = explorador.getPosicionActual();
        mapa.getTablero()[posJugador.getCoordenadaFila()][posJugador.getCoordenadaCol()] = 'J';

        System.out.println("                    ************************************");
        System.out.println("                    Bienvenido al juego del Explorador");
        System.out.println("                    ************************************");
        mapa.mostrar();
    }
}