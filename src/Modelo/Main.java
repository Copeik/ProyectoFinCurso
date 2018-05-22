/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;
import Controlador.InicioControlador;
import Vistas.Inicio;

import Vistas.Responsable;

public class Main {
   
   public static void main(String[] args) {
       //ejecuta el controlador y este la vista
       Inicio ja =new Inicio();
       new InicioControlador(ja).iniciar() ;
   }

}
    
