/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import static Controlador.InicioControlador.responsableG;
import Modelo.BienesJpaController;
import Modelo.EmpleadosJpaController;
import Modelo.SolicitudesJpaController;
import Vistas.Responsable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import Entidades.Bienes;
import Entidades.Facturas;
import Entidades.FacturasPK;
import Entidades.Proveedores;
import Entidades.Solicitudes;
import Modelo.FacturasJpaController;
import Modelo.ProveedoresJpaController;
import Modelo.ResponsablesJpaController;
import Modelo.exceptions.IllegalOrphanException;
import Modelo.exceptions.NonexistentEntityException;
import Vistas.Inicio;
import java.security.Timestamp;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author papa
 */
public class ResponsableControlador implements ActionListener,MouseListener  {
    Responsable vista ;
   /** instancia a nuestro modelo */
   ResponsablesJpaController responsable = new ResponsablesJpaController();
   EmpleadosJpaController modelo = new EmpleadosJpaController();
   BienesJpaController modelo2 = new BienesJpaController();
   SolicitudesJpaController modelo3 = new SolicitudesJpaController();
   BienesJpaController modelo4 = new BienesJpaController();
   ProveedoresJpaController modelo5 = new ProveedoresJpaController();
   FacturasJpaController modelo6 = new FacturasJpaController();
   //BOTONES
   ArrayList<Bienes> bienes=new ArrayList<Bienes>();
   ArrayList<Integer> x= new ArrayList<Integer>();
   ArrayList<Facturas> y= new ArrayList<Facturas>();
   ArrayList<FacturasPK> y2= new ArrayList<FacturasPK>();
   public enum AccionMVC
    {
        ItemBuscar,
        ItemAñadir,
        ItemEliminar,
        ItemModificar,
        LogOut,
        SolicitudAniadirItem,
        SolicitudEliminar,
        SolicitudCrear
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
        
    
    

    public ResponsableControlador( Responsable vista )
   {
       System.out.println("antes");
       this.vista = vista;
       
   }
    @Override
    public void mouseClicked(MouseEvent e) {
        if( e.getButton()== 1)//boton izquierdo
        {
             int fila = this.vista.TablaItem.rowAtPoint(e.getPoint());
             if (fila > -1 && vista.TablaItem.isFocusable()){                
                this.vista.Codigo_Item.setText( String.valueOf( this.vista.TablaItem.getValueAt(fila, 0) ));
                this.vista.Nombre_Item.setText( String.valueOf( this.vista.TablaItem.getValueAt(fila, 1) ));
                this.vista.Proveedor.setText( String.valueOf( this.vista.TablaItem.getValueAt(fila, 2) ));
                this.vista.Valor_Unitario.setText( String.valueOf( this.vista.TablaItem.getValueAt(fila, 3) ));
             }
             int fila2 = this.vista.TablaSolicitudes.rowAtPoint(e.getPoint());
             if (fila2 > -1 && vista.TablaSolicitudes.isFocusable()){                
                this.vista.SolELI.setText( String.valueOf( this.vista.TablaSolicitudes.getValueAt(fila2, 0) ));
             }
        }
    }
    public void iniciar()
   {
               //declara una acción y añade un escucha al evento producido por el componente
        this.vista.ItemAñadir.setActionCommand("ItemAñadir");
        this.vista.ItemAñadir.addActionListener(this);
        //declara una acción y añade un escucha al evento producido por el componente
        this.vista.ItemBuscar.setActionCommand( "ItemBuscar" );
        this.vista.ItemBuscar.addActionListener(this);
        //declara una acción y añade un escucha al evento producido por el componente
        this.vista.ItemEliminar.setActionCommand( "ItemEliminar" );
        this.vista.ItemEliminar.addActionListener(this);
        //
        this.vista.ItemModificar.setActionCommand( "ItemModificar" );
        this.vista.ItemModificar.addActionListener(this);
        //
        this.vista.SolicitudAniadirItem.setActionCommand( "SolicitudAniadirItem" );
        this.vista.SolicitudAniadirItem.addActionListener(this);
        //
        this.vista.SolicitudCrear.setActionCommand( "SolicitudCrear" );
        this.vista.SolicitudCrear.addActionListener(this);
        //
        this.vista.SolicitudEliminar.setActionCommand( "SolicitudEliminar" );
        this.vista.SolicitudEliminar.addActionListener(this);  
        //
        this.vista.LogOut.setActionCommand( "LogOut" );
        this.vista.LogOut.addActionListener(this); 
        //
            //Eventos que suceden por el mouse
        this.vista.TablaItem.setModel( new DefaultTableModel() );
        this.vista.TablaItem.addMouseListener(this);
        
        this.vista.TablaSolicitudes.setModel( new DefaultTableModel() );
        this.vista.TablaSolicitudes.addMouseListener(this);

// Skin tipo WINDOWS
       try {
           UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
           SwingUtilities.updateComponentTreeUI(vista);
           vista.setVisible(true);
           System.out.println("antes");
              
           this.vista.TablaEmpleados.setModel(this.modelo.listarEmpleados());
            System.out.println("despues");   
           this.vista.TablaItem.setModel(this.modelo2.listarItems());
            System.out.println("despues");  
           this.vista.TablaSolicitudes.setModel(this.modelo3.listarSolicitudes());
            System.out.println("despues");  
//this.vista.jTable2.setModel( this.modelo2.listarDirectores());
       } catch (UnsupportedLookAndFeelException ex) {}
         catch (ClassNotFoundException ex) {}
         catch (InstantiationException ex) {}
         catch (IllegalAccessException ex) {}
}
    //Control de eventos de los controles que tienen definido un "ActionCommand"
    public void actionPerformed(ActionEvent e) {

    switch ( AccionMVC.valueOf( e.getActionCommand() ) )
        {
            case ItemAñadir:
                Bienes b=new Bienes(Integer.parseInt(vista.Codigo_Item.getText()));
                b.setNombre(vista.Nombre_Item.getText());
                b.setProveedor(modelo5.findProveedores(Integer.parseInt(vista.Proveedor.getText())));
                b.setCaracter("dasda");
                b.setValorUnitario(1);
    
        try {
            modelo4.create(b);
            vista.Text.setText("Sucefully");
            this.vista.TablaItem.setModel(this.modelo2.listarItems());
        } catch (Exception ex) {
            Logger.getLogger(ResponsableControlador.class.getName()).log(Level.SEVERE, null, ex);
            vista.Text.setText("Item no creado");
        }
    
                break;
            case SolicitudEliminar:
                
    {
        try {
            modelo3.destroy(Integer.parseInt(vista.SolELI.getText()));
            vista.TablaSolicitudes.setModel(modelo3.listarSolicitudes());
        } catch (IllegalOrphanException ex) {
            Logger.getLogger(ResponsableControlador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ResponsableControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
                vista.Text.setText("Item Destruido");
                this.vista.TablaItem.setModel(this.modelo2.listarItems());
                break;
            case ItemBuscar:
                this.vista.TablaItem.setModel( modelo4.BuscarItems(Integer.parseInt(vista.Codigo_Item.getText())) );
                break;
            case ItemEliminar:
    
        try {
            modelo4.destroy(Integer.parseInt(vista.Codigo_Item.getText()));
            vista.Text.setText("Item Destruido");
            this.vista.TablaItem.setModel(this.modelo2.listarItems());
        } catch (IllegalOrphanException ex) {
            Logger.getLogger(ResponsableControlador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ResponsableControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    
                break;    
            case ItemModificar:
                 try {
                modelo4.destroy(Integer.parseInt(vista.Codigo_Item.getText()));
                Bienes c=new Bienes(Integer.parseInt(vista.Codigo_Item.getText()));
                c.setNombre(vista.Nombre_Item.getText());
                c.setProveedor(modelo5.findProveedores(Integer.parseInt(vista.Proveedor.getText())));
                c.setCaracter("dasda");
                c.setValorUnitario(1);
        try {
            modelo4.create(c);
            vista.Text.setText("Item Actualizado");
        } catch (Exception ex) {
            Logger.getLogger(ResponsableControlador.class.getName()).log(Level.SEVERE, null, ex);
            vista.Text.setText("Item no modificado");
        }
            
            this.vista.TablaItem.setModel(this.modelo2.listarItems());
        } catch (IllegalOrphanException ex) {
            Logger.getLogger(ResponsableControlador.class.getName()).log(Level.SEVERE, null, ex);
            vista.Text.setText("Item no modificado");
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ResponsableControlador.class.getName()).log(Level.SEVERE, null, ex);
            vista.Text.setText("Item no modificado");
        }
                break; 
            case SolicitudAniadirItem:
                if (modelo4.findBienes(Integer.parseInt(vista.SolicitudItem.getText()))!=null){
                System.out.println(modelo4.findBienes(Integer.parseInt(vista.SolicitudItem.getText())));
                bienes.add(modelo4.findBienes(Integer.parseInt(vista.SolicitudItem.getText())));
                x.add(Integer.parseInt(vista.CantidadItem.getText()));
                vista.SolicitudItem.setText("");
                vista.CantidadItem.setText("");
                }else {
                    vista.Text.setText("No existe el item");
                }
               
                break; 
                ////// Solucionar
            case SolicitudCrear:
                Solicitudes sol=new Solicitudes();
                //java.util.Date d = new java.util.Date();
                //java.sql.Date date2 = new java.sql.Date(d.getTime());
                //System.out.print(date2);
                LocalDate fecha=LocalDate.now();
                sol.setCodSolicitud(modelo3.getSolicitudesCount()+1);
                System.out.println(fecha.getChronology());
                System.out.println(fecha);
                Date Fecha2=Date.from(fecha.atStartOfDay(ZoneId.systemDefault()).toInstant());
                
                int total=0;
                for (int i = 0; i < bienes.size(); i++) {
                    //FacturasPK facturaPK= new FacturasPK(sol.getCodSolicitud(),bienes.get(i).getCodItem(),Fecha2,x.get(i));
                    Facturas factura= new Facturas(sol.getCodSolicitud(),bienes.get(i).getCodItem(),Fecha2,x.get(i));
                    y.add(factura);
                    System.out.println(factura);
                    //y2.add(facturaPK);
                    System.out.println(bienes.get(i).getValorUnitario()+" "+x.get(i));
                    total=total+(bienes.get(i).getValorUnitario()*x.get(i));
                    System.out.print(total);
                }//(int solicitud, int item, Date fecha,int cantidad)
                //sol.setFacturasList(y);
                System.out.println(total);
                sol.setCodPresupuesto(Integer.parseInt(vista.CentroCostos.getText()));
                sol.setTotal(total);
                sol.setFecha(Fecha2);
                sol.setResponsable(responsable.findResponsables(responsableG));
                try {
                    modelo3.create(sol);
                    vista.TablaSolicitudes.setModel(modelo3.listarSolicitudes());
                } catch (Exception ex) {
                    Logger.getLogger(ResponsableControlador.class.getName()).log(Level.SEVERE, null, ex);
                }
                for (int i = 0; i < y.size(); i++) {
                    
                    try {
                        modelo6.create(y.get(i));
                    } catch (Exception ex) {
                        Logger.getLogger(ResponsableControlador.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
    
                break;  
            case LogOut:
                //vuelve a la vista de inicio
                vista.dispose();
                Inicio in =new Inicio();
                new InicioControlador(in).iniciar() ;
                break; 
        }
    }


}