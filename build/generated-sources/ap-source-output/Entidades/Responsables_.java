package Entidades;

import Entidades.Empleados;
import Entidades.JefesArea;
import Entidades.Solicitudes;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-17T17:41:52")
@StaticMetamodel(Responsables.class)
public class Responsables_ { 

    public static volatile ListAttribute<Responsables, Empleados> empleadosList;
    public static volatile SingularAttribute<Responsables, Integer> codResponsable;
    public static volatile SingularAttribute<Responsables, Integer> salario;
    public static volatile SingularAttribute<Responsables, Integer> centro;
    public static volatile SingularAttribute<Responsables, JefesArea> jefe;
    public static volatile ListAttribute<Responsables, Solicitudes> solicitudesList;
    public static volatile SingularAttribute<Responsables, String> nombre;

}