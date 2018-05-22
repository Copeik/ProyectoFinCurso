package Entidades;

import Entidades.Almacenes;
import Entidades.Centros;
import Entidades.Empleados;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-17T17:41:52")
@StaticMetamodel(Salidas.class)
public class Salidas_ { 

    public static volatile SingularAttribute<Salidas, Empleados> empleado;
    public static volatile SingularAttribute<Salidas, Date> fechaSalida;
    public static volatile SingularAttribute<Salidas, Centros> centro;
    public static volatile SingularAttribute<Salidas, Date> fechaEntrega;
    public static volatile SingularAttribute<Salidas, Almacenes> almacen;
    public static volatile SingularAttribute<Salidas, Integer> numSalida;

}