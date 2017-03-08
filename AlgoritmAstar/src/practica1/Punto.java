/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package practica1;

/**
 *
 * @author sergio.sanchez.ruiz
 */


 public class Punto{
        private double coordX;
        private double coordY;

        public Punto(){}
        public Punto (double x, double y){
            coordX = x;
            coordY = y;
        }

        public double getX(){
            return coordX;}

        public double getY(){
            return coordY;}

        public void setX(double x){
            coordX = x;}

        public void setY(double y){
            coordY = y;}
 }
   
