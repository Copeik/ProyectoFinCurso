/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.CentrosJpaController;
import Modelo.DirectoresJpaController;
import Modelo.EmpleadosJpaController;
import Modelo.JefesAreaJpaController;
import Modelo.ProveedoresJpaController;
import Modelo.ResponsablesJpaController;
import Entidades.Directores;
import Entidades.Empleados;
import Entidades.JefesArea;
import Entidades.Proveedores;
import Entidades.Responsables;
import Modelo.BienesJpaController;
import Modelo.SolicitudesJpaController;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
//se importa modelo e interfaz
import Vistas.Director;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Carolina
 */
public class DirectoresServices implements ActionListener,MouseListener {

   /** instancia a nuestra interfaz de usuario*/
   Director vistaDirector ;
   /** instancia a nuestro modelo */
   DirectoresJpaController modelo = new DirectoresJpaController();
   EmpleadosJpaController modelo2 = new EmpleadosJpaController();
   SolicitudesJpaController modelo3 = new SolicitudesJpaController();
   ProveedoresJpaController modelo4 = new ProveedoresJpaController();
   //DirectoresJpaController modelo2 = new DirectoresJpaController();
   
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

   /** Se declaran en un ENUM las acciones que se realizan desde la
    * interfaz de usuario VISTA y posterior ejecución desde el controlador
    */
   public enum AccionMVC
   {
       BUSCAR,
       BUSCAR_PROVEEDOR,
       BUSCAR_ORDEN,
       ANADIR_DIRECTOR_PROVEEDOR,
       ANADIR_DIRECTOR_EMPLE,
       MODIFICAR_DIRECTOR,
       ELIMINAR_DIRECTOR,
       MODIFICAR_PROVEEDOR,
       ELIMINAR_PROVEEDOR
   }

   /** Constrcutor de clase
    * @param vistaDirector Instancia de clase interfaz
    */
   public DirectoresServices( Director vistaDirector )
   {
       this.vistaDirector = vistaDirector;
       
   }

   /** Inicia el skin y las diferentes variables que se utilizan */
   public void iniciar()
   {
       // Skin tipo WINDOWS
       try {
           UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
           SwingUtilities.updateComponentTreeUI(vistaDirector);
           vistaDirector.setVisible(true);     
           this.vistaDirector.tablaDirectorOrden.setModel(this.modelo.listarDirectorOrden());
           this.vistaDirector.tablaDirectorEmpleado.setModel(this.modelo2.listarEmpleados());
           this.vistaDirector.TablaSolicitudes.setModel(this.modelo3.listarSolicitudes());
           this.vistaDirector.tablaDirectorProveedor.setModel(this.modelo4.listarProveedores());
           
   
        //this.vistaDirector.jTable2.setModel( this.modelo2.listarDirectores());
       } catch (UnsupportedLookAndFeelException ex) {}
         catch (ClassNotFoundException ex) {}
         catch (InstantiationException ex) {}
         catch (IllegalAccessException ex) {}

       //declara una acción y añade un escucha al evento producido por el componente
       this.vistaDirector.BUSCAR.setActionCommand( "BUSCAR" );
       this.vistaDirector.BUSCAR.addActionListener(this);
       this.vistaDirector.BUSCAR_PROVEEDOR.setActionCommand( "BUSCAR_PROVEEDOR" );
       this.vistaDirector.BUSCAR_PROVEEDOR.addActionListener(this);
       this.vistaDirector.BUSCAR_ORDEN.setActionCommand( "BUSCAR_ORDEN" );
       this.vistaDirector.BUSCAR_ORDEN.addActionListener(this);
       this.vistaDirector.ANADIR_DIRECTOR_EMPLE.setActionCommand( "ANADIR_DIRECTOR_EMPLE" );
       this.vistaDirector.ANADIR_DIRECTOR_EMPLE.addActionListener(this);
       this.vistaDirector.MODIFICAR_DIRECTOR.setActionCommand( "MODIFICAR_DIRECTOR" );
       this.vistaDirector.MODIFICAR_DIRECTOR.addActionListener(this);
       this.vistaDirector.ANADIR_DIRECTOR_PROVEEDOR.setActionCommand( "ANADIR_DIRECTOR_PROVEEDOR" );
       this.vistaDirector.ANADIR_DIRECTOR_PROVEEDOR.addActionListener(this);
       this.vistaDirector.MODIFICAR_PROVEEDOR.setActionCommand( "MODIFICAR_PROVEEDOR" );
       this.vistaDirector.MODIFICAR_PROVEEDOR.addActionListener(this);
       this.vistaDirector.ELIMINAR_PROVEEDOR.setActionCommand( "ELIMINAR_PROVEEDOR" );
       this.vistaDirector.ELIMINAR_PROVEEDOR.addActionListener(this);
        this.vistaDirector.ELIMINAR_DIRECTOR.setActionCommand( "ELIMINAR_DIRECTOR" );
       this.vistaDirector.ELIMINAR_DIRECTOR.addActionListener(this);
       
       
       //declara una acción y añade un escucha al evento producido por el componente
       //this.vista.__AGREGAR_PRODUCTO.setActionCommand( "__AGREGAR_PRODUCTO" );
       //this.vista.__AGREGAR_PRODUCTO.addActionListener(this);
       //declara una acción y añade un escucha al evento producido por el componente
       //this.vista.__ELIMINAR_PRODUCTO.setActionCommand( "__ELIMINAR_PRODUCTO" );
       //this.vista.__ELIMINAR_PRODUCTO.addActionListener(this);

        //añade e inicia el jtable con un DefaultTableModel vacio
        
    }
     @Override
    
    public void mouseClicked(MouseEvent e) {
        if( e.getButton()== 1)//boton izquierdo
        {   
            System.out.println("en el mouseEvent"); 
        }
        System.out.println("en el evento"); 
         throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    } 

   @Override
    public void actionPerformed(ActionEvent e) {
           String mensaje;   
           
           switch ( AccionMVC.valueOf( e.getActionCommand() ) )
        { case BUSCAR:
                mensaje =  vistaDirector.cargoDirector.getSelectedItem().toString();
                //obtiene del modelo los registros en un DefaultTableModel y lo asigna en la vista
               this.vistaDirector.tablaDirectorEmpleado.setModel(this.modelo.listarDirectoresEmpleados(mensaje));               
                break;
           case BUSCAR_PROVEEDOR:
                //obtiene del modelo los registros en un DefaultTableModel y lo asigna en la vista
               this.vistaDirector.tablaDirectorProveedor.setModel(this.modelo.listarDirectorProveedor());               
                break;
            case ANADIR_DIRECTOR_EMPLE:
               mensaje =  vistaDirector.cargoDirector.getSelectedItem().toString();
               if (mensaje.equals("Responsable")){                   
                   Responsables resp = new Responsables();
                   ResponsablesJpaController respJ = new ResponsablesJpaController();
                   resp.setNombre(this.vistaDirector.Director_empleado_nombre.getText());
                   resp.setCodResponsable(Integer.parseInt(this.vistaDirector.Director_empleado_codigo.getText()));
                   resp.setSalario(Integer.parseInt(this.vistaDirector.Director_empleado_salario.getText()));                
                   CentrosJpaController cC = new CentrosJpaController();               
                   resp.setCentro((Integer.parseInt(this.vistaDirector.Director_empleado_centro.getText())));
                   JefesAreaJpaController jC = new JefesAreaJpaController();
                   resp.setJefe(jC.findJefesArea(Integer.parseInt(this.vistaDirector.Director_empleado_jefe.getText())));
                try {
                   respJ.create(resp);
               } catch (Exception ex) {
                   Logger.getLogger(DirectoresServices.class.getName()).log(Level.SEVERE, null, ex);
               }             
                   
               }else if (mensaje.equals("Director")){
                   Directores director = new Directores();
                   DirectoresJpaController directoresJ = new DirectoresJpaController();
                   director.setNombre(this.vistaDirector.Director_empleado_nombre.getText());
                   director.setCodDirector(Integer.parseInt(this.vistaDirector.Director_empleado_codigo.getText()));
                   director.setSalario(Integer.parseInt(this.vistaDirector.Director_empleado_salario.getText()));                
                   CentrosJpaController cC = new CentrosJpaController();               
                   director.setCentro(cC.findCentros(Integer.parseInt(this.vistaDirector.Director_empleado_centro.getText())));
                   try {
                   directoresJ.create(director);
               } catch (Exception ex) {
                   Logger.getLogger(DirectoresServices.class.getName()).log(Level.SEVERE, null, ex);
                   vistaDirector.comprobante.setText("El empleado ya existe");
               }
               }else if (mensaje.equals("Jefe")){
                    JefesArea jefearea = new JefesArea();
                   JefesAreaJpaController jefeareaJ = new JefesAreaJpaController(); 
                   jefearea.setNombre(this.vistaDirector.Director_empleado_nombre.getText());
                   jefearea.setCodJefe(Integer.parseInt(this.vistaDirector.Director_empleado_codigo.getText()));
                   jefearea.setSalario(Integer.parseInt(this.vistaDirector.Director_empleado_salario.getText()));                
                   CentrosJpaController cC = new CentrosJpaController();               
                   jefearea.setCentro(cC.findCentros(Integer.parseInt(this.vistaDirector.Director_empleado_centro.getText())));
                   DirectoresJpaController jC = new DirectoresJpaController();
                   jefearea.setDirector(jC.findDirectores(Integer.parseInt(this.vistaDirector.Director_empleado_jefe.getText())));      
                try {
                   jefeareaJ.create(jefearea);
                   vistaDirector.comprobante.setText("El empleado ya existe");
               } catch (Exception ex) {
                   Logger.getLogger(DirectoresServices.class.getName()).log(Level.SEVERE, null, ex);
               }
               }else{                  
                   Empleados emp = new Empleados();
                   EmpleadosJpaController empJ = new EmpleadosJpaController();                    
                    emp.setNombre(this.vistaDirector.Director_empleado_nombre.getText());
                    emp.setCodEmpleado(Integer.parseInt(this.vistaDirector.Director_empleado_codigo.getText()));
                    emp.setSalario(Integer.parseInt(this.vistaDirector.Director_empleado_salario.getText()));                
                    CentrosJpaController cCc = new CentrosJpaController();               
                    emp.setCentro(cCc.findCentros(Integer.parseInt(this.vistaDirector.Director_empleado_centro.getText())));
                    ResponsablesJpaController rJC = new ResponsablesJpaController(); 
                    emp.setResponsable(rJC.findResponsables(Integer.parseInt(this.vistaDirector.Director_empleado_responsable.getText())));
                    JefesAreaJpaController jJC = new JefesAreaJpaController();
                    emp.setJefeArea(jJC.findJefesArea(Integer.parseInt(this.vistaDirector.Director_empleado_jefe.getText())));
                   try {
                   empJ.create(emp);
                   vistaDirector.comprobante.setText("El empleado ya existe");
               } catch (Exception ex) {
                   Logger.getLogger(DirectoresServices.class.getName()).log(Level.SEVERE, null, ex);
               }
               }         
               break;
           case ANADIR_DIRECTOR_PROVEEDOR:
                Proveedores pro = new Proveedores();
                pro.setNombre(this.vistaDirector.Director_proveedor_nombre.getText());
                pro.setNit(Integer.parseInt(this.vistaDirector.Director_proveedor_nit.getText()));
                pro.setTelefono(this.vistaDirector.Director_proveedor_telefono.getText());                
               ProveedoresJpaController proJ= new ProveedoresJpaController();
           {
               try {
                   proJ.create(pro);
               } catch (Exception ex) {
                   Logger.getLogger(DirectoresServices.class.getName()).log(Level.SEVERE, null, ex);
                   vistaDirector.comprobante.setText("El Proveedor ya existe");
               }
                break;
           }
           case MODIFICAR_DIRECTOR:
               mensaje =  vistaDirector.cargoDirector.getSelectedItem().toString();
               if (mensaje.equals("Responsable")){                   
                   Responsables resp = new Responsables();
                   ResponsablesJpaController respJ = new ResponsablesJpaController();
                   resp.setNombre(this.vistaDirector.Director_empleado_nombre.getText());
                   resp.setCodResponsable(Integer.parseInt(this.vistaDirector.Director_empleado_codigo.getText()));
                   resp.setSalario(Integer.parseInt(this.vistaDirector.Director_empleado_salario.getText()));                
                   CentrosJpaController cC = new CentrosJpaController();               
                   resp.setCentro((Integer.parseInt(this.vistaDirector.Director_empleado_centro.getText())));
                   JefesAreaJpaController jC = new JefesAreaJpaController();
                   resp.setJefe(jC.findJefesArea(Integer.parseInt(this.vistaDirector.Director_empleado_jefe.getText())));
                try {
                   respJ.edit(resp);
               } catch (Exception ex) {
                   Logger.getLogger(DirectoresServices.class.getName()).log(Level.SEVERE, null, ex);
               }             
                   
               }else if (mensaje.equals("Director")){
                   Directores director = new Directores();
                   DirectoresJpaController directoresJ = new DirectoresJpaController();
                   director.setNombre(this.vistaDirector.Director_empleado_nombre.getText());
                   director.setCodDirector(Integer.parseInt(this.vistaDirector.Director_empleado_codigo.getText()));
                   director.setSalario(Integer.parseInt(this.vistaDirector.Director_empleado_salario.getText()));                
                   CentrosJpaController cC = new CentrosJpaController();               
                   director.setCentro(cC.findCentros(Integer.parseInt(this.vistaDirector.Director_empleado_centro.getText())));
                   try {
                   directoresJ.edit(director);
               } catch (Exception ex) {
                   Logger.getLogger(DirectoresServices.class.getName()).log(Level.SEVERE, null, ex);
               }
               }else if (mensaje.equals("Jefe")){
                    JefesArea jefearea = new JefesArea();
                   JefesAreaJpaController jefeareaJ = new JefesAreaJpaController(); 
                   jefearea.setNombre(this.vistaDirector.Director_empleado_nombre.getText());
                   jefearea.setCodJefe(Integer.parseInt(this.vistaDirector.Director_empleado_codigo.getText()));
                   jefearea.setSalario(Integer.parseInt(this.vistaDirector.Director_empleado_salario.getText()));                
                   CentrosJpaController cC = new CentrosJpaController();               
                   jefearea.setCentro(cC.findCentros(Integer.parseInt(this.vistaDirector.Director_empleado_centro.getText())));
                   DirectoresJpaController jC = new DirectoresJpaController();
                   jefearea.setDirector(jC.findDirectores(Integer.parseInt(this.vistaDirector.Director_empleado_director.getText())));      
                try {
                   jefeareaJ.edit(jefearea);
               } catch (Exception ex) {
                   Logger.getLogger(DirectoresServices.class.getName()).log(Level.SEVERE, null, ex);
               }
               }else{                  
                   Empleados emp = new Empleados();
                   EmpleadosJpaController empJ = new EmpleadosJpaController();                    
                    emp.setNombre(this.vistaDirector.Director_empleado_nombre.getText());
                    emp.setCodEmpleado(Integer.parseInt(this.vistaDirector.Director_empleado_codigo.getText()));
                    emp.setSalario(Integer.parseInt(this.vistaDirector.Director_empleado_salario.getText()));                
                    CentrosJpaController cCc = new CentrosJpaController();               
                    emp.setCentro(cCc.findCentros(Integer.parseInt(this.vistaDirector.Director_empleado_centro.getText())));
                    ResponsablesJpaController rJC = new ResponsablesJpaController(); 
                    emp.setResponsable(rJC.findResponsables(Integer.parseInt(this.vistaDirector.Director_empleado_responsable.getText())));
                    JefesAreaJpaController jJC = new JefesAreaJpaController();
                    emp.setJefeArea(jJC.findJefesArea(Integer.parseInt(this.vistaDirector.Director_empleado_jefe.getText())));
                   try {
                   empJ.edit(emp);
               } catch (Exception ex) {
                   Logger.getLogger(DirectoresServices.class.getName()).log(Level.SEVERE, null, ex);
               }
               }         
               break;
            case MODIFICAR_PROVEEDOR:
                Proveedores prov = new Proveedores();
                ProveedoresJpaController proveJ = new ProveedoresJpaController(); 
                prov.setNombre(this.vistaDirector.Director_proveedor_nombre.getText());
                prov.setNit(Integer.parseInt(this.vistaDirector.Director_proveedor_nit.getText()));
                prov.setTelefono(this.vistaDirector.Director_proveedor_telefono.getText());
               try {
                   proveJ.edit(prov);
               } catch (Exception ex) {
                   Logger.getLogger(DirectoresServices.class.getName()).log(Level.SEVERE, null, ex);
               }
                break;
            case ELIMINAR_DIRECTOR:
               mensaje =  vistaDirector.cargoDirector.getSelectedItem().toString();
               if (mensaje.equals("Responsable")){                   
                   Responsables resp = new Responsables();
                   ResponsablesJpaController respJ = new ResponsablesJpaController();
                   resp.setCodResponsable(Integer.parseInt(this.vistaDirector.Director_empleado_codigo.getText()));
                try {
                   respJ.destroy(resp.getCodResponsable());
                           
               } catch (Exception ex) {
                   Logger.getLogger(DirectoresServices.class.getName()).log(Level.SEVERE, null, ex);
               }             
                   
               }else if (mensaje.equals("Director")){
                   Directores director = new Directores();
                   DirectoresJpaController directoresJ = new DirectoresJpaController();
                   director.setCodDirector(Integer.parseInt(this.vistaDirector.Director_empleado_codigo.getText()));
                   try {
                   directoresJ.destroy(director.getCodDirector());
               } catch (Exception ex) {
                   Logger.getLogger(DirectoresServices.class.getName()).log(Level.SEVERE, null, ex);
               }
               }else if (mensaje.equals("Jefe")){
                    JefesArea jefearea = new JefesArea();
                   JefesAreaJpaController jefeareaJ = new JefesAreaJpaController(); 
                   jefearea.setCodJefe(Integer.parseInt(this.vistaDirector.Director_empleado_codigo.getText()));     
                try {
                   jefeareaJ.destroy(jefearea.getCodJefe());
               } catch (Exception ex) {
                   Logger.getLogger(DirectoresServices.class.getName()).log(Level.SEVERE, null, ex);
               }
               }else{                  
                   Empleados emp = new Empleados();
                   EmpleadosJpaController empJ = new EmpleadosJpaController();                    
                    emp.setCodEmpleado(Integer.parseInt(this.vistaDirector.Director_empleado_codigo.getText()));
                   try {
                   empJ.destroy(emp.getCodEmpleado());
               } catch (Exception ex) {
                   Logger.getLogger(DirectoresServices.class.getName()).log(Level.SEVERE, null, ex);
               }
               }         
               break;
            case ELIMINAR_PROVEEDOR:
                Proveedores p = new Proveedores();
                ProveedoresJpaController pJ = new ProveedoresJpaController();
                p.setNombre(this.vistaDirector.Director_proveedor_nombre.getText());
                p.setNit(Integer.parseInt(this.vistaDirector.Director_proveedor_nit.getText()));
                p.setTelefono(this.vistaDirector.Director_proveedor_telefono.getText());
                
               try {
                   pJ.destroy(p.getNit());
               } catch (Exception ex) {
                   Logger.getLogger(DirectoresServices.class.getName()).log(Level.SEVERE, null, ex);
               }
                
                break;
               
               
               
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      }
    
    
    }
     


   
    //Eventos que suceden por el mouse
   /* public void mouseClicked(MouseEvent e) {
        if( e.getButton()== 1)//boton izquierdo
        {
             int fila = this.vista.__tabla_producto.rowAtPoint(e.getPoint());
             if (fila > -1){                
                this.vista.__id_producto.setText( String.valueOf( this.vista.__tabla_producto.getValueAt(fila, 0) ));
                this.vista.__nombre.setText( String.valueOf( this.vista.__tabla_producto.getValueAt(fila, 1) ));
                this.vista.__precio.setText( String.valueOf( this.vista.__tabla_producto.getValueAt(fila, 2) ));
                this.vista.__cantidad.setText( String.valueOf( this.vista.__tabla_producto.getValueAt(fila, 3) ));
             }
        }
    }

    public void mousePressed(MouseEvent e) {}

    public void mouseReleased(MouseEvent e) {}

    public void mouseEntered(MouseEvent e) {}

    public void mouseExited(MouseEvent e) { }
 
    //Control de eventos de los controles que tienen definido un "ActionCommand"
    public void actionPerformed(ActionEvent e) {

    switch ( AccionMVC.valueOf( e.getActionCommand() ) )
        {
            case __VER_PRODUCTOS:
                //obtiene del modelo los registros en un DefaultTableModel y lo asigna en la vista
                this.vista.__tabla_producto.setModel( this.modelo.getTablaProducto() );
                break;
            case __AGREGAR_PRODUCTO:
                //añade un nuevo registro
                if ( this.modelo.NuevoProducto(
                        this.vista.__id_producto.getText(),
                        this.vista.__nombre.getText() ,
                        this.vista.__precio.getText(),
                        this.vista.__cantidad.getText() ) )
                {
                    this.vista.__tabla_producto.setModel( this.modelo.getTablaProducto() );
                    JOptionPane.showMessageDialog(vista,"Exito: Nuevo registro agregado.");
                    this.vista.__id_producto.setText("");
                    this.vista.__nombre.setText("") ;
                    this.vista.__precio.setText("0");
                    this.vista.__cantidad.setText("0") ;
                }
                else //ocurrio un error
                    JOptionPane.showMessageDialog(vista,"Error: Los datos son incorrectos.");
                break;
            case __ELIMINAR_PRODUCTO:
                if ( this.modelo.EliminarProducto( this.vista.__id_producto.getText() ) )
                {
                    this.vista.__tabla_producto.setModel( this.modelo.getTablaProducto() );
                    JOptionPane.showMessageDialog(vista,"Exito: Registro eliminado.");
                    this.vista.__id_producto.setText("");
                    this.vista.__nombre.setText("") ;
                    this.vista.__precio.setText("0");
                    this.vista.__cantidad.setText("0") ;
                }
                break;       
        }
    }
*/
}

