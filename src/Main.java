import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);;
        System.out.println("                   \u001B[33m **************************************");
        System.out.println("                     \u001B[33m Bienvenido al juego del Explorador");
        System.out.println("                    \u001B[33m**************************************\u001B[0m");
        System.out.print("introduce el nombre del Explorador: ");
        String nombre = sc.nextLine();
        Explorador explorador = new Explorador(nombre);
        Mapa mapa = new Mapa(explorador.getPosicionActual());


        boolean juegoEncurso = true;
        while (juegoEncurso){
            mapa.mostrar();
            System.out.print("\nElige una direccion para moverte: ");
            System.out.println("\u001B[31m1.Arriba\u001B[0m | \u001B[32m2.Abajo\u001B[0m | \u001B[33m3.Derecha\u001B[0m | \u001B[34m4.Izquierda");
            int direccion = sc.nextInt();
            Posicion antiguaPosicion = new Posicion(explorador.getPosicionActual().getCoordenadaFila(), explorador.getPosicionActual().getCoordenadaCol());
            explorador.moverse(direccion);


            char celda = mapa.getTablero()[explorador.getPosicionActual().getCoordenadaFila()][explorador.getPosicionActual().getCoordenadaCol()];
            if (celda == 'T'){
                System.out.println("\u001B[31m has caido en una trampa . Has perdido.\u001B[0m");
                juegoEncurso = false;
                continue;
            } else if (celda == 'E') {
                System.out.println("\u001B[31m¡Un enemigo te atrapó! Has perdido.\u001B[0m");
                juegoEncurso = false;
                continue;
            } else if (antiguaPosicion.equals(mapa.getPosTesoro())) {
                System.out.println("\u001B[32m¡Felicidades! Has encontrado el tesoro. ¡Has ganado!\u001B[0m");
                juegoEncurso = false;
                continue;
            }
            for (Enemigo enemigo : mapa.getListadoEnemigos()) {
                if (enemigo.getPosicionActual().equals(explorador.getPosicionActual())) {
                    System.out.println("\u001B[31mUn enemigo te atrapó después de moverse. Has perdido.\u001B[0m");
                    juegoEncurso = false;
                    break;
                }
            }
            mapa.actualizarExplorador(antiguaPosicion);
        }

        System.out.println("Gracias por jugar.");
        }

}