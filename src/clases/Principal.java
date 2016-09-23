package clases;

import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        Tablero tablero = new Tablero();
        int[] contFichasJugador1={0};
        int[] contFichasJugador2={0};
        
        while(!tablero.existeGanador()) {
            System.out.println(tablero.toString());
            turnoJugador(1,contFichasJugador1,tablero);
            System.out.println(tablero.toString());
            if (tablero.existeGanador())
                break;
            turnoJugador(2,contFichasJugador2,tablero);
            System.out.println(tablero.toString());
        }
        
        System.out.println("JUEGO TERMINADO, HAY UN GANADOR");     
    }
    
    public static int pedirPosicion() {
        Scanner teclado = new Scanner(System.in);
        int pos = teclado.nextInt();
        return pos;
    }
    
    public static void turnoJugador(int jugador, int[] contFichasJugador, Tablero tablero) {
        System.out.println("TURNO JUGADOR " + jugador);
        if (contFichasJugador[0]<3) {
            int pos = 0;
            do {
                System.out.println("Indica una posicion en la que poner tu ficha: ");
                pos = pedirPosicion();
            } while(!tablero.celdaVacia(pos));
            tablero.insertarFicha(pos, jugador);
            contFichasJugador[0]++;
        } else {
            int pos = 0;
            do {
                System.out.println("Indica una posicion para quitar una ficha: ");
                pos = pedirPosicion();
            } while(tablero.celdaVacia(pos)||(tablero.conseguirFichaPosicion(pos)!=jugador));
            tablero.borrarFicha(pos);
            contFichasJugador[0]--;
            pos = 0;
            do {
                System.out.println("Indica una posicion en la que poner tu ficha: ");
                pos = pedirPosicion();
            } while(!tablero.celdaVacia(pos));
            tablero.insertarFicha(pos, jugador);
            contFichasJugador[0]++;
        }
    }

}
