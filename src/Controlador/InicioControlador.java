/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vistas.Director;
import Vistas.Inicio;
import Vistas.JefeArea;
import Vistas.Responsable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import Controlador.DirectoresServices;
import Controlador.JefeAreaControlador;
//import Controlador.ResponsableControlador;


/**
 *
 * @author Laura
 */
public class InicioControlador implements ActionListener,MouseListener {
   public static int responsableG;
   Inicio vista ;
   /** instancia a nuestros modelos */
   Modelo.EmpleadosJpaController modeloEmple = new Modelo.EmpleadosJpaController();
   Modelo.DirectoresJpaController modeloDir = new Modelo.DirectoresJpaController();
   Modelo.JefesAreaJpaController modeloJefe = new Modelo.JefesAreaJpaController();
   Modelo.ResponsablesJpaController modeloRes = new Modelo.ResponsablesJpaController();

   //guardamos el usuario para uso posterior
   public static int usuarioLog;
   
   public enum AccionMVC
    {
        _INICIAR_SESION
    }
   
   public InicioControlador( Inicio vista )
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
           //System.out.println("antes");
                   
            //System.out.println("despues");           
        } catch (UnsupportedLookAndFeelException ex) {}
         catch (ClassNotFoundException ex) {}
         catch (InstantiationException ex) {}
         catch (IllegalAccessException ex) {}
       
       //declaramos acciones y se les añade las escuchas de los eventos
       this.vista.InicioSesion.setActionCommand("_INICIAR_SESION");
       this.vista.InicioSesion.addActionListener(this);
       
       //this.vista.jButton39.setActionCommand("_LOGOUT");
       //this.vista.jButton39.addActionListener(this);
       
       //this.vista.TablaSolicitudes.addMouseListener(this);
}
   
   
    @Override
    public void actionPerformed(ActionEvent e) {
        String mensaje;
        
        if(AccionMVC.valueOf( e.getActionCommand() ) == AccionMVC._INICIAR_SESION ){
            mensaje =  vista.cargoInicio.getSelectedItem().toString();
        switch (mensaje) 
        {
         //vamos comprobando el tiempo de trabajador que es para que se meta en su pantalla
        case "Director":
            if (modeloDir.findDirectores(Integer.parseInt(vista.Usuario.getText()))!=null){
                vista.dispose();
                Director vd =new Director();
                new DirectoresServices(vd).iniciar();
                 
            }else{
                JOptionPane.showMessageDialog(vista,"Usuario no encontrado");
            }
            break;
            
        case "Responsable":
            
            if (modeloRes.findResponsables(Integer.parseInt(vista.Usuario.getText()))!=null){
                vista.dispose();
                Responsable vr =new Responsable();
                new ResponsableControlador(vr).iniciar() ;
                responsableG=Integer.parseInt(vista.Usuario.getText());
            }else{
                JOptionPane.showMessageDialog(vista,"Usuario no encontrado");
            }
            break;
            
             
        case "Jefe":
            
            if (modeloJefe.findJefesArea(Integer.parseInt(vista.Usuario.getText()))!=null){
                vista.dispose();
                JefeArea vj =new JefeArea();
                new JefeAreaControlador(vj).iniciar() ;
                 
            }else{
                JOptionPane.showMessageDialog(vista,"Usuario no encontrado");
            }
            break;
                                   
        default:
            JOptionPane.showMessageDialog(vista,"Usted no tiene permiso para acceder");
            break;
             
             //new DirectorControlador(v).iniciar() ;
         /*}else if (modeloJefe.findJefesArea(Integer.parseInt(vista.Usuario.getText()))!=null){
             JefeArea v =new JefeArea();
             new JefeAreaControlador(v).iniciar() ;
         }else if (modeloRes.findResponsables(Integer.parseInt(vista.Usuario.getText()))!=null){
             Responsable v =new Responsable();
             //new ResponsableControlador(v).iniciar() ;
         }else if (modeloEmple.findEmpleados(Integer.parseInt(vista.Usuario.getText()))!=null){
             JOptionPane.showMessageDialog(vista,"Usted no tiene permiso para acceder");
         }else{
             JOptionPane.showMessageDialog(vista,"Usuario no encontrado");
         }*/
        }   
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mousePressed(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    
    
}
