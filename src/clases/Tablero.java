package clases;

import java.util.ArrayList;
import java.util.List;

public class Tablero {
    private List<Integer> tablero;

    
    public Tablero() {
        this.tablero = new ArrayList<Integer>();
        for (int i=0; i<9; i++) {
            this.tablero.add(0);
        }
    }
    
    public int size() {
        return tablero.size();
    }
    
    public void insertarFicha(int posicion, int ficha) {
        this.tablero.set(posicion, ficha);
    }
    
    public int conseguirFichaPosicion(int posicion) {
        return this.tablero.get(posicion);
    }
    
    public boolean celdaVacia (int posicion) {
        return (0==this.tablero.get(posicion));
    }
    
    public void borrarFicha(int posicion) {
        this.tablero.set(posicion, 0);
    }
    
    public boolean posicionValida(int posicion) {
        return (posicion>=0 && posicion<=8);
    }
    
    @Override
    public String toString() {
        return  "Referencia de Casillas \n"
                + "[ " + "0" + " " + "1" + " " + "2" + " ]\n"
                + "[ " + "3" + " " + "4" + " " + "5" + " ]\n"
                + "[ " + "6" + " " + "7" + " " + "8" + " ]\n"
                + "*****************************************\n"
                + "\tTABLERO ACTIVO \n"
                + "\t[ " + this.tablero.get(0) + " " + this.tablero.get(1) + " " + this.tablero.get(2) + " ]\n"
                + "\t[ " + this.tablero.get(3) + " " + this.tablero.get(4) + " " + this.tablero.get(5) + " ]\n"
                + "\t[ " + this.tablero.get(6) + " " + this.tablero.get(7) + " " + this.tablero.get(8) + " ]\n"
                + "*****************************************\n";
    }

    public boolean existeGanador() {
            boolean condFilas = hayGanadorFila1(tablero)||hayGanadorFila2(tablero)||hayGanadorFila3(tablero);       
            boolean condColumnas = hayGanadorColumna1(tablero)||hayGanadorColumna2(tablero)||hayGanadorColumna3(tablero);    
            boolean condDiagonales = hayGanadorDiagoPrin(tablero)||hayGanadorDiagoInver(tablero);        
            return (condFilas||condColumnas||condDiagonales);
    }
    
    private static boolean hayGanadorFila1(List<Integer> tablero) {
        boolean condicion1 = tablero.get(0)==tablero.get(1);
        boolean condicion2 = tablero.get(1)==tablero.get(2);
        boolean condicion3 = tablero.get(1)==0;
        return (condicion1 && condicion2 && !condicion3);
    }
    
    private static boolean hayGanadorFila2(List<Integer> tablero) {
        boolean condicion1 = tablero.get(3)==tablero.get(4);
        boolean condicion2 = tablero.get(4)==tablero.get(5);
        boolean condicion3 = tablero.get(4)==0;
        return (condicion1 && condicion2 && !condicion3);    
    }
    
    private static boolean hayGanadorFila3(List<Integer> tablero) {
        boolean condicion1 = tablero.get(6)==tablero.get(7);
        boolean condicion2 = tablero.get(7)==tablero.get(8);
        boolean condicion3 = tablero.get(7)==0;
        return (condicion1 && condicion2 && !condicion3);
    }
    
    private static boolean hayGanadorColumna1(List<Integer> tablero) {
        boolean condicion1 = tablero.get(0)==tablero.get(3);
        boolean condicion2 = tablero.get(3)==tablero.get(6);
        boolean condicion3 = tablero.get(3)==0;
        return (condicion1 && condicion2 && !condicion3);
    }
    
    private static boolean hayGanadorColumna2(List<Integer> tablero) {
        boolean condicion1 = tablero.get(1)==tablero.get(4);
        boolean condicion2 = tablero.get(4)==tablero.get(7);
        boolean condicion3 = tablero.get(4)==0;
        return (condicion1 && condicion2 && !condicion3);
    }
    
    private static boolean hayGanadorColumna3(List<Integer> tablero) {
        boolean condicion1 = tablero.get(2)==tablero.get(5);
        boolean condicion2 = tablero.get(5)==tablero.get(8);
        boolean condicion3 = tablero.get(5)==0;
        return (condicion1 && condicion2 && !condicion3);
    }
    
    private static boolean hayGanadorDiagoPrin(List<Integer> tablero) {
        boolean condicion1 = tablero.get(0)==tablero.get(4);
        boolean condicion2 = tablero.get(4)==tablero.get(8);
        boolean condicion3 = tablero.get(4)==0;
        return (condicion1 && condicion2 && !condicion3);
    }
    
    private static boolean hayGanadorDiagoInver(List<Integer> tablero) {
        boolean condicion1 = tablero.get(2)==tablero.get(4);
        boolean condicion2 = tablero.get(4)==tablero.get(6);
        boolean condicion3 = tablero.get(4)==0;
        return (condicion1 && condicion2 && !condicion3);
    }
    
    
    

}
