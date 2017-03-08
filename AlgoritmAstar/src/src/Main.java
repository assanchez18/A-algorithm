/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package src;

/**
 *
 * @author sergio.sanchez.ruiz
 */


public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        Algoritmo algoritmo = new Algoritmo();
        algoritmo.inicializa();
        algoritmo.algoritmo();
    }
}
/*
    public static void setMapa(int numFilas, int numColumnas){
        mapa = new String[numFilas][numColumnas];}
    public String[][]getMapa(){
        return mapa;
    }
    public static void setCamino(Punto punto){
        camino[camino.length] = punto;
    }
    public Punto[] getCamino(){
        return camino;}
    public static void setProhibidas(Punto punto){
        prohibidas[prohibidas.length] = punto;}
    public Punto[] getProhibidas(){
        return prohibidas;}
    public static void setDudosas(Punto punto){
        dudosas[dudosas.length] = punto;}
    public Punto[] getDudosas(Punto punto){
        return dudosas;}
    public static void setOrigen(Punto punto){
        origen = punto;}
    public Punto getOrigen(){
        return origen;}
    public static void setDestino(Punto punto){
        destino = punto;}
    public Punto getDestino(){
        return destino;}
*/
  

