package Entidades;

import Entidades.OrdenesPK;
import Entidades.Proveedores;
import Entidades.Solicitudes;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-17T17:41:52")
@StaticMetamodel(Ordenes.class)
public class Ordenes_ { 

    public static volatile SingularAttribute<Ordenes, Integer> monto;
    public static volatile SingularAttribute<Ordenes, Date> fechaEntrega;
    public static volatile SingularAttribute<Ordenes, Proveedores> nit;
    public static volatile SingularAttribute<Ordenes, OrdenesPK> ordenesPK;
    public static volatile SingularAttribute<Ordenes, Solicitudes> solicitudes;

}