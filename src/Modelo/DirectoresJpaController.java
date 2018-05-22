/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Modelo.exceptions.NonexistentEntityException;
import Modelo.exceptions.PreexistingEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Entidades.Centros;
import Entidades.Directores;
import Entidades.Empleados;
import Entidades.JefesArea;
import Entidades.Ordenes;
import Entidades.Proveedores;
import Entidades.Responsables;
import Vistas.Director;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author charliVB
 */
public class DirectoresJpaController implements Serializable {
    Director d=new Director();
    public DirectoresJpaController() {
        emf = Persistence.createEntityManagerFactory("ProyectoPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    DefaultTableModel modeloDirector;
    public void crearModeloDirectores() {
        try {
            modeloDirector = (new DefaultTableModel(
                    null, new String[]{
                        "Codigo", "Nombre",
                        "Salario", "centro"}) {
                Class[] types = new Class[]{
                    java.lang.String.class,
                    java.lang.String.class,
                    java.lang.String.class,
                    java.lang.String.class,
                };
                boolean[] canEdit = new boolean[]{
                    false, false, false, false
                };

                @Override
                public Class getColumnClass(int columnIndex) {
                    return types[columnIndex];
                }

                @Override
                public boolean isCellEditable(int rowIndex, int colIndex) {
                    return canEdit[colIndex];
                }
            });
       // Director.tablaDirectorEmpleado.setModel(modeloDirector);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString() + "error2");
        }
    }
    public DefaultTableModel listarDirectoresEmpleados( String mensaje){
        crearModeloDirectores();        
        ResponsablesJpaController respC = new ResponsablesJpaController();
        EmpleadosJpaController empleC = new EmpleadosJpaController();
        JefesAreaJpaController jefesC = new JefesAreaJpaController();
        DirectoresJpaController directoresC = new DirectoresJpaController();
        Object O[]=null;
        //mensaje = d.cargoDirector.getSelectedItem().toString();
        try{
            if (mensaje.equals("Responsable")){
                    
                List<Responsables> r = respC.findResponsablesEntities();
                for (int i=0; i < r.size(); i++){
                   modeloDirector.addRow(O);
                   modeloDirector.setValueAt(r.get(i).getCodResponsable(), i, 0);
                   modeloDirector.setValueAt(r.get(i).getNombre(), i, 1);
                   modeloDirector.setValueAt(r.get(i).getSalario(), i, 2);
                   modeloDirector.setValueAt(r.get(i).getCentro(), i, 3);
                   
               }
                
            }else if(mensaje.equals("Jefe")){
               List<JefesArea> j = jefesC.findJefesAreaEntities();
                for (int i=0; i < j.size(); i++){
                   modeloDirector.addRow(O);
                   modeloDirector.setValueAt(j.get(i).getCodJefe(), i, 0);
                   modeloDirector.setValueAt(j.get(i).getNombre(), i, 1);
                   modeloDirector.setValueAt(j.get(i).getSalario(), i, 2);
                   modeloDirector.setValueAt(j.get(i).getCentro(), i, 3);
               }
               
            }else if (mensaje.equals("Director")){
                 
            List<Directores> c = directoresC.findDirectoresEntities();
            for (int i=0; i < c.size(); i++){
                modeloDirector.addRow(O);
                modeloDirector.setValueAt(c.get(i).getCodDirector(), i, 0);
                modeloDirector.setValueAt(c.get(i).getNombre(), i, 1);
                modeloDirector.setValueAt(c.get(i).getSalario(), i, 2);
                modeloDirector.setValueAt(c.get(i).getCodCentro(), i, 3);
            } 
             }else{
             List<Empleados> e = empleC.findEmpleadosEntities();
            for (int i=0; i < e.size(); i++){
                modeloDirector.addRow(O);
                modeloDirector.setValueAt(e.get(i).getCodEmpleado(), i, 0);
                modeloDirector.setValueAt(e.get(i).getNombre(), i, 1);
                modeloDirector.setValueAt(e.get(i).getSalario(), i, 2);
                modeloDirector.setValueAt(e.get(i).getCentro().getCodCentro(), i, 3);    
                  System.out.println("Caso empleados");
             }
            }
            
        }catch (Exception e) {
        JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return modeloDirector;
    }
    
    public void crearModeloProveedor() {
        try {
            modeloDirector = (new DefaultTableModel(
                    null, new String[]{
                        "NIT", "Nombre",
                        "Telefono"}) {
                Class[] types = new Class[]{
                    java.lang.String.class,
                    java.lang.String.class,
                    java.lang.String.class,
                };
                boolean[] canEdit = new boolean[]{
                    false, false, false
                };

                @Override
                public Class getColumnClass(int columnIndex) {
                    return types[columnIndex];
                }

                @Override
                public boolean isCellEditable(int rowIndex, int colIndex) {
                    return canEdit[colIndex];
                }
            });
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString() + "error2");
        }
    }
    
    public DefaultTableModel listarDirectorProveedor(){
        crearModeloProveedor();        
        ProveedoresJpaController proC = new ProveedoresJpaController();       
        Object O[]=null;
        try{
            List<Proveedores> p = proC.findProveedoresEntities();
                for (int i=0; i < p.size(); i++){
                   modeloDirector.addRow(O);
                   modeloDirector.setValueAt(p.get(i).getNit(), i, 0);
                   modeloDirector.setValueAt(p.get(i).getNombre(), i, 1);
                   modeloDirector.setValueAt(p.get(i).getTelefono(), i, 2);;                   
               }
                System.out.println("Ccaso responsable");
            }
        catch (Exception e) {
        JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return modeloDirector;
    } 
    
    public void crearModeloOrden() {
        try {
            modeloDirector = (new DefaultTableModel(
                    null, new String[]{
                        "Numero_Orden y Solicitud",
                        "NIT","Fecha Entrega","monto"}) {
                Class[] types = new Class[]{
                    java.lang.String.class,
                    java.lang.String.class,
                    java.lang.String.class,
                    java.lang.String.class,
                };
                boolean[] canEdit = new boolean[]{
                    false, false, false
                };

                @Override
                public Class getColumnClass(int columnIndex) {
                    return types[columnIndex];
                }

                @Override
                public boolean isCellEditable(int rowIndex, int colIndex) {
                    return canEdit[colIndex];
                }
            });
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString() + "error2");
        }
    }
    
    public DefaultTableModel listarDirectorOrden(){
        crearModeloOrden();        
        OrdenesJpaController ordenC = new OrdenesJpaController();       
        Object O[]=null;
        try{
            List<Ordenes> p = ordenC.findOrdenesEntities();
                for (int i=0; i < p.size(); i++){
                   modeloDirector.addRow(O);
                   modeloDirector.setValueAt(p.get(i).getOrdenesPK(), i, 0);
                   modeloDirector.setValueAt(p.get(i).getNit(), i, 1);
                   modeloDirector.setValueAt(p.get(i).getFechaEntrega(), i, 2);
                   modeloDirector.setValueAt(p.get(i).getMonto(), i, 1);                   
               }
                System.out.println("Ccaso responsable");
            }
        catch (Exception e) {
        JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return modeloDirector;
    } 
    
    
    
    
            
    public void create(Directores directores) throws PreexistingEntityException, Exception {
        if (directores.getJefesAreaList() == null) {
            directores.setJefesAreaList(new ArrayList<JefesArea>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Centros centro = directores.getCentro();
            if (centro != null) {
                centro = em.getReference(centro.getClass(), centro.getCodCentro());
                directores.setCentro(centro);
            }
            List<JefesArea> attachedJefesAreaList = new ArrayList<JefesArea>();
            for (JefesArea jefesAreaListJefesAreaToAttach : directores.getJefesAreaList()) {
                jefesAreaListJefesAreaToAttach = em.getReference(jefesAreaListJefesAreaToAttach.getClass(), jefesAreaListJefesAreaToAttach.getCodJefe());
                attachedJefesAreaList.add(jefesAreaListJefesAreaToAttach);
            }
            directores.setJefesAreaList(attachedJefesAreaList);
            em.persist(directores);
            if (centro != null) {
                centro.getDirectoresList().add(directores);
                centro = em.merge(centro);
            }
            for (JefesArea jefesAreaListJefesArea : directores.getJefesAreaList()) {
                Directores oldDirectorOfJefesAreaListJefesArea = jefesAreaListJefesArea.getDirector();
                jefesAreaListJefesArea.setDirector(directores);
                jefesAreaListJefesArea = em.merge(jefesAreaListJefesArea);
                if (oldDirectorOfJefesAreaListJefesArea != null) {
                    oldDirectorOfJefesAreaListJefesArea.getJefesAreaList().remove(jefesAreaListJefesArea);
                    oldDirectorOfJefesAreaListJefesArea = em.merge(oldDirectorOfJefesAreaListJefesArea);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findDirectores(directores.getCodDirector()) != null) {
                throw new PreexistingEntityException("Directores " + directores + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
      }

    public void edit(Directores directores) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Directores persistentDirectores = em.find(Directores.class, directores.getCodDirector());
            Centros centroOld = persistentDirectores.getCentro();
            Centros centroNew = directores.getCentro();
            List<JefesArea> jefesAreaListOld = persistentDirectores.getJefesAreaList();
            List<JefesArea> jefesAreaListNew = directores.getJefesAreaList();
            if (centroNew != null) {
                centroNew = em.getReference(centroNew.getClass(), centroNew.getCodCentro());
                directores.setCentro(centroNew);
            }
            List<JefesArea> attachedJefesAreaListNew = new ArrayList<JefesArea>();
            for (JefesArea jefesAreaListNewJefesAreaToAttach : jefesAreaListNew) {
                jefesAreaListNewJefesAreaToAttach = em.getReference(jefesAreaListNewJefesAreaToAttach.getClass(), jefesAreaListNewJefesAreaToAttach.getCodJefe());
                attachedJefesAreaListNew.add(jefesAreaListNewJefesAreaToAttach);
            }
            jefesAreaListNew = attachedJefesAreaListNew;
            directores.setJefesAreaList(jefesAreaListNew);
            directores = em.merge(directores);
            if (centroOld != null && !centroOld.equals(centroNew)) {
                centroOld.getDirectoresList().remove(directores);
                centroOld = em.merge(centroOld);
            }
            if (centroNew != null && !centroNew.equals(centroOld)) {
                centroNew.getDirectoresList().add(directores);
                centroNew = em.merge(centroNew);
            }
            for (JefesArea jefesAreaListOldJefesArea : jefesAreaListOld) {
                if (!jefesAreaListNew.contains(jefesAreaListOldJefesArea)) {
                    jefesAreaListOldJefesArea.setDirector(null);
                    jefesAreaListOldJefesArea = em.merge(jefesAreaListOldJefesArea);
                }
            }
            for (JefesArea jefesAreaListNewJefesArea : jefesAreaListNew) {
                if (!jefesAreaListOld.contains(jefesAreaListNewJefesArea)) {
                    Directores oldDirectorOfJefesAreaListNewJefesArea = jefesAreaListNewJefesArea.getDirector();
                    jefesAreaListNewJefesArea.setDirector(directores);
                    jefesAreaListNewJefesArea = em.merge(jefesAreaListNewJefesArea);
                    if (oldDirectorOfJefesAreaListNewJefesArea != null && !oldDirectorOfJefesAreaListNewJefesArea.equals(directores)) {
                        oldDirectorOfJefesAreaListNewJefesArea.getJefesAreaList().remove(jefesAreaListNewJefesArea);
                        oldDirectorOfJefesAreaListNewJefesArea = em.merge(oldDirectorOfJefesAreaListNewJefesArea);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = directores.getCodDirector();
                if (findDirectores(id) == null) {
                    throw new NonexistentEntityException("The directores with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Directores directores;
            try {
                directores = em.getReference(Directores.class, id);
                directores.getCodDirector();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The directores with id " + id + " no longer exists.", enfe);
            }
            Centros centro = directores.getCentro();
            if (centro != null) {
                centro.getDirectoresList().remove(directores);
                centro = em.merge(centro);
            }
            List<JefesArea> jefesAreaList = directores.getJefesAreaList();
            for (JefesArea jefesAreaListJefesArea : jefesAreaList) {
                jefesAreaListJefesArea.setDirector(null);
                jefesAreaListJefesArea = em.merge(jefesAreaListJefesArea);
            }
            em.remove(directores);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Directores> findDirectoresEntities() {
        return findDirectoresEntities(true, -1, -1);
    }

    public List<Directores> findDirectoresEntities(int maxResults, int firstResult) {
        return findDirectoresEntities(false, maxResults, firstResult);
    }

    private List<Directores> findDirectoresEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Directores.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Directores findDirectores(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Directores.class, id);
        } finally {
            em.close();
        }
    }

    public int getDirectoresCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Directores> rt = cq.from(Directores.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
