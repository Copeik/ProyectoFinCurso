package Entidades;

import Entidades.Facturas;
import Entidades.Ordenes;
import Entidades.Responsables;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-18T19:58:18")
@StaticMetamodel(Solicitudes.class)
public class Solicitudes_ { 

    public static volatile SingularAttribute<Solicitudes, Date> fecha;
    public static volatile SingularAttribute<Solicitudes, Integer> total;
    public static volatile SingularAttribute<Solicitudes, Responsables> responsable;
    public static volatile SingularAttribute<Solicitudes, Integer> aprobada;
    public static volatile ListAttribute<Solicitudes, Ordenes> ordenesList;
    public static volatile SingularAttribute<Solicitudes, Integer> codSolicitud;
    public static volatile ListAttribute<Solicitudes, Facturas> facturasList;
    public static volatile SingularAttribute<Solicitudes, Integer> codPresupuesto;

}