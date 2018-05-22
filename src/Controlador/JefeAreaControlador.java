/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.EmpleadosJpaController;
import Modelo.SolicitudesJpaController;
import Vistas.Inicio;

import Vistas.JefeArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Laura
 */
public class JefeAreaControlador implements ActionListener,MouseListener  {
    
   JefeArea vista ;
   
   /** instancia a nuestro modelo */
   EmpleadosJpaController modelo = new EmpleadosJpaController();
   
   SolicitudesJpaController modeloSol = new SolicitudesJpaController();

   //declaramos el enum para las acciones de los botones
   public enum AccionMVC
    {
        _LOGOUT,
        _AUTORIZAR
    }
   
   
   //constructor
   public JefeAreaControlador( JefeArea vista )
   {
       //System.out.println("antes");
       this.vista = vista;
       
   }
   
   
   public void iniciar()
   {
       // Skin tipo WINDOWS
       try {
           UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
           SwingUtilities.updateComponentTreeUI(vista);
           vista.setVisible(true);
           System.out.println("antes");
             
           //llamamos a la vista de la pestaña emleados y cargamos la tabla
           this.vista.TablaEmpleados.setModel(this.modelo.listarEmpleados());
           //llamamos a la vista de la pestaña solicitudes y cargamos la tabla
           this.vista.TablaSolicitudes.setModel(this.modeloSol.listarSolicitudes());
           
            System.out.println("despues");           
//this.vista.jTable2.setModel( this.modelo2.listarDirectores());
       } catch (UnsupportedLookAndFeelException ex) {}
         catch (ClassNotFoundException ex) {}
         catch (InstantiationException ex) {}
         catch (IllegalAccessException ex) {}
       
       //declaramos acciones y se les añade las escuchas de los eventos
       this.vista.AutorizarSolicitud.setActionCommand("_AUTORIZAR");
       this.vista.AutorizarSolicitud.addActionListener(this);
       
       this.vista.jButton39.setActionCommand("_LOGOUT");
       this.vista.jButton39.addActionListener(this);
       
       this.vista.TablaSolicitudes.addMouseListener(this);
       //this.vista.TablaSolicitudes.setModel( this.modeloSol.listarSolicitudes() );
}
   
   @Override
   public void mouseClicked(MouseEvent e) {
        if( e.getButton()== 1)//boton izquierdo
        {
             int fila = this.vista.TablaSolicitudes.rowAtPoint(e.getPoint());
             if (fila > -1){                
                this.vista.AutorizarCod.setText( String.valueOf( this.vista.TablaSolicitudes.getValueAt(fila, 0) ));
                
             }
        }
    }
   
   
   @Override
    public void actionPerformed(ActionEvent e) {
        switch ( AccionMVC.valueOf( e.getActionCommand() ) ){
            case _LOGOUT:
                //vuelve a la vista de inicio
                vista.setVisible(false);
                Inicio in =new Inicio();
                new InicioControlador(in).iniciar() ;
                //vista.dispose();
                //Vistas.Inicio.setVisible(true);
                
                break;
            case _AUTORIZAR:
                
                
                if(modeloSol.findSolicitudes(Integer.parseInt(this.vista.AutorizarCod.getText())).getAprobada()==0){
                    //modeloSol.findSolicitudes(Integer.parseInt(this.vista.AutorizarCod.getText())).setAprobada(1);
                    modeloSol.autorizar(Integer.parseInt(this.vista.AutorizarCod.getText()));
                    this.vista.TablaSolicitudes.setModel(this.modeloSol.listarSolicitudes());
                    System.out.println("autorizado");
                }else{
                    this.vista.AutorizarCod.setText("Solicitud no encontrada");
                }
                
                    
                break;
                
        }
 //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    

    
    

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    
    
    
    
    
    
    
    
    
}