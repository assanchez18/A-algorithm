/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1;


  

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

/**
 *
 * @author usuario_local
 */
public class Algoritmo {
    
    private String[][]      mapa;
    private Vector<Punto>   camino;
    private double          costeCamino;
    private Vector<Punto>   prohibidas;
    private Vector<Punto>   dudosas;
    private Punto           destino;
    private Punto           origen;
    private Punto           situacionActual;
    private int             cuadriculas;
    private int             numFilas;
    private int             columnas;
    private double          caminoMinimo;
    private enum            Movimiento {inicial, norte, norEste, este, surEste, sur, surOeste, oeste, norOeste };
    
    
    public boolean algoritmo(){
       boolean terminado = false;
       camino.add(origen);
       Vector<Punto> nodosPosibles = new Vector();
       double coste = 0.0;
       do{
          situacionActual = camino.elementAt(camino.size()-1); 
          nodosPosibles = siguienteNodo(situacionActual); //a donde se puede mover desde donde está
          coste = calculaCoste(situacionActual, nodosPosibles);
          
          if (coste == -1)
              return true;
          else 
              caminoMinimo += coste;
          
       }while(camino.size() < 10 && !terminado);
       return false;
    }
 
    public double distanciaEntreDosPuntos(Punto origen, Punto destino){
        double distancia = 0.0;
        distancia = (double) Math.sqrt(Math.pow((origen.getX()-destino.getX()),2)
                                     + Math.pow(origen.getY()-destino.getY(),2));
        
        return distancia;
    }
    public void inicializa() throws FileNotFoundException, IOException{
        
        try{
            numFilas    =   0;
            columnas    =   0;
            camino      =   new Vector();
            prohibidas  =   new Vector();
            dudosas     =   new Vector();
            mapa        =   new String[100][100];
            cargaMapa("./mapa.txt");
            origen      =   new Punto(0,0);
            destino     =   new Punto(5,2);

        }catch(IOException e){
            throw new IOException (e.getMessage());
        }
    }
    
    public double calculaCoste(Punto ubicacion, Vector<Punto> nodosPosibles){
        double coste = 0.0;
        double costeMinimo = 0.0;
        Punto mejorPunto = null;
        if(situacionActual == destino)
            return -1;
        else{
            for (Punto p : nodosPosibles){
                coste = distanciaEntreDosPuntos(ubicacion, p);
                if (coste < costeMinimo){
                    costeMinimo = coste;
                    mejorPunto = p;
                }
            }
            camino.add(mejorPunto);
        }
        return costeMinimo;
    }
    
    public void cargaMapa(String archivo) throws FileNotFoundException, IOException {
        String cadena;
        FileReader file = new FileReader(archivo);
        BufferedReader buffer = new BufferedReader(file);
        int i = 0;
        String[] aux;
        Punto punto;
        int columnas = 0;
        String[][] mapaAux;
        try{
            while((cadena = buffer.readLine())!=null) {
                aux = cadena.split(" ");
         
                for (int j = 0; j < aux.length; j++) {
                    //System.out.println("j: " + j + "  " + aux[j]);
                    if (aux[j].equalsIgnoreCase("X")){
                        punto = new Punto(i,j);
                        prohibidas.add(punto);
                    }
                    mapa[i][j] = aux[j];
                    columnas = j;
                    cuadriculas++;
                }
                //System.out.println("fila: " + i + "  " + mapa[i][0] + " " + mapa[i][1] + " " + mapa[i][2] + " " + mapa[i][3] + " " + mapa[i][4]);
                i++;
            }
            columnas = cuadriculas/i;
            
            mapaAux = new String[i][columnas];
            System.out.println("filas: " + i + "   columnas: " + (columnas));
            
            numFilas = 0;
            while (numFilas < i){
                for(int j= 0; j < columnas;j++){
                        mapaAux[numFilas][j] = mapa[numFilas][j];
                }
                //System.out.println(cuadriculas);
                numFilas++;
            }
            mapa = mapaAux;
            
        }
        catch (IOException e){
            throw new IOException ("Error al cargar el mapa." + e.getMessage());
        }
        buffer.close();
    }
    public Vector<Punto> siguienteNodo(Punto posicionActual){
        Vector<Punto> posiblesNodos = new Vector();
        Punto posible;
        Movimiento ultimoMovimiento = Movimiento.inicial;
        switch(ultimoMovimiento){
            case norte:
                compruebaMovimientoNorte(posicionActual);
                break;
            case sur:
                break;
            case este:
                break;
            case oeste:
                break;
                 case norEste:
                break;
            case surEste:
                break;
            case norOeste:
                break;
            case surOeste:
                break;
            case inicial:
                break;

        }
        
        return posiblesNodos;
    }


    public boolean compruebaMovimientoNorte(Punto posicionActual){
        if(posicionActual.getY()+1 < numFilas)
            return true;
        else return false;
    }
    public boolean compruebaMovimientoSur(Punto posicionActual){
        if(posicionActual.getY()-1 < numFilas)
            return true;
        else return false;
    }
    public boolean compruebaMovimientoEste(Punto posicionActual){
        if(posicionActual.getX()+1 < columnas)
            return true;
        else return false;
    }
    public boolean compruebaMovimientoOeste(Punto posicionActual){
        if(posicionActual.getX()-1 < columnas)
            return true;
        else return false;
    }

    void compruebaMovimiento(Punto posicionActual){
    Vector<Punto> posiblesNodos = new Vector();
    Punto posible;
    if(posicionActual.getY()+1 < numFilas ){
            posible = new Punto(posicionActual.getX(), posicionActual.getY()+1);
            posiblesNodos.add(posible);   // norte

            if(posicionActual.getX()+1 < columnas){
                posible = new Punto(posicionActual.getX()+1, posicionActual.getY()+1);
                posiblesNodos.add(posible); //norEste
            }
            if(posicionActual.getX()-1 > -1){
                posible = new Punto(posicionActual.getX()-1, posicionActual.getY()+1);
                posiblesNodos.add(posible); //norOeste
            }
        }

        if(posicionActual.getX()+1 < columnas){
            posible = new Punto(posicionActual.getX()+1, posicionActual.getY());
            posiblesNodos.add(posible); //Este
        }

        if(posicionActual.getX()-1 > -1){
            posible = new Punto(posicionActual.getX()-1, posicionActual.getY());
            posiblesNodos.add(posible); //Oeste
        }

        if(posicionActual.getY()-1 > -1 ){
            posible = new Punto(posicionActual.getX(), posicionActual.getY()-1);
            posiblesNodos.add(posible);   // sur

            if(posicionActual.getX()+1 < columnas){
                posible = new Punto(posicionActual.getX()+1, posicionActual.getY()-1);
                posiblesNodos.add(posible); //surEste
            }
            if(posicionActual.getX()-1 > -1){
                posible = new Punto(posicionActual.getX()-1, posicionActual.getY()-1);
                posiblesNodos.add(posible); //surOeste
            }
        }
    }

}